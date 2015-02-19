package com.chhimd.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.chhimd.platformer.model.Enemy;
import com.chhimd.platformer.model.Player;

public class EnemyController {

    private static final float VELOCITY = 1f;
    private static final float MAX_VELOCITY = 5f;

    public static Enemy enemy;

    public static void initializeController() {

        enemy = new Enemy(new Vector2(3,3), 51, 58, "img/enemy-barnacle.png");

    }



    public static void update(float deltaTime) {
        enemy.updates(deltaTime);


        Vector2 velocity = enemy.physicsbody.getLinearVelocity();
        Vector2 position = enemy.physicsbody.getPosition();

        if (velocity.x > MAX_VELOCITY) {
            velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
            enemy.physicsbody.setLinearVelocity(velocity.x, velocity.y);
        }

        enemy.physicsbody.applyLinearImpulse(VELOCITY, 0f, position.x, position.y, true);

    }
    public static void draw(Batch spriteBatch) {
        enemy.draw(spriteBatch);
    }

}
