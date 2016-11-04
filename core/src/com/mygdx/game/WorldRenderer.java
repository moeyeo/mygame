
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class WorldRenderer {
    private MyGame myGame;
    private World world;
    private Human human;
    private Coin coin;
    private Rock rock1;
    private Rock rock2;
    private Rock rock3;
    private Tree tree;
    private DoubleRock doubleRock1;
    private DoubleRock doubleRock2;
    private Texture humanImg;
    private Texture coinImg;
    private Texture rockImg;
    private Texture treeImg;
    private Texture doubleRockImg;
    private Texture floorImg;
    public SpriteBatch batch;
    private BitmapFont font;
    private Vector2 rock1Size;
    private Vector2 rock2Size;
    private Vector2 rock3Size;
    private int[][] humanSize;
    
    public WorldRenderer(MyGame myGame, World world) {
        this.myGame = myGame;
        this.world = world;
        
        human = world.getHuman();
        humanImg = new Texture("human.png");
        
        coin = world.getCoin();
        coinImg = new Texture("coin.png");
        
        rock1 = world.getRock(1);
        rock2 = world.getRock(2);
        rock3 = world.getRock(3);
        rockImg = new Texture("rock.png");
        
        tree = world.getTree();
        treeImg = new Texture("grass2.png");
        
        doubleRock1 = world.getDoubleRock(1);
        doubleRock2 = world.getDoubleRock(2);
        doubleRockImg = new Texture("rock2.png");
        
        floorImg = new Texture("floor1.jpg");
        
        font = new BitmapFont();
        
        batch = myGame.batch;
        }
    
    public void render(float delta) {
        batch.begin();
        batch.draw(floorImg, 0, 0);
        Vector2 pos3 = tree.getPosition();
        batch.draw(treeImg, pos3.x, pos3.y);
        batch.draw(treeImg, pos3.x+550, pos3.y);
        Vector2 pos = human.getPosition();
        batch.draw(humanImg, pos.x, pos.y);
        Vector2 pos1 = coin.getPosition();
        batch.draw(coinImg, pos1.x, pos1.y);
        Vector2 pos2 = rock1.getPosition();
        batch.draw(rockImg, pos2.x, pos2.y);
        Vector2 pos4 = rock2.getPosition();
        batch.draw(rockImg, pos4.x, pos4.y);
        Vector2 pos5 = rock3.getPosition();
        batch.draw(rockImg, pos5.x, pos5.y);
        Vector2 posd = doubleRock1.getPosition();
        batch.draw(doubleRockImg, posd.x, posd.y);
        Vector2 posd1 = doubleRock2.getPosition();
        batch.draw(doubleRockImg, posd1.x, posd1.y);
        //font.draw(batch,""+world.getTime(),250, 850);
        batch.end();
        //this.isOver();
    }
    
    private void isOver() {
        rock1Size = rock1.Size();
        rock2Size = rock2.Size();
        rock3Size = rock3.Size();
        humanSize = human.Size();
    } 
}
