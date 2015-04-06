package com.lib.gumisoft.factories;

import com.lib.gumisoft.fighters.Enemy;
import com.lib.gumisoft.fighters.Ninjago;

public class Factory {
    private Randomizer randomizer;
    private SoundManager soundManager;

    public Factory() {
        soundManager = new SoundManager(this);
        randomizer = new Randomizer();
    }

    public SoundManager getSoundmanager() {return soundManager;}
    public Ninjago getNinjago() {
        return new Ninjago(this);
    }
    public Enemy getEnemy() {
        return new Enemy(this);
    }
    public IRandomizer getRandomizer() {
        return randomizer;
    }
}
