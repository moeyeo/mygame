/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import java.util.Random;
import java.util.Timer;

public class World {
    private Human human;
    private MyGame myGame;
    Random rand = new Random();
    private float score;
    private Coin coin;
    private Rock rock1;
    private Rock rock2;
    private Rock rock3;
    private DoubleRock doubleRock1;
    private DoubleRock doubleRock2;
    Timer timer = new Timer();
    
    World(MyGame myGame) {
        this.myGame = myGame;
        human = new Human(50,50);
        coin = new Coin(rand.nextInt(1000)+50,900);
        rock1 = new Rock(50,900);
        rock2 = new Rock(216,200);
        rock3 = new Rock(370,1800);
        doubleRock1 = new DoubleRock(166,500);
        doubleRock2 = new DoubleRock(50,1500);
        updateScore();
    }
    
    void updateScore(){
        score = System.nanoTime()/10^9;
    }
    Human getHuman(){
        return human;
    }
    
    Coin getCoin(){
        return coin;
    }
    
    Rock getRock(int x){
        if(x==1)
            return rock1;   
        else if(x==2)
            return rock2;
        else if(x==3)
            return rock3;
        return rock1;
    }
    
    DoubleRock getDoubleRock(int x){
        if(x==1)
            return doubleRock1;
        else if(x==2)
            return doubleRock2;
        return doubleRock1;
    }
    
    double getScore() {
        return score;
    }
}
