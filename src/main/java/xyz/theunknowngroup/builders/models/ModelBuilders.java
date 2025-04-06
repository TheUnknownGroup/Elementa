package xyz.theunknowngroup.builders.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import static xyz.theunknowngroup.font.ModelColor.*;

public class ModelBuilders {
    public static ModelBuilder model = new ModelBuilder();
    public static Model blockModel;

    static {
        blockModel = model.createBox(
                16f, 16f, 16f, new Material(ColorAttribute.createDiffuse(R, G, B, A)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal
        );
        System.out.println(R);
        System.out.println(G);
        System.out.println(B);
        System.out.println(A);
    }

    public static ModelBatch modelBatch = new ModelBatch();
    public static ModelInstance blockInst;

    public static void setModelX(int x, int y, int z) {
        blockInst = new ModelInstance(blockModel, x, y, z);
    }
    public static void createModel(int x, int y, int z) {
        setModelX(x, y, z);
        makeCamera();
    }

    public static PerspectiveCamera camera;
    public static void makeCamera() {
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(5f, 5f, 10f);
        camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();

        modelBatch.begin(camera);
        modelBatch.setCamera(camera);
        modelBatch.render(blockInst);
        modelBatch.end();
    }
}
