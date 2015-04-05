package com.lib.gumisoft.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import java.awt.*;

/**
 * Created by gumiz on 2015-04-05.
 */
public class RenderFactory {
    public void clearScreen() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    public void setBackgroundColorWhite() {
        Gdx.gl.glClearColor(Color.white.getRed(), Color.white.getGreen(), Color.white.getBlue(), Color.white.getAlpha());
    }
    public void setBackgroundColorBlack() {
        Gdx.gl.glClearColor(Color.black.getRed(), Color.black.getGreen(), Color.black.getBlue(), Color.black.getAlpha());
    }
}
