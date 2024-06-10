package model.enemy;

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
    private BufferedImage[] walkingImages;        // Enemy's walking images
    private BufferedImage[] attackingImages;      // Enemy's attacking images
    private BufferedImage[] deathImages;          // Enemy's death images




    /**** Constructors ****/
    /** Main constructor **/
    public Enemy(int lifePoints, int speed, int hitPower, int enIdx, int walkingLength, int attackingLength, int deathLength) {
        this.lifePoints = lifePoints;
        this.speed = speed;
        this.hitPower = hitPower;
        this.xPosition = 0;
        this.yPosition = 0;
        this.enemyIndex = enIdx;
        this.walkingImages = new BufferedImage[walkingLength];
        this.attackingImages = new BufferedImage[attackingLength];
        this.deathImages = new BufferedImage[deathLength];
    }




    /**** Methods ****/
    /** Move method **/
    public void move() {

    }

    /** Hit method **/
    public void hit() {

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
}