package model.tower;

import model.enemy.Fightable;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/***** Parent class for the tower *****/
public class Tower implements Placeable {

    /**** Fields ****/
    private int lifePoints;                             // Variable for the life points for the tower
    private int dmgPower;                               // Damage per shot from the tower
    private int yPosition;                              // Y position of the tower
    private int towerType;                              // Type of the tower
    private int cost;                                   // Gold cost to build
    private BufferedImage[] standingImages;             // Images for the standing state of the tower
    private BufferedImage[] firingImages;               // Images for the firing state of the tower
    private Rectangle bounds;                           // Hitbox and bounds of the tower
    private boolean isStanding;                         // Variable to check if the tower is just standing
    private boolean isShooting;                         // Variable to check if the tower is shooting




    /**** Constructors ****/
    public Tower(int lifePoints, int dmgPower, int x, int y, int height, int towerType, int cost) {
        this.lifePoints = lifePoints;
        this.dmgPower = dmgPower;
        this.yPosition = y;
        this.cost = cost;
        this.bounds = new Rectangle(0, y, x, height);
        this.towerType = towerType;
        this.isStanding = true;
        this.isShooting = false;
    }




    /**** Methods ****/
    /** Shoot method **/
    private void shoot(Fightable enemyInRange) {
        enemyInRange.setLifePoints(enemyInRange.getLifePoints() - this.dmgPower);
    }

    /** Method to check if the enemy is in range of the tower with a slight offset tolerance **/
    private boolean isInRange(Fightable enemy) {
        return ((-15 <= (this.yPosition - enemy.getLineOfFire())) && ((this.yPosition - enemy.getLineOfFire()) <= 15));
    }


    /** Tower logic method to handle all the situations the tower may be in **/
    public void towerLogic(ArrayList<Fightable> enemies) {

        boolean foundEnemyInRange = false;                  // Local variable to keep in check if the enemy in range

        for (Fightable enemy : enemies) {                                       // For every enemy in the arrayList of enemies passed as a parameter
            if (enemy != null && enemy.isAlive() && this.isInRange(enemy)) {    // If the enemy is not null, alive and in range
                this.isShooting = true;                                         // Set the shooting status check to true
                this.isStanding = false;                                        // Set the standing status check to false
                this.shoot(enemy);                                              // Start the shooting phase against the enemy in range
                foundEnemyInRange = true;                                       // Keep the check of the enemy in range as true
                break;
            }
        }
        if (!foundEnemyInRange) {                   // If there's no enemy in range
            this.isShooting = false;                // Set the shooting status check to false to stop the shooting phase
            this.isStanding = true;                 // Set the standing status check to true to start the standing phase
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

    /** Y position setter **/
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    /** Get the tower type method **/
    public int getTowerType() {
        return towerType;
    }

    /** Get the rectangle bounds method **/
    public Rectangle getBounds() {
        return bounds;
    }

    /** Set the bounds method **/
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    /** Get the standing status check variable **/
    public boolean isStanding() {
        return isStanding;
    }

    /** Get the shooting status check variable **/
    public boolean isShooting() {
        return isShooting;
    }

    /** Get the tower's cost method **/
    public int getCost(){
        return this.cost;
    }
}