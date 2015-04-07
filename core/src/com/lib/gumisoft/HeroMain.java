package com.lib.gumisoft;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.fighters.IFighter;

public class HeroMain extends ApplicationAdapter {
	SpriteBatch batch;
	private Factory factory;
	private final Array<IFighter> ninjagos = new Array<IFighter>();
	private final Array<IFighter> enemies = new Array<IFighter>();

	@Override
	public void create () {
		factory = new Factory();
		batch = new SpriteBatch();
		setupFighters();
	}


	@Override
	public void render () {
		factory.getRenderFactory().clearScreen();
		batch.begin();
		renderLegend();
		renderFighters(enemies);
		renderFighters(ninjagos);
		resolveCollisions();
		getInput();
		batch.end();
	}

	private void renderLegend() {
		factory.getLegendDisplayService().renderLegend(batch, ninjagos.size, enemies.size);
		factory.getLegendDisplayService().renderDebug(batch);
	}

	private void resolveCollisions() {
		for (IFighter ninjago : ninjagos)
			for (IFighter enemy : enemies)
				if (ninjago.collision(enemy)) {
					enemies.removeValue(enemy, true);
					factory.getSoundmanager().playSword();
				}
	}

	private void renderFighters(Array<IFighter> fighters) {
		for (IFighter fighter : fighters)
			fighter.render(batch);
	}

	private void setupFighters() {
		factory.getLegendDisplayService().restartTimer();
		ninjagos.clear();
		enemies.clear();
		for (int i = 0; i < 20; i++) {
			IFighter ninjago = factory.getNinjago();
			ninjagos.add(ninjago);
		}
		for (int i = 0; i < 200; i++) {
			IFighter enemy = factory.getEnemy();
			enemies.add(enemy);
		}
	}

	public void getInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE))  {
			setupFighters();
		}
	}
}
