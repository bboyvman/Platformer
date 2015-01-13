package com.chhimd.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.chhimd.platformer.controller.LevelController;

import java.util.HashMap;

public class Sprite {
    public Vector2 position; // a point for x, y positioning
    public Spritesheet spriteSheet;
    public float width;
    public float height;
    public String currentAnimation;


    protected float stateTime;
    protected HashMap<String, Animation> animations;

    public Sprite(Vector2 position, int width, int height) {
        this.position = position; // initialize the position to origin
        this.width = width * LevelController.UNIT_SCALE;
        this.height = height * LevelController.UNIT_SCALE;
        spriteSheet = new Spritesheet("img/aliens.png", width, height);
        animations = new HashMap<String, Animation>();
        stateTime = 0f;
    }
    // function to draw speadsheet
    public void draw(Batch spriteBatch) {
        // to draw the player on the screen
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);

    }
    // function to update position of player
    public void updates(float deltaTimes) {
        stateTime += deltaTimes;
    }

}
