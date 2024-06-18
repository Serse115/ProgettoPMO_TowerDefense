package view.guiComponents;

import model.tower.*;
import view.gameScenes.GameScenes;
import view.gameScenes.Playable;
import view.imageUtilities.SpriteUtilities;
import java.awt.*;
import static view.gameScenes.GameScenes.MENU;

/**** Class for the action bar in the Play game scene ****/
public class GameActionBar extends Bar implements Playable {

    /**** Fields ****/
    private Playable randomGame;            // Object reference to the "Random Game" game scene
    private Playable endlessWaves;          // Object reference to the "Endless waves" game scene
    private Clickable bMenu;                // Go back to the menu button
    private Clickable bTurret;              // Defense turret button
    private Clickable bCannon;              // Defense cannon button
    private Clickable bMachineGun;          // Defense machine-gun button
    private Clickable bWall;                // Defense wall button




    /**** Constructors ****/
    /** Main constructor for the Random maps and Endless waves game modes **/
    public GameActionBar(int x, int y, int width, int height, Playable randomGame, Playable endlessWaves) {
        super(x, y, width, height);             // Using the superclass constructor
        this.randomGame = randomGame;
        this.endlessWaves = endlessWaves;
        this.bMenu = new MyButton("Menu", 10, 680, 100, 56);
        this.bTurret = new MyButton("Turret", 155, 680, 56, 56, SpriteUtilities.getSpriteAtlas("tower_turret/turret_icon.png"));
        this.bCannon = new MyButton("Cannon", 220, 680, 56, 56, SpriteUtilities.getSpriteAtlas("tower_cannon/cannon_icon.png"));
        this.bMachineGun = new MyButton("MachineGun", 285, 680, 56, 56, SpriteUtilities.getSpriteAtlas("tower_machinegun/machinegun_icon.png"));
        this.bWall = new MyButton("Wall", 350, 680, 56, 56, SpriteUtilities.getSpriteAtlas("tower_wall/defenseWall_icon.jpg"));
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
    }

    /** Draw the bar to display the current gold **/
    private void drawGoldDisplayBar(Graphics g) {

        // Space for the gold stats
        g.setColor(Color.BLACK);
        g.drawRect(540, 640, 200, 149);
        g.setColor(Color.GRAY);
        g.fillRect(541, 641, 200, 148);

        // Displaying the available gold
        g.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.BOLD, 10);           // Changing the font and size of the string
        g.setFont(font);

        switch (GameScenes.gameScenes) {                                                            // Depending on the current gamescene
            case PLAY:                                                                              // Case random game
                g.drawString("Available gold: " + this.randomGame.getGold(), 580, 675);    // Draw the gold only
                break;
            case ENDLESS_WAVES:                                                                     // Case endless waves
                g.drawString("Available gold: " + this.endlessWaves.getGold(), 580, 675);  // Draw gold
                g.drawString("Wave : " + this.endlessWaves.getWave(), 580, 725);           // Draw current wave
                break;
        }
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {
        if (this.bMenu.getButtonBounds().contains(x, y)) {       // If it's clicked within the menu button's boundaries
            switch (GameScenes.gameScenes) {                     // Depending on the current gameScene
                case PLAY:                                       // If the gameScene is the play one
                    GameScenes.setGameScene(MENU);                                      // Set the game scene back to the menu
                    this.randomGame.initializeMap();                                    // Reset the game map to a new random one when back into the menu
                    this.randomGame.initializeEnemies();                                // Reset the game set of enemies for the new random game
                    this.randomGame.resetTowers();                                      // Reset the towers in the game
                    break;
                case ENDLESS_WAVES:                              // If the gameScene is the endless waves one
                    GameScenes.setGameScene(MENU);                                      // Set the game scene back to the menu
                    this.endlessWaves.initializeMap();                                  // Reset the endless waves game map to the standard layout when back into the menu
                    this.endlessWaves.initializeEnemies();                                // Reset the game set of enemies for the new random game
                    this.endlessWaves.resetTowers();                                      // Reset the towers in the game
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
            }
        }
        else if (this.bWall.getButtonBounds().contains(x, y)) {     // If it's clicked within the cannon tower button's boundaries
            switch (GameScenes.gameScenes) {                            // Depending on what game mode are we playing and what game scene are we on
                case PLAY:
                    this.randomGame.setSelectedTower(new Wall());           // Set the wall as the selected tower
                    break;
                case ENDLESS_WAVES:
                    this.endlessWaves.setSelectedTower(new Wall());           // Set the wall as the selected tower
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
        this.bWall.setMouseOver(false);         // Set the mouse over for the machine-gun button as false

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
    }

    /** Mouse pressed method **/
    public void mousePressed(int x, int y) {
        this.bMenu.setMousePressed(false);          // Set the mouse pressed over for the menu button as false
        this.bTurret.setMousePressed(false);        // Set the mouse pressed over for the turret button as false
        this.bCannon.setMousePressed(false);        // Set the mouse pressed over for the cannon button as false
        this.bMachineGun.setMousePressed(false);    // Set the mouse pressed over for the machine-gun button as false
        this.bWall.setMousePressed(false);          // Set the mouse pressed over for the wall button as false

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
    }

    /** Mouse released method **/
    public void mouseReleased(int x, int y) {
        this.bMenu.resetBooleans();                 // Resetting the booleans for the menu button
        this.bTurret.resetBooleans();               // Resetting the booleans for the turret button
        this.bCannon.resetBooleans();               // Resetting the booleans for the cannon button
        this.bMachineGun.resetBooleans();           // Resetting the booleans for the machine-gun button
        this.bWall.resetBooleans();                 // Resetting the booleans for the wall button
    }

    /** Mouse dragged method **/
    public void mouseDragged(int x, int y) {
        // Not required
    }

    /** Not required methods (got from the interface) **/
    /** Update method (not required) **/
    public void update() {
        // Not required
    }

    /** Initialize map (not required) **/
    public void initializeMap() {
        // Not required
    }

    /** Initialize enemies (not required) **/
    public void initializeEnemies() {
        // Not required
    }

    /** Selected tower setter (not required) **/
    public void setSelectedTower(Tower tower) {
        // Not required
    }

    /** Reset tower method (not required) **/
    public void resetTowers() {
        // Not required
    }

    /** Gold getter (not required) **/
    public int getGold() {
        return 0;
    }

    /** Wave getter (not required) **/
    public int getWave() {
        return 0;
    }

    /** BottomBar setter (not required) **/
    public void setBottomBar(Playable bottomBar) {
        // Not required
    }
}