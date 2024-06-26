package view.gameScenes;

import model.tower.Tower;
import view.guiComponents.GameActionBar;
import view.guiComponents.Tile;
import view.imageUtilities.LevelUtilities;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**** Class for the saved map game scene ****/
public class SavedMapGame extends RandomGame implements Playable {

    /**** Fields ****/
    // Inherited
    private String savedMapPath;                    // Saved map to load as game map path




    /**** Constructors ****/
    public SavedMapGame() {
        super();
        this.savedMapPath = "";
    }




    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {
        super.render(g);                    // Using the SuperClass method
    }

    /** Update method **/
    public void update() {
        super.update();                               // Using the SuperClass method
    }

    /** Initialize the real saved game map method **/
    public void initializeRealMap() {

        int[][] mapArrayInt = LevelUtilities.getLvlData(this.savedMapPath);             // Initialize the map array tiles layout with the data from the chosen txt file
        ArrayList<Integer> roadsNumber = this.roadsCounter(mapArrayInt);                // ArrayList of integers for the roads positions
        int[] roadsNumberArray = new int[roadsNumber.size()];                           // Array of ints for the positions of the roads on the map


        Iterator<Integer> iterator = roadsNumber.iterator();                    // Iterator for the list of integers representing the positions of roads
        int k = 0;                                                              // Counter for the array
        while (iterator.hasNext()) {                                            // While there are values in the list
            int index = iterator.next();                                        // Index that keeps track of the position on the array of ints to fill
            roadsNumberArray[k] = index;                                        // Passing the value of the road index on the map to the array
            k++;
        }

        super.setPositionsOnTheArray(roadsNumberArray);                         // Setting the positions on the tiles array where roads are

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

        this.initializeEnemies();
    }

    /** Map roads analyzer sub-method **/
    private ArrayList<Integer> roadsCounter(int[][] arrayInts) {


        ArrayList<Integer> roadsPositions = new ArrayList<>();                  // ArrayList of indexes of the roads to return

        for (int i = 0; i < arrayInts.length; i++) {                            // Loop through the rows
            boolean isFullRowRoad = true;                                       // Set the full of road variable as true
            for (int j = 0; j < arrayInts[i].length; j++) {                     // Loop through the columns
                if (arrayInts[i][j] != 2) {                                     // Check if the tile type is not road (code 2)
                    isFullRowRoad = false;                                      // If any tile in the row is not a road, mark the row as not a full road
                    break;                                                      // No need to check further in this row, so break the loop
                }
            }
            if (isFullRowRoad) {
                roadsPositions.add(i);                                          // Add row index if it's fully a road
            }
        }
        return roadsPositions;                                                  // Return the arrayList of indexes
    }

    /** Initialize the map with a default layout method **/
    /** Load saved game map layout method **/
    public void initializeMap() {

        int[][] mapArrayInt = LevelUtilities.getLvlData("resources/levels/DefaultCustomMap.txt");             // Initialize the map array tiles layout with the data from the chosen txt file
        ArrayList<Integer> roadsNumber = this.roadsCounter(mapArrayInt);                // ArrayList of integers for the roads positions
        int[] roadsNumberArray = new int[roadsNumber.size()];                           // Array of ints for the positions of the roads on the map


        Iterator<Integer> iterator = roadsNumber.iterator();                    // Iterator for the list of integers representing the positions of roads
        int k = 0;                                                              // Counter for the array
        while (iterator.hasNext()) {                                            // While there are values in the list
            int index = iterator.next();                                        // Index that keeps track of the position on the array of ints to fill
            roadsNumberArray[k] = index;                                        // Passing the value of the road index on the map to the array
            k++;
        }

        super.setPositionsOnTheArray(roadsNumberArray);                         // Setting the positions on the tiles array where roads are

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

    /** Initialize the number of enemies for the map **/
    public void initializeEnemies() {

        try {
            super.initializeEnemies();                      // Using the SuperClass method
        }
        catch (Exception e) {

        }
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

    /** Saved map path setter **/
    public void setSavedMapPath(String savedMapPath) {
        this.savedMapPath = savedMapPath;
    }
}