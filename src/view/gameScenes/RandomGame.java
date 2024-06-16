package view.gameScenes;

import controller.GUIController;
import controller.GameLoopController;
import controller.ModelController;
import model.enemy.*;
import model.tower.Placeable;
import model.tower.Tower;
import view.guiComponents.GameActionBar;
import view.guiComponents.MainFrame;
import view.guiComponents.Tile;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**** Class for the random game scene ****/
public class RandomGame extends GameSceneBase implements Playable {

    /**** Fields ****/
    private GameActionBar bottomBar;                // Action bar at the bottom of the screen
    private GUIController guiController;            // GUI controller object for the random map generating and the tiles
    //private ModelController modelController;        // Model controller object for the enemies
    private Tile[][] mapArrayTile;                  // Array of tiles for the map
    private int numberOfRoads;                      // Number of roads on the map
    private int[] positionsOnTheArray;              // Row position of each road in the array of the map
    private ArrayList <Fightable> lvlEnemies;       // Array of enemies that will be present in the level
    private ArrayList <Placeable> lvlTowers;        // ArrayLiat of the towers in the level
    private GameLoopController gameLoopController;  // Game loop controller object reference to handle the game loop during the random game
    private int walkingAnimationIndex;              // Animation index int for the walking animation frames
    private int attackingAnimationIndex;            // Animation index int for the attacking animation frames
    private int deathAnimationIndex;                // Animation index int for the death animation frames
    private int animationSpeed;                     // Animation speed int for the animation frames in milliseconds
    private long lastTime;                          // Loop time variable
    private long timer;                             // Other loop time variable
    private Tile tileToAddTower;                    // Tile variable reference where the tower will be added
    private Placeable towerToAdd;                   // Tower variable reference for the tower chosen to add to the specific tile
    private boolean towerToDraw;                    // Variable to decide if the tile will have a tower added
    private int xMouseCoord;                        // Coordinate x for the current mouse location
    private int yMouseCoord;                        // Coordinate y for the current mouse location
    private int lastTileX;                          // Coordinate x for the location of the last tile highlighted
    private int lastTileY;                          // Coordinate y for the location of the last tile highlighted




    /**** Constructors ****/
    /** Main constructor **/
    public RandomGame(MainFrame mainFrame, Playable endlessWaves) {
        super(mainFrame);
        this.gameLoopController = new GameLoopController(this);
        this.bottomBar = new GameActionBar(0, 640, 736, 160, this, endlessWaves, this.gameLoopController);
        this.guiController = new GUIController();
        //this.modelController = new ModelController();
        this.mapArrayTile = new Tile[20][23];
        this.initializeMap();
        this.initializeEnemies();
        this.walkingAnimationIndex = 0;
        this.attackingAnimationIndex = 0;
        this.deathAnimationIndex = 0;
        this.animationSpeed = 150;
        this.lastTime = System.currentTimeMillis();
        this.timer = 0;
        this.tileToAddTower = null;
        this.towerToAdd = null;
        this.towerToDraw = false;
        this.xMouseCoord = 0;
        this.yMouseCoord = 0;
        this.lastTileX = 0;
        this.lastTileY = 0;
        this.lvlTowers = new ArrayList<>();

        // Start the game loop
        this.gameLoopController.start();
    }




    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {
        this.drawLevel(g);
        this.drawEnemies(g);
        this.bottomBar.render(g);
        this.drawSelectedTileTower(g);
    }

