package model.enemy;

import view.guiComponents.Tile;

/**** Subclass of the Enemy abstract superclass, one of the implemented enemies of the game ****/
public class Skeleton extends Enemy implements Fightable {

    /**** Fields ****/
    // Inherited from parent class





    /**** Constructors ****/
    /** Main constructor (uses the superclass constructor) **/
    public Skeleton(int lifePoints, int speed, int hitPower, int enIndex, Tile[] tiles, int x, int y) {
        super(lifePoints, speed, hitPower, enIndex, 13, 18, 15, tiles, x, y, 43, 37);
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
}

/* new int[] {13, 18, 15}, new int[] {22, 43, 33}, new int[] {33, 37, 32} */