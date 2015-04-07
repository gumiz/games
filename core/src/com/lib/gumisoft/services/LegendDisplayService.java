package com.lib.gumisoft.services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.factories.TextureManager;

import java.util.concurrent.TimeUnit;

public class LegendDisplayService {
    private final Factory _factory;
    private long startTime;

    public LegendDisplayService(Factory factory) {
        _factory = factory;
    }

    public void renderLegend(SpriteBatch batch, int ninjagos, int enemies) {
        batch.draw(TextureManager.getPlayerTextureKaiBig(), 0, 10);
        _factory.getRenderFactory().print(batch, String.valueOf(ninjagos), 70, 50);
        batch.draw(TextureManager.getPlayerTextureSkeletonBig(), 550, 10);
        _factory.getRenderFactory().print(batch, String.valueOf(enemies), 520, 50);
        long currentTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        _factory.getRenderFactory().print(batch, String.valueOf(currentTime-startTime), 300, 50);
    }
    public void renderDebug(SpriteBatch batch) {
        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.graphics.getHeight()-Gdx.input.getY();
        _factory.getRenderFactory().printDebug(batch, "Mouse pos: " + String.valueOf(Gdx.input.getX()) + "," + String.valueOf(Gdx.input.getY()), 5, 480);
        _factory.getRenderFactory().printDebug(batch, "Real pos: " + String.valueOf(mouseX) + "," + String.valueOf(mouseY), 5, 465);
    }

    public void restartTimer() {
        startTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }
}
