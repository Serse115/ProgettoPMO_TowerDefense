package view.guiComponents;

import controller.GameLoopController;
import controller.ModelController;
import model.tower.Tower;
import view.gameScenes.GameScenes;
import view.gameScenes.Playable;
import view.imageUtilities.SpriteUtilities;
import java.awt.*;
import static view.gameScenes.GameScenes.MENU;

/**** Class for the action bar in the Play game scene ****/
public class GameActionBar extends Bar implements Playable {

    /**** Fields ****/
    private GameLoopController gameLoopController;  // Object reference to the Game loop controller
    private Playable randomGame;            // Object reference to the "Random Game" game scene
    private Playable endlessWaves;          // Object reference to the "Endless waves" game scene
    private Clickable bMenu;                // Go back to the menu button
    private Clickable bPause;               // Pause the game button
    private Clickable bTurret;              // Defense turret button
    private Clickable bCannon;              // Defense cannon button
    private Clickable bMachineGun;          // Defense machine-gun button




    /**** Constructors ****/
    /** Main constructor for the Random maps and Endless waves game modes **/
    public GameActionBar(int x, int y, int width, int height, Playable randomGame, Playable endlessWaves, GameLoopController gameLoopController) {
        super(x, y, width, height);             // Using the superclass constructor
        this.randomGame = randomGame;
        this.endlessWaves = endlessWaves;
        this.gameLoopController = gameLoopController;
        this.bMenu = new MyButton("Menu", 10, 660, 100, 30);
        this.bPause = new MyButton("Pause", 10, 710, 100, 30);
        this.bTurret = new MyButton("Turret", 155, 680, 56, 56, SpriteUtilities.getSpriteAtlas("tower_turret/turret_icon.png"));
        this.bCannon = new MyButton("Cannon", 220, 680, 56, 56, SpriteUtilities.getSpriteAtlas("tower_cannon/cannon_icon.png"));
        this.bMachineGun = new MyButton("MachineGun", 285, 680, 56, 56, SpriteUtilities.getSpriteAtlas("tower_machinegun/machinegun_icon.png"));
    }

    /** Secondary constructor for the temporary Endless waves game mode **/
    public GameActionBar(int x, int y, int width, int height, Playable endlessWaves) {
        super(x, y, width, height);             // Using the superclass constructor
        this.randomGame = null;
        this.endlessWaves = endlessWaves;
        this.bMenu = new MyButton("Menu", 10, 660, 100, 30);
        this.bPause = new MyButton("Pause", 10, 710, 100, 30);
        this.bTurret = new MyButton("Turret", 155, 680, 56, 56, SpriteUtilities.getSpriteAtlas("tower_turret/turret_icon.png"));
        this.bCannon = new MyButton("Cannon", 220, 680, 56, 56, SpriteUtilities.getSpriteAtlas("tower_cannon/cannon_icon.png"));
        this.bMachineGun = new MyButton("MachineGun", 285, 680, 56, 56, SpriteUtilities.getSpriteAtlas("tower_machinegun/machinegun_icon.png"));
    }




    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {

        // Body of the action bar
        g.setColor(new Color(220, 123, 15));
        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());

