/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;


public class World {
    private Human human;
    private MyGame myGame;
    
    World(MyGame myGame) {
        this.myGame = myGame;
        human = new Human(50,50);
    }
    
    Human getHuman(){
        return human;
    }
}
