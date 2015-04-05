package com.lib.gumisoft.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.TextureFactory;

public class Player {
    private Vector2 position = new Vector2();

    private Texture getTexture() {
        return TextureFactory.getPlayerTextureKai();
    }

    private void interact(){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x--;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x++;
        }
    }

    public void render(Batch batch) {
        interact();
        batch.draw(getTexture(), position.x, position.y);
    }

}
