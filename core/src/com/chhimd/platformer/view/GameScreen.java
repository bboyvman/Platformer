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
import com.chhimd.platformer.model.Player;

public class GameScreen implements Screen {
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;
    // to draw our sprite on the screen
    public Batch spriteBatch;
    public Player player;

    public static World gameWorld;
    // draw the shape of the player object
    private Box2DDebugRenderer debugRenderer;

    public GameScreen() {
        map = new TmxMapLoader().load("map/map1.tmx");// loading the map
        renderer = new OrthogonalTiledMapRenderer(map, 1 / 70f);// telling render how wide/tall it is
        gameWorld = new World(new Vector2(0, -10), true);
        debugRenderer = new Box2DDebugRenderer();


        float width = Gdx.graphics.getWidth();// width for aspect ratio
        float height = Gdx.graphics.getHeight();// height for aspect ratio

        // enlarge gamescreen to match aspect ratio
        camera = new OrthographicCamera(14f, 14f * (height / width));// display how much map we want to show
        // adjust the camera to fit the map
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0); // set camera position

        // create a new spriteBatch object
        spriteBatch = renderer.getSpriteBatch();
        player = new Player(70, 100);

    }

    @Override
    // render is important b/c it updates
    public void render(float delta) {

        // set the color on the clear
        Gdx.gl.glClearColor(0.55f, 0.84f, 0.56f, 1f);

        // set clear color and you place it in there
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();// upadating the camera
        renderer.setView(camera);
        renderer.render();

        gameWorld.step(1/60f, 1, 1);

        player.updates(delta);
        spriteBatch.begin();
        player.draw(spriteBatch);
        spriteBatch.end();
        // display the shape of the exact size
        debugRenderer.render(gameWorld, camera.combined);

    }

    @Override
    public void resize(int width, int height) {
        // set view port to 14units width
        camera.viewportWidth = 14f;
        // new height and width of the window
        camera.viewportHeight = 14f * height / width;
        camera.update();

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
