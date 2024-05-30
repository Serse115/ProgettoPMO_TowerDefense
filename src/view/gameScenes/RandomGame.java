package view.gameScenes;

import controller.GUIController;
import view.guiComponents.GameActionBar;
import view.guiComponents.MainFrame;
import java.awt.*;
import java.util.Random;

/**** Class for the random game scene ****/
public class RandomGame extends GameSceneBase implements Playable {

    /**** Fields ****/
    private GameActionBar bottomBar;            // Action bar at the bottom of the screen
    private GUIController guiController;        // GUI controller object for the random map generating and the tiles
    private int[][] mapArrayTile;               // Array of tiles for the map




    /**** Constructors ****/
    /** Main constructor **/
    public RandomGame(MainFrame mainFrame, Playable endlessWaves) {
        super(mainFrame);
        this.bottomBar = new GameActionBar(0, 640, 736, 160, this, endlessWaves);
        this.guiController = new GUIController();
        this.mapArrayTile = new int[20][23];
        this.initializeMap();
    }




    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {
        this.drawLevel(g);
        this.bottomBar.render(g);
    }

    /** Initialize the map tile method **/
    public void initializeMap() {

        int numberOfRoads = this.randomTilesGenerator(1, 8);                    // Number of roads possible in the level
        int[] positionsOnTheArray = new int[numberOfRoads];                                         // Row position of each road in the array of the map
        for (int z = 0; z < numberOfRoads; z++) {                                                   // For every position of the road in the array
            positionsOnTheArray[z] = this.randomTilesGenerator(0, 20);          // Choose the rows where the roads will be located through the random method
        }
        for (int j = 0; j < 20; j++) {                                                              // For every row
            for (int i = 0; i < 23; i++) {                                                          // And column of the array of int
                this.mapArrayTile[j][i] = this.randomTilesGenerator(0, 2);      // Generate its tile type value through the random function
            }
        }
        for (int h = 0; h < numberOfRoads; h++) {                                                   // For every row that corresponds to the one that should be a road
            for (int k = 0; k < 23; k++) {                                                          // Turn every column of that own row
                this.mapArrayTile[positionsOnTheArray[h]][k] = 2;                                   // Into a road
            }
        }
    }

    /** Drawing the level method **/
    private void drawLevel(Graphics g) {

        for (int j = 0; j < 20; j++) {                                                                                                  // For every row
            for (int i = 0; i < 23; i++) {                                                                                              // And column
                g.drawImage(this.guiController.getTileTypeReturnImage(this.mapArrayTile[j][i]), 32 * i, (32 * j), null);     // Draw the right tile image
            }
        }
    }

    /** Random method to select the number of roads and other tiles **/
    private int randomTilesGenerator(int lowerBound, int upperBound) {

        Random random = new Random();                       // Creating the random object

        return random.nextInt(lowerBound, upperBound);      // Returning the generated value
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {

        if (y >= 640) {                             // If the mouse click is located inside the bottom game action bar bounds
            this.bottomBar.mouseClicked(x, y);      // Use the bottom bar's mouse clicked method passing it the coordinates of where its clicked
        }
    }

    /** Mouse moved method **/
    public void mouseMoved(int x, int y) {

        if (y >= 640) {                             // If the mouse moved position is located inside the bottom game action bar bounds
            this.bottomBar.mouseMoved(x, y);        // Use the bottom bar's mouse moved method passing it the coordinates of where its clicked
        }
    }

    /** Mouse pressed method **/
    public void mousePressed(int x, int y) {

        if (y >= 640) {                             // If the mouse pressed position is located inside the bottom game action bar bounds
            this.bottomBar.mousePressed(x, y);      // Use the bottom bar's mouse pressed method passing it the coordinates of where its clicked
        }
    }

    /** Mouse released method **/
    public void mouseReleased(int x, int y) {

        this.bottomBar.mouseReleased(x, y);         // Use the mouse released method from the bottom game action bar object
    }

    /** Mouse dragged method **/
    public void mouseDragged(int x, int y) {

        // Do nothing for now
    }
}