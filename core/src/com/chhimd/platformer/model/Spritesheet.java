package com.chhimd.platformer.model;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spritesheet {
    public Texture spriteSheet; // an image(alien.png)
    public TextureRegion[] spriteFrames;


    public Spritesheet(String pathToFile, int width, int height) {
        //load up texture to our spreadsheet
        // allow to draw aliens on the screen
        // need to have a position and texture on the screen
        spriteSheet = new Texture(Gdx.files.internal(pathToFile));

        // draw two dimensional array
        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, width, height);

        // create rows and column in a table
        int counter = 0;
        for (int row = 0; row < spriteSheetFrames.length; row++) {
            for (int column = 0; column < spriteSheetFrames[row].length; column++) {
                counter++;
            }
        }

        // store 55 character into spriteframes
        spriteFrames = new TextureRegion[counter];
        //** reset the counter **//
        counter = 0;
        for (TextureRegion[] row : spriteSheetFrames) {
            for (TextureRegion sprite : row) {
                spriteFrames[counter++] = sprite;

            }
        }
    }
    // where to start and where to end(start and last frame, how fast or slow animation run
    public Animation createAnimation(int startFrame, int lastFrame, float animationSpeed) {
        // how many frame to use for the last animation
        int counter = (lastFrame + 1) - startFrame;
        TextureRegion[] animationFrames = new TextureRegion[counter];

        // create animation frames
        for (int index = lastFrame; index >= startFrame; index--) {
            animationFrames[--counter] = spriteFrames[index];
        }

        return new Animation(animationSpeed, animationFrames);
    }

    public Animation flipAnimation(Animation orignalAnimation, boolean flipX, boolean flipY) {
        int frameCount = orignalAnimation.getKeyFrames().length;
        TextureRegion[] flippedFrames = new TextureRegion[frameCount];

        // does account the number 0, substract 1 to get the true number
        for (int index = 0; index <= frameCount - 1; index++) {
            flippedFrames[index] = new TextureRegion(orignalAnimation.getKeyFrames()[index]);
            flippedFrames[index].flip(flipX, flipY);
        }
        return new Animation(orignalAnimation.getFrameDuration(), flippedFrames);
    }
}











