package model.enemy;

import view.guiComponents.Tile;
import view.imageUtilities.SpriteUtilities;

/**** Subclass of the Enemy abstract superclass, one of the implemented enemies of the game ****/
public class Skeleton extends Enemy implements Fightable {

    /**** Fields ****/
    // Most inherited from parent class
    private final String skeletonWalkingPath = "enemy_skeleton/skeleton_walk.png";              // Path for the skeleton walking images
    private final String skeletonAttackingPath = "enemy_skeleton/skeleton_attack.png";          // Path for the skeleton attacking images
    private final String skeletonDeathPath = "enemy_skeleton/skeleton_dead.png";                // Path for the skeleton death images





    /**** Constructors ****/
    /** Main constructor (uses the superclass constructor) **/
    public Skeleton(int enIndex, Tile[] tiles, int y) {
        super(1750, 0.3f, 3, enIndex, 13, 18, 15, tiles, 0, y, 43, 37);
        super.setWalkingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.skeletonWalkingPath), 13, 22, 33));
        super.setAttackingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.skeletonAttackingPath), 18, 43, 37));
        super.setDeathImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.skeletonDeathPath), 15, 33, 32));
    }



    /**** Methods ****/
    /** Move method **/
    public void move() {
        super.move();
    }

    /** Hit method **/
    public void hit(Tile t) {
        super.hit(t);
    }

    public int getLineOfFire(int offSet) {
        return ((super.getyPosition() + 5) / 32);
    }

    @Override
    public int getOffset() {
        return 5;
    }
}