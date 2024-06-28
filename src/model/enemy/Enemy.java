package model.enemy;

import view.gameScenes.GameScenes;
import view.guiComponents.Tile;
import java.awt.*;
import java.awt.image.BufferedImage;

/**** Parent class for the enemies ****/
public class Enemy implements Fightable {

    /**** Fields ****/
    private int lifePoints;                       // Enemy's health
    private float speed;                          // Enemy's speed
    private int hitPower;                         // Enemy's attack potency
    private float xPosition;                      // X position of the enemy on the map
    private int yPosition;                        // Y position of the enemy on the map
    private boolean isWalking;                    // Boolean variable to decide if the enemy is currently walking
    private boolean isAttacking;                  // Boolean variable to decide if the enemy is currently attacking
    private BufferedImage[] walkingImages;        // Enemy's walking images
    private BufferedImage[] attackingImages;      // Enemy's attacking images
    private Tile[] nextTiles;                     // Tile object reference to check if the next tile is a tower to attack
    private Tile currentTile;                     // Tile where the enemy eventually stops to fight with the tower
    private Rectangle bounds;                     // Hitbox and bounds of the enemy
    private int goldReward;                       // Gold reward for the killing of the enemy




    /**** Constructors ****/
    /** Main constructor **/
    public Enemy(int lifePoints, float speed, int hitPower, int walkingLength, int attackingLength, Tile[] nextTiles, float x, int y, int width, int height, int gold) {
        this.lifePoints = lifePoints;
        this.speed = speed;
        this.hitPower = hitPower;
        this.xPosition = x;
        this.yPosition = y;
        this.isWalking = true;
        this.isAttacking = false;
        this.walkingImages = new BufferedImage[walkingLength];
        this.attackingImages = new BufferedImage[attackingLength];
        this.nextTiles = nextTiles;
        this.bounds = new Rectangle((int) x, y, width, height);
        this.goldReward = gold;
    }




    /**** Methods ****/
    /** Move method **/
    // General implementation here that works for every subclass too
    private void move() {
        this.xPosition += this.speed;                           // Increase the enemy x position by its speed
    }

    /** Hit method **/
    // General implementation here that works for every subclass too
    private void hit(Tile t) {
        t.getTower().setLifePoints(t.getTower().getLifePoints() - this.hitPower);       // Decrease the life of the tower by the hitpower of the enemy
        t.checkTowerLife();                                                             // Check the tower's life points to in case destroy it
    }

    /** Update the current tile position method **/
    // General implementation here that works for every subclass too
    private void updateTilePosition() {

        int tilePositionX = (int) this.xPosition / 32;                          // Calculate the tile position through the x position

        if (tilePositionX >= 0 && tilePositionX < this.nextTiles.length) {      // Check for boundaries (start and finish of the map)
            this.currentTile = this.nextTiles[tilePositionX];                   // Update the tile reference
        } else {
            this.currentTile = null;                                            // Otherwise set the current tile to null
        }
    }

    /** Enemy logic method to handle all the situations the enemy may be in **/
    // General implementation here that works for every subclass too
    public void enemyLogic() {

        if (this.isAlive()) {                                                   // If the enemy is still alive
            this.updateTilePosition();                                          // Update the tile positions reference
            if (this.xPosition >= 735) {                                        // If the enemy reached the end of the road tiles on the x-axis
                GameScenes.setGameScene(GameScenes.GAME_OVER);                  // Set the game over scene
            }

            if (this.isWalking) {                                                                                           // If the walking boolean check is true
                if (this.currentTile != null && this.currentTile.isHasTower() && this.currentTile.getTower() != null) {     // If the current tile is not null,
                    this.isWalking = false;                                     // If it has a tower and the tower is not null, set the walking boolean as false
                    this.isAttacking = true;                                    // And set the attacking boolean variable as true and end the walking loop
                } else {
                    this.move();                                                // Or else keep walking
                }
            }

            if (this.isAttacking) {                                                                                         // If the attacking boolean check is true
                if (this.currentTile != null && this.currentTile.isHasTower() && this.currentTile.getTower() != null) {     // If the current tile is not null,
                    this.hit(this.currentTile);                       // If the current tile has a tower and the tower is different from null, hit the tower in the tile
                } else {
                    this.isAttacking = false;                         // Or else set the attacking boolean variable as false to end the attacking phase
                    this.isWalking = true;                            // Restart the walking phase
                }
            }
        }
    }

    /*** Getters and setters ***/
    /** LifePoints getter **/
    public int getLifePoints() {
        return this.lifePoints;
    }

    /** IsAlive getter **/
    public boolean isAlive() {
        return this.lifePoints > 0;
    }

    /** X position getter **/
    public float getxPosition() {
        return this.xPosition;
    }

    /** Y position getter **/
    public int getyPosition() {
        return this.yPosition;
    }

    /** Walking images getter **/
    public BufferedImage[] getWalkingImages() {
        return this.walkingImages;
    }

    /** Walking images setter **/
    public void setWalkingImages(BufferedImage[] imgs) {
        this.walkingImages = imgs;
    }

    /** Attacking images getter **/
    public BufferedImage[] getAttackingImages() {
        return this.attackingImages;
    }

    /** Attacking images setter **/
    public void setAttackingImages(BufferedImage[] imgs) {
        this.attackingImages = imgs;
    }

    /** LifePoints setter **/
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    /** Is walking boolean getter **/
    public boolean isWalking() {
        return this.isWalking;
    }

    /** Is attacking boolean getter **/
    public boolean isAttacking() {
        return this.isAttacking;
    }

    /** Rectangle width getter **/
    public int getRectangleWidth() {
        return this.bounds.width;
    }

    /** Return the line of fire of the tile **/
    public int getLineOfFire() {
        return this.yPosition / 32;
    }

    /** Return the gold as a reward for killing this enemy **/
    public int getGold() {
        return this.goldReward;
    }
}