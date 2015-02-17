package com.chhimd.platformer.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.chhimd.platformer.controller.LevelController;

public class InputControl {

    public String action;
    public Vector2 position;

    private TextureRegion textureRegion;
    private float width;
    private float height;

    public InputControl(Vector2 position, TextureRegion textureRegion, String action) {
        this.textureRegion = textureRegion;
        this.position = position;
        this.action = action;

        width = textureRegion.getRegionWidth();
        height = textureRegion.getRegionHeight();

    }

    public void draw(Batch spriteBatch) {
        spriteBatch.draw(textureRegion, position.x, position.y, width * LevelController.UNIT_SCALE, height * LevelController.UNIT_SCALE);
    }
}
