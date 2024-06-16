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
    private BufferedImage[] standingImages;             // Images for the standing state of the tower
    private BufferedImage[] firingImages;               // Images for the firing state of the tower
    private Rectangle bounds;                           // Hitbox and bounds of the tower
    private Fightable enemyInRange;                     // Object reference to the enemy in range
    private boolean isStanding;                         // Variable to check if the tower is just standing
    private boolean isShooting;                         // Variable to check if the tower is shooting
    private int range;




    /**** Constructors ****/
    public Tower(int lifePoints, float fireCooldown, int dmgPower, int x, int y, int width, int height, int towerType) {
        this.lifePoints = lifePoints;
        this.fireCooldown = fireCooldown;
        this.dmgPower = dmgPower;
        this.xPosition = x;
        this.yPosition = y;
        this.bounds = new Rectangle(x, y, width, height);
        this.towerType = towerType;
        this.enemyInRange = null;
        this.isStanding = true;
        this.isShooting = false;
        this.range = 500;
    }




    /**** Methods ****/
    public void shoot(Fightable enemyInRange) {
        System.out.println("Hitting enemy!");
        enemyInRange.setLifePoints(enemyInRange.getLifePoints() - this.dmgPower);
    }

    private boolean isInRange(Fightable enemy) {
        double distance = (enemy.getxPosition() - this.xPosition);
        return distance <= this.range;
    }


    public void towerLogic(ArrayList<Fightable> enemies) {
        for (Fightable enemy : enemies) {
            if (enemy != null && enemy.isAlive() && this.isInRange(enemy) && ((this.yPosition / 32) == enemy.getLineOfFire())) {
                this.shoot(enemy);
                break;
            }
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

    /** First image of the standing images array getter **/
    public BufferedImage getFirstStandingImage() {
        return this.standingImages[0];
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
}