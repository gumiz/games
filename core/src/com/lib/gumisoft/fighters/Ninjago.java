package com.lib.gumisoft.fighters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.factories.Factory;

public class Ninjago extends Fighter {
    Array<Texture> textures;

    public Ninjago(Factory factory) {
        super(factory);
    }

    @Override
    protected void setup() {
        textures = new Array<Texture>();
        textures.add(_factory.getTextureManager().getPlayerTextureKai());
        textures.add(_factory.getTextureManager().getPlayerTextureJay());
        textures.add(_factory.getTextureManager().getPlayerTextureZane());
        textures.add(_factory.getTextureManager().getPlayerTextureCole());
    }

    @Override
    protected void setPosition() {
        position = new Vector2(200, 200);
    }

    @Override
    protected void setTexture() {
        int number = _factory.getRandomizer().getRandomNumber(textures.size);
        texture = textures.get(number);
    }

    @Override
    protected void applyMousePosition() {
        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.graphics.getHeight()-Gdx.input.getY();
        if (mouseX > position.x)
            directionX++;
        else
            directionX--;
        if (mouseY > position.y)
            directionY++;
        else
            directionY--;
    }

}
