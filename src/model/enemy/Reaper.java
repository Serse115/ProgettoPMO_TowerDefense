package model.enemy;

import view.guiComponents.Tile;
import view.imageUtilities.SpriteUtilities;

/**** Subclass of the Enemy abstract superclass, one of the implemented enemies of the game ****/
public class Reaper extends Enemy implements Fightable {

    /**** Fields ****/
    // Most inherited from parent class
    private final String reaperWalkingPath = "enemy_reaper/HostileRunningReaper.png";           // Path for the reaper walking images
    private final String reaperAttackingPath = "enemy_reaper/HostileAttackReaper.png";          // Path for the reaper attacking images





    /**** Constructors ****/
    /** Main constructor (uses the superclass constructor and sets the images) **/
    public Reaper(Tile[] tiles, int y) {
        super(1450, 0.25f, 2, 8, 10, tiles, 0, y, 48, 48);
        super.setWalkingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.reaperWalkingPath), 8, 48, 48));
        super.setAttackingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.reaperAttackingPath), 10, 48, 48));
    }



    /**** Methods ****/
    // Most methods except for the overrides are inherited from parentclass
    /** Get line of fire method override **/
    public int getLineOfFire() {
        return (super.getyPosition() + 22);
    }
}