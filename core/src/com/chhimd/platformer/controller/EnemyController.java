package com.chhimd.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.chhimd.platformer.model.Enemy;
import com.chhimd.platformer.model.Player;

public class EnemyController {

    public static Enemy enemy;

    public static void initializeController() {

        enemy = new Enemy(new Vector2(4,4), 70, 100);

    }

    public static void  update(float deltaTime) {
        enemy.updates(deltaTime);
    }

    public static void draw(Batch spriteBatch) {
        enemy.draw(spriteBatch);
    }

}
