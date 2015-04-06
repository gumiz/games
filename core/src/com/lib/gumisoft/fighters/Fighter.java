package com.lib.gumisoft.fighters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.factories.IRandomizer;
import com.lib.gumisoft.factories.TextureManager;

public abstract class Fighter implements IFighter {
    protected final Factory _factory;
    private final IRandomizer _randomizer;

    protected Vector2 position = new Vector2(200, 200);
    protected Texture texture = TextureManager.getPlayerTextureKai();
    protected int directionX;
    protected int directionY;

    public Fighter(Factory factory) {
        _factory = factory;
        _randomizer = _factory.getRandomizer();
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


    public void render(Batch batch) {
        move();
        batch.draw(texture, position.x, position.y);
    }

    private void move() {
        if (_randomizer.rollDice(5))
            rotate();
        changePosition();
    }

    @Override
    public boolean collision(IFighter fighter) {
        int accuracy = 5;
        float distanceX = Math.abs(this.getPosition().x - fighter.getPosition().x);
        float distanceY = Math.abs(this.getPosition(). y- fighter.getPosition().y);
        return ( (distanceX <= accuracy) && (distanceY <= accuracy ));
    }

    @Override
    public Vector2 getPosition() {
        return this.position;
    }

}
