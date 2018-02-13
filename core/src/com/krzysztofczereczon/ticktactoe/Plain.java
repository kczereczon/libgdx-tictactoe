package com.krzysztofczereczon.ticktactoe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class Plain extends Sprite {

    Tile[][] tiles = new Tile[3][3]; //quad in tictactoe is 3x3
    boolean plainClicked = false;
    boolean isWin = false;
    int mouseX;
    int mouseY;
    Game game;
    int usedTiles = 0;

    public Plain(Game game){
        super(new Texture("tictactoe.png"));
        this.setSize(300, 307);
        this.setPosition(250, 66);
        this.game = game;
        //making quad
        createPlain();

        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if (button == Input.Buttons.LEFT) {
                    if(usedTiles >= 9 || isWin == true){
                        renewPlain();

                    }else {
                        plainClicked = true;
                        mouseX = screenX;
                        mouseY = screenY;
                        System.out.println("X: " + screenX + " Y: " + screenY);
                    }
                    return true;
                }
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if (button == Input.Buttons.LEFT) {
                    plainClicked = false;
                    //System.out.println("Puszczono");
                    return true;
                }
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(int amount) {
                return false;
            }
        });
    }

    public void createPlain(){
        for(int x = 0; x <= 2; x++){
            for(int y = 0; y <= 2; y++){
                tiles[x][y] = new Tile(x, y, (int)this.getX(), (int)this.getY(), game);
            }
        }
    }

    public void renewPlain(){
        tiles = new Tile[3][3];
        usedTiles = 0;
        isWin = false;
        createPlain();
    }

    public void update(SpriteBatch batch){
        batch.draw(this, this.getX(), this.getY());
        for (Tile[] tiles1: tiles
             ) {
            for (Tile tile: tiles1
                 ) {
                if(tile.getTexture() != null)
                    tile.render(batch);
                if(plainClicked) {
                    if(tile.checkClick(mouseX, mouseY, game.currentSign)){
                        usedTiles++;
                        if(game.currentSign == 0){
                            game.currentSign = 1;
                        }else{
                            game.currentSign = 0;
                        }
                    }
                }
            }
        }
        checkWin();
    }

    public void checkWin(){
        //left stright line
        if(tiles[0][1].sign == tiles[0][2].sign && tiles[0][1].sign == tiles[0][0].sign && tiles[0][0].sign != 3){
            isWin = true;
        }
        //right stright line
        if(tiles[2][1].sign == tiles[2][2].sign && tiles[2][1].sign == tiles[2][0].sign && tiles[2][0].sign != 3){
            isWin = true;
        }
        //up strigt line
        if(tiles[0][2].sign == tiles[1][2].sign && tiles[0][2].sign == tiles[2][2].sign && tiles[2][2].sign != 3){
            isWin = true;
        }
        //down stright line
        if(tiles[0][0].sign == tiles[1][0].sign && tiles[0][0].sign == tiles[2][0].sign && tiles[2][0].sign != 3){
            isWin = true;
        }
        //from left corner diagonal line
        if(tiles[2][0].sign == tiles[1][1].sign && tiles[2][0].sign == tiles[0][2].sign && tiles[0][2].sign != 3){
            isWin = true;
        }
        //from right corner diagonal line
        if(tiles[2][2].sign == tiles[1][1].sign && tiles[2][2].sign == tiles[0][0].sign && tiles[0][0].sign != 3){
            isWin = true;
        }
        //center vertical line
        if(tiles[1][0].sign == tiles[1][1].sign && tiles[1][1].sign == tiles[1][2].sign && tiles[1][2].sign != 3){
            isWin = true;
        }
        //center horizontal line
        if(tiles[0][1].sign == tiles[1][1].sign && tiles[0][1].sign == tiles[2][1].sign && tiles[2][1].sign != 3){
            isWin = true;
        }
    }

}
