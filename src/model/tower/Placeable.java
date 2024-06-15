package model.tower;

import java.awt.image.BufferedImage;

/***** Interface for the tower methods *****/
public interface Placeable {

    /**** Methods ****/
    int getTowerType();

    BufferedImage[] getStandingImages();

    public BufferedImage[] getFiringImages();
}
