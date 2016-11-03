/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import java.util.Random;

/**
 *
 * @author Moeyeo
 */
public class DoubleRock {
    
    private Vector2 position;
    Random rand = new Random();
    
    public DoubleRock(int x, int y) {
        position = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public void move(int speed) {
        if(position.y<-150){
            position.y = position.y = rand.nextInt(4000)+1500;
        }
        position.y -= speed;
    }
    
}
