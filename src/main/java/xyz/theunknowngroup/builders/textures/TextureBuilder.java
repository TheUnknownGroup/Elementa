package xyz.theunknowngroup.builders.textures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextureBuilder {
    public static Texture texture;

    public static Texture createTexture(String path) {
        texture = new Texture(Gdx.files.internal(path));
        return texture;
    }

    public static void getTexture(String path, SpriteBatch batch, int x, int y, int width, int height) {
        createTexture(path);
        batch.draw(texture, x, y, width, height);
    }
}
