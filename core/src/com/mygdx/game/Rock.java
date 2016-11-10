
package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import java.util.Random;

public class Rock {
    
    private Vector2 position;
    private Vector2 rockSize;
    private int WIDTH = 160,HEIGHT = 160;
    Random rand = new Random();
    int speed=0;
    
 
    public Rock(int x, int y) {
        position = new Vector2(x,y);
        rockSize = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public int width() {
        return WIDTH;
    }
    
    public int height() {
        return HEIGHT;
    }
    
    public void move(int speed) {
        if(position.y <= -300){
            position.y = rand.nextInt(1600)+900;
        }
        position.y -= speed;
    }
    
}
