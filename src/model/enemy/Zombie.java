package model.enemy;

import view.guiComponents.Tile;
import view.imageUtilities.SpriteUtilities;

/**** Subclass of the Enemy abstract superclass, one of the implemented enemies of the game ****/
public class Zombie extends Enemy implements Fightable {

    /**** Fields ****/
    // Most inherited from parent class
    private final String zombieWalkingPath = "enemy_zombie/zombie_run.png";                     // Path for the zombie walking images
    private final String zombieAttackingPath = "enemy_zombie/zombie_attack.png";                // Path for the zombie attacking images





    /**** Constructors ****/
    /** Main constructor (uses the superclass constructor) **/
    public Zombie(Tile[] tiles, int x, int y) {
        super(1100, 0.35f, 8, 12, 5, tiles, x, y, 96, 95);
        super.setWalkingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.zombieWalkingPath), 8, 96, 56));
        super.setAttackingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.zombieAttackingPath), 12, 95, 62));
    }



    /**** Methods ****/
    // Most methods except for the overrides are inherited from parentclass
    /** Get line of fire method override **/
    public int getLineOfFire() {
        return (super.getyPosition() + 42);
    }
}