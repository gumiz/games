package com.lib.gumisoft.fighters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.services.IRandomizer;

public abstract class Fighter implements IFighter {
    private final int renderRotationDelay = 5; 
    private final int renderMoveDelay = 2;
    private final int _COLLISION_DISTANCE = 5;

    protected final Factory _factory;
    private final IRandomizer _randomizer;
    protected Vector2 position = new Vector2(200, 200);
    protected Texture texture;
    protected int directionX;
    protected int directionY;

    public Fighter(Factory factory) {
        _factory = factory;
        _randomizer = _factory.getRandomizer();
        texture = _factory.getTextureManager().getPlayerTextureKai();
        setup();
        setTexture();
        setPosition();
    }

    protected abstract void setup();
    protected abstract void setPosition();
    protected abstract void setTexture();
    protected abstract void applyMousePosition();

    private void changePosition(){
        position.x += directionX;
        position.y += directionY;
        overrideIfScreenBoundariesReached();
    }

    private void overrideIfScreenBoundariesReached() {
        position.x = Math.min(position.x, Gdx.graphics.getWidth());
        position.x = Math.max(position.x, 0);
        position.y = Math.min(position.y, Gdx.graphics.getHeight());
        position.y = Math.max(position.y, 0);
    }

    private void rotate() {
        randomizeRotation();
        applyMousePosition();
    }

    private void randomizeRotation() {
        directionX = _randomizer.getRandomNumber(-1,1);
        directionY = _randomizer.getRandomNumber(-1,1);
    }


    public abstract void render(Batch batch);

    protected void move() {
        if (_randomizer.rollDice(renderRotationDelay))
            rotate();
        if (_randomizer.rollDice(renderMoveDelay))
            changePosition();
    }

    @Override
    public boolean collision(IFighter fighter) {
        float distanceX = Math.abs(this.getPosition().x - fighter.getPosition().x);
        float distanceY = Math.abs(this.getPosition(). y- fighter.getPosition().y);
        return ( (distanceX <= _COLLISION_DISTANCE) && (distanceY <= _COLLISION_DISTANCE ));
    }

    @Override
    public Vector2 getPosition() {
        return this.position;
    }

}
