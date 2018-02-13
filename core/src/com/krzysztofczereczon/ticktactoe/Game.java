package com.krzysztofczereczon.ticktactoe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Plain plain;
	NextSignWindow window;

	public int width = 800;
	public int height = 600;

	// 0 is circle, 1 is cross
	public int currentSign = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		plain = new Plain(this);
		window = new NextSignWindow(this);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.24f, 0.24f, 0.45f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		plain.update(batch);
		window.update(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		plain.getTexture().dispose();
		window.getTexture().dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		this.width = width;
		this.height = height;
		System.out.println(width +" XDD "+ height);
	}
}
