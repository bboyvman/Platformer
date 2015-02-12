package com.chhimd.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.chhimd.platformer.controller.CameraController;
import com.chhimd.platformer.controller.EnemyController;
import com.chhimd.platformer.controller.InputController;
import com.chhimd.platformer.controller.LevelController;
import com.chhimd.platformer.controller.PlayerController;
import com.chhimd.platformer.model.Enemy;
import com.chhimd.platformer.model.InputControl;
import com.chhimd.platformer.model.Player;

public class GameScreen implements Screen {

    public GameScreen() {
      LevelController.initializeController();
      CameraController.initializeController();
      PlayerController.initializeController();
      EnemyController.initializeController();
        InputController.initializeController();

    }

    @Override
    // render is important b/c it updates
    public void render(float delta) {

        // set the color on the clear
        Gdx.gl.glClearColor(0.55f, 0.84f, 0.56f, 1f);

        // set clear color and you place it in there
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        LevelController.update(delta);
        CameraController.update();
        PlayerController.update(delta);
        EnemyController.update(delta);
        LevelController.draw();



    }

    @Override
    public void resize(int width, int height) {
       CameraController.realize(width, height);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
