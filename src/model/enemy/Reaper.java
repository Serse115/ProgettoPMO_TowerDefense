package model.enemy;

import view.imageUtilities.SpriteUtilities;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Reaper extends Enemy implements Fightable {

    /**** Fields ****/
    private BufferedImage imgAtlas = null;                 // Image later used to store the sprites to obtain the animation frames




    /**** Constructors ****/
    /** Main constructor (uses the superclass constructor) **/
    public Reaper(short lifePoints, byte speed, short hitPower) {
        super(lifePoints, speed, hitPower);
        this.setFramesAnimations();
    }



    /**** Methods ****/
    /** Move method **/
    public void move() {

    }

    /** Hit method **/
    public void hit() {

    }

    /** Is alive method **/
    public boolean isAlive() {
        return super.isAlive();
    }

    /** Set the walking, attacking and death animation frames method **/
    private void setFramesAnimations() {
        this.imgAtlas = SpriteUtilities.getSpriteAtlas("enemy_reaper/HostileRunningReaper.png");    // Walking sprite atlas
        super.setWalkingImgs(SpriteUtilities.getAniSprites(0, 0, this.imgAtlas, 8));     // Setting the walking images

        this.imgAtlas = SpriteUtilities.getSpriteAtlas("enemy_reaper/HostileAttackReaper.png");    // Attacking sprite atlas
        super.setAttackingImgs(SpriteUtilities.getAniSprites(0, 0, this.imgAtlas, 10));  // Setting the attacking images

        this.imgAtlas = SpriteUtilities.getSpriteAtlas("enemy_reaper/DeathAnimationReaper.png");    // Death sprite atlas
        super.setDeathImgs(SpriteUtilities.getAniSprites(0, 0, this.imgAtlas, 10));     // Setting the death images
    }

    private void drawEnemy(BufferedImage img, Graphics g) {
        g.drawImage(super.getWalkingImgs()[0], 350, 50, null);
    }


}