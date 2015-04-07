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
	private final int numberOfNinjagos = 20;
	private final int numberOfEnemies = 200;
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
		getInput();
		batch.end();
	}

	private void renderLegend() {
		factory.getLegendDisplayService().renderLegend(batch, ninjagos.size, enemies.size);
//		factory.getLegendDisplayService().renderDebug(batch);
	}

	private void resolveCollisions() {
		for (IFighter ninjago : ninjagos) {
			for (IFighter enemy : enemies)
				if (ninjago.collision(enemy)) {
					dropRandomFighter(ninjago, enemy);
					factory.getSoundManager().playSword();
				}
		}
	}

	private void dropRandomFighter(IFighter ninjago, IFighter enemy) {
		if (factory.getRandomizer().rollDice(Math.round(numberOfEnemies/numberOfNinjagos)))
            ninjagos.removeValue(ninjago, true);
        else
            enemies.removeValue(enemy, true);
	}

	private void renderFighters(Array<IFighter> fighters) {
		for (IFighter fighter : fighters)
			fighter.render(batch);
	}
	private void renderTrees() {
		for (Tree tree : trees)
			tree.render(batch);
	}

	private void setupFighters() {
		factory.getLegendDisplayService().restartTimer();
		ninjagos.clear();
		enemies.clear();
		for (int i = 0; i < numberOfNinjagos; i++) {
			IFighter ninjago = factory.getNinjago();
			ninjagos.add(ninjago);
		}
		for (int i = 0; i < numberOfEnemies; i++) {
			IFighter enemy = factory.getEnemy();
			enemies.add(enemy);
		}
	}

	private void setupTrees() {
		trees.clear();
		for (int i = 0; i < 30; i++) {
			Tree tree = factory.getTree();
			trees.add(tree);
		}
	}

	public void getInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE))  {
			setupFighters();
		}
	}
}
