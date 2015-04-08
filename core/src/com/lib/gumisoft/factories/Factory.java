package com.lib.gumisoft.factories;

import com.lib.gumisoft.entities.Tree;
import com.lib.gumisoft.fighters.AnimatedPrincess;
import com.lib.gumisoft.fighters.Enemy;
import com.lib.gumisoft.fighters.Ninjago;
import com.lib.gumisoft.fighters.PlayerControlledFighter;
import com.lib.gumisoft.services.*;

public class Factory {
    private final RenderService renderFactory;
    private final TextureManager textureManager;
    private LegendDisplayService legendDisplayService;
    private Randomizer randomizer;
    private SoundService soundManager;

    public Factory() {
        soundManager = new SoundService(this);
        randomizer = new Randomizer();
        legendDisplayService = new LegendDisplayService(this);
        renderFactory = new RenderService(this);
        textureManager = new TextureManager(this);
    }
    public RenderService getRenderFactory() {
        return renderFactory;
    }
    public TextureManager getTextureManager() {
        return textureManager;
    }
    public SoundService getSoundManager() {
        return soundManager;
    }
    public PlayerControlledFighter getNinjago() {
        return new Ninjago(this);
    }
    public PlayerControlledFighter getAnimatedPrincess() {
        return new AnimatedPrincess(this);
    }
    public Enemy getEnemy() {
        return new Enemy(this);
    }
    public IRandomizer getRandomizer() {
        return randomizer;
    }
    public LegendDisplayService getLegendDisplayService() {
        return legendDisplayService;
    }
    public Tree getTree() {
        return new Tree(this);
    }
}
