package model.enemy;

import java.awt.image.BufferedImage;

/**** Interface for the Enemy parentclass and subclasses ****/
public interface Fightable {

    /**** Methods ****/
    /** Is alive method **/
    boolean isAlive();

    /** Main enemy logic method **/
    void enemyLogic();

    /** Is walking boolean status getter **/
    boolean isWalking();

    /** Is attacking boolean status getter **/
    boolean isAttacking();

    /** Get walking images method **/
    BufferedImage[] getWalkingImages();

    /** Get attacking images method **/
    BufferedImage[] getAttackingImages();

    /** Set walking images method **/
    void setWalkingImages(BufferedImage[] imgs);

    /** Set attacking images method **/
    void setAttackingImages(BufferedImage[] imgs);

    /** Get x position method **/
    float getxPosition();

    /** Get y position method **/
    int getyPosition();

    /** Get the rectangle's width method **/
    int getRectangleWidth();

    /** Set the life points method **/
    void setLifePoints(int lifePoints);

    /** Get the life points method **/
    int getLifePoints();

    /** Get the line of fire method **/
    int getLineOfFire();
}