package model.enemy;

import view.guiComponents.Tile;

/**** Subclass of the Enemy abstract superclass, one of the implemented enemies of the game ****/
public class Zombie extends Enemy implements Fightable {

    /**** Fields ****/
    // Inherited from parent class





    /**** Constructors ****/
    /** Main constructor (uses the superclass constructor) **/
    public Zombie(int lifePoints, float speed, int hitPower, int enIndex, Tile[] tiles, int x, int y) {
        super(lifePoints, speed, hitPower, enIndex, 8, 12, 5, tiles, x, y, 96, 95);
    }



    /**** Methods ****/
    /** Move method **/
    public void move() {
        super.move();
    }

    /** Hit method **/
    public void hit() {

    }
}
 /*  new int[] {8, 12, 5}, new int[] {96, 95, 95}, new int[] {56, 62, 48}, */
