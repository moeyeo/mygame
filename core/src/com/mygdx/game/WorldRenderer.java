
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class WorldRenderer {
    private MyGame myGame;
    private World world;
    private Human human;
    private Texture humanImg;
    public SpriteBatch batch;
    
    public WorldRenderer(MyGame myGame, World world) {
        this.myGame = myGame;
        this.world = world;
        human = world.getHuman();
        humanImg = new Texture("human.png");
        batch = myGame.batch;
    }
    
    public void render(float delta) {
        batch.begin();
        Vector2 pos = human.getPosition();
        batch.draw(humanImg, pos.x, pos.y);
        batch.end();;
    }
    
}
