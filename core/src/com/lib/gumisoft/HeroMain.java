package com.lib.gumisoft;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.factories.RenderFactory;
import com.lib.gumisoft.player.Player;

public class HeroMain extends ApplicationAdapter {
	SpriteBatch batch;
	private RenderFactory renderFactory;
	private Factory factory;
	private Player player;

	@Override
	public void create () {
		renderFactory = new RenderFactory();
		factory = new Factory();
		batch = new SpriteBatch();
		player = factory.getPlayer();
	}

	@Override
	public void render () {
		renderFactory.setBackgroundColorBlack();
		renderFactory.clearScreen();
		batch.begin();
		player.render(batch);
		batch.end();
	}
}
