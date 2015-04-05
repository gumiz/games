package com.lib.gumisoft.factories;

import com.lib.gumisoft.player.Player;

public class Factory {
    public Player getPlayer() {
        return new Player();
    }
}
