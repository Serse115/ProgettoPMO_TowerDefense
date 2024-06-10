package model.enemy;

/**** Subclass of the Enemy abstract superclass, one of the implemented enemies of the game ****/
public class Zombie extends Enemy implements Fightable {

    /**** Fields ****/
    // Inherited from parent class





    /**** Constructors ****/
    /** Main constructor (uses the superclass constructor) **/
    public Zombie(int lifePoints, int speed, int hitPower, int enIndex) {
        super(lifePoints, speed, hitPower, enIndex, 8, 12, 5);
    }



    /**** Methods ****/
    /** Move method **/
    public void move() {

    }

    /** Hit method **/
    public void hit() {

    }
}
 /*  new int[] {8, 12, 5}, new int[] {96, 95, 95}, new int[] {56, 62, 48}, */
