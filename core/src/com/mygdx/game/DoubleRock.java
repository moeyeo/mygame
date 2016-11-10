
package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import java.util.Random;

public class DoubleRock {
    
    private Vector2 position;
    private int WIDTH = 320,HEIGHT = 160;
    Random rand = new Random();
    
    public DoubleRock(int x, int y) {
        position = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public void move(int speed) {
        if(position.y <- 150){
            //position.y = position.y = rand.nextInt(4000)+1500;
            //position.y = 1200;
        }
        position.y -= speed;
    }
    
    public int width() {
        return WIDTH;
    }
    
    public int height() {
        return HEIGHT;
    }
    
}
