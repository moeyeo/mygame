/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
 
public class GameScreen extends ScreenAdapter {
    MyGame myGame;
    World world;
    WorldRenderer worldRenderer;
    Human human;
    Coin coin;
    Rock rock1;
    Rock rock2;
    Rock rock3;
    DoubleRock doubleRock1;
    DoubleRock doubleRock2;
    int speed;
    
    public GameScreen(MyGame myGame) {
        this.myGame = myGame;
        world = new World(myGame);
        worldRenderer = new WorldRenderer(myGame,world);
        human = world.getHuman();
        coin = world.getCoin();
        rock1 = world.getRock(1);
        rock2 = world.getRock(2);
        rock3 = world.getRock(3);
        doubleRock1 = world.getDoubleRock(1);
        doubleRock2 = world.getDoubleRock(2);
    }
    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        worldRenderer.render(delta);
    }
    private void update(float delta) {
        speed = 5;
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            human.move(1);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            human.move(-1);
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
            coin.move(speed);
            rock1.move(speed+2);
            rock2.move(speed+2);
            rock3.move(speed+2);
            doubleRock1.move(speed+2);
            doubleRock2.move(speed+2);
        }
        coin.move(speed-3);
        rock1.move(speed);
        rock2.move(speed);
        rock3.move(speed);
        doubleRock1.move(speed);
        doubleRock2.move(speed);
        
    }
 
}
