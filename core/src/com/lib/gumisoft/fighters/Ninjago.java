package com.lib.gumisoft.fighters;

import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.factories.IRandomizer;
import com.lib.gumisoft.factories.TextureManager;

public class Ninjago extends Fighter {
    public Ninjago(Factory factory) {
        super(factory);
    }

    @Override
    protected void setPosition() {
        position = new Vector2(200, 200);
    }

    @Override
    protected void setTexture() {
        IRandomizer random = _factory.getRandomizer();
        if (random.rollDice(3))
            texture = TextureManager.getPlayerTextureKai();
        else if (random.rollDice(2))
            texture = TextureManager.getPlayerTextureJay();
        else
            texture = TextureManager.getPlayerTextureZane();
    }
}
