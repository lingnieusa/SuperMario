package components;

import org.joml.Vector2f;
import renderer.Texture;

public class Sprite {
    private float width, height;

    private Texture texture = null;
    private Vector2f[] texCoords = {
            new Vector2f(1, 1),
            new Vector2f(1, 0),
            new Vector2f(0, 0),
            new Vector2f(0, 1)
    };

//    public Sprite(Texture texture) {
//        this.texture = texture;
//        Vector2f[] texCoords = {
//                new Vector2f(1, 1),
//                new Vector2f(1, 0),
//                new Vector2f(0, 0),
//                new Vector2f(0, 1)
//        };
//        this.texCoords = texCoords;
//    }
//
//    public Sprite(Texture texture,Vector2f[] texCoords) {
//        this.texture = texture;
//        this.texCoords = texCoords;
//    }

    public Vector2f[] getTexCoords() {
        return texCoords;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture tex) {
        this.texture = tex;
    }

    public void setTexCoords(Vector2f[] texCoords) {
        this.texCoords = texCoords;
    }

    public void setWidth(float width) {
        this.width = width;
    }
    public float getWidth() {
        return width;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    public float getHeight() {
        return height;
    }

    public int getTexId() {
        return texture == null ? -1 : texture.getId();
    }

}
