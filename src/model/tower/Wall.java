package model.tower;

import view.imageUtilities.SpriteUtilities;

/***** Subclass of the parent class Tower *****/
public class Wall extends Tower implements Placeable {

    /**** Fields ****/
    private final String wallSpritePath = "tower_wall/defenseWall_sprite.png";          // Wall standing path




    /**** Constructors ****/
    /** Using the superclass constructor **/
    public Wall() {
        super(9000, 0, 0, 0, 104, 3, 70);
        super.setStandingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.wallSpritePath), 4, 97, 104));
        super.setFiringImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.wallSpritePath), 4, 97, 104));
    }




    /**** Methods ****/
    // Mostly inherited from upperclass

    /** Repair the tower **/
    // Specialization of the superclass method
    public void repairTower() {
        super.setLifePoints(super.getLifePoints() + (9000 - super.getLifePoints()));
    }
}