
package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import java.util.Random;

/**
 *
 * @author Moeyeo
 */
public class Clock {
    private Vector2 position;
    Random rand = new Random();
    
    public Clock(int x, int y) {
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
