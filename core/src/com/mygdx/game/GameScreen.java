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
    private MyGame myGame;
    private Texture humanImg;
    private Human human;
    
    public GameScreen(MyGame myGame) {
        this.myGame = myGame;
        humanImg = new Texture("human1.png");
        human = new Human(100,50);
    }
    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = myGame.batch;
        batch.begin();
        Vector2 pos = human.getPosition();
        batch.draw(humanImg, pos.x, pos.y);
        batch.end();;
    }
    private void update(float delta) {
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            human.move(1);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            human.move(-1);
        }  
    }
 
}
