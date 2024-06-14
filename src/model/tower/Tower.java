package model.tower;

import java.awt.*;
import java.awt.image.BufferedImage;

/***** Parent class for the tower *****/
public class Tower implements Placeable {

    /**** Fields ****/
    private int lifePoints;                             // Variable for the life points for the tower
    private float fireCooldown;                         // Cooldown in between the shots fired from a tower
    private int dmgPower;                               // Damage per shot from the tower
    private int xPosition;                              // X position of the tower
    private int yPosition;                              // Y position of the tower
    private int towerType;                              // Type of the tower
    private BufferedImage[] standingImages;             // Images for the standing state of the tower
    private BufferedImage[] firingImages;               // Images for the firing state of the tower
    private Rectangle bounds;                           // Hitbox and bounds of the enemy




    /**** Constructors ****/
    public Tower(int lifePoints, float fireCooldown, int dmgPower, int x, int y, int width, int height, int towerType) {
        this.lifePoints = lifePoints;
        this.fireCooldown = fireCooldown;
        this.dmgPower = dmgPower;
        this.xPosition = x;
        this.yPosition = y;
        this.bounds = new Rectangle(x, y, width, height);
        this.towerType = towerType;
    }




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
    public float getFireCooldown() {
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

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getTowerType() {
        return towerType;
    }

    public void setTowerType(int towerType) {
        this.towerType = towerType;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
}
