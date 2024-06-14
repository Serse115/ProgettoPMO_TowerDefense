package model.tower;

/***** Subclass of the parent class Tower *****/
public class Cannon extends Tower implements Placeable {

    /**** Fields ****/
    // Inherited from parent class




    /**** Constructors ****/
    /** Using the superclass constructor **/
    public Cannon(int lifePoints, float fireCooldown, int dmgPower, int x, int y, int width, int height, int towerType) {
        super(lifePoints, fireCooldown, dmgPower, x, y, width, height, towerType);
    }



    /**** Methods ****/
}
