package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

/**
 * Created by s6091 on 2016/3/2.
 */
public class Tube {
    private static final int FLACTUATION = 200;
    private static final int TUBE_GAP = 150;
    private static final int LOWEST_OPENING = 250;
    public static int TUBE_WIDTH;
    private Texture topTube, bottomTube;
    private Vector2 posTopTube, posButtomTube;
    private Rectangle boundsTop, boundsBot;
    private Random rand;

    public Tube(float x){
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        rand = new Random();
        TUBE_WIDTH = topTube.getWidth();

        posTopTube = new Vector2(x, rand.nextInt(FLACTUATION) + TUBE_GAP + LOWEST_OPENING);
        posButtomTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBot = new Rectangle(posButtomTube.x, posButtomTube.y ,bottomTube.getWidth(), bottomTube.getHeight());
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosButtomTube() {
        return posButtomTube;
    }

    public void Reposition(float x){
        posTopTube.set(x, rand.nextInt(FLACTUATION) + TUBE_GAP + LOWEST_OPENING);
        posButtomTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
        boundsTop.setPosition(posTopTube.x, posTopTube.y);
        boundsBot.setPosition(posButtomTube.x, posButtomTube.y);
    }

    public boolean Collides(Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }

    public void dispose(){
        bottomTube.dispose();
        topTube.dispose();
    }
}
