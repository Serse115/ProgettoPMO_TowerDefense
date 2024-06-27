package model.tower;

import model.enemy.Fightable;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/***** Interface for the tower methods *****/
public interface Placeable {

    /**** Methods ****/
    /** Get tower type method **/
    int getTowerType();

    /** Main tower logic method **/
    void towerLogic(ArrayList<Fightable> enemies);

    /** Get standing images method **/
    BufferedImage[] getStandingImages();

    /** Get shooting images method **/
    BufferedImage[] getShootingImages();

    /** Get tower's life points method **/
    int getLifePoints();

    /** Set tower's life points method **/
    void setLifePoints(int lifePoints);

    /** Set the y coordinate position **/
    void setyPosition(int yPosition);

    /** Is standing variable check getter **/
    boolean isStanding();

    /** Is shooting variable check getter **/
    boolean isShooting();

    /** Get the first standing image of the standing images array for the preview of the tower add **/
    BufferedImage getFirstStandingImage();

    /** Get the cost method **/
    int getCost();

    /** Get the tower's damage **/
    int getDmgPower();

    /** Set the dmg power **/
    void upgradeDmgPower();

    /** Repair the tower **/
    void repairTower();
}