package com.lib.gumisoft;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lib.gumisoft.factories.RenderFactory;
import com.lib.gumisoft.factories.TextureFactory;

public class HeroMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture playerKai;
	private TextureFactory textureFactory;
	private RenderFactory renderFactory;

	@Override
	public void create () {
		renderFactory = new RenderFactory();
		textureFactory = new TextureFactory();
		batch = new SpriteBatch();
		playerKai = textureFactory.getPlayerKai();
	}

	@Override
	public void render () {
		renderFactory.setBackgroundColorBlack();
		renderFactory.clearScreen();
		batch.begin();
		batch.draw(playerKai, 0, 0);
		batch.end();
	}
}
