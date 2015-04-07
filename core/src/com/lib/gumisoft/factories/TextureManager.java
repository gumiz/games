package com.lib.gumisoft.factories;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class TextureManager {
    private final Factory _factory;
    private final Array<Texture> trees;

    public TextureManager(Factory factory) {
        _factory = factory;
        trees = new Array<Texture>();
        trees.add(new Texture("img/tree01.png"));
        trees.add(new Texture("img/tree02.png"));
        trees.add(new Texture("img/tree03.png"));
    }

    public Texture getBackground() {
        return new Texture("img/background01.png");
    }
    public Texture getPlayerTextureKai() {
        return new Texture("img/playerNinjagoKai2.png");
    }
    public Texture getPlayerTextureJay() {
        return new Texture("img/playerNinjagoJay.png");
    }
    public Texture getPlayerTextureZane() {
        return new Texture("img/playerNinjagoZane.png");
    }
    public Texture getPlayerTextureSkeleton() {
        return new Texture("img/playerNinjagoSkeleton.png");
    }
    public Texture getPlayerTextureKaiBig() {
        return new Texture("img/playerNinjagoKaiBig.png");
    }
    public Texture getPlayerTextureSkeletonBig() {
        return new Texture("img/playerNinjagoSkeletonBig.png");
    }
    public Array<Texture> getTreeTextures() {
        return trees;
    }
}
