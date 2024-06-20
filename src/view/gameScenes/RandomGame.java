package view.gameScenes;

import controller.GUIController;
import model.tower.Tower;
import view.guiComponents.GameActionBar;
import view.guiComponents.MainFrame;
import view.guiComponents.Tile;
import java.awt.*;

/**** Class for the random game scene ****/
public class RandomGame extends GameSceneBase implements Playable {

    /**** Fields ****/
    // Inherited from superclass




    /**** Constructors ****/
    /** Main constructor **/
    public RandomGame() {
        super();                       // SuperClass constructor
    }




    /**** Methods ****/
    public void render(Graphics g) {
        super.render(g);                    // Using the SuperClass method
    }

    /** Update method **/
    // Specialization of the superclass method
    public void update() {

        try {
            super.update();                                             // Calling the superclass update method

            // Specialization
            if (super.getLvlEnemies().isEmpty()) {                      // If the list of enemies is empty and there are no more enemies
                GameScenes.setGameScene(GameScenes.GAME_WON);           // Set the game scene as the victory one
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /** Initialize the map tile method **/
    // Specialization of the empty method of the superclass
    public void initializeMap() {

        int numberOfRoads = super.randomGenerator(1, 8);              // Generate the number of roads possible in the level
        super.setNumberOfRoads(numberOfRoads);                                                     // Set the number of roads
        int[] positionsOnTheArray = new int[numberOfRoads];                                        // Initialize positions array for roads

        for (int z = 0; z < numberOfRoads; z++) {
            positionsOnTheArray[z] = super.randomGenerator(1, 20);       // Choose the rows where the roads will be located through the random method
        }
        super.setPositionsOnTheArray(positionsOnTheArray);                                            // Set the positions on the array in the superclass

        Tile[][] mapArrayTile = super.getMapArrayTile();                                              // Get the map array from the superclass
        GUIController guiController = super.getGuiController();                                       // Get the GUI controller from the superclass

        for (int j = 0; j < 20; j++) {                                                                                  // For every row
            for (int i = 0; i < 23; i++) {                                                                              // And column of the array of int
                mapArrayTile[j][i] = new Tile();                                                                        // Default constructor for the 2d array of tiles
                mapArrayTile[j][i].setTileType(super.randomGenerator(0, 2));               // Generate the tile type value with the random function
                mapArrayTile[j][i].setSprite(guiController.getTileTypeReturnImage(mapArrayTile[j][i].getTileType()));   // Setting the sprite
            }
        }

        for (int h = 0; h < numberOfRoads; h++) {                                                           // For every row that corresponds to the one that should be a road
            for (int k = 0; k < 23; k++) {                                                                  // Turn every column of that own row
                mapArrayTile[positionsOnTheArray[h]][k].setTileType(2);                                     // Into a road
                mapArrayTile[positionsOnTheArray[h]][k].setSprite(guiController.getTileTypeReturnImage(2)); // Setting the sprite into a road
            }
        }
    }

    /** Initialize the number of enemies for the map **/
    // Specialization of the superclass method
    public void initializeEnemies() {

        super.setnOfEnemies(this.randomGenerator(5, 25));   // Initializing the number of enemies for the game
        super.initializeEnemies();                                              // Using the superClass method

        // Specialization                                                       // Since it's a single wave mode, the gold gets re-initialized everytime a new game starts
        super.setGold((super.getLvlEnemies().size() * 75));                     // Reset the gold resources for a new game
    }

    /** Set the selected tower as the one chosen **/
    public void setSelectedTower(Tower selectedTower) {
        super.setSelectedTower(selectedTower);              // Using the superClass method
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {

        super.mouseClicked(x, y);                       // Using the superClass method
    }

    /** Mouse moved method **/
    public void mouseMoved(int x, int y) {

        super.mouseMoved(x, y);                         // Using the superClass method
    }

    /** Mouse pressed method **/
    public void mousePressed(int x, int y) {

        super.mousePressed(x, y);                       // Using the superClass method
    }

    /** Mouse released method **/
    public void mouseReleased(int x, int y) {

        super.mouseReleased(x, y);                      // Using the superClass method
    }

    /** Mouse dragged method **/
    public void mouseDragged(int x, int y) {

        // Not required
    }

    /** Reset towers method **/
    public void resetTowers() {

        super.resetTowers();                        // Using the superClass method
    }

    /** BottomBar setter **/
    public void setBottomBar(GameActionBar bottomBar) {
        super.setBottomBar(bottomBar);                  // Using the suerClass method
    }

    /** Gold getter **/
    public int getGold() {
        return super.getGold();
    }

    /** Wave counter setter (not required) **/
    public void setWaveCounter(int waveCounter) {
        // Not required
    }
}