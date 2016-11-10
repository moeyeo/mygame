package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
 
public class GameScreen extends ScreenAdapter {
    MyGame myGame;
    World world;
    WorldRenderer worldRenderer;
    private Human human;
    private Coin coin;
    private Clock clock;
    private Rock rock1;
    private Rock rock2;
    private Rock rock3;
    private Tree tree;
    private DoubleRock doubleRock1;
    private DoubleRock doubleRock2;
    int speed;
    
    public GameScreen(MyGame myGame) {
        this.myGame = myGame;
        world = new World(myGame);
        worldRenderer = new WorldRenderer(myGame,world);
        human = world.getHuman();
        coin = world.getCoin();
        clock = world.getClock();
        rock1 = world.getRock(1);
        rock2 = world.getRock(2);
        rock3 = world.getRock(3);
        tree = world.getTree();
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
            tree.move(speed);
            coin.move(speed);
            clock.move(speed);
            rock1.move(speed+2);
            rock2.move(speed+2);
            rock3.move(speed+2);
            doubleRock1.move(speed+2);
            doubleRock2.move(speed+2);
        }
        
        tree.move(speed-2);
        coin.move(speed-2);
        clock.move(speed-2);
        rock1.move(speed);
        rock2.move(speed);
        rock3.move(speed);
        doubleRock1.move(speed);
        doubleRock2.move(speed);
    }
 
}
