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
    public Zombie(int enIndex, Tile[] tiles, int y) {
        super(950, 0.35f, 1, enIndex, 8, 12, 5, tiles, 0, y, 96, 95);
        super.setWalkingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.zombieWalkingPath), 8, 96, 56));
        super.setAttackingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.zombieAttackingPath), 12, 95, 62));
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

    /** Get line of fire method override **/
    public int getLineOfFire() {
        return (super.getyPosition() + 42);
    }
}