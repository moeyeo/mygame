/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import java.util.Random;

public class World {
    private Human human;
    private MyGame myGame;
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
    Random rand = new Random();
    
    World(MyGame myGame) {
        this.myGame = myGame;
        human = new Human(50,50);
        tree = new Tree(0,0);
        coin = new Coin(rand.nextInt(450)+50,900);
        clock = new Clock(rand.nextInt(450)+50,2000);
        ball = new Ball(rand.nextInt(450)+50,3000);
        shuriken = new Shuriken (rand.nextInt(450)+50,2500);
        rock1 = new Rock(50,900);
        rock2 = new Rock(216,900);
        rock3 = new Rock(382,900);
        doubleRock1 = new DoubleRock(200,900);
        doubleRock2 = new DoubleRock(50,900);
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
    
    Ball getBall(){
        return ball;
    }
    
    Shuriken getShuriken(){
        return shuriken;
    }
    
    Tree getTree(){
        return tree;
    }
    
    Rock getRock(int x){
        switch (x) {
            case 1:
                return rock1;
            case 2:
                return rock2;
            case 3:
                return rock3;
            default:
                break;
        }
        return rock1;
    }
    
    DoubleRock getDoubleRock(int x){
        switch (x) {
            case 1:
                return doubleRock1;
            case 2:
                return doubleRock2;
            default:
                return doubleRock1;
        }
    }
}
