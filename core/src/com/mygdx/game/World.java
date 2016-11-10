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
    private Coin coin;
    private Clock clock;
    private Rock rock1;
    private Rock rock2;
    private Rock rock3;
    private Tree tree;
    private DoubleRock doubleRock1;
    private DoubleRock doubleRock2;
    Random rand = new Random();
    
    World(MyGame myGame) {
        this.myGame = myGame;
        human = new Human(50,50);
        coin = new Coin(rand.nextInt(1000)+50,900);
        clock = new Clock(rand.nextInt(1000)+50,1200);
        rock1 = new Rock(50,900);
        rock2 = new Rock(216,200);
        rock3 = new Rock(382,1800);
        tree = new Tree(0,0);
        doubleRock1 = new DoubleRock(200,500);
        doubleRock2 = new DoubleRock(50,1500);
    }
    
    Human getHuman(){
        return human;
    }
    
    Coin getCoin(){
        return coin;
    }
    
    Clock getClock(){
        return clock;
    }
    
    Tree getTree(){
        return tree;
    }
    
    Rock getRock(int x){
        if (x == 1) {
            return rock1;
        }
        else if (x == 2) {
            return rock2;
        }
        else if (x == 3) {
            return rock3;
        }
        return rock1;
    }
    
    DoubleRock getDoubleRock(int x){
        if (x == 1) {
            return doubleRock1;
        }
        else if (x == 2) {
            return doubleRock2;
        }
        else {
            return doubleRock1;
        }
    }
}
