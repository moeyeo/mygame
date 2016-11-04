/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Human {
    private Vector2 position;
    private int[][] humanSize;
    private int speed = 10,width=60,height=100;
 
    public Human(int x, int y) {
        position = new Vector2(x,y);
        
    }    
 
    public Vector2 getPosition() {
        if(position.x<=50)
            position.x = 50;
        if(position.x>=500)
            position.x = 500;
        return position;    
    }
    
    public int[][] Size() {
        for(int i=0 ; i <= width ; i++){
            for(int j=0 ; j <= height ; j++){
                humanSize[i][j] = 1;
            }
        }
        return humanSize;
    }
    
    public void move(int dir) { 
        switch(dir) {
        case -1:
            position.x += speed;
            break;
        case 1:
            position.x -= speed;
            break;
        }
    }
}
