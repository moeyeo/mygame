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
public class Tree {
    private Vector2 position;
 
    public Tree(int x, int y) {
        position = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public void move(int speed) {
        if(position.y<=-900){
            position.y = 0;
        }
        position.y -= speed;
    }
}
