package com.chhimd.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.chhimd.platformer.model.Level;
import com.chhimd.platformer.model.Player;

public class LevelController {

    public static final float UNIT_SCALE = 1/70f;

    public static Level level;

    public static OrthogonalTiledMapRenderer renderer;

    // to draw our sprite on the screen
    public static Batch spriteBatch;

    public static World gameWorld;

    public static Array<Body> worldBodies;
    // draw the shape of the player object
    private static  Box2DDebugRenderer debugRenderer;

    public static void initializeController() {
         level = new Level("map/map1.tmx");
         renderer = new OrthogonalTiledMapRenderer(level.map, UNIT_SCALE);// telling render how wide/tall it is
        gameWorld = new World(new Vector2(0, -10), true);
        worldBodies = new Array<Body>();
        debugRenderer = new Box2DDebugRenderer();

        // create a new spriteBatch object
        spriteBatch = renderer.getSpriteBatch();
    }

    public static void draw() {
        spriteBatch.begin();
        PlayerController.draw(spriteBatch);
        spriteBatch.end();
        // display the shape of the exact size
        debugRenderer.render(gameWorld, CameraController.camera.combined);
    }

    public static void update(float deltaTime) {
        renderer.setView(CameraController.camera);
        renderer.render();
        updateWorldBodies();
        gameWorld.step(1/60f, 1, 1);
    }

    private static void updateWorldBodies() {
        worldBodies.clear(); // clears the box
        gameWorld.getBodies(worldBodies);

        for (Body body : worldBodies) { //access every body in world bodies
            Player playerBody = (Player)body.getUserData();//casting a variable
            playerBody.position = body.getPosition();//this line does all the work
        }
    }
}

