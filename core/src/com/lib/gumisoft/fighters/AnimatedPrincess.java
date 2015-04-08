package com.lib.gumisoft.fighters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.lib.gumisoft.factories.Factory;

public class AnimatedPrincess extends PlayerControlledFighter {
    private TextureRegion[][] animated;
    private TextureRegion[] walkFrames;
    private Animation walkAnimation;
    private float animationTime;

    public AnimatedPrincess(Factory factory, Vector2 position) {
        super(factory, position);
    }

    @Override
    protected void setup() {
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
    protected void setTexture() {
    }

    @Override
    public void render(Batch batch) {
        move();
        drawPrincess(batch);
    }

    private void drawPrincess(Batch batch) {
        animationTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = walkAnimation.getKeyFrame(animationTime, true);
        batch.draw(currentFrame, _position.x, _position.y);
    }
}
