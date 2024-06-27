package view.guiComponents;

import model.tower.*;
import view.gameScenes.GameScenes;
import view.gameScenes.Playable;
import view.imageUtilities.SpriteUtilities;
import java.awt.*;
import static view.gameScenes.GameScenes.MENU;

/**** Class for the action bar in the Play game scene ****/
public class GameActionBar extends Bar {

    /**** Fields ****/
    private Playable randomGame;            // Object reference to the "Random Game" game scene
    private Playable endlessWaves;          // Object reference to the "Endless waves" game scene
    private Playable savedMapsGame;         // Object reference to the "Saved maps game" scene
    private Clickable bMenu;                // Go back to the menu button
    private Clickable bTurret;              // Defense turret button
    private Clickable bCannon;              // Defense cannon button
    private Clickable bMachineGun;          // Defense machine-gun button
    private Clickable bWall;                // Defense wall button
    private Clickable bUpgrade;             // Upgrade tower button
    private Clickable bRepair;              // Repair tower button
    private Placeable towerToDisplay;       // Tower to display in the bar object




    /**** Constructors ****/
    /** Main constructor for the Random maps and Endless waves game modes **/
    public GameActionBar(int x, int y, int width, int height, Playable randomGame, Playable endlessWaves, Playable savedMapsGame) {
        super(x, y, width, height);                                         // Using the superclass constructor
        this.randomGame = randomGame;
        this.endlessWaves = endlessWaves;
        this.savedMapsGame = savedMapsGame;
        this.bMenu = new MyButton("Menu", 10, 680, 100, 56);
        this.bTurret = new MyButton("Turret", 155, 680, 56, 56, SpriteUtilities.getSpriteAtlas("tower_turret/turret_icon.png"));
        this.bCannon = new MyButton("Cannon", 220, 680, 56, 56, SpriteUtilities.getSpriteAtlas("tower_cannon/cannon_icon.png"));
        this.bMachineGun = new MyButton("MachineGun", 285, 680, 56, 56, SpriteUtilities.getSpriteAtlas("tower_machinegun/machinegun_icon.png"));
        this.bWall = new MyButton("Wall", 350, 680, 56, 56, SpriteUtilities.getSpriteAtlas("tower_wall/defenseWall_icon.jpg"));
        this.bUpgrade = new MyButton("Upgrade", 440, 690, 56, 30);
        this.bRepair = new MyButton("Repair", 440, 730, 56, 30);
        this.towerToDisplay = null;
    }





    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {

        // Body of the action bar
        g.setColor(new Color(220, 123, 15));                                    // Set the color
        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());    // Draw the filled rectangle

