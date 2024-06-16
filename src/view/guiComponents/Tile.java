package view.guiComponents;

import model.tower.*;
import java.awt.image.BufferedImage;

/***** Class for the tiles objects that form the map layout and playable field *****/
public class Tile {

    /**** Fields ****/
    private BufferedImage sprite;           // Sprite that forms the tile
    private int id;                            // Tile id
    private int tileType;                      // Type of the tile
    private boolean hasTower;                  // Has tower variable to define if the tile already has a tower located in it
    private Placeable tower;                       // Object reference to the tower in the tile



    /**** Constructors ****/
    /** Main constructor for the static sprites (land/road) **/
    public Tile(BufferedImage sprite, int id, int tileType) {
        this.sprite = sprite;
        this.id = id;
        this.tileType = tileType;
        this.hasTower = false;
        this.tower = null;
    }

    /** Secondary default constructor **/
    public Tile() {
        this.sprite = null;
        this.id = 0;
        this.tileType = 0;
        this.hasTower = false;
        this.tower = null;
    }



    /**** Methods ****/
    /** Single sprite getter **/
    public BufferedImage getSprite() {
        return this.sprite;
    }

    /** Set sprite method **/
    public void setSprite(BufferedImage img) {
        this.sprite = img;
    }

    /** Id getter **/
    public int getId() {
        return this.id;
    }

    /** Tile type getter **/
    public int getTileType() {
        return this.tileType;
    }

    /** Tile type setter **/
    public void setTileType(int tileType) {
        this.tileType = tileType;
    }

    /** Has tower getter **/
    public boolean isHasTower() {
        return this.hasTower;
    }

    /** Has tower setter **/
    public void setHasTower(boolean hasTower) {
        this.hasTower = hasTower;
    }

    /** Tower getter **/
    public Placeable getTower() {
        return this.tower;
    }

    /** Tower setter for the reset **/
    public void resetTower() {
        this.tower = null;
        this.hasTower = false;
    }
    /** Tower setter **/
    public void addTower(Placeable newTower) {


        switch (newTower.getTowerType()) {
            case 0:
                this.tower = new Turret();
                break;
            case 1:
                this.tower = new Cannon();
                break;
            case 2:
                this.tower = new MachineGun();
                break;
            case 3:
                this.tower = new Wall();
                break;
        }
    }

    /** Check the tower life points **/
    public void checkTowerLife() {
        if (this.tower.getLifePoints() < 0) {
            this.hasTower = false;
            this.tower = null;
        }
    }
}