package model.enemy;

import view.guiComponents.Tile;
import view.imageUtilities.SpriteUtilities;

/**** Subclass of the Enemy abstract superclass, one of the implemented enemies of the game ****/
public class Skeleton extends Enemy implements Fightable {

    /**** Fields ****/
    // Most inherited from parent class
    private final String skeletonWalkingPath = "enemy_skeleton/skeleton_walk.png";              // Path for the skeleton walking images
    private final String skeletonAttackingPath = "enemy_skeleton/skeleton_attack.png";          // Path for the skeleton attacking images





    /**** Constructors ****/
    /** Main constructor (uses the superclass constructor) **/
    public Skeleton(Tile[] tiles, int x, int y) {
        super(2050, 0.20f, 3, 13, 18, tiles, x, y, 43, 37, 50);
        super.setWalkingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.skeletonWalkingPath), 13, 22, 33));
        super.setAttackingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.skeletonAttackingPath), 18, 43, 37));
    }



    /**** Methods ****/
    // Most methods except for the overrides are inherited from parentclass
    /** Get line of fire method override **/
    public int getLineOfFire() {
        return (super.getyPosition() + 22);
    }
}