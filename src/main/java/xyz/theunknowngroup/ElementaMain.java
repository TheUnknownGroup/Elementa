package xyz.theunknowngroup;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static xyz.theunknowngroup.builders.textures.TextureBuilder.getTexture;
import static xyz.theunknowngroup.builders.models.ModelBuilders.createModel;
public class ElementaMain extends Game {
    private SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
    }
    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        Gdx.gl.glClearColor(R, G, B, A);
        batch.begin();
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                getTexture("assets/texture/dirt.png", batch, i * 15, j * 15, 64, 32);
//            }
//        }
        createModel(0, 0, 0);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public void resize(int i, int i1) {}
    public void pause() {}
    public void resume() {}
}
