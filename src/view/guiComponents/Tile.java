package view.guiComponents;

import java.awt.image.BufferedImage;

/***** Class for the tiles objects that form the map layout and playable field *****/
public class Tile {

    /**** Fields ****/
    private BufferedImage[] sprites;           // Sprite that forms the tile
    private int id;                            // Tile id
    private int tileType;                      // Type of the tile



    /**** Constructors ****/
    /** Main constructor for the static sprites (land/road) **/
    public Tile(BufferedImage sprite, int id, int tileType) {
        this.sprites = new BufferedImage[1];
        this.sprites[0] = sprite;
        this.id = id;
        this.tileType = tileType;
    }

    /** Second constructor for the animated sprites (water) **/
    public Tile(BufferedImage[] sprites, int id, int tileType) {
        this.sprites = sprites;
        this.id = id;
        this.tileType = tileType;
    }



    /**** Methods ****/
    /** Single sprite getter **/
    public BufferedImage getSprite() {
        return this.sprites[0];
    }

    /** Is animation boolean **/
    public boolean isAnimatedSprite() {
        return this.sprites.length > 1;
    }

    /** Animated sprite getter at chosen index **/
    public BufferedImage getSprite(int animationIndex) {
        return this.sprites[animationIndex];
    }

    /** Id getter **/
    public int getId() {
        return this.id;
    }

    /** Tile type getter **/
    public int getTileType() {
        return this.tileType;
    }
}