package components;


import org.joml.Vector2f;
import renderer.Texture;

import java.util.ArrayList;

public class Spritesheet {

    ArrayList<Sprite> sprites;
    Texture texture;
    //transform texture into sprites
    public Spritesheet(Texture texture, int spriteWidth, int spriteHeight, int numSprite, int spacing){
        this.sprites = new ArrayList<>();
        this.texture = texture;

        float currentX = 0;
        float currentY = texture.getHeight();
        float textureHeight = texture.getHeight();
        float textureWidth = texture.getWidth();
        for(int i=0;i<numSprite;i++){
            float topY = currentY / (float)textureHeight;
            float rightX = (currentX + spriteWidth)/textureWidth;
            float leftX = currentX/textureWidth;
            float bottomY =(currentY - spriteHeight) / (float)textureHeight;
            Vector2f[] texCoords = {
                    new Vector2f(rightX,topY),
                    new Vector2f(rightX,bottomY),
                    new Vector2f(leftX,bottomY),
                    new Vector2f(leftX,topY)
            };
            sprites.add(new Sprite(texture,texCoords));

            currentX = currentX + spriteWidth + spacing;
            if(currentX>textureWidth){
                currentX = 0;
                currentY = currentY - spriteHeight - spacing;
            }
        }

    }

    public Sprite getSprite(int index) {
        return this.sprites.get(index);
    }

}
