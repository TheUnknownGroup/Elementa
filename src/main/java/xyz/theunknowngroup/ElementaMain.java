package xyz.theunknowngroup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ElementaMain {
    private SpriteBatch batch;
    private BitmapFont font;

    public ElementaMain() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, "Hello!", 427, 240);
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    public void resize(int i, int i1) {}
    public void pause() {}
    public void resume() {}
    public void hide() {}
    public void show() {}
}
