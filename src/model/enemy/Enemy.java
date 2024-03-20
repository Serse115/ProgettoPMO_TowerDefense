package model.enemy;

import view.imageUtilities.SpriteUtilities;
import java.awt.image.BufferedImage;

/**** Abstract parent class for the enemies ****/
public abstract class Enemy {

    /**** Fields ****/
    private short lifePoints;                   // Enemy's health
    private byte speed;                         // Enemy's speed
    private short hitPower;                     // Enemy's attack potency
    private BufferedImage[] walkingImages;        // Enemy's walking frames
    private BufferedImage[] attackingImages;      // Enemy's attacking frames
    private BufferedImage[] deathImages;          // Enemy's death frames




    /**** Constructors ****/
    /** Main constructor **/
    public Enemy(short lifePoints, byte speed, short hitPower, String movingAtlasPath, String attackAtlasPath, String deathAtlasPath, int[] nOfSubImgs, int[] widths, int[] heights) {
        this.lifePoints = lifePoints;
        this.speed = speed;
        this.hitPower = hitPower;
        this.setFramesAnimations(movingAtlasPath, attackAtlasPath, deathAtlasPath, nOfSubImgs, widths, heights);    // Setting the enemy's frames through the paths assigned from the subclasses
    }




    /**** Methods ****/
    /** Set the walking, attacking and death animation frames method **/
    private void setFramesAnimations(String movingAtlasPath, String attackAtlasPath, String deathAtlasPath, int[] nOfSubImgs, int[] widths, int[] heights) {
        BufferedImage imageAtlas = null;                                                                       // Image to store the sprites to obtain the animation frames
        imageAtlas = SpriteUtilities.getSpriteAtlas(movingAtlasPath);                                         // Obtaining the whole walking sprite atlas
        this.setWalkingImages(SpriteUtilities.getAniSprites(0, 0, imageAtlas, nOfSubImgs[0], widths[0], heights[0]));// Setting the walking images

        imageAtlas = SpriteUtilities.getSpriteAtlas(attackAtlasPath);                                           // Obtaining the whole attacking sprite atlas
        this.setAttackingImages(SpriteUtilities.getAniSprites(0, 0, imageAtlas, nOfSubImgs[1], widths[1], heights[1]));  // Setting the attacking images

        imageAtlas = SpriteUtilities.getSpriteAtlas(deathAtlasPath);                                            // Obtaining the whole death sprite atlas
        this.setDeathImages(SpriteUtilities.getAniSprites(0, 0, imageAtlas, nOfSubImgs[2], widths[2], heights[2]));     // Setting the death images
    }

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
        return this.lifePoints > 0;
    }

    /** Speed getter **/
    public byte getSpeed() {
        return this.speed;
    }

    /** HitPower getter **/
    public short getHitPower() {
        return this.hitPower;
    }

    /** WalkingImages getter **/
    public BufferedImage[] getWalkingImages() {
        return this.walkingImages;
    }

    /** AttackingImages getter **/
    public BufferedImage[] getAttackingImages() {
        return this.attackingImages;
    }

    /** DeathImages getter **/
    public BufferedImage[] getDeathImages() {
        return this.deathImages;
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

    /** WalkingImages setter **/
    private void setWalkingImages(BufferedImage[] imgs) {
        this.walkingImages = imgs;
    }

    /** AttackingImages setter **/
    private void setAttackingImages(BufferedImage[] imgs) {
        this.attackingImages = imgs;
    }

    /** DeathImages setter **/
    private void setDeathImages(BufferedImage[] imgs) {
        this.deathImages = imgs;
    }
}