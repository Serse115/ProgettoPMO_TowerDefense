package model.enemy;

/**** Interface for the Enemy subclasses ****/
public interface Fightable {

    /**** Methods ****/
    /** Move method **/
    void move();

    /** Hit method **/
    void hit();

    /** Is alive method **/
    boolean isAlive();
}