package model.tower;

import java.awt.*;
import java.awt.image.BufferedImage;

/***** Abstract parent class for the tower *****/
public abstract class Tower {

    /**** Fields ****/
    private int lifePoints;                             // Variable for the life points for the tower
    private int fireCooldown;                           // Cooldown in between the shots fired from a tower
    private int dmgPower;                               // Damage per shot from the tower
    private BufferedImage[] standingImages;             // Images for the standing state of the tower
    private BufferedImage[] firingImages;               // Images for the firing state of the tower
    private Rectangle bounds;                           // Hitbox and bounds of the enemy



    /**** Constructors ****/




    /**** Methods ****/
    /** Life points getter **/
    public int getLifePoints() {
        return lifePoints;
    }

    /** LIfe points setter **/
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    /** Cooldown getter **/
    public int getFireCooldown() {
        return fireCooldown;
    }

    /** Cooldown setter **/
    public void setFireCooldown(int fireCooldown) {
        this.fireCooldown = fireCooldown;
    }

    /** Dmg power getter **/
    public int getDmgPower() {
        return dmgPower;
    }

    /** Dmg power setter **/
    public void setDmgPower(int dmgPower) {
        this.dmgPower = dmgPower;
    }

    /** Standing images getter **/
    public BufferedImage[] getStandingImages() {
        return standingImages;
    }

    /** Standing images setter **/
    public void setStandingImages(BufferedImage[] standingImages) {
        this.standingImages = standingImages;
    }

    /** Firing images getter **/
    public BufferedImage[] getFiringImages() {
        return firingImages;
    }

    /** Firing images setter **/
    public void setFiringImages(BufferedImage[] firingImages) {
        this.firingImages = firingImages;
    }
}
