package jade;

import components.FontRenderer;
import components.SpriteRenderer;
import org.joml.Vector2f;
import org.joml.Vector4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL20;
import renderer.Shader;
import renderer.Texture;
import util.Time;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class LevelEditorScene extends Scene {



    private int vertexID, fragmentID, shaderProgram;

    private float[] vertexArray = {
            // position               // color                  // UV Coordinates
            100f,   0f, 0.0f,       1.0f, 0.0f, 0.0f, 1.0f,     1, 1, // Bottom right 0
            0f,   100f, 0.0f,       0.0f, 1.0f, 0.0f, 1.0f,     0, 0, // Top left     1
            100f, 100f, 0.0f,       1.0f, 0.0f, 1.0f, 1.0f,     1, 0, // Top right    2
            0f,     0f, 0.0f,       1.0f, 1.0f, 0.0f, 1.0f,     0, 1  // Bottom left  3
    };

    // IMPORTANT: Must be in counter-clockwise order
    private int[] elementArray = {
            /*
                    1        2
                    3        0
             */
            2, 1, 0, // Top right triangle
            0, 1, 3 // bottom left triangle
    };
    //Vertex Array Object,Vertex Buffer Object,Element Buffer Object
    private int vaoID, vboID, eboID;
    private Shader defaultShader;
    private Texture testTexture;

    GameObject testObj;
    private boolean firstTime = false;

    public LevelEditorScene() {

    }


    @Override
    public void init() {
        this.camera = new Camera(new Vector2f(-250, 0));

        int xOffset = 10;
        int yOffset = 10;

        float totalWidth = (float)(600 - xOffset * 2);//580
        float totalHeight = (float)(300 - yOffset * 2);//280
        float sizeX = totalWidth / 9.0f;//5.8
        float sizeY = totalHeight / 9.0f;//2.8
        float padding = 3;

        for (int x=0; x < 9; x++) {
            for (int y=0; y < 9; y++) {
                float xPos = xOffset + (x * sizeX) + (padding * x);
                //10 10+8.8 10+2*8.8 10+99*8.8=881.2
                float yPos = yOffset + (y * sizeY) + (padding * y);
                //10 10+5.8 10+2*5.8 10+99*5.8=584.2
                GameObject go = new GameObject("Obj" + x + "" + y, new Transform(new Vector2f(xPos, yPos), new Vector2f(sizeX, sizeY)));
                go.addComponent(new SpriteRenderer(new Vector4f(xPos / totalWidth, yPos / totalHeight, 1, 1)));
                this.addGameObjectToScene(go);
            }
        }
        ///////

    }


    @Override
    public void update(float dt) {
        camera.position.x -= dt * 50.0f;
        camera.position.y -= dt * 20.0f;

        System.out.println("FPS: " + (1.0f / dt));

        for (GameObject go : this.gameObjects) {
            go.update(dt);
        }

        this.renderer.render();
    }
}