package model.tower;

import model.enemy.Fightable;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/***** Parent class for the tower *****/
public class Tower implements Placeable {

    /**** Fields ****/
    private int lifePoints;                             // Variable for the life points for the tower
    private float fireCooldown;                         // Cooldown in between the shots fired from a tower
    private int dmgPower;                               // Damage per shot from the tower
    private int xPosition;                              // X position of the tower
    private int yPosition;                              // Y position of the tower
    private int towerType;                              // Type of the tower
    private int cost;                                   // Gold cost to build
    private BufferedImage[] standingImages;             // Images for the standing state of the tower
    private BufferedImage[] firingImages;               // Images for the firing state of the tower
    private Rectangle bounds;                           // Hitbox and bounds of the tower
    private Fightable enemyInRange;                     // Object reference to the enemy in range
    private boolean isStanding;                         // Variable to check if the tower is just standing
    private boolean isShooting;                         // Variable to check if the tower is shooting




    /**** Constructors ****/
    public Tower(int lifePoints, float fireCooldown, int dmgPower, int x, int y, int height, int towerType, int cost) {
        this.lifePoints = lifePoints;
        this.fireCooldown = fireCooldown;
        this.dmgPower = dmgPower;
        this.xPosition = x;
        this.yPosition = y;
        this.cost = cost;
        this.bounds = new Rectangle(0, y, x, height);
        this.towerType = towerType;
        this.enemyInRange = null;
        this.isStanding = true;
        this.isShooting = false;
    }




    /**** Methods ****/
    /** Shoot method **/
    public void shoot(Fightable enemyInRange) {
        System.out.println("Hitting enemy!");
        enemyInRange.setLifePoints(enemyInRange.getLifePoints() - this.dmgPower);
    }

    /** Method to check if the enemy is in range of the tower with a slight offset tolerance **/
    private boolean isInRange(Fightable enemy) {
        return ((-15 <= (this.yPosition - enemy.getLineOfFire())) && ((this.yPosition - enemy.getLineOfFire()) <= 15));
    }


    /** Tower logic method to handle all the situations the tower may be in **/
    public void towerLogic(ArrayList<Fightable> enemies) {

        boolean foundEnemyInRange = false;

        for (Fightable enemy : enemies) {
            if (enemy != null && enemy.isAlive() && this.isInRange(enemy)) {
                this.isShooting = true;
                this.isStanding = false;
                this.shoot(enemy);
                foundEnemyInRange = true;
                break;
            }
        }
        if (!foundEnemyInRange) {
            this.isShooting = false;
            this.isStanding = true;
        }
    }


    /** Life points getter **/
    public int getLifePoints() {
        return lifePoints;
    }

    /** LIfe points setter **/
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    /** Standing images getter **/
    public BufferedImage[] getStandingImages() {
        return standingImages;
    }

    /** First image of the standing images array getter **/
    public BufferedImage getFirstStandingImage() {
        return this.standingImages[0];
    }

    /** Standing images setter **/
    public void setStandingImages(BufferedImage[] standingImages) {
        this.standingImages = standingImages;
    }

    /** Firing images getter **/
    public BufferedImage[] getShootingImages() {
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

    public int getWidth() {
        return this.bounds.width;
    }

    public int getHeight() {
        return this.bounds.height;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void setWidthHitboxBounds(int width) {
        this.bounds.width = width;
    }

    public void setEnemyInRange(Fightable enemy) {
        this.enemyInRange = enemy;
    }

    public boolean isStanding() {
        return isStanding;
    }

    public boolean isShooting() {
        return isShooting;
    }

    public void setStanding(boolean standing) {
        this.isStanding = standing;
    }

    public void setShooting(boolean shooting) {
        this.isShooting = shooting;
    }

    public int getCost(){
        return this.cost;
    }
}