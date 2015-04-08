package com.lib.gumisoft;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.entities.Tree;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.fighters.IFighter;

public class HeroMain extends ApplicationAdapter {
	SpriteBatch batch;
	private Factory factory;
	private final Array<IFighter> ninjagos = new Array<IFighter>();
	private final Array<IFighter> enemies = new Array<IFighter>();
	private Array<Tree> trees;

	@Override
	public void create () {
		factory = new Factory();
		batch = new SpriteBatch();
		trees = new Array<Tree>();
		setupFighters();
		setupTrees();
	}

	@Override
	public void render () {
		batch.begin();
		factory.getRenderFactory().clearScreen();
		factory.getRenderFactory().showBackground(batch);
		renderFighters(enemies);
		renderFighters(ninjagos);
		renderTrees();
		renderLegend();
		resolveCollisions();
		controlUserInput();
		batch.end();
	}

	private void renderLegend() {
		factory.getLegendDisplayService().renderLegend(batch, ninjagos.size, enemies.size);
//		factory.getLegendDisplayService().renderDebug(batch);
	}

	private void resolveCollisions() {
		factory.getCollisionResolver().resolveCollisions(ninjagos, enemies);
	}

	private void setupFighters() {
		factory.getLegendDisplayService().restartTimer();
		factory.getFightersCreator().prepareFighters(ninjagos, enemies);
	}

	private void renderFighters(Array<IFighter> fighters) {
		for (IFighter fighter : fighters)
			fighter.render(batch);
	}
	private void renderTrees() {
		for (Tree tree : trees)
			tree.render(batch);
	}

	private void setupTrees() {
		trees.clear();
		for (int i = 0; i < 30; i++) {
			Tree tree = factory.getTree();
			trees.add(tree);
		}
	}

	public void controlUserInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE))  {
			setupFighters();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE))  {
			System.exit(0);
		}
	}
}
