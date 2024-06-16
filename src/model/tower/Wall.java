package model.tower;

import model.enemy.Fightable;
import view.gameScenes.RandomGame;
import view.imageUtilities.SpriteUtilities;

/***** Subclass of the parent class Tower *****/
public class Wall extends Tower implements Placeable {

    /**** Fields ****/
    private final String wallSpritePath = "tower_wall/defenseWall_sprite.png";




    /**** Constructors ****/
    /** Using the superclass constructor **/
    public Wall() {
        super(8500, 0, 0, 0, 0, 66, 58, 3);
        super.setStandingImages(SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(this.wallSpritePath), 1, 65, 109));
        super.setFiringImages(null);
    }




    /**** Methods ****/
    /** Shoot method (not required for the wall) **/
    public void shoot(Fightable enemy) {
        // Not required
    }
}
