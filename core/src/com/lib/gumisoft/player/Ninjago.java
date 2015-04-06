package com.lib.gumisoft.player;

import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.factories.IRandomizer;
import com.lib.gumisoft.factories.TextureFactory;

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
            texture = TextureFactory.getPlayerTextureKai();
        else if (random.rollDice(2))
            texture = TextureFactory.getPlayerTextureJay();
        else
            texture = TextureFactory.getPlayerTextureZane();
    }
}
