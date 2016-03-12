package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by 繼民 on 2016/3/7.
 */
public class Animation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;

    public Animation(TextureRegion reigion, int frameCount, float cycleTime){
        frames = new Array<TextureRegion>();
        int frameWidth = reigion.getRegionWidth() / frameCount;
        for(int i = 0;i < frameCount;i++){
            frames.add(new TextureRegion(reigion, i * frameWidth, 0, frameWidth, reigion.getRegionHeight()));
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }

    public void update(float dt){
        currentFrameTime += dt;
        if(currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if(frame >= frameCount){
            frame = 0;
        }
    }

    public TextureRegion getFrame(){
        return frames.get(frame);
    }
}
