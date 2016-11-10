
package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Human {
    private Vector2 position;
    private int HEIGHT = 100;
    private int WIDTH = 60;
    private int speed = 10;
 
    public Human(int x, int y) {
        position = new Vector2(x,y); 
    }    
 
    public Vector2 getPosition() {
        if (position.x <= 50) {
            position.x = 50;
        }
        if (position.x >= 500) {
            position.x = 500;
        }
        return position;    
    }
    
    public int height() {
        return HEIGHT;
    }
    
    public int width() {
        return WIDTH;
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
