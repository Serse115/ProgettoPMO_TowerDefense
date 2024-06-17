package model.tower;

import view.gameScenes.RandomGame;
import view.imageUtilities.SpriteUtilities;

/***** Subclass of the parent class Tower *****/
public class Cannon extends Tower implements Placeable {

    /**** Fields ****/
    // Most inherited from parent class
    private final String cannonStandingPath = "tower_cannon/cannon_standing.png";               // Standing cannon sprite path
    private final String cannonShootingPath = "tower_cannon/cannon_shooting.png";               // Firing cannon sprite path




    /**** Constructors ****/
    /** Using the superclass constructor **/
    public Cannon() {
        super(2100, 2f, 3, 0, 0, 58, 1, 100);
        super.setStandingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.cannonStandingPath), 4, 66, 58));
        super.setFiringImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.cannonShootingPath), 7, 63, 56));
    }



    /**** Methods ****/
}
