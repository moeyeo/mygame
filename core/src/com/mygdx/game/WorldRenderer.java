
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
    private Ball ball;
    private Shuriken shuriken;
    private Rock rock1;
    private Rock rock2;
    private Rock rock3;
    private Tree tree;
    private DoubleRock doubleRock1;
    private DoubleRock doubleRock2;
    private Texture humanImg;
    private Texture coinImg;
    private Texture clockImg;
    private Texture ballImg;
    private Texture shurikenImg;
    private Texture rockImg;
    private Texture treeImg;
    private Texture doubleRockImg;
    private Texture floorImg;
    private Texture overImg;
    private BitmapFont font;
    
    float TIME = 30;
    float ballTime = 0;
    float invisibleTime = 0;
    int gameStage = 1;
    int bonus = 0;
    int score = 0;
    int highScore = 0;
    
    public WorldRenderer(MyGame myGame, World world) {
        this.myGame = myGame;
        this.world = world;
        
        human = world.getHuman();
        humanImg = new Texture("human.png");
        
        coin = world.getCoin();
        coinImg = new Texture("coin.png");
        
        clock = world.getClock();
        clockImg = new Texture("clock.png");
        
        ball = world.getBall();
        ballImg = new Texture("ball.png");
        
        shuriken = world.getShuriken();
        shurikenImg = new Texture("shuriken.png");
        
        rock1 = world.getRock(1);
        rock2 = world.getRock(2);
        rock3 = world.getRock(3);
        rockImg = new Texture("rock.png");
        
        tree = world.getTree();
        treeImg = new Texture("grass.jpg");
        
        doubleRock1 = world.getDoubleRock(1);
        doubleRock2 = world.getDoubleRock(2);
        doubleRockImg = new Texture("rock2.png");
        
        floorImg = new Texture("floor.jpg");
        overImg = new Texture("gameOver.png");
        
        font = new BitmapFont();
        
        batch = myGame.batch;
        }
    
    public void render(float delta) {
        Vector2 treePos = tree.getPosition();
        Vector2 humanPos = human.getPosition();
        Vector2 coinPos = coin.getPosition();
        Vector2 clockPos = clock.getPosition();
        Vector2 ballPos = ball.getPosition();
        Vector2 shurikenPos = shuriken.getPosition();
        Vector2 pos1 = rock1.getPosition();
        Vector2 pos2 = rock2.getPosition();
        Vector2 pos3 = rock3.getPosition();
        Vector2 posd1 = doubleRock1.getPosition();
        Vector2 posd2 = doubleRock2.getPosition();
        this.posHuman();
        TIME-=delta;
        
        if(gameStage==1) {
            batch.begin();
            batch.draw(floorImg, treePos.x, treePos.y);
            batch.draw(treeImg, treePos.x, treePos.y);
            batch.draw(treeImg, treePos.x+550, treePos.y);
            batch.draw(humanImg, humanPos.x, humanPos.y);  
            batch.draw(coinImg, coinPos.x, coinPos.y);
            batch.draw(clockImg, clockPos.x, clockPos.y);
            batch.draw(ballImg, ballPos.x, ballPos.y);
            batch.draw(shurikenImg, shurikenPos.x, shurikenPos.y);
            batch.draw(rockImg, pos1.x, pos1.y);
            batch.draw(rockImg, pos2.x, pos2.y);
            batch.draw(rockImg, pos3.x, pos3.y);
            batch.draw(doubleRockImg, posd1.x, posd1.y);
            batch.draw(doubleRockImg, posd2.x, posd2.y);
            font.draw(batch,""+TIME,250, 850);
            font.draw(batch,""+score,450, 850);
            font.draw(batch,""+bonus,450, 800);
            batch.end();
            score += ((int)treePos.y+1-(int)treePos.y);
            this.isOver(pos1);
            this.isOver(pos2);
            this.isOver(pos3);
            this.isOver2(posd1);
            this.isOver2(posd2);
            this.checkCoin();
            this.checkClock();
            this.checkBall();
            this.checkShuriken();
            this.checkRock(pos2);
            this.checkDoubleRock(posd2);
            this.isTimeOver();
        }
        if(gameStage==2) {
            ballStage(delta);
        }
        
        if(gameStage==3) {
            invisibleStage(delta);
        }
        
        if(gameStage==0) {
            endStage();
        }
    }
    
    private void endStage() {
        if(score>highScore)
            highScore = score;
        Vector2 treePos = tree.getPosition();
        Vector2 humanPos = human.getPosition();
        Vector2 coinPos = coin.getPosition();
        Vector2 pos1 = rock1.getPosition();
        Vector2 pos2 = rock2.getPosition();
        Vector2 pos3 = rock3.getPosition();
        Vector2 posd1 = doubleRock1.getPosition();
        Vector2 posd2 = doubleRock2.getPosition();
        batch.begin();
        batch.draw(floorImg, 0, 0);
        batch.draw(treeImg, treePos.x, treePos.y);
        batch.draw(treeImg, treePos.x+550, treePos.y);
        batch.draw(humanImg, humanPos.x, humanPos.y);        
        batch.draw(coinImg, coinPos.x, coinPos.y);
        batch.draw(rockImg, pos1.x, pos1.y);
        batch.draw(rockImg, pos2.x, pos2.y);
        batch.draw(rockImg, pos3.x, pos3.y);
        batch.draw(doubleRockImg, posd1.x, posd1.y);
        batch.draw(doubleRockImg, posd2.x, posd2.y);
        font.draw(batch,"SCORE : "+score,250, 430);
        font.draw(batch,"BONUS : "+bonus,250, 400);
        font.draw(batch,"TOTAL SCORE : "+(score+bonus),250, 370);
        font.draw(batch,"HIGH SCORE : "+(score+bonus),250, 340);
        batch.draw(overImg, 150, 450);
        batch.end();
        this.checkRock(pos2);
        this.checkDoubleRock(posd2);
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            gameStage = 1;
            ballTime = 0;
            invisibleTime =0;
            score=0;
            TIME=10;
            bonus=0;
            this.posHuman();
        }
    }
    
    private void ballStage(float delta) {
        coin.move(8);
        clock.move(8);
        ball.move(8);
        rock1.move(8);
        tree.move(8);
        rock2.move(8);
        rock3.move(8);
        doubleRock1.move(8);
        doubleRock2.move(8);
        Vector2 treePos = tree.getPosition();
        Vector2 humanPos = human.getPosition();
        Vector2 coinPos = coin.getPosition();
        Vector2 clockPos = clock.getPosition();
        Vector2 ballPos = ball.getPosition();
        Vector2 shurikenPos = shuriken.getPosition();
        Vector2 pos1 = rock1.getPosition();
        Vector2 pos2 = rock2.getPosition();
        Vector2 pos3 = rock3.getPosition();
        Vector2 posd1 = doubleRock1.getPosition();
        Vector2 posd2 = doubleRock2.getPosition();
        ballTime -= delta;
        if(ballTime<=0){
            gameStage=1;
            ballTime=0;
            this.posHuman();
        }
        batch.begin();
        batch.draw(floorImg, treePos.x, treePos.y);
        batch.draw(treeImg, treePos.x, treePos.y);
        batch.draw(treeImg, treePos.x+550, treePos.y);
        batch.draw(humanImg, humanPos.x, humanPos.y);  
        batch.draw(coinImg, coinPos.x, coinPos.y);
        batch.draw(clockImg, clockPos.x, clockPos.y);
        batch.draw(ballImg, ballPos.x, ballPos.y);
        batch.draw(shurikenImg, shurikenPos.x, shurikenPos.y);
        batch.draw(rockImg, pos1.x, pos1.y);
        batch.draw(rockImg, pos2.x, pos2.y);
        batch.draw(rockImg, pos3.x, pos3.y);
        batch.draw(doubleRockImg, posd1.x, posd1.y);
        batch.draw(doubleRockImg, posd2.x, posd2.y);
        font.draw(batch,""+TIME,250, 850);
        font.draw(batch,""+score,450, 850);
        font.draw(batch,""+bonus,450, 800);
        batch.end();
        score += ((int)treePos.y+1-(int)treePos.y);
        this.checkCoin();
        this.checkClock();
        this.checkRock(pos2);
        this.checkDoubleRock(posd2);
        this.checkBall();
        this.checkShuriken();
        this.isTimeOver();
    }
    
    private void invisibleStage(float delta) {
        Vector2 treePos = tree.getPosition();
        Vector2 humanPos = human.getPosition();
        Vector2 coinPos = coin.getPosition();
        Vector2 clockPos = clock.getPosition();
        Vector2 ballPos = ball.getPosition();
        Vector2 shurikenPos = shuriken.getPosition();
        Vector2 pos1 = rock1.getPosition();
        Vector2 pos2 = rock2.getPosition();
        Vector2 pos3 = rock3.getPosition();
        Vector2 posd1 = doubleRock1.getPosition();
        Vector2 posd2 = doubleRock2.getPosition();
        this.posHuman();
        invisibleTime -= delta;
        if(invisibleTime<=0){
            gameStage=1;
            invisibleTime=0;
            this.posHuman();
        }
        batch.begin();
        batch.draw(floorImg, treePos.x, treePos.y);
        batch.draw(treeImg, treePos.x, treePos.y);
        batch.draw(treeImg, treePos.x+550, treePos.y);
        batch.draw(humanImg, humanPos.x, humanPos.y);  
        batch.draw(coinImg, coinPos.x, coinPos.y);
        batch.draw(clockImg, clockPos.x, clockPos.y);
        batch.draw(ballImg, ballPos.x, ballPos.y);
        batch.draw(shurikenImg, shurikenPos.x, shurikenPos.y);
        batch.draw(rockImg, pos1.x, pos1.y);
        batch.draw(rockImg, pos2.x, pos2.y);
        batch.draw(rockImg, pos3.x, pos3.y);
        batch.draw(doubleRockImg, posd1.x, posd1.y);
        batch.draw(doubleRockImg, posd2.x, posd2.y);
        font.draw(batch,""+TIME,250, 850);
        font.draw(batch,""+score,450, 850);
        font.draw(batch,""+bonus,450, 800);
        batch.end();
        score += ((int)treePos.y+1-(int)treePos.y);
        this.checkCoin();
        this.checkClock();
        this.checkRock(pos2);
        this.checkDoubleRock(posd2);
        this.checkBall();
        this.checkShuriken();
        this.isTimeOver();
    }
    
    private void posHuman(){
        if(gameStage==1||gameStage==0){
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                humanImg = new Texture("human1.png");
            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                humanImg = new Texture("human.png");
            }
        }
        if(gameStage==2){
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                humanImg = new Texture("shuman1.png");
            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                humanImg = new Texture("shuman.png");
            }
        }
        if(gameStage==3){
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                humanImg = new Texture("ihuman1.png");
            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                humanImg = new Texture("ihuman.png");
            }
        }
    }
    
    private void checkCoin() {
        Vector2 humanPos = human.getPosition();
        Vector2 coinPos = coin.getPosition();
        if(coinPos.y<humanPos.y+human.height()&&coinPos.y+25>humanPos.y) {
            if(coinPos.x+20>humanPos.x && coinPos.x+20<humanPos.x+human.width()){
                coin.delete(coinPos);
                bonus += 100;
            }
        }
    }
    
    private void checkClock() {
        Vector2 humanPos = human.getPosition();
        Vector2 clockPos = clock.getPosition();
        
        if(clockPos.y<humanPos.y+human.height()&&clockPos.y+25>humanPos.y) {
            if(clockPos.x+20>humanPos.x && clockPos.x+20<humanPos.x+human.width()){
                clock.delete(clockPos);
                TIME += 10;
            }
        }
    }
    
    private void checkBall() {
        Vector2 humanPos = human.getPosition();
        Vector2 ballPos = ball.getPosition();
        
        if(ballPos.y<humanPos.y+human.height()&&ballPos.y+25>humanPos.y) {
            if(ballPos.x+20>humanPos.x && ballPos.x+20<humanPos.x+human.width()){
                ball.delete(ballPos);
                gameStage=2;
                ballTime+=5;
            }
        }
    }
    
    private void checkShuriken() {
        Vector2 humanPos = human.getPosition();
        Vector2 shurikenPos = shuriken.getPosition();
        
        if(shurikenPos.y<humanPos.y+human.height()&&shurikenPos.y+25>humanPos.y) {
            if(shurikenPos.x+20>humanPos.x && shurikenPos.x+20<humanPos.x+human.width()){
                shuriken.delete(shurikenPos);
                gameStage=3;
                invisibleTime+=5;
            }
        }
    }
    
    private void isTimeOver() {
        if(TIME <= 0)
            gameStage=0;
    }
    
    private void isOver(Vector2 pos) {
        Vector2 humanPos = human.getPosition();
        if(humanPos.y+human.height()-15<pos.y+rock1.height() && humanPos.y+human.height()-15>pos.y) {
            if((humanPos.x+15<pos.x+rock1.width() && humanPos.x+15>pos.x) ||
               (humanPos.x+human.width()-10<pos.x+rock1.width() && humanPos.x+human.width()-10>pos.x)) {
                gameStage = 0;
            }  
        }
    }
    
    private void isOver2(Vector2 pos) {
        Vector2 humanPos = human.getPosition();
        if(humanPos.y-15+human.height()<pos.y+rock1.height() && humanPos.y+human.height()-15>pos.y) {
            if((humanPos.x<pos.x+doubleRock1.width() && humanPos.x>pos.x) ||
               (humanPos.x+human.width()<pos.x+doubleRock1.width() && humanPos.x+human.width()>pos.x)) {
                gameStage = 0;
            }
        }
    }
    
    private void checkRock(Vector2 pos2) {
        Vector2 pos1 = rock1.getPosition();
        Vector2 pos3 = rock3.getPosition();
        if((pos1.y+300 >= pos2.y && pos2.y >= pos1.y-300 )
            ||(pos3.y+300>= pos2.y && pos2.y >= pos3.y-300))
            pos2.y = -900;
       
    }
    
    private void checkDoubleRock(Vector2 posd2) {
        Vector2 pos1 = rock1.getPosition();
        Vector2 pos2 = rock2.getPosition();
        Vector2 pos3 = rock3.getPosition();
        Vector2 posd = doubleRock1.getPosition();
        if((pos1.y+300) >= posd2.y && posd2.y >= (pos1.y-300 ))
            pos1.y = -900;
        if((pos2.y+300) >= posd2.y && posd2.y >= (pos2.y-300 ))
            pos2.y = -900;
        if((pos3.y+300) >= posd2.y && posd2.y >= (pos3.y-300 ))
            pos3.y = -900;
        if((pos1.y+300) >= posd.y && posd.y >= (pos1.y-300))
            pos1.y = -900;
        if((pos2.y+300) >= posd.y && posd.y >= (pos2.y-300))
            pos2.y = -900;
        if((pos3.y+300) >= posd.y && posd.y >= (pos3.y-300 ))
            pos3.y = -900;
        if((posd.y+300) >= posd2.y && posd2.y >= (posd.y-300 ))
            posd2.y = -900;
        
    }
}
