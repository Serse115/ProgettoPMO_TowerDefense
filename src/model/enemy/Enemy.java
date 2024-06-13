package model.enemy;

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
    private int enemyIndex;                       // Id to identify every enemy currently in the game session
    private boolean isWalking;                    // Boolean variable to decide if the enemy is currently walking
    private boolean isAttacking;                  // Boolean variable to decide if the enemy is currently attacking
    private BufferedImage[] walkingImages;        // Enemy's walking images
    private BufferedImage[] attackingImages;      // Enemy's attacking images
    private BufferedImage[] deathImages;          // Enemy's death images
    private Tile[] nextTiles;                     // Tile object reference to check if the next tile is a tower to attack
    private Tile currentTile;                     // Tile id where the enemy stops to fight with the tower
    private Rectangle bounds;                     // Hitbox and bounds of the enemy




    /**** Constructors ****/
    /** Main constructor **/
    public Enemy(int lifePoints, float speed, int hitPower, int enIdx, int walkingLength, int attackingLength, int deathLength, Tile[] nextTiles, float x, int y, int width, int height) {
        this.lifePoints = lifePoints;
        this.speed = speed;
        this.hitPower = hitPower;
        this.xPosition = x;
        this.yPosition = y;
        this.enemyIndex = enIdx;
        this.isWalking = true;
        this.isAttacking = false;
        this.walkingImages = new BufferedImage[walkingLength];
        this.attackingImages = new BufferedImage[attackingLength];
        this.deathImages = new BufferedImage[deathLength];
        this.nextTiles = nextTiles;
        this.bounds = new Rectangle((int) x, y, width, height);
    }




    /**** Methods ****/
    /** Move method **/
    public void move() {
        this.xPosition += this.speed;
    }

    /** Hit method **/
    public void hit(Tile t) {
        while (this.isAttacking) {
            t.getTower().setLifePoints(t.getTower().getLifePoints() - this.hitPower);
        }
    }

    /** Update the current tile position method **/
    private void updateTilePosition() {

        int tilePositionX = (int) this.xPosition / 32;

        if (tilePositionX >= 0 && tilePositionX < this.nextTiles.length) {      // Check for boundaries
            this.currentTile = this.nextTiles[tilePositionX];
        } else {
            this.currentTile = null;
        }
    }

    /** Check if the enemy will move **/
    public void enemyLogic() {

        if (this.isAlive()) {
            this.updateTilePosition();

            if (this.isWalking) {                                       // While there are no towers on the enemy's way and the enemy is walking with still health
                for (Tile t : this.nextTiles) {                         // For each tile in the set of tiles composing the whole road way
                    if (t.isHasTower() && t.getTower() != null) {       // If a tower is on the tile
                        this.currentTile = t;                           // Setting the tile to fight as the current tile where the turret is
                        this.isAttacking = true;                        // Set the attacking variable as true so that the enemy can attack
                        this.isWalking = false;                         // Stop the walking through making the isWalking variable false
                        break;
                    }
                }
                if (this.isWalking) {                                    // If the variable remains true
                    this.move();                                         // And the enemy keeps on moving
                }
            }
            if (this.isAttacking) {                                      // If the attack variable is true
                this.hit(this.currentTile);                              // Use the method to hit to fight the tower
                if (!this.currentTile.isHasTower()) {                    // If there's no tower to fight anymore
                    this.isAttacking = false;                            // Set the fighting variable to false
                    this.isWalking = true;                               // Set the walking variable to true
                    this.currentTile = null;                             // Set the tile to fight reference to null
                }
            }
        }
        else {

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

    /** Speed getter **/
    public float getSpeed() {
        return this.speed;
    }

    /** HitPower getter **/
    public int getHitPower() {
        return this.hitPower;
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

    /** Death images getter **/
    public BufferedImage[] getDeathImages() {
        return this.deathImages;
    }

    /** Death images setter **/
    public void setDeathImages(BufferedImage[] imgs) {
        this.deathImages = imgs;
    }

    /** LifePoints setter **/
    public void setLifePoints(short lifePoints) {
        this.lifePoints = lifePoints;
    }

    /** Speed setter **/
    public void getSpeed(byte speed) {
        this.speed = speed;
    }

    /** HitPower setter **/
    public void getHitPower(short hitPower) {
        this.hitPower = hitPower;
    }

    /** LifePoints setter **/
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    /** X position setter **/
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    /** Y position setter **/
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    /** Is walking boolean getter **/
    public boolean isWalking() {
        return this.isWalking;
    }

    /** Is walking boolean setter **/
    public void setWalking(boolean isWalking) {
        this.isWalking = isWalking;
    }

    /** Is attacking boolean getter **/
    public boolean isAttacking() {
        return this.isAttacking;
    }

    /** Is attacking boolean setter **/
    public void setAttacking(boolean isAttacking) {
        this.isAttacking = isAttacking;
    }

    /** Rectangle width getter **/
    public int getRectangleWidth() {
        return this.bounds.width;
    }
}