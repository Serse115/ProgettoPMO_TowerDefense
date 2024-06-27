package view.gameScenes;

import controller.GUIController;
import model.enemy.Fightable;
import model.enemy.Reaper;
import model.enemy.Skeleton;
import model.enemy.Zombie;
import model.tower.Placeable;
import model.tower.Tower;
import view.guiComponents.GameActionBar;
import view.guiComponents.Tile;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**** Parent class for the game scenes ****/
public class GameSceneBase {

    /**** Fields ****/
    private GameActionBar bottomBar;                // Action bar at the bottom of the screen
    private final GUIController guiController;      // GUI controller object for the random map generating and the tiles
    private Tile[][] mapArrayTile;                  // Array of tiles for the map
    private int numberOfRoads;                      // Number of roads on the map
    private int[] positionsOnTheArray;              // Row position of each road in the array of the map
    private ArrayList<Fightable> lvlEnemies;        // Array of enemies that will be present in the level
    private ArrayList <Placeable> lvlTowers;        // ArrayLiat of the towers in the level
    private int nOfEnemies;                         // Number of enemies in the level
    private int walkingAnimationIndex;              // Animation index int for the walking animation frames
    private int attackingAnimationIndex;            // Animation index int for the attacking animation frames
    private int standingAnimationIndex;             // Animation index int for the standing animation frames
    private int shootingAnimationIndex;             // Animation index int for the standing animation frames
    private final int animationSpeed;               // Animation speed int for the animation frames in milliseconds
    private long lastTime;                          // Loop time variable
    private long timer;                             // Other loop time variable
    private int gold;                               // Gold resource for placing towers
    private Placeable towerToAdd;                   // Tower variable reference for the tower chosen to add to the specific tile
    private boolean towerToDraw;                    // Variable to decide if the tile will have a tower added
    private int xMouseCoord;                        // Coordinate x for the current mouse location
    private int yMouseCoord;                        // Coordinate y for the current mouse location
    private final Random random;                    // Random class object




    /**** Constructors ****/
    /** Main constructor **/
    public GameSceneBase() {
        this.bottomBar = null;
        this.guiController = new GUIController();
        this.mapArrayTile = new Tile[20][23];
        this.random = new Random();
        this.nOfEnemies = 1;
        this.initializeMap();
        this.initializeEnemies();
        this.walkingAnimationIndex = 0;
        this.attackingAnimationIndex = 0;
        this.standingAnimationIndex = 0;
        this.shootingAnimationIndex = 0;
        this.animationSpeed = 125;
        this.lastTime = System.currentTimeMillis();
        this.timer = 0;
        this.towerToAdd = null;
        this.towerToDraw = false;
        this.xMouseCoord = 0;
        this.yMouseCoord = 0;
        this.lvlTowers = new ArrayList<>();
    }




    /**** Methods ****/
    // General implementation here that works for every subclass too
    public void render(Graphics g) {
        this.drawLevel(g);                  // Draw the level
        this.drawEnemies(g);                // Draw the enemies
        this.drawTowers(g);                 // Draw the towers
        if (this.bottomBar != null) {       // If the bottomBar is not null
            this.bottomBar.render(g);       // Draw it
        }
        this.drawSelectedTileTower(g);      // Draw the preview of the chosen tower (if selected)
    }

