package view.gameScenes;

import controller.GameLoopController;
import controller.ModelController;
import model.tower.Tower;

import java.awt.*;

/**** Interface for the GameScenes subclasses ****/
public interface Playable {

    /**** Methods ****/
    /** Render method **/
    void render(Graphics g);

    /** Update method **/
    void update();

    /** Initialize map method **/
    void initializeMap();

    /** Initialize the enemies method **/
    void initializeEnemies();

    /** Mouse Clicked method **/
    void mouseClicked(int x, int y);

    /** Mouse Moved method **/
    void mouseMoved(int x, int y);

    /** Mouse Pressed method **/
    void mousePressed(int x, int y);

    /** Mouse Released method **/
    void mouseReleased(int x, int y);

    /** Mouse Dragged method **/
    void mouseDragged(int x, int y);

    GameLoopController getGameLoopController();

    void setSelectedTower(Tower tower);

    ModelController getModelController();
}