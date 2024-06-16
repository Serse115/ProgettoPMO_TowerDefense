package model.enemy;

import view.guiComponents.Tile;
import view.imageUtilities.SpriteUtilities;

/**** Subclass of the Enemy abstract superclass, one of the implemented enemies of the game ****/
public class Reaper extends Enemy implements Fightable {

    /**** Fields ****/
    // Most inherited from parent class
    private final String reaperWalkingPath = "enemy_reaper/HostileRunningReaper.png";           // Path for the reaper walking images
    private final String reaperAttackingPath = "enemy_reaper/HostileAttackReaper.png";          // Path for the reaper attacking images
    private final String reaperDeathPath = "enemy_reaper/DeathAnimationReaper.png";             // Path for the reaper death images





    /**** Constructors ****/
    /** Main constructor (uses the superclass constructor and sets the images) **/
    public Reaper(int enIndex, Tile[] tiles, int y) {
        super(1550, 0.4f, 2, enIndex, 8, 10, 10, tiles, 0, y, 48, 48);
        super.setWalkingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.reaperWalkingPath), 8, 48, 48));
        super.setAttackingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.reaperAttackingPath), 10, 48, 48));
        super.setDeathImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.reaperDeathPath), 10, 48, 48));
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
        return ((super.getyPosition() + 10) / 32);
   }

   @Override
   public int getOffset() {
        return 10;
   }
}