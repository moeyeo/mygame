
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class WorldRenderer {
    public SpriteBatch batch;
    private MyGame myGame;
    private World world;
    private Human human;
    private Coin coin;
    private Clock clock;
    private Rock rock1;
    private Rock rock2;
    private Rock rock3;
    private Tree tree;
    private DoubleRock doubleRock1;
    private DoubleRock doubleRock2;
    private Texture humanImg;
    private Texture coinImg;
    private Texture clockImg;
    private Texture rockImg;
    private Texture treeImg;
    private Texture doubleRockImg;
    private Texture floorImg;
    private Texture overImg;
    private BitmapFont font;
    float TIME = 30;
    boolean gameStage = true;
    int bonus = 0;
    int score = 0;
    
    public WorldRenderer(MyGame myGame, World world) {
        this.myGame = myGame;
        this.world = world;
        
        human = world.getHuman();
        humanImg = new Texture("human.png");
        
        coin = world.getCoin();
        coinImg = new Texture("coin.png");
        
        clock = world.getClock();
        clockImg = new Texture("clock.png");
        
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
        overImg = new Texture("gameOver.png");
        
        font = new BitmapFont();
        
        batch = myGame.batch;
        }
    
    public void render(float delta) {
        Vector2 treePos = tree.getPosition();
        Vector2 humanPos = human.getPosition();
        Vector2 coinPos = coin.getPosition();
        Vector2 clockPos = clock.getPosition();
        Vector2 pos1 = rock1.getPosition();
        Vector2 pos2 = rock2.getPosition();
        Vector2 pos3 = rock3.getPosition();
        Vector2 posd = doubleRock1.getPosition();
        Vector2 posd1 = doubleRock2.getPosition();
        this.isOver(pos1);
        this.isOver(pos2);
        this.isOver(pos3);
        this.isOver2(posd);
        this.isOver2(posd1);
        TIME-=delta;
        
        if(gameStage) {
            batch.begin();
            batch.draw(floorImg, 0, 0);
            batch.draw(treeImg, treePos.x, treePos.y);
            batch.draw(treeImg, treePos.x+550, treePos.y);
            batch.draw(humanImg, humanPos.x, humanPos.y);        
            batch.draw(coinImg, coinPos.x, coinPos.y);
            batch.draw(clockImg, clockPos.x, clockPos.y);
            batch.draw(rockImg, pos1.x, pos1.y);
            batch.draw(rockImg, pos2.x, pos2.y);
            batch.draw(rockImg, pos3.x, pos3.y);
            batch.draw(doubleRockImg, posd.x, posd.y);
            batch.draw(doubleRockImg, posd1.x, posd1.y);
            font.draw(batch,""+TIME,250, 850);
            font.draw(batch,""+score,450, 850);
            font.draw(batch,""+bonus,450, 800);
            batch.end();
            score += ((int)treePos.y+1-(int)treePos.y);
            this.checkCoin();
            this.checkClock();
            this.isTimeOver();
        }
        else {
            endStage();
        }
    }
    
    private void checkCoin() {
        Vector2 humanPos = human.getPosition();
        Vector2 coinPos = coin.getPosition();
        if(coinPos.y<humanPos.y+human.height()&&coinPos.y>humanPos.y) {
            if(coinPos.x>humanPos.x && coinPos.x<humanPos.x+human.width()){
                coin.delete(coinPos);
                bonus += 100;
            }
        }
    }
    
    private void checkClock() {
        Vector2 humanPos = human.getPosition();
        Vector2 clockPos = clock.getPosition();
        
        if(clockPos.y<humanPos.y+human.height()&&clockPos.y>humanPos.y) {
            if(clockPos.x>humanPos.x && clockPos.x<humanPos.x+human.width()){
                clock.delete(clockPos);
                TIME += 10;
            }
        }
    }
    
    private void endStage() {
        Vector2 treePos = tree.getPosition();
        Vector2 humanPos = human.getPosition();
        Vector2 coinPos = coin.getPosition();
        Vector2 pos1 = rock1.getPosition();
        Vector2 pos2 = rock2.getPosition();
        Vector2 pos3 = rock3.getPosition();
        Vector2 posd = doubleRock1.getPosition();
        Vector2 posd1 = doubleRock2.getPosition();
        batch.begin();
        batch.draw(floorImg, 0, 0);
        batch.draw(treeImg, treePos.x, treePos.y);
        batch.draw(treeImg, treePos.x+550, treePos.y);
        batch.draw(humanImg, humanPos.x, humanPos.y);        
        batch.draw(coinImg, coinPos.x, coinPos.y);
        batch.draw(rockImg, pos1.x, pos1.y);
        batch.draw(rockImg, pos2.x, pos2.y);
        batch.draw(rockImg, pos3.x, pos3.y);
        batch.draw(doubleRockImg, posd.x, posd.y);
        batch.draw(doubleRockImg, posd1.x, posd1.y);
        font.draw(batch,"BONUS : "+bonus,250, 400);
        font.draw(batch,"SCORE : "+score,250, 430);
        batch.draw(overImg, 150, 450);
        batch.end();
    }
    
    private void isTimeOver() {
        if(TIME <= 0)
            gameStage=false;
    }
    
    private void isOver(Vector2 pos) {
        Vector2 humanPos = human.getPosition();
        if(humanPos.y+human.height()<pos.y+rock1.height() && humanPos.y+human.height()>pos.y) {
            if((humanPos.x<pos.x+rock1.width() && humanPos.x>pos.x) ||
               (humanPos.x+human.width()<pos.x+rock1.width() && humanPos.x+human.width()>pos.x)) {
                gameStage = false;
            }  
        }
    }
    
    private void isOver2(Vector2 pos) {
        Vector2 humanPos = human.getPosition();
        if(humanPos.y+human.height()<pos.y+rock1.height() && humanPos.y+human.height()>pos.y) {
            if((humanPos.x<pos.x+doubleRock1.width() && humanPos.x>pos.x) ||
               (humanPos.x+human.width()<pos.x+doubleRock1.width() && humanPos.x+human.width()>pos.x)) {
                gameStage = false;
            }
        }
    } 
}
