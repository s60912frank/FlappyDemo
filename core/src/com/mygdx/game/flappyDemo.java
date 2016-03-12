package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.States.GameStateManager;
import com.mygdx.game.States.MenuState;

public class flappyDemo implements ApplicationListener {
	public static final int WIDTH = 480;
	public static int HEIGHT = 800;
	public static final String TITLE = "FlappyDemo";
	private GameStateManager gsm; //遊戲狀態管理員，控制遊戲狀態
	private SpriteBatch batch;
	private OrthographicCamera cam;

	private Music music;
	
	@Override
	public void create () {  //這裡是遊戲的Main
		cam = new OrthographicCamera();
		cam.setToOrtho(false, WIDTH, HEIGHT);
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
		gsm.Push(new MenuState(gsm, cam));
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		batch.setProjectionMatrix(cam.combined);
		gsm.render(batch);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		//super.dispose();
		music.dispose();
	}
}
