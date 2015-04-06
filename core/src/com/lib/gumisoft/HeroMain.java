package com.lib.gumisoft;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.factories.RenderFactory;
import com.lib.gumisoft.factories.TextureManager;
import com.lib.gumisoft.fighters.IFighter;

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
		renderFactory.clearScreen();
		batch.begin();
		renderLegend();
		renderFighters();
		resolveCollisions();
		batch.end();
	}

	private void renderLegend() {
		batch.draw(TextureManager.getPlayerTextureKaiBig(), 0, 10);
		renderFactory.print(batch, String.valueOf(ninjagos.size), 70, 50);
		batch.draw(TextureManager.getPlayerTextureSkeletonBig(), 550, 10);
		renderFactory.print(batch, String.valueOf(enemies.size), 520, 50);
	}

	private void resolveCollisions() {
		for (IFighter ninjago : ninjagos)
			for (IFighter enemy : enemies)
				if (ninjago.collision(enemy)) {
					enemies.removeValue(enemy, false);
					factory.getSoundmanager().playSword();
				}
	}

	private void renderFighters() {
		for (IFighter fighter : allFighters)
			fighter.render(batch);
	}

	private void setupFighters() {
		for (int i = 0; i < 20; i++) {
			IFighter ninjago = factory.getNinjago();
			ninjagos.add(ninjago);
			allFighters.add(ninjago);
		}
		for (int i = 0; i < 200; i++) {
			IFighter enemy = factory.getEnemy();
			enemies.add(enemy);
			allFighters.add(enemy);
		}
	}

}