    /** Update method **/
    public void update() {

        try {
            long currentTime = System.currentTimeMillis();                          // Current time variable with the System feature in milliseconds
            this.timer += currentTime - this.lastTime;                              // Timer update
            this.lastTime = currentTime;                                            // Last time update

            if (this.timer > this.animationSpeed) {                                 // If the timer is higher than the animation speed
                this.walkingAnimationIndex++;                                       // Increase the walking animation index variable
                this.attackingAnimationIndex++;                                     // Increase the attacking animation index variable
                this.deathAnimationIndex++;                                         // Increase the attacking animation index variable
                this.timer = 0;                                                     // And reset the time variable

                for (Fightable enemy : this.lvlEnemies) {                                    // For every enemy in the array of enemies
                    if (this.walkingAnimationIndex >= enemy.getWalkingImages().length) {     // If the animation index is over the length of the walking images array
                        this.walkingAnimationIndex = 0;                                             // Reset the animation index
                    }
                    if (this.attackingAnimationIndex >= enemy.getAttackingImages().length) {        // If the animation index is over the length of the attacking images array
                        this.attackingAnimationIndex = 0;                                           // Reset the animation index
                    }
                    if (this.deathAnimationIndex >= enemy.getDeathImages().length) {                // If the animation index is over the length of the death images array
                        this.deathAnimationIndex = 0;                                               // Reset the animation index
                    }
                }
            }


            Iterator<Fightable> iterator = this.lvlEnemies.iterator();              // Iterator for the list of enemies
            while (iterator.hasNext()) {
                Fightable enemy = iterator.next();
                if (enemy.isAlive()) {
                    enemy.enemyLogic();                                             // Start the enemy logic
                } else {
                    iterator.remove();                                              // Remove the enemy
                }
            }


            for (Placeable tower : this.lvlTowers) {                            // For every tower in the level
                if (this.lvlTowers.size() > 0) {                                // If the number of towers is more than 0 (at least on tower is on the field)
                    tower.towerLogic(this.lvlEnemies);                          // Start the tower logic
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /** Initialize the map tile method **/
    public void initializeMap() {

        this.numberOfRoads = this.randomGenerator(1, 8);                   // Generating the number of roads possible in the level
        this.positionsOnTheArray = new int[numberOfRoads];                                          // Initializing the number of row positions for the roads on the map
        for (int z = 0; z < numberOfRoads; z++) {                                                   // For every position of the road in the array
            positionsOnTheArray[z] = this.randomGenerator(1, 20);          // Choose the rows where the roads will be located through the random method
        }
        for (int j = 0; j < 20; j++) {                                                                  // For every row
            for (int i = 0; i < 23; i++) {                                                              // And column of the array of int
                this.mapArrayTile[j][i] = new Tile();                                                   // Generic constructor used for the 2d array of tiles
                this.mapArrayTile[j][i].setTileType(this.randomGenerator(0, 2));    // Generate its tile type value through the random function
                this.mapArrayTile[j][i].setSprite(this.guiController.getTileTypeReturnImage(this.mapArrayTile[j][i].getTileType()));   // Setting the sprite
            }
        }
        for (int h = 0; h < numberOfRoads; h++) {                                                   // For every row that corresponds to the one that should be a road
            for (int k = 0; k < 23; k++) {                                                          // Turn every column of that own row
                this.mapArrayTile[positionsOnTheArray[h]][k].setTileType(2);                        // Into a road
                this.mapArrayTile[positionsOnTheArray[h]][k].setSprite(this.guiController.getTileTypeReturnImage(2));   // Setting the sprite
            }
        }
    }

    /** Initialize the number of enemies for the map **/
    public void initializeEnemies() {

        int nOfEnemies = this.randomGenerator(1, 30);             // Generating a value in between 1 and 30 enemies (from easy to hard)
        this.lvlEnemies = new ArrayList<>();                                          // Initializing the list of enemies with the number of enemies generated prior

        for (int i = 0; i < nOfEnemies; i ++) {                                       // For every enemy
            int enemyType = this.randomGenerator(0, 3);           // Generate a value representing the type of enemy that will appear in the game
            int indexRoad = this.randomGenerator(0, this.positionsOnTheArray.length);   // Generate the index for the roads for the enemies to appear on

            if (enemyType == 0) {                                                       // If the generated type number is 0, add a reaper
                this.lvlEnemies.add(new Reaper(i, this.getRoadArrayLine(this.positionsOnTheArray[indexRoad]),(this.positionsOnTheArray[indexRoad] * 32) - 10));   // And its sprite animations
            }
            else if (enemyType == 1) {                                                       // If the generated type number is 1, add a skeleton
                this.lvlEnemies.add(new Skeleton(i, this.getRoadArrayLine(this.positionsOnTheArray[indexRoad]), (this.positionsOnTheArray[indexRoad] * 32) - 5));  // And its sprite animations
            }
            else if (enemyType == 2) {                                                       // If the generated type number is 2, add a zombie
                this.lvlEnemies.add(new Zombie(i, this.getRoadArrayLine(this.positionsOnTheArray[indexRoad]),(this.positionsOnTheArray[indexRoad] * 32) - 30));     // And its sprite animations
            }
        }

        // Reset animation fields when initializing new enemies
        this.walkingAnimationIndex = 0;
        this.attackingAnimationIndex = 0;
        this.deathAnimationIndex = 0;
        this.lastTime = System.currentTimeMillis();
        this.timer = 0;
    }

    /** Drawing the level method **/
    private void drawLevel(Graphics g) {

        for (int j = 0; j < 20; j++) {                                                                                                             // For every row
            for (int i = 0; i < 23; i++) {                                                                                                         // And column
                g.drawImage(this.mapArrayTile[j][i].getSprite(), 32 * i, (32 * j), null);  // Draw the right tile image
                if (this.mapArrayTile[j][i].isHasTower()) {
                    g.drawImage(this.mapArrayTile[j][i].getTower().getFirstStandingImage(), 32 * i, (32 * j), 32, 32,null);  // Draw the tower on the tile
                }
            }
        }
    }

    /** Drawing the enemies method **/
    private void drawEnemies(Graphics g) {
        for (Fightable e : this.lvlEnemies) {
            if (e.isWalking() && e.isAlive() ) {
                g.drawImage(e.getWalkingImages()[this.walkingAnimationIndex], (int) e.getxPosition() - e.getRectangleWidth(), e.getyPosition(),null);
            } else if (e.isAttacking() && e.isAlive()) {
                g.drawImage(e.getAttackingImages()[this.attackingAnimationIndex], (int) e.getxPosition() - e.getRectangleWidth(), e.getyPosition(), null);
            }
            //} else {
              //  g.drawImage(e.getDeathImages()[this.deathAnimationIndex], (int) e.getxPosition() - e.getRectangleWidth(), e.getyPosition(),null);
            //}
        }
    }

    /** Random method to select the number of roads and other tiles and also for the enemies **/
    private int randomGenerator(int lowerBound, int upperBound) {

        Random random = new Random();                       // Creating the random object

        return random.nextInt(lowerBound, upperBound);      // Returning the generated value
    }

    /** Return the road array line from the 2d array **/
    private Tile[] getRoadArrayLine(int index) {
        return this.mapArrayTile[index];
    }

    /** Set the selected tower as the one chosen **/
    public void setSelectedTower(Tower selectedTower) {
        this.towerToAdd = selectedTower;
    }

    /** Tile change method **/
    private void addTowerToTile(int x, int y) {

        if (this.towerToAdd != null) {                      // If the selected tower to add the tile has been chosen

            int tileX = x / 32;                                 // X position of the tile to change
            int tileY = y / 32;                                 // Y position of the tile to change

            Tile selectedTile = this.mapArrayTile[tileY][tileX];        // Selected tile to change
            if (selectedTile.getTileType() == 2 && !selectedTile.isHasTower()) {        // Ensure tile is a road and does not already have a tower
                selectedTile.setHasTower(true);                                         // Set the tile as having a tower
                selectedTile.addTower(this.towerToAdd);                                 // Set the tower on the tile
                this.lvlTowers.add(this.towerToAdd);                                    // Adding the tower to the arrayList of towers of the game
                this.towerToDraw = false;                                               // Reset the tower drawing variable to false
                this.towerToAdd = null;                                                 // Reset the selected tower variable to false
            }
        }
    }

    /** Draw the selected tile's tower method **/
    private void drawSelectedTileTower(Graphics g) {
        if (this.towerToAdd != null && this.towerToDraw) {            // If the tower to add is chosen and the change tile option is active
            g.drawImage(this.towerToAdd.getFirstStandingImage(), this.xMouseCoord, this.yMouseCoord, 32, 32, null);        // Draw the tile
            //this.towerToAdd.setWidthHitboxBounds(this.xMouseCoord);
        }
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {

        if (y >= 640) {                             // If the mouse click is located inside the bottom game action bar bounds
            this.bottomBar.mouseClicked(x, y);      // Use the bottom bar's mouse clicked method passing it the coordinates of where its clicked
        }
        else {
            this.addTowerToTile(x, y);
        }
    }

    /** Mouse moved method **/
    public void mouseMoved(int x, int y) {

        if (y >= 640) {                             // If the mouse moved position is located inside the bottom game action bar bounds
            this.bottomBar.mouseMoved(x, y);        // Use the bottom bar's mouse moved method passing it the coordinates of where its clicked
            this.towerToDraw = false;
        }
        else {
            this.towerToDraw = true;                     // Now there's need to focus on a tile to eventually paint since the mouse is not on the toolbar
            this.xMouseCoord = (x / 32) * 32;            // Giving the coordinate of x divided and then multiplied to assure the closest value to 32 multipliers
            this.yMouseCoord = (y / 32) * 32;            // Giving the coordinate of y divided and then multiplied to assure the closest value to 32 multipliers
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

    /** Game loop controller getter **/
    public GameLoopController getGameLoopController() {
        return this.gameLoopController;
    }

    public ModelController getModelController() {
       // return this.modelController;
        return null;
    }

    public void resetTowers() {

        for (int i = 0; i < 20; i ++) {
            for (int j = 0; j < 23; j++) {
                this.mapArrayTile[i][j].resetTower();
            }
        }
        this.lvlTowers.clear();
    }
}