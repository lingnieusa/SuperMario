package components;

import org.joml.Vector2f;
import renderer.Texture;

public class Sprite {
    Texture texture;
    private Vector2f[] texCoords;

    public Sprite(Texture texture,Vector2f[] texCoords) {
        this.texture = texture;
        this.texCoords = texCoords;
    }

    public Vector2f[] getTexCoords() {
        return texCoords;
    }

    public Texture getTexture() {
        return texture;
    }
}
