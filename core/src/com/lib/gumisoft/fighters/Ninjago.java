package com.lib.gumisoft.fighters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.lib.gumisoft.factories.Factory;

public class Ninjago extends Fighter {
    Array<Texture> textures;
    private TextureRegion[][] animated;
    private TextureRegion[] walkFrames;
    private Animation walkAnimation;
    private float animationTime;

    public Ninjago(Factory factory) {
        super(factory);
    }

    @Override
    protected void setup() {
        textures = new Array<Texture>();
        textures.add(_factory.getTextureManager().getPlayerTextureKai());
        textures.add(_factory.getTextureManager().getPlayerTextureJay());
        textures.add(_factory.getTextureManager().getPlayerTextureZane());
        textures.add(_factory.getTextureManager().getPlayerTextureCole());
        Texture sheet = _factory.getTextureManager().getFrames();
        animated = TextureRegion.split(sheet, sheet.getWidth()/12, sheet.getHeight()/8);
        int randomCharacterX = _factory.getRandomizer().getRandomNumber(2)*4;
        int randomCharacterY = _factory.getRandomizer().getRandomNumber(4)*3;
        walkFrames = new TextureRegion[3];
        walkFrames[0] = animated[randomCharacterX][randomCharacterY+0];
        walkFrames[1] = animated[randomCharacterX][randomCharacterY+1];
        walkFrames[2] = animated[randomCharacterX][randomCharacterY+2];
        walkAnimation = new Animation(0.085f, walkFrames);
        animationTime = 0f;
    }

    @Override
    protected void setPosition() {
        position = new Vector2(200, 200);
    }

    @Override
    protected void setTexture() {
        int number = _factory.getRandomizer().getRandomNumber(textures.size);
        texture = textures.get(number);
    }

    @Override
    protected void applyMousePosition() {
        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.graphics.getHeight()-Gdx.input.getY();
        if (mouseX > position.x)
            directionX++;
        else
            directionX--;
        if (mouseY > position.y)
            directionY++;
        else
            directionY--;
    }

    @Override
    public void render(Batch batch) {
        move();
//        drawNinjago(batch);
        drawPrincess(batch);

    }

    private void drawPrincess(Batch batch) {
        animationTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = walkAnimation.getKeyFrame(animationTime, true);
        batch.draw(currentFrame, position.x, position.y);
    }

    private void drawNinjago(Batch batch) {
        batch.draw(texture, position.x, position.y);
    }

}
