package com.lib.gumisoft.fighters;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.factories.TextureManager;

public class Enemy extends Fighter {
    public Enemy(Factory factory) {
        super(factory);
    }

    @Override
    protected void setup() {
    }

    @Override
    protected void setPosition() {
        position = new Vector2(300, 300);
    }

    @Override
    protected void setTexture() {
        texture = _factory.getTextureManager().getPlayerTextureSkeleton();
    }

    @Override
    protected void applyMousePosition() {}

    @Override
    public void render(Batch batch) {
        move();
        batch.draw(texture, position.x, position.y);
    }


}
