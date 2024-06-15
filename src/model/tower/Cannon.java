package model.tower;

import view.imageUtilities.SpriteUtilities;

/***** Subclass of the parent class Tower *****/
public class Cannon extends Tower implements Placeable {

    /**** Fields ****/
    // Inherited from parent class
    private final String cannonStandingPath = "tower_cannon/cannon_standing.png";               //
    private final String cannonShootingPath = "tower_cannon/cannon_shooting.png";               //




    /**** Constructors ****/
    /** Using the superclass constructor **/
    public Cannon(int lifePoints, float fireCooldown, int dmgPower, int x, int y, int towerType) {
        super(lifePoints, fireCooldown, dmgPower, x, y, 66, 58, towerType);
        super.setStandingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.cannonStandingPath), 4, 66, 58));
        super.setFiringImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.cannonShootingPath), 7, 63, 56));
    }



    /**** Methods ****/
}
