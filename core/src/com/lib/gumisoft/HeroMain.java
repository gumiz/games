package com.lib.gumisoft;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.fighters.IFighter;
import com.lib.gumisoft.services.FightersService;

public class HeroMain extends ApplicationAdapter {
	SpriteBatch batch;
	private Factory factory;
	private final Array<IFighter> heroes = new Array<IFighter>();
	private final Array<IFighter> enemies = new Array<IFighter>();
	private FightersService fightersService;

	@Override
	public void create () {
		factory = new Factory();
		batch = new SpriteBatch();
		fightersService = factory.getNinjagoFightersService();
		fightersService.prepareFighters(heroes, enemies);
		factory.getTreesService().createTrees();
	}

	@Override
	public void render () {
		batch.begin();
		handleGameFrame();
		controlUserInput();
		batch.end();
	}

	private void handleGameFrame() {
		factory.getRenderFactory().clearScreen();
		factory.getRenderFactory().showBackground(batch);
		factory.getLegendDisplayService().restartTimer();
		fightersService.renderFighters(batch, enemies);
		fightersService.renderFighters(batch, heroes);
		factory.getTreesService().renderTrees(batch);
		factory.getLegendDisplayService().renderLegend(batch, heroes.size, enemies.size);
		//factory.getLegendDisplayService().renderDebug(batch);
		factory.getCollisionResolver().resolveCollisions(heroes, enemies);
		fightersService.cloneHeroes();
	}

	public void controlUserInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.F1))  {
			fightersService = factory.getNinjagoFightersService();
			fightersService.prepareFighters(heroes, enemies);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.F2))  {
			fightersService = factory.getAnimatedFightersService();
			fightersService.prepareFighters(heroes, enemies);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE))  {
			System.exit(0);
		}
	}
}
