package model.enemy;

import view.guiComponents.Tile;
import java.awt.*;
import java.awt.image.BufferedImage;

/**** Parent class for the enemies ****/
public class Enemy implements Fightable {

    /**** Fields ****/
    private int lifePoints;                       // Enemy's health
    private int speed;                            // Enemy's speed
    private int hitPower;                         // Enemy's attack potency
    private int xPosition;                        // X position of the enemy on the map
    private int yPosition;                        // Y position of the enemy on the map
    private int enemyIndex;                       // Id to identify every enemy currently in the game session
    private boolean isWalking;                    // Boolean variable to decide if the enemy is currently walking
    private boolean isAttacking;                  // Boolean variable to decide if the enemy is currently attacking
    private BufferedImage[] walkingImages;        // Enemy's walking images
    private BufferedImage[] attackingImages;      // Enemy's attacking images
    private BufferedImage[] deathImages;          // Enemy's death images
    private Tile[] nextTiles;                     // Tile object reference to check if the next tile is a tower to attack
    private Tile tileToFight;                     // Tile id where the enemy stops to fight with the tower
    private Rectangle bounds;                     // Hitbox and bounds of the enemy




    /**** Constructors ****/
    /** Main constructor **/
    public Enemy(int lifePoints, int speed, int hitPower, int enIdx, int walkingLength, int attackingLength, int deathLength, Tile[] nextTiles, int x, int y, int width, int height) {
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
        this.bounds = new Rectangle(x, y, width, height);
    }




    /**** Methods ****/
    /** Move method **/
    public void move() {
        while (this.isWalking) {
            this.setxPosition(this.getxPosition() + this.getSpeed());
        }
    }

    /** Hit method **/
    public void hit(Tile t) {
        while (this.isAttacking) {
            t.getTower().setLifePoints(t.getTower().getLifePoints() - this.hitPower);
        }
    }

    /** Check if the enemy will move **/
    private void enemyLogic() {

        while (this.isAlive()) {
            while (this.isWalking) {                  // While there are no towers on the enemy's way and the enemy is walking with still health
                for (Tile t : this.nextTiles) {                         // For each tile in the set of tiles composing the whole road way
                    if (t.isHasTower() && t.getTower() != null) {       // If a tower is on the tile
                        this.tileToFight = t;                           // Setting the tile to fight as the current tile where the turret is
                        this.isAttacking = true;                        // Set the attacking variable as true so that the enemy can attack
                        this.isWalking = false;                         // Stop the walking through making the isWalking variable false
                    }
                    else {                                              // Or else the variable remains true
                        this.move();                                    // And the enemy keeps on moving
                    }
                }
            }
            while (this.isAttacking) {                // While there is a tower to attack
                if (!tileToFight.isHasTower() && !this.isAttacking) {   //
                    this.tileToFight = null;
                    this.isAttacking = false;
                    this.isWalking = true;
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

    /** Speed getter **/
    public int getSpeed() {
        return this.speed;
    }

    /** HitPower getter **/
    public int getHitPower() {
        return this.hitPower;
    }

    /** X position getter **/
    public int getxPosition() {
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

    /** Walking single image getter try **/
    public BufferedImage getSingleWalkingImage() {
        return this.walkingImages[0];
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
}