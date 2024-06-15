package model.tower;

import view.imageUtilities.SpriteUtilities;

/***** Subclass of the parent class Tower *****/
public class Turret extends Tower implements Placeable {

    /**** Fields ****/
    // Inherited from parent class
    private final String turretStandingPath = "tower_turret/turret_mk.png";                     //




    /**** Constructors ****/
    /** Using the superclass constructor **/
    public Turret(int lifePoints, float fireCooldown, int dmgPower, int x, int y, int towerType) {
        super(lifePoints, fireCooldown, dmgPower, x, y, 111, 77, towerType);
        super.setStandingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.turretStandingPath), 11, 111, 77));
        super.setFiringImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.turretStandingPath), 11, 111, 77));
    }



    /**** Methods ****/
}
