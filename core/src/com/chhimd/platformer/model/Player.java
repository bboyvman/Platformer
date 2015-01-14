package com.chhimd.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.chhimd.platformer.controller.LevelController;
import com.chhimd.platformer.view.GameScreen;

import java.util.HashMap;


public class Player extends Sprite { // family tree

    public Player(Vector2 position ,int width, int height) {
        super(position, width, height);

        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);

        physicsbody = LevelController.gameWorld.createBody(bodyDefinition);
        physicsbody.setUserData(this);

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width / 2f, this.height / 2f), 0f);

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        physicsbody.createFixture(fixtureDefinition);
        rectangleShape.dispose();

        // stand, jump, walk, climb, hurt, idol, swim, climb, duck
        animations.put("stand", spriteSheet.createAnimation(8, 8, 0.1f ));
        animations.put("walk", spriteSheet.createAnimation(9, 10, 0.1f ));
        animations.put("duck", spriteSheet.createAnimation(3, 3, 0.1f ));
        animations.put("swim", spriteSheet.createAnimation(7, 8, 0.1f ));
        animations.put("idle", spriteSheet.createAnimation(6, 6, 0.1f ));
        animations.put("jump", spriteSheet.createAnimation(5, 5, 0.1f ));
        animations.put("climb", spriteSheet.createAnimation(1, 2, 0.1f));
        animations.put("hurt", spriteSheet.createAnimation(4, 4, 0.1f));
        // flipped  duck,jump,hurt,idle,swim,walk//
        animations.put("walkleft", spriteSheet.flipAnimation(animations.get("walk"), true, false));
        animations.put("duckleft", spriteSheet.flipAnimation(animations.get("duck"), true, false));
        animations.put("jumpleft", spriteSheet.flipAnimation(animations.get("jump"), true, false));
        animations.put("swimleft", spriteSheet.flipAnimation(animations.get("swim"), true, false));
        animations.put("idleleft", spriteSheet.flipAnimation(animations.get("idle"), true, false));
        animations.put("hurtleft", spriteSheet.flipAnimation(animations.get("hurt"), true, false));

        currentAnimation = "walk";

    }

    // function to draw speadsheet
    public void draw(Batch spriteBatch) {
        super.draw(spriteBatch);
    }
    // function to update position of player
    public void updates(float deltaTime) {
        super.updates(deltaTime);

     }
}




