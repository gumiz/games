package com.lib.gumisoft.fighters;

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
    private int directionX;
    private int directionY;

    public Fighter(Factory factory) {
        _factory = factory;
        _randomizer = _factory.getRandomizer();
        setPosition();
        setTexture();
    }

    protected abstract void setPosition();
    protected abstract void setTexture();

    private void changePosition(){
        position.x += directionX;
        position.y += directionY;
    }

    private void rotate() {
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
        return ( (this.getPosition().x == fighter.getPosition().x) && (this.getPosition().y == fighter.getPosition().y));
    }

    @Override
    public Vector2 getPosition() {
        return this.position;
    }

}
