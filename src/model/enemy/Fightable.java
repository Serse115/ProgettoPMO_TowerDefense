package model.enemy;

import view.guiComponents.Tile;

import java.awt.image.BufferedImage;

/**** Interface for the Enemy subclasses ****/
public interface Fightable {

    /**** Methods ****/
    /** Move method **/
    void move();

    /** Hit method **/
    void hit(Tile t);

    /** Is alive method **/
    boolean isAlive();

    void enemyLogic();

    boolean isWalking();

    boolean isAttacking();

    /** Get walking images method **/
    BufferedImage[] getWalkingImages();

    BufferedImage[] getAttackingImages();

    BufferedImage[] getDeathImages();

    /** Set walking images method **/
    void setWalkingImages(BufferedImage[] imgs);

    /** Set attacking images method **/
    void setAttackingImages(BufferedImage[] imgs);

    /** Set death images method **/
    void setDeathImages(BufferedImage[] imgs);

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

    int getLineOfFire();
}