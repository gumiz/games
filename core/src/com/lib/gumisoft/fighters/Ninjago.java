package com.lib.gumisoft.fighters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.factories.Factory;

public class Ninjago extends PlayerControlledFighter {
    Array<Texture> textures;

    public Ninjago(Factory factory, Vector2 position) {
        super(factory, position);
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
    protected void setTexture() {
        int number = _factory.getRandomizer().getRandomNumber(textures.size);
        texture = textures.get(number);
    }

    @Override
    public void render(Batch batch) {
        move();
        drawNinjago(batch);
    }

    private void drawNinjago(Batch batch) {
        batch.draw(texture, _position.x, _position.y);
    }

}
