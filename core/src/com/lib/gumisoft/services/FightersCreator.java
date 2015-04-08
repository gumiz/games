package com.lib.gumisoft.services;

import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.com.lib.gumisoft.params.GameParams;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.fighters.IFighter;

public class FightersCreator {
    private final Factory _factory;
    private Array<IFighter> _heroes;
    private Array<IFighter> _enemies;

    public FightersCreator(Factory factory) {
        _factory = factory;
    }

    public void prepareFighters(Array<IFighter> heroes, Array<IFighter> enemies) {
        _heroes = heroes;
        _enemies = enemies;
        destroyFighters();
        createNewHeroes();
        createNewEnemies();
    }

    private void createNewEnemies() {
        for (int i = 0; i < GameParams.NumberOfEnemies; i++) {
            IFighter enemy = _factory.getEnemy();
            _enemies.add(enemy);
        }
    }

    private void createNewHeroes() {
        for (int i = 0; i < GameParams.NumberOfHeroes; i++) {
            IFighter hero = _factory.getAnimatedPrincess();
            _heroes.add(hero);
        }
    }

    private void destroyFighters() {
        _heroes.clear();
        _enemies.clear();
    }
}
