/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class CheckStage {
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
    int gameStage;
    
    public int getStage() {
        this.checkBall();
        this.checkShuriken();
        this.isOver(pos1);
        this.isOver(pos2);
        this.isOver(pos3);
        this.isOver2(posd1);
        this.isOver2(posd2);
        return gameStage;
    }
    
    public int getStage2() {
        this.checkBall();
        this.checkShuriken();
        return gameStage;
    }
    
    private void checkBall() {
        if(ballPos.y<humanPos.y+human.height()&&ballPos.y+25>humanPos.y) {
            if(ballPos.x+20>humanPos.x && ballPos.x+20<humanPos.x+human.width()){
                ball.delete(ballPos);
                gameStage=2;
                //ballTime+=5;
            }
        }
    }
    
    private void checkShuriken() {
        if(shurikenPos.y<humanPos.y+human.height()&&shurikenPos.y+25>humanPos.y) {
            if(shurikenPos.x+20>humanPos.x && shurikenPos.x+20<humanPos.x+human.width()){
                shuriken.delete(shurikenPos);
                gameStage=3;
                //invisibleTime+=5;
            }
        }
    }
    
    
    private void isOver(Vector2 pos) {
        if(humanPos.y+human.height()-15<pos.y+rock1.height() && humanPos.y+human.height()-15>pos.y) {
            if((humanPos.x+15<pos.x+rock1.width() && humanPos.x+15>pos.x) ||
               (humanPos.x+human.width()-10<pos.x+rock1.width() && humanPos.x+human.width()-10>pos.x)) {
                gameStage = 0;
            }  
        }
    }
    
    private void isOver2(Vector2 pos) {
        if(humanPos.y-15+human.height()<pos.y+rock1.height() && humanPos.y+human.height()-15>pos.y) {
            if((humanPos.x<pos.x+doubleRock1.width() && humanPos.x>pos.x) ||
               (humanPos.x+human.width()<pos.x+doubleRock1.width() && humanPos.x+human.width()>pos.x)) {
                gameStage = 0;
            }
        }
    }
}
