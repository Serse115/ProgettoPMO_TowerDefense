package model.tower;

import view.imageUtilities.SpriteUtilities;

/***** Subclass of the parent class Tower *****/
public class MachineGun extends Tower implements Placeable {

    /**** Fields ****/
    // Inherited from parent class
    private final String machineGunStandingPath = "tower_machinegun/machinegun_standing.png";   //
    private final String machineGunShootingPath = "tower_machinegun/machinegun_shooting.png";   //




    /**** Constructors ****/
    /** Using the superclass constructor **/
    public MachineGun(int lifePoints, float fireCooldown, int dmgPower, int x, int y, int towerType) {
        super(lifePoints, fireCooldown, dmgPower, x, y, 71, 43, towerType);
        super.setStandingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.machineGunStandingPath), 1, 71, 43));
        super.setFiringImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.machineGunShootingPath), 4, 83, 43));
    }



    /**** Methods ****/

}