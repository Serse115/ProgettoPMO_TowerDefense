package view.gameScenes;

import controller.GUIController;
import model.enemy.Fightable;
import model.enemy.Reaper;
import model.enemy.Skeleton;
import model.enemy.Zombie;
import model.tower.Placeable;
import model.tower.Tower;
import view.guiComponents.MainFrame;
import view.guiComponents.Tile;
import view.imageUtilities.LevelUtilities;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/***** Class for the endless waves game scene *****/
public class EndlessWaves extends GameSceneBase implements Playable {

    /**** Fields ****/
    private Playable bottomBar;                    // Game action bar at the bottom of the screen
    private GUIController guiController;                // GUI controller object for the map generating and tiles
    private int[][] mapArrayInt;                        // Array of ints for the map initialization
    private Tile[][] mapArrayTile;                      // Array of tiles for the map
    private int[] positionsOnTheArray;                  // Array positions for the roads
    private ArrayList <Fightable> lvlEnemies;            // ArrayList of enemies in the level
    private ArrayList <Placeable> lvlTowers;        // ArrayLiat of the towers in the level
    private int nOfeEnemiesPerWave;                     // Number of enemies per every wave
    private int walkingAnimationIndex;                  // Animation index int for the walking animation frames
    private int attackingAnimationIndex;                // Animation index int for the attacking animation frames
    private int standingAnimationIndex;                 // Animation index int for the standing animation frames
    private int shootingAnimationIndex;                 // Animation index int for the standing animation frames
    private int animationSpeed;                         // Animation speed int for the animation frames in milliseconds
    private long lastTime;                              // Loop time variable
    private long timer;                                 // Other loop time variable
    private int gold;                                   // Gold resource for placing towers
    private Placeable towerToAdd;                       // Tower variable reference for the tower chosen to add to the specific tile
    private boolean towerToDraw;                        // Variable to decide if the tile will have a tower added
    private int xMouseCoord;                            // Coordinate x for the current mouse location
    private int yMouseCoord;                            // Coordinate y for the current mouse location
    private int waveCounter;                            // Wave counter variable