        // Background of the action bar
        g.setColor(Color.BLACK);
        g.drawRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());

        // Buttons
        this.bMenu.draw(g);
        this.bPause.draw(g);
        this.bTurret.draw(g, this.bTurret.getbImage());
        this.bCannon.draw(g, this.bCannon.getbImage());
        this.bMachineGun.draw(g, this.bMachineGun.getbImage());
    }

    /** Update method **/
    public void update() {
        // Not required
    }

    /** Initialize map **/
    public void initializeMap() {
        // Not required, handled in the randomGame and EndlessWaves class
    }

    /** Initialize enemies **/
    public void initializeEnemies() {
        // Not required, handled in the randomGame class
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {
        if (this.bMenu.getButtonBounds().contains(x, y)) {       // If it's clicked within the menu button's boundaries
            switch (GameScenes.gameScenes) {                     // Depending on the current gameScene
                case PLAY:                                       // If the gameScene is the play one
                    GameScenes.setGameScene(MENU);                                      // Set the game scene back to the menu
                    this.gameLoopController.stopGameLoop();                             // Stop the game loop for the random game
                    this.randomGame.initializeMap();                                    // Reset the game map to a new random one when back into the menu
                    this.randomGame.initializeEnemies();                                // Reset the game set of enemies for the new random game
                    this.gameLoopController.restartGameLoop();                          // Restart the game loop
                    break;
                case ENDLESS_WAVES:                              // If the gameScene is the endless waves one
                    GameScenes.setGameScene(MENU);                                      // Set the game scene back to the menu
                    this.gameLoopController.stopGameLoop();                             // Stop the game loop for the random game
                    this.endlessWaves.initializeMap();                                  // Reset the endless waves game map to the standard layout when back into the menu
                    this.gameLoopController.restartGameLoop();                          // Restart the game loop
                    break;
            }
        }
        else if (this.bPause.getButtonBounds().contains(x, y)) {  // If it's clicked within the pause game button's boundaries
            // do nothing for now
        }
        else if (this.bTurret.getButtonBounds().contains(x, y)) {   // If it's clicked within the turret tower button's boundaries
            this.randomGame.setSelectedTower((Tower) this.randomGame.getModelController().getTurret());
        }
        else if (this.bCannon.getButtonBounds().contains(x, y)) {   // If it's clicked within the cannon tower button's boundaries
            this.randomGame.setSelectedTower((Tower) this.randomGame.getModelController().getCannon());
        }
        else if (this.bMachineGun.getButtonBounds().contains(x, y)) {   // If it's clicked within the cannon tower button's boundaries
            this.randomGame.setSelectedTower((Tower) this.randomGame.getModelController().getMachineGun());
        }
    }

    /** Mouse moved method **/
    public void mouseMoved(int x, int y) {
        this.bMenu.setMouseOver(false);         // Set the mouse over for the menu button as false
        this.bPause.setMouseOver(false);        // Set the mouse over for the pause button as false
        this.bTurret.setMouseOver(false);       // Set the mouse over for the turret button as false
        this.bCannon.setMouseOver(false);       // Set the mouse over for the cannon button as false
        this.bMachineGun.setMouseOver(false);   // Set the mouse over for the machine-gun button as false

        if (this.bMenu.getButtonBounds().contains(x, y)) {       // If it's moved over the menu button
            this.bMenu.setMouseOver(true);                       // Add the effect
        }
        else if (this.bPause.getButtonBounds().contains(x, y)) {       // If it's moved over the pause button
            this.bPause.setMouseOver(true);                            // Add the effect
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
    }

    /** Mouse pressed method **/
    public void mousePressed(int x, int y) {
        this.bMenu.setMousePressed(false);          // Set the mouse pressed over for the menu button as false
        this.bPause.setMousePressed(false);         // Set the mouse pressed over for the pause button as false
        this.bTurret.setMousePressed(false);        // Set the mouse pressed over for the turret button as false
        this.bCannon.setMousePressed(false);        // Set the mouse pressed over for the cannon button as false
        this.bMachineGun.setMousePressed(false);    // Set the mouse pressed over for the machine-gun button as false

        if (this.bMenu.getButtonBounds().contains(x, y)) {      // If it's pressed on the menu button
            this.bMenu.setMousePressed(true);                   // Add the effect
        }
        else if (this.bPause.getButtonBounds().contains(x, y)) {    // If it's pressed on the pause button
            this.bPause.setMousePressed(true);                      // Add the effect
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
    }

    /** Mouse released method **/
    public void mouseReleased(int x, int y) {
        this.bMenu.resetBooleans();                 // Resetting the booleans for the menu button
        this.bPause.resetBooleans();                // Resetting the booleans for the pause button
        this.bTurret.resetBooleans();               // Resetting the booleans for the turret button
        this.bCannon.resetBooleans();               // Resetting the booleans for the cannon button
        this.bMachineGun.resetBooleans();           // Resetting the booleans for the machine-gun button
    }

    /** Mouse dragged method **/
    public void mouseDragged(int x, int y) {
        // Do nothing for now
    }

    /** Get game loop controller (not needed) **/
    public GameLoopController getGameLoopController() {
        return this.gameLoopController;
    }

    @Override
    public void setSelectedTower(Tower tower) {
        //
    }

    @Override
    public ModelController getModelController() {
        return null;
    }

    /** Menu button getter **/
    public Clickable getbMenu() {
        return this.bMenu;
    }

    /** Pause button getter **/
    public Clickable getbPause() {
        return this.bPause;
    }

    /** Turret button getter **/
    public Clickable getbTurret() {
        return this.bTurret;
    }

    /** Cannon button getter **/
    public Clickable getbCannon() {
        return this.bCannon;
    }

    /** Machine-gun button getter **/
    public Clickable getbMachineGun() {
        return this.bMachineGun;
    }
}