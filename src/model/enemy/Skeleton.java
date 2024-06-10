package model.enemy;

/**** Subclass of the Enemy abstract superclass, one of the implemented enemies of the game ****/
public class Skeleton extends Enemy implements Fightable {

    /**** Fields ****/
    // Inherited from parent class





    /**** Constructors ****/
    /** Main constructor (uses the superclass constructor) **/
    public Skeleton(int lifePoints, int speed, int hitPower, int enIndex) {
        super(lifePoints, speed, hitPower, enIndex, 13, 18, 15);
    }



    /**** Methods ****/
    /** Move method **/
    public void move() {
        super.move();
    }

    /** Hit method **/
    public void hit() {
        super.hit();
    }
}

/* new int[] {13, 18, 15}, new int[] {22, 43, 33}, new int[] {33, 37, 32} */