    /**** Constructors ****/
    /** Main constructor for the real endless waves game scene **/
    public EndlessWaves(MainFrame mainFrame) {
        super(mainFrame);
        this.bottomBar = null;
        this.guiController = new GUIController();
        this.mapArrayInt = new int[20][23];
        this.mapArrayTile = new Tile[20][23];
        this.nOfeEnemiesPerWave = 5;
        this.lvlTowers = new ArrayList<>();
        this.lvlEnemies = new ArrayList<>();                                          // Initializing the list of enemies with the number of enemies generated prior
        this.initializeMap();
        this.initializeEnemies();
        this.walkingAnimationIndex = 0;
        this.attackingAnimationIndex = 0;
        this.standingAnimationIndex = 0;
        this.shootingAnimationIndex = 0;
        this.animationSpeed = 125;
        this.lastTime = System.currentTimeMillis();
        this.timer = 0;
        this.gold = 1500;
        this.towerToAdd = null;
        this.towerToDraw = false;
        this.xMouseCoord = 0;
        this.yMouseCoord = 0;
        this.waveCounter = 1;
    }





    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {
        this.drawLevel(g);
        this.drawEnemies(g);
        this.drawTowers(g);
        if (this.bottomBar != null) {
            this.bottomBar.render(g);
        }
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
                this.standingAnimationIndex++;                                      // Increase the standing animation index variable
                this.shootingAnimationIndex++;

                this.timer = 0;                                                     // And reset the time variable

                for (Fightable enemy : this.lvlEnemies) {                                    // For every enemy in the array of enemies
                    if (this.walkingAnimationIndex >= enemy.getWalkingImages().length) {     // If the animation index is over the length of the walking images array
                        this.walkingAnimationIndex = 0;                                             // Reset the animation index
                    }
                    if (this.attackingAnimationIndex >= enemy.getAttackingImages().length) {        // If the animation index is over the length of the attacking images array
                        this.attackingAnimationIndex = 0;                                           // Reset the animation index
                    }
                }

                for (Placeable tower : this.lvlTowers) {
                    if (this.standingAnimationIndex >= tower.getStandingImages().length) {          // If the animation index is over the length of the standing images array
                        this.standingAnimationIndex = 0;                                            // Reset the animation index
                    }
                    if (this.shootingAnimationIndex >= tower.getShootingImages().length) {          // If the animation index is over the length of the shooting images array
                        this.shootingAnimationIndex = 0;                                            // Reset the animation index
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

            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 23; j++) {
                    if (this.mapArrayTile[i][j].isHasTower() && this.mapArrayTile[i][j].getTower() != null) {
                        this.mapArrayTile[i][j].getTower().towerLogic(this.lvlEnemies);
                    }
                }
            }

            if (this.lvlEnemies.isEmpty()) {
                this.waveCounter++;
                this.gold += 250;
                this.initializeEnemies();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Initialize the map method **/
    public void initializeMap() {

        this.mapArrayInt = LevelUtilities.getLvlData("resources/levels/EndlessWavesMap.txt");     // Initialize the map array tiles layout with the data from the chosen txt file
        this.positionsOnTheArray = new int[]{2, 5, 8, 11, 14, 17};          // Positions on the tiles array where roads are

        try {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 23; j++) {
                    this.mapArrayTile[i][j] = new Tile();
                    this.mapArrayTile[i][j].setTileType(this.mapArrayInt[i][j]);
                    this.mapArrayTile[i][j].setSprite(this.guiController.getTileTypeReturnImage(this.mapArrayTile[i][j].getTileType()));
                }
            }
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /** Initialize enemies method **/
    public void initializeEnemies() {

        this.nOfeEnemiesPerWave += (this.waveCounter + this.randomGenerator(5, 15));
        this.lvlEnemies = new ArrayList<>();

        for (int i = 0; i < this.nOfeEnemiesPerWave; i++) {                                       // For every enemy
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
            else {
                this.lvlEnemies.add(new Reaper(i, this.getRoadArrayLine(this.positionsOnTheArray[indexRoad]),(this.positionsOnTheArray[indexRoad] * 32) - 10));   // And its sprite animations
            }
        }

        // Reset animation fields when initializing new enemies
        this.walkingAnimationIndex = 0;
        this.attackingAnimationIndex = 0;
        this.lastTime = System.currentTimeMillis();
        this.timer = 0;
    }

    /** Draw level method **/
    private void drawLevel(Graphics g) {

        for (int i = 0; i < 20; i++) {                                                                             // For every row
            for (int j = 0; j < 23; j++) {                                                                         // And column
                g.drawImage(this.mapArrayTile[i][j].getSprite(), 32 * j, (32 * i), null);               // Draw the right tile image
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
        }
    }

    /** Draw the towers method **/
    private void drawTowers(Graphics g) {

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 23; j++) {

                if (this.mapArrayTile[i][j].isHasTower()) {
                    if (this.mapArrayTile[i][j].getTower().isStanding()) {
                        BufferedImage[] standingImages = this.mapArrayTile[i][j].getTower().getStandingImages();
                        if (standingImages != null && standingImages.length > 0) {
                            int index = Math.min(this.standingAnimationIndex, standingImages.length - 1);
                            g.drawImage(standingImages[index], 32 * j, 32 * i, 32, 32, null);
                        }
                    }
                    else if (this.mapArrayTile[i][j].getTower().isShooting()) {
                        BufferedImage[] shootingImages = this.mapArrayTile[i][j].getTower().getShootingImages();
                        if (shootingImages != null && shootingImages.length > 0) {
                            int index = Math.min(this.shootingAnimationIndex, shootingImages.length - 1);
                            g.drawImage(shootingImages[index], 32 * j, 32 * i, 32, 32, null);
                        }
                    }
                }
            }
        }
    }

    /** Set the selected tower as the one chosen **/
    public void setSelectedTower(Tower selectedTower) {
        this.towerToAdd = selectedTower;
    }

    /** Tile change method **/
    private void addTowerToTile(int x, int y) {

        if (this.towerToAdd != null && this.gold >= this.towerToAdd.getCost()) {     // If the selected tower to add the tile has been chosen and there's enough gold

            int tileX = x / 32;                                 // X position of the tile to change
            int tileY = y / 32;                                 // Y position of the tile to change

            Tile selectedTile = this.mapArrayTile[tileY][tileX];        // Selected tile to change
            if (selectedTile.getTileType() == 2 && !selectedTile.isHasTower()) {        // Ensure tile is a road and does not already have a tower
                selectedTile.setHasTower(true);                                         // Set the tile as having a tower
                this.towerToAdd.setyPosition(y);                                        // Set the y coordinate for the tower's reference
                this.towerToAdd.setxPosition(x);                                        // Set the x coordinate for the tower's reference
                selectedTile.addTower(this.towerToAdd);                                 // Set the tower on the tile
                this.lvlTowers.add(this.towerToAdd);                                    // Adding the tower to the arrayList of towers of the game
                this.mapArrayTile[tileY][tileX].getTower().setyPosition(y);
                this.gold -= this.towerToAdd.getCost();

                this.towerToDraw = false;                                               // Reset the tower drawing variable to false
                this.towerToAdd = null;                                                 // Reset the selected tower variable to false
            }
        }
    }

    /** Draw the selected tile's tower method **/
    private void drawSelectedTileTower(Graphics g) {
        if (this.towerToAdd != null && this.towerToDraw) {            // If the tower to add is chosen and the change tile option is active
            g.drawImage(this.towerToAdd.getFirstStandingImage(), this.xMouseCoord, this.yMouseCoord, 32, 32, null);        // Draw the tile
        }
    }

    /** Return the road array line from the 2d array **/
    private Tile[] getRoadArrayLine(int index) {
        return this.mapArrayTile[index];
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
        else {
            this.addTowerToTile(x, y);
        }
    }

    /** Mouse moved method **/
    public void mouseMoved(int x, int y) {

        if (y >= 640) {                             // If the mouse moved position is located inside the bottom game action bar bounds
            this.bottomBar.mouseMoved(x, y);        // Use the bottom bar's mouse moved method passing it the coordinates of where its clicked
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

    @Override
    public void mouseReleased(int x, int y) {

        this.bottomBar.mouseReleased(x, y);         // Use the mouse released method from the bottom game action bar object
    }

    @Override
    public void mouseDragged(int x, int y) {

        // Do nothing for now
    }

    public void resetTowers() {

        for (int i = 0; i < 20; i ++) {
            for (int j = 0; j < 23; j++) {
                this.mapArrayTile[i][j].resetTower();
            }
        }
        this.lvlTowers.clear();

        // Reset animation fields when initializing new towers
        this.standingAnimationIndex = 0;
        this.shootingAnimationIndex = 0;
        this.lastTime = System.currentTimeMillis();
        this.timer = 0;
        this.waveCounter = 1;
        this.resetGold();
    }

    @Override
    public int getGold() {
        return this.gold;
    }

    private void resetGold() {
        this.gold = 1500;
    }

    @Override
    public int getWave() {
        return this.waveCounter;
    }

    public void setBottomBar(Playable bottomBar) {
        this.bottomBar = bottomBar;
    }
}