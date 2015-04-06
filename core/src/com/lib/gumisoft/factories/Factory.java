package com.lib.gumisoft.factories;

import com.lib.gumisoft.player.Enemy;
import com.lib.gumisoft.player.Ninjago;

public class Factory {
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
