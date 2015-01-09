package com.chhimd.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class LevelController {
    public static TiledMap map;
    public static OrthogonalTiledMapRenderer renderer;

    // to draw our sprite on the screen
    public static Batch spriteBatch;

    public static World gameWorld;
    // draw the shape of the player object
    private static  Box2DDebugRenderer debugRenderer;

    public static void initializeController() {
        map = new TmxMapLoader().load("map/map1.tmx");// loading the map
        renderer = new OrthogonalTiledMapRenderer(map, 1 / 70f);// telling render how wide/tall it is

        gameWorld = new World(new Vector2(0, -10), true);
        debugRenderer = new Box2DDebugRenderer();

        // create a new spriteBatch object
        spriteBatch = renderer.getSpriteBatch();
    }

    public static void draw() {
        spriteBatch.begin();
        player.draw(spriteBatch);
        spriteBatch.end();
        // display the shape of the exact size
        debugRenderer.render(gameWorld, CameraController.camera.combined);
    }

    public static void update(float deltaTime) {
        renderer.setView(CameraController.camera);
        renderer.render();
        gameWorld.step(1/60f, 1, 1);
    }
}

