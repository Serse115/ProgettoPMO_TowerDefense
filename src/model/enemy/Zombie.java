package model.enemy;

/**** Subclass of the Enemy abstract superclass, one of the implemented enemies of the game ****/
public class Zombie extends Enemy implements Fightable {

    /**** Fields ****/
    private static final String movingAtlasPath = "enemy_zombie/zombie_run.png";            // Path to the requested atlas resource
    private static final String attackAtlasPath = "enemy_zombie/zombie_attack.png";         // Path to the requested atlas resource
    private static final String deathAtlasPath = "enemy_zombie/zombie_dead.png";            // Path to the requested atlas resource





    /**** Constructors ****/
    /** Main constructor (uses the superclass constructor) **/
    public Zombie(short lifePoints, byte speed, short hitPower) {
        super(lifePoints, speed, hitPower, movingAtlasPath, attackAtlasPath, deathAtlasPath, new int[] {8, 12, 5}, new int[] {96, 95, 95}, new int[] {56, 62, 48});
    }



    /**** Methods ****/
    /** Move method **/
    public void move() {

    }

    /** Hit method **/
    public void hit() {

    }
}
