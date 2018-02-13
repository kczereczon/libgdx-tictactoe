package com.krzysztofczereczon.ticktactoe;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CurrentSignTile extends Sprite {

    public CurrentSignTile(float x, float y, float width, float height){
        super(new Texture("0.png"));
        setPosition(x, y);
        setSize(width, height);
    }

    public void update(SpriteBatch batch, int currentSign){
        setTexture(new Texture(currentSign+".png"));
        batch.draw(this, getX(), getY());
    }
}
