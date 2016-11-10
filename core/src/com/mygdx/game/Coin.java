/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import java.util.Random;

public class Coin {
    private Vector2 position;
    Random rand = new Random();
    
    public Coin(int x, int y) {
        position = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public void move(int speed) {
        if(position.y<-50){
            position.y = rand.nextInt(4000)+900;
            position.x = rand.nextInt(500)+50;
        }
        position.y -= speed;
    }
    
    public void delete(Vector2 pos) {
        position.y = -50;
    }   
}