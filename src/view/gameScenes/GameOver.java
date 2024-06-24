package view.gameScenes;

import view.guiComponents.Clickable;
import view.guiComponents.MainFrame;
import view.guiComponents.MyButton;
import java.awt.*;
import static view.gameScenes.GameScenes.*;

/**** Class for the game over scene ****/
public class GameOver {

    /**** Fields ****/
    private MainFrame mainFrame;                // MainFrame reference object
    private Clickable bMenu;                    // Menu button




    /**** Constructors ****/
    /** Main constructor **/
    public GameOver(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.bMenu = new MyButton("Menu", 300, 350, 150, 100);
    }




    /**** Methods ****/
    /** Render the Game over page **/
    public void render(Graphics g) {
        this.bMenu.draw(g);                                               // Draw the button menu
        Font font = new Font("Arial", Font.BOLD, 45);           // Changing the font and size of the string
        g.setFont(font);                                                  // Set the font
        g.drawString("YOU HAVE LOST! ;-;", 150, 150);            // Draw the string on the scene
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {
        if (this.bMenu.getButtonBounds().contains(x, y)) {           // If it's clicked within the menu button's boundaries
            if (this.bMenu.getButtonBounds().contains(x, y)) {       // If it's clicked within the menu button's boundaries

                GameScenes.setGameScene(MENU);                                                     // Set the game scene back to the menu
                this.mainFrame.getRandomgame().initializeMap();                                    // Reset the game map to a new random one when back into the menu
                this.mainFrame.getRandomgame().initializeEnemies();                                // Reset the game set of enemies for the new random game
                this.mainFrame.getRandomgame().resetTowers();                                      // Reset the towers in the random game

                this.mainFrame.getEndlessWaves().initializeMap();                                  // Reset the endless waves game map to the standard layout when back into the menu
                this.mainFrame.getEndlessWaves().resetTowers();                                    // Reset the towers in the endless waves game
                this.mainFrame.getEndlessWaves().setnOfEnemies(1);                                 // Reset the number of enemies
                this.mainFrame.getEndlessWaves().setWaveCounter(1);                                // Reset the wave counter to 1
                this.mainFrame.getEndlessWaves().setGold(750);                                     // Reset the initial gold
                this.mainFrame.getEndlessWaves().initializeEnemies();                              // Reset the game set of enemies for the new endless waves game

                this.mainFrame.getSavedMapGame().initializeMap();                                  // Reset the game map to a new saved map one when back into the menu
                this.mainFrame.getSavedMapGame().initializeEnemies();                              // Reset the game set of enemies for the saved map game
                this.mainFrame.getSavedMapGame().resetTowers();                                    // Reset the towers in the saved map game
            }
        }
    }

    /** Mouse moved method **/
    public void mouseMoved(int x, int y) {
        this.bMenu.setMouseOver(false);                     // Set the mouse over by default as false

        if (this.bMenu.getButtonBounds().contains(x, y)) {  // If it's moved over within the menu button
            this.bMenu.setMouseOver(true);                  // Set the mouse over as true to trigger the visive effect
        }
    }

    /** Mouse pressed method **/
    public void mousePressed(int x, int y) {
        if (this.bMenu.getButtonBounds().contains(x, y)) {     // If it's pressed within the menu button's bounds
            this.bMenu.setMousePressed(true);                  // Set the mouse over as true to trigger the visive effect
        }
    }

    /** Mouse released method **/
    public void mouseReleased(int x, int y) {
        this.bMenu.resetBooleans();
    }

    /** Mouse dragged method **/
    public void mouseDragged(int x, int y) {
        // Not required
    }
}