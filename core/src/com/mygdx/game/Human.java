/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Human {
    private Vector2 position;
    private int speed = 10;
 
    public Human(int x, int y) {
        position = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
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
