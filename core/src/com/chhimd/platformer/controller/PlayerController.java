package com.chhimd.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.chhimd.platformer.model.Player;

public class PlayerController {

    public static Player player;

    private static final float VELOCITY = 1f;
    private static final float MAX_VELOCITY = 5f;

    public static void initializeController() {

        player = new Player(new Vector2(2,2), 70, 100, "img/aliens.png");

    }

    public static void  update(float deltaTime) {
        handleInput();
        player.updates(deltaTime);
    }

    public static void draw(Batch spriteBatch) {
        player.draw(spriteBatch);
    }

    private static void handleInput () {
        Vector2 velocity = player.physicsbody.getLinearVelocity();
        Vector2 position = player.physicsbody.getPosition();

        if (velocity.x > MAX_VELOCITY) {
            velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
            player.physicsbody.setLinearVelocity(velocity.x, velocity.y);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.physicsbody.applyLinearImpulse(VELOCITY, 0f, position.x, position.y, true);
        }
    }
}