    /** Update method **/
    // Implemented here but with some specialization in subclasses
    public void update() {

        try {
            long currentTime = System.currentTimeMillis();                          // Current time variable with the System feature in milliseconds
            this.timer += currentTime - this.lastTime;                              // Timer update
            this.lastTime = currentTime;                                            // Last time update

            if (this.timer > this.animationSpeed) {                                 // If the timer is higher than the animation speed
                this.walkingAnimationIndex++;                                       // Increase the walking animation index variable
                this.attackingAnimationIndex++;                                     // Increase the attacking animation index variable
                this.standingAnimationIndex++;                                      // Increase the standing animation index variable
                this.shootingAnimationIndex++;                                      // Increase the shooting animation index variable
                this.timer = 0;                                                     // And reset the time variable

                for (Fightable enemy : this.lvlEnemies) {                                    // For every enemy in the array of enemies
                    if (this.walkingAnimationIndex >= enemy.getWalkingImages().length) {     // If the animation index is over the length of the walking images array
                        this.walkingAnimationIndex = 0;                                      // Reset the animation index
                    }
                    if (this.attackingAnimationIndex >= enemy.getAttackingImages().length) {        // If the animation index is over the length of the attacking images array
                        this.attackingAnimationIndex = 0;                                           // Reset the animation index
                    }
                }

                for (Placeable tower : this.lvlTowers) {                                            // For every tower in the array of towers
                    if (this.standingAnimationIndex >= tower.getStandingImages().length) {          // If the animation index is over the length of the standing images array
                        this.standingAnimationIndex = 0;                                            // Reset the animation index
                    }
                    if (this.shootingAnimationIndex >= tower.getShootingImages().length) {          // If the animation index is over the length of the shooting images array
                        this.shootingAnimationIndex = 0;                                            // Reset the animation index
                    }
                }
            }


            Iterator<Fightable> iterator = this.lvlEnemies.iterator();              // Iterator for the list of enemies
            while (iterator.hasNext()) {                                            // While there are still more enemies to check
                Fightable enemy = iterator.next();                                  // Assign the next enemy to the variable used to check the items
                if (enemy.isAlive()) {                                              // If the enemy item is still alive
                    enemy.enemyLogic();                                             // Start the enemy logic
                } else {                                                            // Or else
                    iterator.remove();                                              // Remove the enemy
                    this.gold += enemy.getGold();                                   // Increment the gold resources by the gold reward of the enemy
                }
            }

            for (int i = 0; i < 20; i++) {                                                                      // For every row and column of the array of tiles of the lvl
                for (int j = 0; j < 23; j++) {
                    if (this.mapArrayTile[i][j].isHasTower() && this.mapArrayTile[i][j].getTower() != null) {   // If the tile has a tower and the tower is not null
                        this.mapArrayTile[i][j].getTower().towerLogic(this.lvlEnemies);                         // Start the tower logic passing it the list of enemies
                    }
                }
            }

            // Specialization depending on the kind of GameScene implemented in lowerclasses
            //
            //
            //

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /** Initialize the map tile method **/
    // Implemented in different cases in subclasses
    public void initializeMap() {
        //
    }

    /** Initialize the number of enemies for the map **/
    // General implementation here that works for every subclass too
    public void initializeEnemies() {

        this.lvlEnemies = new ArrayList<>();                                               // Initializing the list of enemies with the number of enemies generated prior

        for (int i = 0; i < this.nOfEnemies; i++) {                                        // For every enemy

            int enemyType = this.randomGenerator(0, 3);       // Generate a value representing the type of enemy that will appear in the game
            int indexRoad = this.randomGenerator(0, this.positionsOnTheArray.length);   // Generate the index for the roads for the enemies to appear on
            int randomXPosition = this.randomGenerator(0, 45);

            if (enemyType == 0) {                                                       // If the generated type number is 0, add a reaper and its sprite animations
                this.lvlEnemies.add(new Reaper(this.getRoadArrayLine(this.positionsOnTheArray[indexRoad]), randomXPosition, (this.positionsOnTheArray[indexRoad] * 32) - 10));
            }
            else if (enemyType == 1) {                                                       // If the generated type number is 1, add a skeleton and its sprite animations
                this.lvlEnemies.add(new Skeleton(this.getRoadArrayLine(this.positionsOnTheArray[indexRoad]), randomXPosition, (this.positionsOnTheArray[indexRoad] * 32) - 5));
            }
            else if (enemyType == 2) {                                                       // If the generated type number is 2, add a zombie and its sprite animations
                this.lvlEnemies.add(new Zombie(this.getRoadArrayLine(this.positionsOnTheArray[indexRoad]), randomXPosition, (this.positionsOnTheArray[indexRoad] * 32) - 30));
            }
            else {                                                                            // Else as default add a reaper and its sprite animations
                this.lvlEnemies.add(new Reaper(this.getRoadArrayLine(this.positionsOnTheArray[indexRoad]), randomXPosition, (this.positionsOnTheArray[indexRoad] * 32) - 10));
            }
        }

        // Reset animation fields when initializing new enemies
        this.walkingAnimationIndex = 0;
        this.attackingAnimationIndex = 0;
        this.lastTime = System.currentTimeMillis();
        this.timer = 0;
    }

    /** Drawing the level method **/
    // General implementation here that works for every subclass too
    private void drawLevel(Graphics g) {

        for (int i = 0; i < 20; i++) {                                                                // For every row
            for (int j = 0; j < 23; j++) {                                                            // And column
                g.drawImage(this.mapArrayTile[i][j].getSprite(), 32 * j, (32 * i), null);  // Draw the right tile image
            }
        }
    }

    /** Drawing the enemies method **/
    // General implementation here that works for every subclass too
    private void drawEnemies(Graphics g) {
        for (Fightable e : this.lvlEnemies) {                   // For every enemy in the list of enemies

            if (e.isWalking() && e.isAlive() ) {                // If the enemy is walking and alive, draw it walking
                g.drawImage(e.getWalkingImages()[this.walkingAnimationIndex], (int) e.getxPosition() - e.getRectangleWidth(), e.getyPosition(),null);
            } else if (e.isAttacking() && e.isAlive()) {        // Else draw it attacking
                g.drawImage(e.getAttackingImages()[this.attackingAnimationIndex], (int) e.getxPosition() - e.getRectangleWidth(), e.getyPosition(), null);
            }
        }
    }

    /** Draw the towers method **/
    // General implementation here that works for every subclass too
    private void drawTowers(Graphics g) {

        for (int i = 0; i < 20; i++) {                      // For every row and column of the array of tiles of the lvl
            for (int j = 0; j < 23; j++) {

                if (this.mapArrayTile[i][j].isHasTower()) {                                                             // If a tile has a tower
                    if (this.mapArrayTile[i][j].getTower().isStanding()) {                                              // And the tower is in the standing phase
                        BufferedImage[] standingImages = this.mapArrayTile[i][j].getTower().getStandingImages();        // Get the standing images
                        if (standingImages != null && standingImages.length > 0) {                                      // If the standing images are not null and more than 0
                            int index = Math.min(this.standingAnimationIndex, standingImages.length - 1);               // Get the index for the animations
                            g.drawImage(standingImages[index], 32 * j, 32 * i, 32, 32, null);  // Draw the animation images
                        }
                    }
                    else if (this.mapArrayTile[i][j].getTower().isShooting()) {                                         // Else if it's in the shooting phase
                        BufferedImage[] shootingImages = this.mapArrayTile[i][j].getTower().getShootingImages();        // Get the shooting images
                        if (shootingImages != null && shootingImages.length > 0) {                                      // If the shooting images are not null and more than 0
                            int index = Math.min(this.shootingAnimationIndex, shootingImages.length - 1);               // Get the index for the animations
                            g.drawImage(shootingImages[index], 32 * j, 32 * i, 32, 32, null);  // Draw the animation images
                        }
                    }
                }
            }
        }
    }

    /** Set the selected tower as the one chosen **/
    // General implementation here that works for every subclass too
    public void setSelectedTower(Tower selectedTower) {
        this.towerToAdd = selectedTower;
    }

    /** Tile change method **/
    // General implementation here that works for every subclass too
    private void addTowerToTile(int x, int y) {

        if (this.towerToAdd != null && this.gold >= this.towerToAdd.getCost()) {     // If the selected tower to add the tile has been chosen and there's enough gold

            int tileX = x / 32;                                 // X position of the tile to change
            int tileY = y / 32;                                 // Y position of the tile to change

            Tile selectedTile = this.mapArrayTile[tileY][tileX];        // Selected tile to change
            if (selectedTile.getTileType() == 2 && !selectedTile.isHasTower()) {        // Ensure tile is a road and does not already have a tower
                selectedTile.setHasTower(true);                                         // Set the tile as having a tower
                this.towerToAdd.setyPosition(y);                                        // Set the y coordinate for the tower's reference
                selectedTile.addTower(this.towerToAdd);                                 // Set the tower on the tile
                this.lvlTowers.add(this.towerToAdd);                                    // Adding the tower to the arrayList of towers of the game
                this.mapArrayTile[tileY][tileX].getTower().setyPosition(y);             // Set the tower's y coordinate
                this.gold -= this.towerToAdd.getCost();                                 // Subtract the tower's cost from the resources

                this.towerToDraw = false;                                               // Reset the tower drawing variable to false
                this.towerToAdd = null;                                                 // Reset the selected tower variable to false
            }
        }
    }

    /** Draw the selected tile's tower method **/
    // General implementation here that works for every subclass too
    private void drawSelectedTileTower(Graphics g) {
        if (this.towerToAdd != null && this.towerToDraw) {            // If the tower to add is chosen and the change tile option is active
            g.drawImage(this.towerToAdd.getFirstStandingImage(), this.xMouseCoord, this.yMouseCoord, 32, 32, null);        // Draw the tile
        }
    }

    /** Random method to select the number of roads and other tiles and also for the enemies **/
    // General implementation here that works for every subclass too
    public int randomGenerator(int lowerBound, int upperBound) {

        return this.random.nextInt(lowerBound, upperBound);      // Returning the generated value
    }

    /** Return the road array line from the 2d array **/
    // General implementation here that works for every subclass too
    private Tile[] getRoadArrayLine(int index) {
        return this.mapArrayTile[index];
    }

    /** Mouse clicked method **/
    // General implementation here that works for every subclass too
    public void mouseClicked(int x, int y) {

        if (y >= 640) {                             // If the mouse click is located inside the bottom game action bar bounds
            this.bottomBar.mouseClicked(x, y);      // Use the bottom bar's mouse clicked method passing it the coordinates of where its clicked
        }
        else {                                      // Else
            this.addTowerToTile(x, y);              // Add the chosen tower to the tile through the coordinates
            this.checkTowerToUpgrade(x, y);
        }
    }

    /** Mouse moved method **/
    // General implementation here that works for every subclass too
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
    // General implementation here that works for every subclass too
    public void mousePressed(int x, int y) {

        if (y >= 640) {                             // If the mouse pressed position is located inside the bottom game action bar bounds
            this.bottomBar.mousePressed(x, y);      // Use the bottom bar's mouse pressed method passing it the coordinates of where its clicked
        }
    }

    /** Mouse released method **/
    // General implementation here that works for every subclass too
    public void mouseReleased(int x, int y) {

        this.bottomBar.mouseReleased(x, y);         // Use the mouse released method from the bottom game action bar object
    }

    /** Mouse dragged method **/
    // General implementation here that works for every subclass too
    public void mouseDragged(int x, int y) {

        // Not required
    }

    /** Check if the tile clicked has a tower **/
    private void checkTowerToUpgrade(int x, int y) {

        int tileX = x / 32;
        int tileY = y / 32;

        if (this.mapArrayTile[tileY][tileX].isHasTower()) {
            this.bottomBar.setTowerToDisplay(this.mapArrayTile[tileY][tileX].getTower());
        }
        else {
            this.bottomBar.setTowerToDisplay(null);
        }
    }

    /** Reset towers method **/
    // General implementation here that works for every subclass too
    public void resetTowers() {

        for (int i = 0; i < 20; i ++) {                     // For every tile of the array of tiles of the lvl
            for (int j = 0; j < 23; j++) {
                this.mapArrayTile[i][j].resetTower();       // Reset every tile's tower
            }
        }
        this.lvlTowers.clear();                                     // Clear the towers arrayList

        // Reset animation fields when initializing new towers
        this.standingAnimationIndex = 0;
        this.shootingAnimationIndex = 0;
        this.lastTime = System.currentTimeMillis();
        this.timer = 0;
    }

    /** BottomBar setter **/
    // General implementation here that works for every subclass too
    public void setBottomBar(GameActionBar bottomBar) {
        this.bottomBar = bottomBar;
    }

    /** Gold getter **/
    // General implementation here that works for every subclass too
    public int getGold() {
        return this.gold;
    }

    /** Gold setter method **/
    // General implementation here that works for every subclass too
    public void setGold(int gold) {
        this.gold = gold;
    }

    /** Wave getter **/
    // Specialized in endless waves class
    public int getWave() {
        return 0;
    }

    /** GUI controller getter **/
    // General implementation here that works for every subclass too
    public GUIController getGuiController() {
        return guiController;
    }

    /** Map Array of tiles getter **/
    // General implementation here that works for every subclass too
    public Tile[][] getMapArrayTile() {
        return mapArrayTile;
    }

    /** Number of roads setter **/
    // General implementation here that works for every subclass too
    public void setNumberOfRoads(int numberOfRoads) {
        this.numberOfRoads = numberOfRoads;
    }

    /** Road positions on the array setter **/
    // General implementation here that works for every subclass too
    public void setPositionsOnTheArray(int[] positionsOnTheArray) {
        this.positionsOnTheArray = positionsOnTheArray;
    }

    /** List of enemies in the level getter **/
    // General implementation here that works for every subclass too
    public ArrayList<Fightable> getLvlEnemies() {
        return lvlEnemies;
    }

    /** Number of enemies getter **/
    // General implementation here that works for every subclass too
    public int getnOfEnemies() {
        return this.nOfEnemies;
    }

    /** Number of enemies setter **/
    // General implementation here that works for every subclass too
    public void setnOfEnemies(int nOfEnemies) {
        this.nOfEnemies = nOfEnemies;
    }

    /** Tower to add setter **/
    // General implementation here that works for every subclass too
    public void setTowerToAdd(Placeable towerToAdd) {
        this.towerToAdd = towerToAdd;
    }

    /** Bottom-bar getter **/
    // General implementation here that works for every subclass too
    public GameActionBar getBottomBar() {
        return bottomBar;
    }
}