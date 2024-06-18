package controller;

import view.guiComponents.Tile;
import view.imageUtilities.SpriteUtilities;
import java.awt.image.BufferedImage;

/***** Class for the GUI controller to control the tiles generation and handling in the GUI classes *****/
public class GUIController {

    /**** Fields ****/
    private Tile grass;                     // Grass tile, tile type 0
    private Tile water;                     // Water tile, tile type 1
    private Tile road;                      // Road tile, tile type 2




    /**** Constructors ****/
    /** Main constructor **/
    public GUIController() {
        this.grass = new Tile(SpriteUtilities.getSpriteAtlas("layout_atlas/grass_atlas.png"), 0);
        this.water = new Tile(SpriteUtilities.getSpriteAtlas("layout_atlas/water_atlas.png"), 1);
        this.road = new Tile(SpriteUtilities.getSpriteAtlas("layout_atlas/road_atlas.png"), 2);
    }




    /**** Methods ****/
    /** Method to get the tile type and return its corresponding image **/
    public BufferedImage getTileTypeReturnImage(int type) {

        switch (type) {                             // Depending on the tile type
            case 0:                                 // Tile type 0
                return this.grass.getSprite();      // Return the grass sprite
            case 1:                                 // Tile type 1
                return this.water.getSprite();      // Return the water sprite
            case 2:                                 // Tile type 2
                return this.road.getSprite();       // Return the road sprite
            default:                                // Or else
                return null;                        // Return null
        }
    }

    /** Grass tile getter **/
    public Tile getGrass() {
        return this.grass;
    }

    /** Road tile getter **/
    public Tile getRoad() {
        return this.road;
    }

    /** Water tile getter **/
    public Tile getWater() {
        return this.water;
    }
}