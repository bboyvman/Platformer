package com.chhimd.platformer.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.chhimd.platformer.controller.LevelController;

public class Enemy extends Sprite {


    public Enemy(Vector2 position ,int width, int height, String sheetPath) {
        super(position, width, height, sheetPath);

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width / 2f, this.height / 2f), 0f);

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);

        physicsbody = LevelController.gameWorld.createBody(bodyDefinition);
        physicsbody.setUserData(this);


        physicsbody.createFixture(fixtureDefinition);
        rectangleShape.dispose();

        animations.put("stand", spriteSheet.createAnimation(0, 1, 0.1f));

        currentAnimation = "stand";

    }

    public void draw(Batch spriteBatch) {
        super.draw(spriteBatch);
    }
    // function to update position of player
    public void updates(float deltaTime) {
        super.updates(deltaTime);

    }

}
