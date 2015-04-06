package com.lib.gumisoft.factories;

import com.lib.gumisoft.player.Enemy;
import com.lib.gumisoft.player.Ninjago;

public class Factory {
    private SoundManager soundManager;

    public Factory() {
        soundManager = new SoundManager(this);
    }

    public SoundManager getSoundmanager() {return soundManager;}
    public Ninjago getNinjago() {
        return new Ninjago(this);
    }
    public Enemy getEnemy() {
        return new Enemy(this);
    }
    public IRandomizer getRandomizer() {
        return new Randomizer();
    }
}
