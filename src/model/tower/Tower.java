package model.tower;

import java.awt.image.BufferedImage;

/***** Abstract parent class for the tower *****/
public abstract class Tower {

    /**** Fields ****/
    private int lifePoints;                             // Variable for the life points for the tower
    private int fireCooldown;                           // Cooldown in between the shots fired from a tower
    private int dmgPower;                               // Damage per shot from the tower
    private BufferedImage[] standingImages;             // Images for the standing state of the tower
    private BufferedImage[] firingImages;               // Images for the firing state of the tower



    /**** Constructors ****/




    /**** Methods ****/
}
