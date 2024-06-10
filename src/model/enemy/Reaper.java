package model.enemy;

import java.awt.image.BufferedImage;

/**** Subclass of the Enemy abstract superclass, one of the implemented enemies of the game ****/
public class Reaper extends Enemy implements Fightable {

    /**** Fields ****/
    // Inherited from parent class





    /**** Constructors ****/
    /** Main constructor (uses the superclass constructor) **/
    public Reaper(int lifePoints, int speed, int hitPower, int enIndex) {
        super(lifePoints, speed, hitPower, enIndex, 8, 10, 10);
    }



    /**** Methods ****/
    /** Move method **/
    public void move() {

    }

    /** Hit method **/
    public void hit() {

    }

    /** CurrentlyInUsImages setter **/
    //public void setCurrentInUseImages(BufferedImage[] imgs) {
      //  super.setCurrentInUseImages(imgs);
    //}
}
/* , new int[] {8, 10, 10}, new int[] {48, 48, 48}, new int[] {48, 48, 48} */