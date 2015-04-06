package com.lib.gumisoft;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.factories.RenderFactory;
import com.lib.gumisoft.player.Enemy;
import com.lib.gumisoft.player.Player;

import java.util.List;

public class HeroMain extends ApplicationAdapter {
	SpriteBatch batch;
	private RenderFactory renderFactory;
	private Factory factory;
	private final Array<Player> players = new Array<Player>();
	private final Array<Enemy> enemies = new Array<Enemy>();
	private boolean _gameState = true;

	@Override
	public void create () {
		renderFactory = new RenderFactory();
		factory = new Factory();
		batch = new SpriteBatch();
		for (int i = 0; i < 100; i++) {
			players.add(factory.getPlayer());
			enemies.add(factory.getEnemy());
		}
	}

	@Override
	public void render () {
		renderFactory.setBackgroundColorBlack();
		renderFactory.clearScreen();
		batch.begin();
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
			_gameState = !_gameState;
		}
		for (Player player : players)
			player.render(batch);
		for (Enemy enemy : enemies)
			enemy.render(batch);
		batch.end();
	}
}
