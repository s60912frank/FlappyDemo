package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.flappyDemo;

/**
 * Created by 繼民 on 2016/2/29.
 */
public class MenuState extends State {
    private Texture background;
    private Texture playBtn;
    private OrthographicCamera cam;
    public MenuState(GameStateManager gsm, OrthographicCamera cam) {
        super(gsm);
        this.cam = cam;
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.Set(new PlayState(gsm, cam));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, flappyDemo.WIDTH, flappyDemo.HEIGHT);
        //sb.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(playBtn, flappyDemo.WIDTH / 2 - playBtn.getWidth() / 2, flappyDemo.HEIGHT / 2- playBtn.getHeight() / 2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
