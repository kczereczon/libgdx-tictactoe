package com.krzysztofczereczon.ticktactoe;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class NextSignWindow extends Sprite{

    CurrentSignTile currentSignTile;
    Game game;

    public NextSignWindow(Game game){
        super(new Texture("smallwindow.png"));
        this.setSize(100, 100);
        this.setPosition(350, 437);
        this.game = game;
        currentSignTile = new CurrentSignTile(getX(), getY()+5, getWidth(), getHeight());
    }

    public void update(SpriteBatch batch){
        batch.draw(this, getX(), getY());
        currentSignTile.update(batch, game.currentSign);
    }

}
