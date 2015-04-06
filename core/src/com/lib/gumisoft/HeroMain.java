package com.lib.gumisoft;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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
		renderDebug();
		renderLegend();
		renderFighters(enemies);
		renderFighters(ninjagos);
		resolveCollisions();
		batch.end();
	}

	private void renderLegend() {
		batch.draw(TextureManager.getPlayerTextureKaiBig(), 0, 10);
		renderFactory.print(batch, String.valueOf(ninjagos.size), 70, 50);
		batch.draw(TextureManager.getPlayerTextureSkeletonBig(), 550, 10);
		renderFactory.print(batch, String.valueOf(enemies.size), 520, 50);
	}

	private void renderDebug() {
		int mouseX = Gdx.input.getX();
		int mouseY = Gdx.graphics.getHeight()-Gdx.input.getY();
		renderFactory.printDebug(batch, "Mouse pos: " + String.valueOf(Gdx.input.getX()) + "," + String.valueOf(Gdx.input.getY()), 5, 480);
		renderFactory.printDebug(batch, "Real pos: " + String.valueOf(mouseX) + "," + String.valueOf(mouseY), 5, 465);
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
		for (int i = 0; i < 20; i++) {
			IFighter ninjago = factory.getNinjago();
			ninjagos.add(ninjago);
		}
		for (int i = 0; i < 200; i++) {
			IFighter enemy = factory.getEnemy();
			enemies.add(enemy);
		}
	}

}
