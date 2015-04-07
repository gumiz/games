package com.lib.gumisoft.factories;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class TextureManager {
    private final Factory _factory;
    private final Array<Texture> trees;
    private final Texture background;
    private final Texture kai;
    private final Texture jay;
    private final Texture kaiBig;
    private final Texture zane;
    private final Texture skeleton;
    private final Texture skeletonBig;

    public TextureManager(Factory factory) {
        _factory = factory;
        trees = new Array<Texture>();
        trees.add(new Texture("img/tree01.png"));
        trees.add(new Texture("img/tree02.png"));
        trees.add(new Texture("img/tree03.png"));
        background = new Texture("img/background01.png");
        kai = new Texture("img/playerNinjagoKai2.png");
        kaiBig = new Texture("img/playerNinjagoKaiBig.png");
        jay = new Texture("img/playerNinjagoJay.png");
        zane = new Texture("img/playerNinjagoZane.png");
        skeleton = new Texture("img/playerNinjagoSkeleton.png");
        skeletonBig = new Texture("img/playerNinjagoSkeletonBig.png");
    }

    public Texture getBackground() {
        return background;
    }
    public Texture getPlayerTextureKai() {
        return kai;
    }
    public Texture getPlayerTextureJay() {
        return jay;
    }
    public Texture getPlayerTextureZane() {
        return zane;
    }
    public Texture getPlayerTextureSkeleton() {
        return skeleton;
    }
    public Texture getPlayerTextureKaiBig() {
        return kaiBig;
    }
    public Texture getPlayerTextureSkeletonBig() {
        return skeletonBig;
    }
    public Array<Texture> getTreeTextures() {
        return trees;
    }
}
