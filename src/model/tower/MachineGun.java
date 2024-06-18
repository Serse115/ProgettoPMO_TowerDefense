package model.tower;

import view.imageUtilities.SpriteUtilities;

/***** Subclass of the parent class Tower *****/
public class MachineGun extends Tower implements Placeable {

    /**** Fields ****/
    // Most inherited from parent class
    private final String machineGunStandingPath = "tower_machinegun/machinegun_standing.png";   // Standing machinegun sprite path
    private final String machineGunShootingPath = "tower_machinegun/machinegun_shooting.png";   // Firing machinegun sprite path




    /**** Constructors ****/
    /** Using the superclass constructor **/
    public MachineGun() {
        super(1500, 1, 0, 0, 43, 2, 50);
        super.setStandingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.machineGunStandingPath), 4, 72, 46));
        super.setFiringImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.machineGunShootingPath), 4, 83, 43));
    }



    /**** Methods ****/
    // Inherited from superclass
}