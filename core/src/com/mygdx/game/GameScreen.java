package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
    private Ball ball;
    private Shuriken shuriken;
    private DoubleRock doubleRock1;
    private DoubleRock doubleRock2;
    int speed=5;
    float time=0;
    
    public GameScreen(MyGame myGame) {
        this.myGame = myGame;
        world = new World(myGame);
        worldRenderer = new WorldRenderer(myGame,world);
        human = world.getHuman();
        coin = world.getCoin();
        clock = world.getClock();
        ball = world.getBall();
        shuriken = world.getShuriken();
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
        time += delta;
        if(time > 10) {
            if(speed <= 10){
                speed += 1;
            }
            time = 0;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            time=0;
            speed=5;
        }
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
            ball.move(speed);
            shuriken.move(speed);
            rock1.move(speed+2);
            rock2.move(speed+2);
            rock3.move(speed+2);
            doubleRock1.move(speed+2);
            doubleRock2.move(speed+2);
        }
        
        tree.move(speed-2);
        coin.move(speed-2);
        clock.move(speed-2);
        ball.move(speed-2);
        shuriken.move(speed-2);
        rock1.move(speed);
        rock2.move(speed);
        rock3.move(speed);
        doubleRock1.move(speed);
        doubleRock2.move(speed);
    }
}
