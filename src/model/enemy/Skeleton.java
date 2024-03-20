package model.enemy;

/**** Subclass of the Enemy abstract superclass, one of the implemented enemies of the game ****/
public class Skeleton extends Enemy implements Fightable {

    /**** Fields ****/
    private static final String movingAtlasPath = "enemy_skeleton/skeleton_walk.png";      // Path to the requested atlas resource
    private static final String attackAtlasPath = "enemy_skeleton/skeleton_attack.png";    // Path to the requested atlas resource
    private static final String deathAtlasPath = "enemy_skeleton/skeleton_dead.png";       // Path to the requested atlas resource





    /**** Constructors ****/
    /** Main constructor (uses the superclass constructor) **/
    public Skeleton(short lifePoints, byte speed, short hitPower) {
        super(lifePoints, speed, hitPower, movingAtlasPath, attackAtlasPath, deathAtlasPath, new int[] {13, 18, 15}, new int[] {22, 43, 33}, new int[] {33, 37, 32});
    }



    /**** Methods ****/
    /** Move method **/
    public void move() {

    }

    /** Hit method **/
    public void hit() {

    }
}