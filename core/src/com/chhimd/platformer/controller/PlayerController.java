package com.chhimd.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.chhimd.platformer.model.Player;

public class PlayerController {

    public static Player player;

    public static void initializeController() {

        player = new Player(new Vector2(2,2), 70, 100);

    }

    public static void  update(float deltaTime) {
        player.updates(deltaTime);
    }

    public static void draw(Batch spriteBatch) {
        player.draw(spriteBatch);
    }
}
