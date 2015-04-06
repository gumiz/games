package com.lib.gumisoft.factories;

import com.lib.gumisoft.player.Enemy;
import com.lib.gumisoft.player.Player;

public class Factory {
    public Player getPlayer() {
        return new Player(this);
    }
    public Enemy getEnemy() {
        return new Enemy(this);
    }

    public IRandomizer getRandomizer() {
        return new Randomizer();
    }
}
