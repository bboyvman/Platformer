package com.chhimd.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;

    public static void initializeController() {
        float width = Gdx.graphics.getWidth();// width for aspect ratio
        float height = Gdx.graphics.getHeight();// height for aspect ratio

        // enlarge gamescreen to match aspect ratio
        camera = new OrthographicCamera(14f, 14f * (height / width));// display how much map we want to show
        // adjust the camera to fit the map
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0); // set camera position

    }

    public static void update() {
        camera.update();// upadating the camera
    }

    public static void realize(int width, int height) {
        // set view port to 14units width
        camera.viewportWidth = 14f;
        // new height and width of the window
        camera.viewportHeight = 14f * height / width;
        camera.update();
    }
}
