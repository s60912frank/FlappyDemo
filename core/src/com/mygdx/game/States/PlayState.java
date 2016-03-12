package com.mygdx.game.States;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.flappyDemo;
import com.mygdx.game.sprites.Bird;
import com.mygdx.game.sprites.Tube;

import javax.swing.DebugGraphics;

/**
 * Created by 繼民 on 2016/2/29.
 */
public class PlayState extends State {
    private Bird bird;
    private Texture background;
    private Texture ground;
    private Vector2 groundPos1, groundPos2;
    private static final int TUBE_SPACING = 150;
    private static final int TUBE_COUNT = 4;
    private static final int GROUND_Y_OFFSET = -70;
    private Array<Tube> tubes;
    private OrthographicCamera cam;

    protected PlayState(GameStateManager gsm, OrthographicCamera cam) {
        super(gsm);
        this.cam = cam;
        cam.position.x = flappyDemo.WIDTH / 2;
        bird = new Bird(160, 300);
        background = new Texture("bg.png");
        ground = new Texture("ground.png");
        groundPos1 = new Vector2(cam.position.x - cam.viewportWidth/2, GROUND_Y_OFFSET);
        groundPos2 = new Vector2((cam.position.x - cam.viewportWidth/2) + ground.getWidth(), GROUND_Y_OFFSET);
        tubes = new Array<Tube>();
        for(int i = 0;i < TUBE_COUNT;i++) {
            tubes.add(new Tube((i + 3) * TUBE_SPACING + Tube.TUBE_WIDTH));
        }
        //Gdx.app.log("Game", String.valueOf(cam.position.x));
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            bird.Jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        UpdateGround();
        bird.update(dt);
        cam.position.x = bird.getPosition().x + 80;
        for(int i = 0;i < tubes.size;i++){
            Tube tube = tubes.get(i);
            if(cam.position.x - cam.viewportWidth / 2 > tube.getPosTopTube().x + Tube.TUBE_WIDTH){
                //tube.Reposition(tube.getPosTopTube().x + (Tube.TUBE_WIDTH + TUBE_SPACING) * (TUBE_COUNT - 1));
                if(i == 0){
                    tube.Reposition(tubes.get(tubes.size - 1).getPosTopTube().x  + Tube.TUBE_WIDTH + TUBE_SPACING);
                }
                else{
                    tube.Reposition(tubes.get(i - 1).getPosTopTube().x  + Tube.TUBE_WIDTH + TUBE_SPACING);
                }
            }
            if(tube.Collides(bird.getBounds())){
                gsm.Set(new PlayState(gsm, cam));
                //com.mygdx.game.
                //執行到這裡就是死掉了，但我不知道如何在這裡呼叫GoToMaps
            }

        }
        if(bird.getPosition().y <= ground.getHeight() + GROUND_Y_OFFSET)
            gsm.Set(new PlayState(gsm, cam));
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, cam.position.x - flappyDemo.WIDTH / 2, 0, flappyDemo.WIDTH, flappyDemo.HEIGHT);
        sb.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);
        for(Tube tube : tubes){
            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            sb.draw(tube.getBottomTube(), tube.getPosButtomTube().x, tube.getPosButtomTube().y);
        }
        sb.draw(ground, groundPos1.x, groundPos1.y);
        sb.draw(ground, groundPos2.x, groundPos2.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        bird.dispose();
        for(Tube tube : tubes){
            tube.dispose();
        }
        ground.dispose();
    }

    private void UpdateGround(){
        if(cam.position.x - (cam.viewportWidth / 2) > groundPos1.x + ground.getWidth()) {
            groundPos1.add(ground.getWidth() * 2, 0);
        }
        if(cam.position.x - (cam.viewportWidth / 2) > groundPos2.x + ground.getWidth()) {
            groundPos2.add(ground.getWidth() * 2, 0);
        }
    }
}