        // Background of the action bar
        g.setColor(Color.BLACK);                                                        // Set the color
        g.drawRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());    // Draw the border rectangle

        // Buttons
        this.bMenu.draw(g);                                             // Draw the menu button
        this.bTurret.draw(g, this.bTurret.getbImage());                 // Draw the turret button
        this.bCannon.draw(g, this.bCannon.getbImage());                 // Draw the cannon button
        this.bMachineGun.draw(g, this.bMachineGun.getbImage());         // Draw the machinegun button
        this.bWall.draw(g, this.bWall.getbImage());                     // Draw the wall button
        this.drawGoldDisplayBar(g);                                     // Draw the bottom display bar
        this.drawTowersCost(g);                                         // Draw the towers cost
        this.drawTowerInfoBar(g);
    }

    /** Draw the towers cost method **/
    private void drawTowersCost(Graphics g) {

        this.drawTheBoxesAndStrings(g, this.bTurret.getX(), this.bTurret.getY(), 75);               // Turret cost box
        this.drawTheBoxesAndStrings(g, this.bCannon.getX(), this.bCannon.getY(), 100);              // Cannon cost box
        this.drawTheBoxesAndStrings(g, this.bMachineGun.getX(), this.bMachineGun.getY(), 50);       // MachineGun cost box
        this.drawTheBoxesAndStrings(g, this.bWall.getX(), this.bWall.getY(), 70);                   // Wall cost box
    }

    /** Draw the cost boxes and strings above the turret buttons method **/
    private void drawTheBoxesAndStrings(Graphics g, int x, int y, int goldRequired) {

        // Little rectangles for the towers cost string
        int yHeightOffset = 30;                                            // Offset y to draw the rectangle
        int xOffset = 5;                                                   // Offset x to draw the string
        int yOffset = 20;                                                  // Offset y to draw the string
        Font font = new Font("Arial", Font.BOLD, 10);            // Changing the font and size of the string
        g.setFont(font);
        g.setColor(Color.GRAY);
        g.fillRect(x, y - yHeightOffset, 56, 30);                         // Rectangle showing the tower's cost
        g.setColor(Color.BLACK);                                                         // Resetting the color to draw the string
        g.drawRect(x, y - yHeightOffset, 56, 30);
        g.drawString("Gold: " + goldRequired, x + xOffset, (y - yHeightOffset) + yOffset);        // Displaying the turret's cost
    }

    /** Draw the bar to display the current gold **/
    private void drawGoldDisplayBar(Graphics g) {

        // Space for the gold stats
        g.setColor(Color.BLACK);
        g.drawRect(580, 640, 180, 149);
        g.setColor(Color.GRAY);
        g.fillRect(581, 641, 180, 148);

        // Displaying the available gold
        g.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.BOLD, 10);           // Changing the font and size of the string
        g.setFont(font);

        switch (GameScenes.gameScenes) {                                                                    // Depending on the current gamescene
            case PLAY:                                                                                      // Case random game
                g.drawString("Available gold: " + this.randomGame.getGold(), 610, 675);            // Draw the gold
                g.drawString("Enemies in wave: " + this.randomGame.getnOfEnemies(), 610, 700);     // Draw the enemies left
                break;
            case ENDLESS_WAVES:                                                                              // Case endless waves
                g.drawString("Available gold: " + this.endlessWaves.getGold(), 610, 675);           // Draw gold
                g.drawString("Enemies in wave: " + this.endlessWaves.getnOfEnemies(), 610, 700);    // Draw the enemies left
                g.drawString("Wave: " + this.endlessWaves.getWave(), 610, 725);                     // Draw current wave
                break;
            case SAVED_MAPS_GAME:
                g.drawString("Available gold: " + this.savedMapsGame.getGold(), 610, 675);            // Draw the gold
                g.drawString("Enemies in wave: " + this.savedMapsGame.getnOfEnemies(), 610, 700);     // Draw the enemies left
                break;
        }
    }

    /** Level and health bar for the towers **/
    private void drawTowerInfoBar(Graphics g) {

        if (this.towerToDisplay != null && this.towerToDisplay.getLifePoints() > 0) {
            // Space for the tower stats
            g.setColor(Color.BLACK);
            g.drawRect(420, 640, 140, 149);
            g.setColor(Color.GRAY);
            g.fillRect(421, 641, 139, 148);

            // Displaying the available gold
            g.setColor(Color.BLACK);
            Font font = new Font("Arial", Font.BOLD, 10);           // Changing the font and size of the string
            g.setFont(font);
            g.drawImage(this.towerToDisplay.getFirstStandingImage(), 425, 645, 32, 32, null);
            g.drawString("Life points: " + this.towerToDisplay.getLifePoints(), 470, 655);
            g.drawString("Damage: " + this.towerToDisplay.getDmgPower(), 470, 675);

            this.bUpgrade.draw(g);
            this.bRepair.draw(g);
        }
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {
        if (this.bMenu.getButtonBounds().contains(x, y)) {       // If it's clicked within the menu button's boundaries
            switch (GameScenes.gameScenes) {                     // Depending on the current gameScene
                case PLAY:                                       // If the gameScene is the play one
                    GameScenes.setGameScene(MENU);                                      // Set the game scene back to the menu
                    this.setTowerToDisplay(null);                                       // Set the tower to display to null
                    this.randomGame.initializeMap();                                    // Reset the game map to a new random one when back into the menu
                    this.randomGame.initializeEnemies();                                // Reset the game set of enemies for the new random game
                    this.randomGame.resetTowers();                                      // Reset the towers in the game
                    break;
                case ENDLESS_WAVES:                              // If the gameScene is the endless waves one
                    GameScenes.setGameScene(MENU);                                      // Set the game scene back to the menu
                    this.setTowerToDisplay(null);                                       // Set the tower to display to null
                    this.endlessWaves.initializeMap();                                  // Reset the endless waves game map to the standard layout when back into the menu
                    this.endlessWaves.resetTowers();                                    // Reset the towers in the game
                    this.endlessWaves.setnOfEnemies(1);                                 // Reset the number of enemies
                    this.endlessWaves.setWaveCounter(1);                                // Reset the wave counter to 1
                    this.endlessWaves.setGold(750);                                     // Reset the initial goal
                    this.endlessWaves.initializeEnemies();                              // Reset the game set of enemies for the new random game
                    break;
                case SAVED_MAPS_GAME:                              // If the gameScene is the saved maps game one
                    GameScenes.setGameScene(MENU);                                         // Set the game scene back to the menu
                    this.setTowerToDisplay(null);                                          // Set the tower to display to null
                    this.savedMapsGame.initializeMap();                                    // Reset the game map to a new random one when back into the menu
                    this.savedMapsGame.initializeEnemies();                                // Reset the game set of enemies for the new random game
                    this.savedMapsGame.resetTowers();                                      // Reset the towers in the game
                    break;
            }
        }
        else if (this.bTurret.getButtonBounds().contains(x, y)) {   // If it's clicked within the turret tower button's boundaries
            switch (GameScenes.gameScenes) {                        // Depending on what game mode are we playing and what game scene are we on
                case PLAY:
                    this.randomGame.setSelectedTower(new Turret());         // Set the turret as the selected tower
                    break;
                case ENDLESS_WAVES:
                    this.endlessWaves.setSelectedTower(new Turret());       // Set the turret as the selected tower
                    break;
                case SAVED_MAPS_GAME:
                    this.savedMapsGame.setSelectedTower(new Turret());       // Set the turret as the selected tower
                    break;
            }
        }
        else if (this.bCannon.getButtonBounds().contains(x, y)) {   // If it's clicked within the cannon tower button's boundaries
            switch (GameScenes.gameScenes) {                        // Depending on what game mode are we playing and what game scene are we on
                case PLAY:
                    this.randomGame.setSelectedTower(new Cannon());         // Set the cannon as the selected tower
                    break;
                case ENDLESS_WAVES:
                    this.endlessWaves.setSelectedTower(new Cannon());       // Set the cannon as the selected tower
                    break;
                case SAVED_MAPS_GAME:
                    this.savedMapsGame.setSelectedTower(new Cannon());       // Set the cannon as the selected tower
                    break;
            }
        }
        else if (this.bMachineGun.getButtonBounds().contains(x, y)) {   // If it's clicked within the cannon tower button's boundaries
            switch (GameScenes.gameScenes) {                            // Depending on what game mode are we playing and what game scene are we on
                case PLAY:
                    this.randomGame.setSelectedTower(new MachineGun());         // Set the machinegun as the selected tower
                    break;
                case ENDLESS_WAVES:
                    this.endlessWaves.setSelectedTower(new MachineGun());         // Set the machinegun as the selected tower
                    break;
                case SAVED_MAPS_GAME:
                    this.savedMapsGame.setSelectedTower(new MachineGun());       // Set the machinegun as the selected tower
                    break;
            }
        }
        else if (this.bWall.getButtonBounds().contains(x, y)) {     // If it's clicked within the wall tower button's boundaries
            switch (GameScenes.gameScenes) {                            // Depending on what game mode are we playing and what game scene are we on
                case PLAY:
                    this.randomGame.setSelectedTower(new Wall());           // Set the wall as the selected tower
                    break;
                case ENDLESS_WAVES:
                    this.endlessWaves.setSelectedTower(new Wall());           // Set the wall as the selected tower
                    break;
                case SAVED_MAPS_GAME:
                    this.savedMapsGame.setSelectedTower(new Wall());       // Set the turret as the selected tower
                    break;
            }
        }
        else if (this.bUpgrade.getButtonBounds().contains(x, y)) {      // If it's clicked within the upgrade tower button's boundaries
            switch (GameScenes.gameScenes) {                            // Depending on what game mode are we playing and what game scene are we on
                case PLAY:                                                                                  // Case of the random game
                    if (this.randomGame.getGold() >= (this.towerToDisplay.getCost() * 1.5)) {                               // If there's enough gold to upgrade the tower
                        this.towerToDisplay.upgradeDmgPower();                                                              // Upgrade the tower
                        this.randomGame.setGold((int) (this.randomGame.getGold() - (this.towerToDisplay.getCost() * 1.5))); // Decrease the gold of the tower's upgrade cost
                    }
                    break;
                case ENDLESS_WAVES:                                                                         // Case of the endless game
                    if (this.endlessWaves.getGold() >= (this.towerToDisplay.getCost() * 1.5)) {                                 // If there's enough gold to upgrade the tower
                        this.towerToDisplay.upgradeDmgPower();                                                                  // Upgrade the tower
                        this.endlessWaves.setGold((int) (this.endlessWaves.getGold() - (this.towerToDisplay.getCost() * 1.5))); // Decrease the gold of the tower's upgrade cost
                    }
                    break;
                case SAVED_MAPS_GAME:                                                                         // Case of the saved maps game
                    if (this.savedMapsGame.getGold() >= (this.towerToDisplay.getCost() * 1.5)) {                                  // If there's enough gold to upgrade the tower
                        this.towerToDisplay.upgradeDmgPower();                                                                    // Upgrade the tower
                        this.savedMapsGame.setGold((int) (this.savedMapsGame.getGold() - (this.towerToDisplay.getCost() * 1.5))); // Decrease the gold of the tower's upgrade cost
                    }
                    break;
            }
        }
        else if (this.bRepair.getButtonBounds().contains(x, y)) {       // If it's clicked within the repair tower button's boundaries
            switch (GameScenes.gameScenes) {                            // Depending on what game mode are we playing and what game scene are we on
                case PLAY:                                                                                  // Case of the random game
                    if (this.randomGame.getGold() >= (this.towerToDisplay.getCost() / 2)) {                                // If there's enough gold to repair the tower
                        this.towerToDisplay.repairTower();                                                                 // Repair the tower
                        this.randomGame.setGold(this.randomGame.getGold() - (this.towerToDisplay.getCost() / 2));  // Decrease the gold of the tower's repair cost
                    }
                    break;
                case ENDLESS_WAVES:                                                                         // Case of the endless game
                    if (this.endlessWaves.getGold() >= (this.towerToDisplay.getCost() / 2)) {                             // If there's enough gold to repair the tower
                        this.towerToDisplay.repairTower();                                                                // Upgrade the tower
                        this.endlessWaves.setGold(this.endlessWaves.getGold() - (this.towerToDisplay.getCost() / 2)); // Decrease the gold of the tower's repair cost
                    }
                    break;
                case SAVED_MAPS_GAME:                                                                         // Case of the saved maps game
                    if (this.savedMapsGame.getGold() >= (this.towerToDisplay.getCost() / 2)) {                              // If there's enough gold to repair the tower
                        this.towerToDisplay.repairTower();                                                                  // Upgrade the tower
                        this.savedMapsGame.setGold(this.savedMapsGame.getGold() - (this.towerToDisplay.getCost() / 2)); // Decrease the gold of the tower's repair cost
                    }
                    break;
            }
        }
    }

    /** Mouse moved method **/
    public void mouseMoved(int x, int y) {
        this.bMenu.setMouseOver(false);         // Set the mouse over for the menu button as false
        this.bTurret.setMouseOver(false);       // Set the mouse over for the turret button as false
        this.bCannon.setMouseOver(false);       // Set the mouse over for the cannon button as false
        this.bMachineGun.setMouseOver(false);   // Set the mouse over for the machine-gun button as false
        this.bWall.setMouseOver(false);         // Set the mouse over for the wall button as false
        this.bUpgrade.setMouseOver(false);      // Set the mouse over for the upgrade button as false
        this.bRepair.setMouseOver(false);       // Set the mouse over for the repair button as false

        if (this.bMenu.getButtonBounds().contains(x, y)) {       // If it's moved over the menu button
            this.bMenu.setMouseOver(true);                       // Add the effect
        }
        else if (this.bTurret.getButtonBounds().contains(x, y)) {       // If it's moved over the turret button
            this.bTurret.setMouseOver(true);                            // Add the effect
        }
        else if (this.bCannon.getButtonBounds().contains(x, y)) {       // If it's moved over the cannon button
            this.bCannon.setMouseOver(true);                            // Add the effect
        }
        else if (this.bMachineGun.getButtonBounds().contains(x, y)) {       // If it's moved over the machine-gun button
            this.bMachineGun.setMouseOver(true);                            // Add the effect
        }
        else if (this.bWall.getButtonBounds().contains(x, y)) {   // If it's moved over the wall button
            this.bWall.setMouseOver(true);                        // Add the effect
        }
        else if (this.bUpgrade.getButtonBounds().contains(x, y)) {   // If it's moved over the upgrade button
            this.bUpgrade.setMouseOver(true);                        // Add the effect
        }
        else if (this.bRepair.getButtonBounds().contains(x, y)) {   // If it's moved over the repair button
            this.bRepair.setMouseOver(true);                        // Add the effect
        }
    }

    /** Mouse pressed method **/
    public void mousePressed(int x, int y) {
        this.bMenu.setMousePressed(false);          // Set the mouse pressed over for the menu button as false
        this.bTurret.setMousePressed(false);        // Set the mouse pressed over for the turret button as false
        this.bCannon.setMousePressed(false);        // Set the mouse pressed over for the cannon button as false
        this.bMachineGun.setMousePressed(false);    // Set the mouse pressed over for the machine-gun button as false
        this.bWall.setMousePressed(false);          // Set the mouse pressed over for the wall button as false
        this.bUpgrade.setMousePressed(false);       // Set the mouse pressed over for the upgrade button as false
        this.bRepair.setMousePressed(false);        // Set the mouse pressed over for the repair button as false

        if (this.bMenu.getButtonBounds().contains(x, y)) {      // If it's pressed on the menu button
            this.bMenu.setMousePressed(true);                   // Add the effect
        }
        else if (this.bTurret.getButtonBounds().contains(x, y)) {    // If it's pressed on the turret button
            this.bTurret.setMousePressed(true);                      // Add the effect
        }
        else if (this.bCannon.getButtonBounds().contains(x, y)) {    // If it's pressed on the cannon button
            this.bCannon.setMousePressed(true);                      // Add the effect
        }
        else if (this.bMachineGun.getButtonBounds().contains(x, y)) {    // If it's pressed on the machine-gun button
            this.bMachineGun.setMousePressed(true);                      // Add the effect
        }
        else if (this.bWall.getButtonBounds().contains(x, y)) {      // If it's pressed on the wall button
            this.bWall.setMousePressed(true);                        // Add the effect
        }
        else if (this.bUpgrade.getButtonBounds().contains(x, y)) {      // If it's pressed on the upgrade button
            this.bUpgrade.setMousePressed(true);                        // Add the effect
        }
        else if (this.bRepair.getButtonBounds().contains(x, y)) {      // If it's pressed on the repair button
            this.bRepair.setMousePressed(true);                        // Add the effect
        }
    }

    /** Mouse released method **/
    public void mouseReleased(int x, int y) {
        this.bMenu.resetBooleans();                 // Resetting the booleans for the menu button
        this.bTurret.resetBooleans();               // Resetting the booleans for the turret button
        this.bCannon.resetBooleans();               // Resetting the booleans for the cannon button
        this.bMachineGun.resetBooleans();           // Resetting the booleans for the machine-gun button
        this.bWall.resetBooleans();                 // Resetting the booleans for the wall button
        this.bUpgrade.resetBooleans();              // Resetting the booleans for the upgrade button
        this.bRepair.resetBooleans();               // Resetting the booleans for the repair button
    }

    /** Mouse dragged method **/
    public void mouseDragged(int x, int y) {
        // Not required
    }

    /** Tower to display setter **/
    public void setTowerToDisplay(Placeable tower) {
        this.towerToDisplay = tower;
    }
}