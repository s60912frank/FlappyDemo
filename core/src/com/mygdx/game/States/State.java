package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.flappyDemo;

/**
 * Created by 繼民 on 2016/2/29.
 */
public abstract class State {
    //protected OrthographicCamera cam;
    //private Viewport viewport;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    protected  State(GameStateManager gsm){
        this.gsm = gsm;
        mouse = new Vector3();
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
