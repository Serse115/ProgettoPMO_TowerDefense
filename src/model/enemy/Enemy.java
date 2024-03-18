package model.enemy;

import java.awt.image.BufferedImage;

/**** Abstract parent class for the enemies ****/
public abstract class Enemy {

    /**** Fields ****/
    private short lifePoints;                   // Enemy's health
    private boolean aliveStatus = false;        // Enemy's current alive/dead status
    private byte speed;                         // Enemy's speed
    private short hitPower;                     // Enemy's attack potency
    private BufferedImage[] walkingImgs;        // Enemy's walking frames
    private BufferedImage[] attackingImgs;      // Enemy's attacking frames
    private BufferedImage[] deathImgs;          // Enemy's death frames




    /**** Constructors ****/
    /** Main constructor **/
    public Enemy(short lifePoints, byte speed, short hitPower, BufferedImage[] walkingImgs, BufferedImage[] attackingImgs, final BufferedImage[] deathImgs) {
        this.lifePoints = lifePoints;
        this.aliveStatus = true;
        this.speed = speed;
        this.hitPower = hitPower;
        this.walkingImgs = walkingImgs;
        this.attackingImgs = attackingImgs;
        this.deathImgs = deathImgs;
    }




    /**** Methods ****/
    /** Move method **/
    public abstract void move();

    /** Hit method **/
    public abstract void hit();

    /*** Getters and setters ***/
    /** LifePoints getter **/
    public short getLifePoints() {
        return this.lifePoints;
    }

    /** IsAlive getter **/
    public boolean isAlive() {
        return this.aliveStatus;
    }

    /** Speed getter **/
    public byte getSpeed() {
        return this.speed;
    }

    /** HitPower getter **/
    public short getHitPower() {
        return this.hitPower;
    }

    /** WalkingImgs getter **/
    public BufferedImage[] getWalkingImgs() {
        return this.walkingImgs;
    }

    /** AttackingImgs getter **/
    public BufferedImage[] getAttackingImgs() {
        return this.attackingImgs;
    }

    /** DeathImgs getter **/
    public BufferedImage[] getDeathImgs() {
        return this.deathImgs;
    }

    /** LifePoints setter **/
    public void setLifePoints(short lifePoints) {
        this.lifePoints = lifePoints;
    }

    /** IsAlive setter **/
    public void isAlive(boolean aliveStatus) {
        this.aliveStatus = aliveStatus;
    }

    /** Speed setter **/
    public void getSpeed(byte speed) {
        this.speed = speed;
    }

    /** HitPower setter **/
    public void getHitPower(short hitPower) {
        this.hitPower = hitPower;
    }

    /** WalkingImgs setter **/
    public void setWalkingImgs(BufferedImage[] imgs) {
        this.walkingImgs = imgs;
    }

    /** AttackingImgs setter **/
    public void setAttackingImgs(BufferedImage[] imgs) {
        this.attackingImgs = imgs;
    }

    /** DeathImgs setter **/
    public void setDeathImgs(BufferedImage[] imgs) {
        this.deathImgs = imgs;
    }
}