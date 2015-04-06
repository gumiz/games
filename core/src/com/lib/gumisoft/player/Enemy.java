package com.lib.gumisoft.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.factories.IRandomizer;
import com.lib.gumisoft.factories.TextureFactory;

public class Enemy extends Fighter {
    public Enemy(Factory factory) {
        super(factory);
    }

    @Override
    protected void setPosition() {
        position = new Vector2(300, 300);
    }

    @Override
    protected void setTexture() {
        texture = TextureFactory.getPlayerTextureSnake();
    }
}
