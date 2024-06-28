package view.gameScenes;

import model.tower.Tower;
import view.guiComponents.GameActionBar;
import view.guiComponents.Tile;
import view.imageUtilities.LevelUtilities;
import java.awt.*;

/***** Class for the endless waves game scene *****/
public class EndlessWaves extends GameSceneBase implements Playable {

    /**** Fields ****/
    // Inherited from superclass
    private int waveCounter;                            // Wave counter variable




    /**** Constructors ****/
    /** Main constructor for the endless waves game scene **/
    public EndlessWaves() {
        super();                                 // Using the superclass constructor
        this.waveCounter = 1;                    // Starting wave
        super.setGold(500);                      // Starting gold
        this.setnOfEnemies(1);                   // Starting number of enemies
    }




    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {

        super.render(g);                    // Using the SuperClass method
    }

    /** Update method **/
    // Specialization of the superclass method
    public void update() {

        try {
            super.update();                                             // Calling the superclass update method

            // Specialization
            if (super.getLvlEnemies().isEmpty()) {                      // If the list of enemies of the lvl is empty
                this.waveCounter++;                                     // Upgrade the wave counter
                super.setGold(super.getGold() + 250);                   // Add 250 gold as a reward for the survived wave
                super.setnOfEnemies(super.getnOfEnemies() + 5);         // Increasing the number of enemies for the next wave
                super.initializeEnemies();                              // Initialize the enemies for the next wave
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Initialize the map method **/
    // Specialization of the superclass method
    public void initializeMap() {

        int[][] mapArrayInt = LevelUtilities.getLvlData("resources/levels/EndlessWavesMap.txt");  // Initialize the map array tiles layout with the data from the chosen txt file
        super.setPositionsOnTheArray(new int[]{2, 5, 8, 11, 14, 17});                                   // Positions on the tiles array where roads are

        try {
            for (int i = 0; i < 20; i++) {                                                // For every row and column of the array of tiles of the lvl
                for (int j = 0; j < 23; j++) {
                    super.getMapArrayTile()[i][j] = new Tile();                            // Initialize every tile by default
                    super.getMapArrayTile()[i][j].setTileType(mapArrayInt[i][j]);          // Initialize then the tile types through the setter and the values of the array of ints
                    super.getMapArrayTile()[i][j].setSprite(super.getGuiController().getTileTypeReturnImage(super.getMapArrayTile()[i][j].getTileType()));  // Set the tile sprites through the types
                }
            }
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /** Initialize enemies method **/
    public void initializeEnemies() {

        super.initializeEnemies();                                              // Using the superClass method
    }

    /** Set the selected tower as the one chosen **/
    public void setSelectedTower(Tower selectedTower) {
        super.setTowerToAdd(selectedTower);                                              // Using the superClass method
    }

    /** Reset the towers method **/
    // Specialization of the superclass method
    public void resetTowers() {

        super.resetTowers();                                // Using the superClass method to reset towers
        super.getLvlEnemies().clear();                      // Using the superClass method to clear the enemies list
        this.waveCounter = 1;                               // Resetting the waves counter
        super.setGold(500);                                 // Resetting the gold resources
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {

        super.mouseClicked(x, y);                                // Using the superClass method
    }

    /** Mouse moved method **/
    public void mouseMoved(int x, int y) {

        super.mouseMoved(x, y);                                  // Using the superClass method
    }

    /** Mouse pressed method **/
    public void mousePressed(int x, int y) {

        super.mousePressed(x, y);                                // Using the superClass method
    }

    /** Mouse released method **/
    public void mouseReleased(int x, int y) {

        super.mouseReleased(x, y);                               // Using the superClass method
    }

    /** Mouse dragged method **/
    public void mouseDragged(int x, int y) {

        // Not required
    }

    /** Wave getter **/
    public int getWave() {
        return this.waveCounter;
    }

    /** BottomBar setter **/
    public void setBottomBar(GameActionBar bottomBar) {
        super.setBottomBar(bottomBar);                                              // Using the superClass method
    }

    /** Gold getter **/
    public int getGold() {
        return super.getGold();                // Using the superClass method
    }

    /** Number of enemies setter **/
    public void setnOfEnemies(int nOfEnemies) {
        super.setnOfEnemies(nOfEnemies);            // Using the superClass method
    }

    /** Wave counter setter **/
    public void setWaveCounter(int waveCounter) {
        this.waveCounter = waveCounter;
    }

    /** Gold setter **/
    public void setGold(int gold) {
        super.setGold(gold);
    }

    /** Saved map to load in game path (Not required) **/
    public void setSavedMapPath(String savedMapPath) {
        // Not required
    }

    /** Map initializer (not required) **/
    public void initializeRealMap() {
        // Not required
    }
}