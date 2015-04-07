package com.lib.gumisoft.factories;

import com.lib.gumisoft.entities.Tree;
import com.lib.gumisoft.fighters.Enemy;
import com.lib.gumisoft.fighters.Ninjago;
import com.lib.gumisoft.services.IRandomizer;
import com.lib.gumisoft.services.LegendDisplayService;
import com.lib.gumisoft.services.Randomizer;
import com.lib.gumisoft.services.SoundService;

public class Factory {
    private final RenderFactory renderFactory;
    private final TextureManager textureManager;
    private LegendDisplayService legendDisplayService;
    private Randomizer randomizer;
    private SoundService soundManager;

    public Factory() {
        soundManager = new SoundService(this);
        randomizer = new Randomizer();
        legendDisplayService = new LegendDisplayService(this);
        renderFactory = new RenderFactory(this);
        textureManager = new TextureManager(this);
    }
    public RenderFactory getRenderFactory() {return renderFactory;}
    public TextureManager getTextureManager() {return textureManager;}
    public SoundService getSoundmanager() {return soundManager;}
    public Ninjago getNinjago() {
        return new Ninjago(this);
    }
    public Enemy getEnemy() {
        return new Enemy(this);
    }
    public IRandomizer getRandomizer() {
        return randomizer;
    }
    public LegendDisplayService getLegendDisplayService() { return legendDisplayService; }
    public Tree getTree() {
        return new Tree(this);
    }


}
