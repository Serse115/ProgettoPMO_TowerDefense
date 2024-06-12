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

    /** Get walking images method **/
    BufferedImage[] getWalkingImages();

    /** Set walking images method **/
    void setWalkingImages(BufferedImage[] imgs);

    /** Set attacking images method **/
    void setAttackingImages(BufferedImage[] imgs);

    /** Set death images method **/
    void setDeathImages(BufferedImage[] imgs);

    BufferedImage getSingleWalkingImage();

    int getxPosition();

    int getyPosition();
}