package com.chhimd.platformer;


import com.badlogic.gdx.Game;
import com.chhimd.platformer.view.GameScreen;

public class Platformer extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());

    }
}
