package com.krzysztofczereczon.ticktactoe;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile extends Sprite {

    public boolean used = false;
    public int sign = 3;
    Game game;

    public Tile(int x, int y, int plainX, int plainY, Game game) {
        super(new Texture("blank.png"));
        this.game = game;
        setSize(100, 100);
        setPosition(x*100 + plainX, y*100 + plainY);

    }

    public boolean checkClick(int x, int y, int currentSign) {
        if(used != true) {
            if (x > getX() * game.width/800 && x < (getX() + getWidth()) * game.width/800) {
                if (y  > (600 - getY() - getHeight()) * game.height/600  && y < (600 - getY()) * game.height/600) {
                    setTexture(new Texture(currentSign+".png"));
                    used = true;
                    sign = currentSign;
                    return true;
                }
            }
        }
        return false;
    }

    public void render(SpriteBatch batch) {
        batch.draw(this, getX(), getY());
    }
}
