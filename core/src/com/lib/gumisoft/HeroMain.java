package com.lib.gumisoft;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.factories.RenderFactory;
import com.lib.gumisoft.player.IFighter;

public class HeroMain extends ApplicationAdapter {
	SpriteBatch batch;
	private RenderFactory renderFactory;
	private Factory factory;
	private final Array<IFighter> allFighters = new Array<IFighter>();
	private final Array<IFighter> ninjagos = new Array<IFighter>();
	private final Array<IFighter> enemies = new Array<IFighter>();

	@Override
	public void create () {
		renderFactory = new RenderFactory();
		factory = new Factory();
		batch = new SpriteBatch();
		setupFighters();
	}

	@Override
	public void render () {
		renderFactory.setBackgroundColorBlack();
		renderFactory.clearScreen();
		batch.begin();
		for (IFighter fighter : allFighters)
			fighter.render(batch);
		for (IFighter ninjago : ninjagos)
			for (IFighter enemy : enemies)
				if (ninjago.collision(enemy)) {
					enemies.removeValue(enemy, false);
				}

		batch.end();
	}

	private void setupFighters() {
		for (int i = 0; i < 200; i++) {
			IFighter ninjago = factory.getNinjago();
			IFighter enemy = factory.getEnemy();
			ninjagos.add(ninjago);
			enemies.add(enemy);
			allFighters.add(ninjago);
			allFighters.add(enemy);
		}
	}

}
