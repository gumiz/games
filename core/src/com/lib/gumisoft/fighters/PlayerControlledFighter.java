package com.lib.gumisoft.fighters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.factories.Factory;

public abstract class PlayerControlledFighter extends Fighter {

    public PlayerControlledFighter(Factory factory) {
        super(factory);
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
