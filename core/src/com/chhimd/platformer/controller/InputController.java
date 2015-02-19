package com.chhimd.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.chhimd.platformer.model.InputControl;
import com.chhimd.platformer.model.Spritesheet;

public class InputController {

    public static Spritesheet spritesheet;
    public  static InputControl left;
    public  static InputControl right;

    public static void initializeController() {
        spritesheet = new Spritesheet("img/touch-controls.png", 80, 80);
        left = new InputControl(new Vector2(0,0), spritesheet.spriteFrames[0], "left");
        right = new InputControl(new Vector2(2,0), spritesheet.spriteFrames[1], "right");
        Gdx.input.setInputProcessor(createInputAdapter());
    }

    public static void draw(Batch spriteBatch) {
        spriteBatch.begin();
        left.draw(spriteBatch);
        right.draw(spriteBatch);
        spriteBatch.end();
    }

    private static InputAdapter createInputAdapter() {
        return new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                System.out.println("Touch Down");
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                System.out.println("Touch Up");
                return true;
            }
        };
    }

}
