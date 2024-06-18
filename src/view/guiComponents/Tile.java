package view.guiComponents;

import model.tower.*;
import java.awt.image.BufferedImage;

/***** Class for the tiles objects that form the map layout and playable field *****/
public class Tile {

    /**** Fields ****/
    private BufferedImage sprite;              // Sprite that forms the tile
    private int tileType;                      // Type of the tile
    private boolean hasTower;                  // Has tower variable to define if the tile already has a tower located in it
    private Placeable tower;                   // Object reference to the tower in the tile



    /**** Constructors ****/
    /** Main constructor for the static sprites (land/road) **/
    public Tile(BufferedImage sprite, int tileType) {
        this.sprite = sprite;
        this.tileType = tileType;
        this.hasTower = false;
        this.tower = null;
    }

    /** Secondary default constructor for later initialization through the setter **/
    public Tile() {
        this.sprite = null;
        this.tileType = 0;
        this.hasTower = false;
        this.tower = null;
    }




    /**** Methods ****/
    /** Sprite getter **/
    public BufferedImage getSprite() {
        return this.sprite;
    }

    /** Set sprite method **/
    public void setSprite(BufferedImage img) {
        this.sprite = img;
    }

    /** Tile type getter **/
    public int getTileType() {
        return this.tileType;
    }

    /** Tile type setter **/
    public void setTileType(int tileType) {
        this.tileType = tileType;
    }

    /** Has tower variable check getter **/
    public boolean isHasTower() {
        return this.hasTower;
    }

    /** Has tower variable check setter **/
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
    /** Add tower method **/
    public void addTower(Placeable newTower) {

        switch (newTower.getTowerType()) {          // Depending on the tower type of the chosen tower to place
            case 0:                                 // Tower type 0
                this.tower = new Turret();          // Place a turret
                break;
            case 1:                                 // Tower type 1
                this.tower = new Cannon();          // Place a cannon
                break;
            case 2:                                 // Tower type 2
                this.tower = new MachineGun();      // Place a machinegun
                break;
            case 3:                                 // Tower type 3
                this.tower = new Wall();            // Place a wall
                break;
        }
    }

    /** Check the tower life points **/
    public void checkTowerLife() {
        if (this.tower.getLifePoints() < 0) {           // If the tower's life points are below 0
            this.hasTower = false;                      // Set the tower presence variable check as false
            this.tower = null;                          // Set the tower in the tile as null
        }
    }
}