package com.mygdx.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by 繼民 on 2016/2/29.
 */
public class GameStateManager {
    private Stack<State> states;

    public GameStateManager(){
        states = new Stack<State>();
    }

    public void Push(State state){
        states.push(state);
    }

    public void Pop(State state){
        states.pop().dispose();
    }

    public void Set(State state){
        states.pop().dispose();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
