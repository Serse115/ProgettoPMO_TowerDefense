package model.tower;

import view.gameScenes.RandomGame;
import view.imageUtilities.SpriteUtilities;

/***** Subclass of the parent class Tower *****/
public class Turret extends Tower implements Placeable {

    /**** Fields ****/
    // Most inherited from parent class
    private final String turretStandingPath = "tower_turret/turret_mk.png";                     // Turret standing and firing sprite path




    /**** Constructors ****/
    /** Using the superclass constructor **/
    public Turret() {
        super(1700, 1.2f, 2, 0, 0, 77, 0);
        super.setStandingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.turretStandingPath), 11, 111, 77));
        super.setFiringImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.turretStandingPath), 11, 111, 77));
    } // 111



    /**** Methods ****/
}
