package com.lib.gumisoft.services;

import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.params.GameParams;

public class AnimatedFightersService extends FightersService {

    public AnimatedFightersService(Factory factory) {
        super(factory);
    }

    protected void createNewHero() {
        _newHero = _factory.createNewAnimatedPrincess(GameParams.HeroSpawnPosition);
    }

    protected void cloneNewHero() {
        Vector2 pos = _heroes.get(0).getPosition();
        _heroes.add(_factory.createNewAnimatedPrincess(pos));
    }

}
