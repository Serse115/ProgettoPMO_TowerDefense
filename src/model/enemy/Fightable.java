package model.enemy;

import java.awt.image.BufferedImage;

/**** Interface for the Enemy subclasses ****/
public interface Fightable {

    /**** Methods ****/
    /** Move method **/
    void move();

    /** Hit method **/
    void hit();

    /** Is alive method **/
    boolean isAlive();

    /** Set walking images method **/
    void setWalkingImages(BufferedImage[] imgs);

    /** Set attacking images method **/
    void setAttackingImages(BufferedImage[] imgs);

    /** Set death images method **/
    void setDeathImages(BufferedImage[] imgs);
}