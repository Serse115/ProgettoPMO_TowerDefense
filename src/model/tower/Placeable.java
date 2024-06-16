package model.tower;

import model.enemy.Fightable;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/***** Interface for the tower methods *****/
public interface Placeable {

    /**** Methods ****/
    int getTowerType();

    void towerLogic(ArrayList<Fightable> enemies);

    BufferedImage[] getStandingImages();

    public BufferedImage[] getFiringImages();

    BufferedImage getFirstStandingImage();

    int getLifePoints();

    void setLifePoints(int lifePoints);

    void shoot(Fightable enemy);

    void setyPosition(int yPosition);

    void setxPosition(int yPosition);
}
