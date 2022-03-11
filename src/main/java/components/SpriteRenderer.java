package components;

import jade.Component;
import org.joml.Vector2f;
import org.joml.Vector4f;
import renderer.Texture;
import renderer.Texture;

public class SpriteRenderer extends Component {

    private Vector4f color;
    private Texture texture;
    private Sprite sprite;

    public SpriteRenderer(Vector4f color) {
        this.color = color;
    }
    public SpriteRenderer(Texture texture) {
        this.texture = texture;
        this.color = new Vector4f(1, 1, 1, 1);
    }

    public SpriteRenderer(Sprite sprite) {
        this.sprite = sprite;
        this.color = new Vector4f(1, 1, 1, 1);

    }

    @Override
    public void start() {
    }

    @Override
    public void update(float dt) {

    }

    public Vector4f getColor() {
        return this.color;
    }
    public Texture getTexture() {
        return sprite.getTexture();
    }
    public Vector2f[] getTexCoords() {
        return sprite.getTexCoords();
    }
}
