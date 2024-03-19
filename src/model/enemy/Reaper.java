package model.enemy;

/**** Subclass of the Enemy abstract superclass, one of the implemented enemies of the game ****/
public class Reaper extends Enemy implements Fightable {

    /**** Fields ****/
    private static final String movingAtlasPath = "enemy_reaper/HostileRunningReaper.png";      // Path to the requested atlas resource
    private static final String attackAtlasPath = "enemy_reaper/HostileAttackReaper.png";       // Path to the requested atlas resource
    private static final String deathAtlasPath = "enemy_reaper/HostileRunningReaper.png";       // Path to the requested atlas resource





    /**** Constructors ****/
    /** Main constructor (uses the superclass constructor) **/
    public Reaper(short lifePoints, byte speed, short hitPower) {
        super(lifePoints, speed, hitPower, movingAtlasPath, attackAtlasPath, deathAtlasPath);
    }



    /**** Methods ****/
    /** Move method **/
    public void move() {

    }

    /** Hit method **/
    public void hit() {

    }
}