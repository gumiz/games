package com.lib.gumisoft.services;

import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;
import com.lib.gumisoft.params.GameParams;

public class NinjagoFightersService extends FightersService {

    public NinjagoFightersService(Factory factory) {
        super(factory);
    }

    protected void createNewHero() {
        _newHero = _factory.createNewNinjago(GameParams.HeroSpawnPosition);
    }

    protected void cloneNewHero() {
        Vector2 pos = _heroes.get(0).getPosition();
        _heroes.add(_factory.createNewNinjago(pos));
    }


}
