package view.gameScenes;

import controller.GUIController;
import controller.ModelController;
import model.enemy.*;
import view.guiComponents.GameActionBar;
import view.guiComponents.MainFrame;
import java.awt.*;
import java.util.Random;

/**** Class for the random game scene ****/
public class RandomGame extends GameSceneBase implements Playable {

    /**** Fields ****/
    private GameActionBar bottomBar;            // Action bar at the bottom of the screen
    private GUIController guiController;        // GUI controller object for the random map generating and the tiles
    private ModelController modelController;    // Model controller object for the enemies
    private int[][] mapArrayTile;               // Array of tiles for the map
    private int numberOfRoads;                  // Number of roads on the map
    private int[] positionsOnTheArray;          // Row position of each road in the array of the map
    private Fightable[] lvlEnemies;             // Array of enemies that will be present in the level




    /**** Constructors ****/
    /** Main constructor **/
    public RandomGame(MainFrame mainFrame, Playable endlessWaves) {
        super(mainFrame);
        this.bottomBar = new GameActionBar(0, 640, 736, 160, this, endlessWaves);
        this.guiController = new GUIController();
        this.modelController = new ModelController();
        this.mapArrayTile = new int[20][23];
        this.initializeMap();
        this.initializeEnemies();
    }




    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {
        this.drawLevel(g);
        this.bottomBar.render(g);
    }

    /** Initialize the map tile method **/
    public void initializeMap() {

        this.numberOfRoads = this.randomGenerator(1, 8);                   // Generating the number of roads possible in the level
        this.positionsOnTheArray = new int[numberOfRoads];                                          // Initializing the number of row positions for the roads on the map
        for (int z = 0; z < numberOfRoads; z++) {                                                   // For every position of the road in the array
            positionsOnTheArray[z] = this.randomGenerator(0, 20);          // Choose the rows where the roads will be located through the random method
        }
        for (int j = 0; j < 20; j++) {                                                              // For every row
            for (int i = 0; i < 23; i++) {                                                          // And column of the array of int
                this.mapArrayTile[j][i] = this.randomGenerator(0, 2);      // Generate its tile type value through the random function
            }
        }
        for (int h = 0; h < numberOfRoads; h++) {                                                   // For every row that corresponds to the one that should be a road
            for (int k = 0; k < 23; k++) {                                                          // Turn every column of that own row
                this.mapArrayTile[positionsOnTheArray[h]][k] = 2;                                   // Into a road
            }
        }
    }

    /** Initialize the number of enemies for the map **/
    private void initializeEnemies() {

        int nOfEnemies = this.randomGenerator(1, 30);             // Generating a value in between 1 and 30 enemies (from easy to hard)
        this.lvlEnemies = new Enemy[nOfEnemies];                                      // Initializing the list of enemies with the number of enemies generated prior

        for (int i = 0; i < nOfEnemies; i ++) {                                       // For every enemy
            int enemyType = this.randomGenerator(0, 3);           // Generate a value representing the type of enemy that will appear in the game

            if (enemyType == 0) {                                                       // If the generated type number is 0, add a reaper
                this.lvlEnemies[i] = new Reaper(115, 10, 7, i);   // And its sprite animations
                this.lvlEnemies[i].setWalkingImages(this.modelController.getWalkingImages(this.modelController.getReaperMovingAtlasPath(), 8, 48, 48));
                this.lvlEnemies[i].setAttackingImages(this.modelController.getAttackingImages(this.modelController.getReaperAttackAtlasPath(), 10, 48, 48));
                this.lvlEnemies[i].setDeathImages(this.modelController.getDeathImages(this.modelController.getReaperDeathAtlasPath(),10, 48, 48));
            }
            else if (enemyType == 1) {                                                       // If the generated type number is 0, add a skeleton
                this.lvlEnemies[i] = new Skeleton(150, 8, 10, i);      // And its sprite animations
                this.lvlEnemies[i].setWalkingImages(this.modelController.getWalkingImages(this.modelController.getSkeletonMovingAtlasPath(), 13, 22, 33));
                this.lvlEnemies[i].setAttackingImages(this.modelController.getAttackingImages(this.modelController.getSkeletonAttackAtlasPath(), 18, 43, 37));
                this.lvlEnemies[i].setDeathImages(this.modelController.getDeathImages(this.modelController.getSkeletonDeathAtlasPath(),15, 33, 32));
            }
            else if (enemyType == 2) {                                                       // If the generated type number is 2, add a zombie
                this.lvlEnemies[i] = new Zombie(90, 15, 5, i);         // And its sprite animations
                this.lvlEnemies[i].setWalkingImages(this.modelController.getWalkingImages(this.modelController.getZombieMovingAtlasPath(), 8, 96, 56));
                this.lvlEnemies[i].setAttackingImages(this.modelController.getAttackingImages(this.modelController.getZombieAttackAtlasPath(), 12, 95, 62));
                this.lvlEnemies[i].setDeathImages(this.modelController.getDeathImages(this.modelController.getZombieDeathAtlasPath(),5, 95, 48));
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

    /** Random method to select the number of roads and other tiles and also for the enemies **/
    private int randomGenerator(int lowerBound, int upperBound) {

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