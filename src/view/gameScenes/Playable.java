package view.gameScenes;

import model.tower.Tower;
import view.guiComponents.GameActionBar;

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

    /** Set the selected tower method **/
    void setSelectedTower(Tower tower);

    /** Reset the towers method **/
    void resetTowers();

    /** Gold getter **/
    int getGold();

    /** Wave getter **/
    int getWave();

    /** Set the bottomBar method **/
    void setBottomBar(GameActionBar bottomBar);

    /** Number of enemies getter **/
    int getnOfEnemies();

    /** Number of enemies setter **/
    void setnOfEnemies(int nOfEnemies);

    /** Wave counter setter **/
    void setWaveCounter(int waveCounter);

    /** Gold setter **/
    void setGold(int gold);

    /** Saved map to load as game path **/
    void setSavedMapPath(String savedMapPath);

    /** Map initializer for the saved map games modes **/
    void initializeRealMap();

    /** Bottom-bar getter **/
    GameActionBar getBottomBar();
}