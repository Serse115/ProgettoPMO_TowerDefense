package view.gameScenes;

import view.guiComponents.Clickable;
import view.guiComponents.MainFrame;
import view.guiComponents.MyButton;
import java.awt.*;
import static view.gameScenes.GameScenes.*;

/**** Class for the menu game scene ****/
public class Menu extends GameSceneBase implements Playable {

    /**** Fields ****/
    private Clickable bPlay;         // Play button
    private Clickable bEditMap;      // Edit the map button
    private Clickable bSavedGame;    // Saved games button
    private Clickable bEndlessWaves; // Endless waves mode button
    private Clickable bQuit;         // Quit the game button



    /**** Constructors ****/
    /** Main constructor **/
    public Menu(MainFrame mainFrame) {
        super(mainFrame);

        this.bPlay = new MyButton("Random Map", 300, 150, 150, 50);
        this.bEditMap = new MyButton("Edit Map", 300, 250, 150, 50);
        this.bSavedGame = new MyButton("Saved Maps", 300, 350, 150, 50);
        this.bEndlessWaves = new MyButton("Endless Waves", 300, 450, 150, 50);
        this.bQuit = new MyButton("Quit", 300, 550, 150, 50);
    }




    /**** Methods ****/
    /** Render the MENU scene with the buttons override method **/
    public void render(Graphics g) {
        this.bPlay.draw(g);             // Draw the play button
        this.bEditMap.draw(g);          // Draw the edit map button
        this.bSavedGame.draw(g);        // Draw the saved games button
        this.bEndlessWaves.draw(g);     // Draw the endless waves button
        this.bQuit.draw(g);             // Draw the quit button
    }

    /** Initialize map method **/
    public void initializeMap() {
        // Not required, handled in the randomGame class and the endlessWaves class
    }

    /** Initialize enemies method **/
    public void initializeEnemies() {
        // Not required, handled in the randomGame class and the endlessWaves class
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {
        if (this.bPlay.getButtonBounds().contains(x, y)) {      // If it's clicked within the play button's boundaries
            GameScenes.setGameScene(PLAY);                      // Set the game scene as the playing one
        }
        else if (this.bEditMap.getButtonBounds().contains(x, y)) {  // If it's clicked within the edit map button
            GameScenes.setGameScene(EDIT_MAP);                      // Set the game scene as the map edit one
        }
        else if (this.bSavedGame.getButtonBounds().contains(x, y)) {  // If it's clicked within the saved games button
            GameScenes.setGameScene(SAVED_GAME);                      // Set the game scene as the saved games one
        }
        else if (this.bEndlessWaves.getButtonBounds().contains(x, y)) {  // If it's clicked within the endless waves button
            GameScenes.setGameScene(ENDLESS_WAVES);                      // Set the game scene as the endless waves one
        }
        else if (this.bQuit.getButtonBounds().contains(x, y)) {     // If it's clicked within the quit button
            System.exit(0);                                   // Close the application
        }
    }

    /** Mouse moved method **/
    public void mouseMoved(int x, int y) {
        this.bPlay.setMouseOver(false);         // Set the mouse over for the play button as false
        this.bEditMap.setMouseOver(false);      // Set the mouse over for the edit map button as false
        this.bSavedGame.setMouseOver(false);    // Set the mouse over for the saved games button as false
        this.bEndlessWaves.setMouseOver(false); // Set the mouse over for the endless waves button as false
        this.bQuit.setMouseOver(false);         // Set the mouse over for the quit button as false

        if (this.bPlay.getButtonBounds().contains(x, y)) {  // If it's moved over within the play button
            this.bPlay.setMouseOver(true);                  // Set the mouse over as true to trigger the visive effect
        }
        else if (this.bEditMap.getButtonBounds().contains(x, y)) {  // If it's moved over within the edit map button
            this.bEditMap.setMouseOver(true);                       // Set the mouse over as true to trigger the visive effect
        }
        else if (this.bSavedGame.getButtonBounds().contains(x, y)) {  // If it's moved over within the saved games button
            this.bSavedGame.setMouseOver(true);                       // Set the mouse over as true to trigger the visive effect
        }
        else if (this.bEndlessWaves.getButtonBounds().contains(x, y)) {  // If it's moved over within the endless waves button
            this.bEndlessWaves.setMouseOver(true);                       // Set the mouse over as true to trigger the visive effect
        }
        else if (this.bQuit.getButtonBounds().contains(x, y)) {       // If it's moved over within the quit button
            this.bQuit.setMouseOver(true);                            // Set the mouse over as true to trigger the visive effect
        }
    }

    /** Mouse pressed method **/
    public void mousePressed(int x, int y) {
        if (this.bPlay.getButtonBounds().contains(x, y)) {     // If it's pressed within the play button's bounds
            this.bPlay.setMousePressed(true);                  // Set the mouse over as true to trigger the visive effect
        }
        else if (this.bEditMap.getButtonBounds().contains(x, y)) {     // If it's moved over within the edit map button's bounds
            this.bEditMap.setMousePressed(true);                       // Set the mouse over as true to trigger the visive effect
        }
        else if (this.bSavedGame.getButtonBounds().contains(x, y)) {     // If it's moved over within the saved games button's bounds
            this.bSavedGame.setMousePressed(true);                       // Set the mouse over as true to trigger the visive effect
        }
        else if (this.bEndlessWaves.getButtonBounds().contains(x, y)) {     // If it's moved over within the endless waves button's bounds
            this.bEndlessWaves.setMousePressed(true);                       // Set the mouse over as true to trigger the visive effect
        }
        else if (this.bQuit.getButtonBounds().contains(x, y)) {        // If it's moved over within the quit button's bounds
            this.bQuit.setMousePressed(true);                          // Set the mouse over as true to trigger the visive effect
        }
    }

    /** Mouse released method **/
    public void mouseReleased(int x, int y) {
        this.bPlay.resetBooleans();
        this.bEditMap.resetBooleans();
        this.bSavedGame.resetBooleans();
        this.bEndlessWaves.resetBooleans();
        this.bQuit.resetBooleans();
    }

    /** Mouse dragged method **/
    public void mouseDragged(int x, int y) {
        // Not necessary
    }
}