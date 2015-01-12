package com.chhimd.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.chhimd.platformer.model.Player;

public class PlayerController {

    public static Player player;

    public static void initializeController() {

        player = new Player(70, 100);

    }

    public static void  update(float deltaTime) {
        player.updates(deltaTime);
    }

    public static void draw(Batch spriteBatch) {
        player.draw(spriteBatch);
    }
}
