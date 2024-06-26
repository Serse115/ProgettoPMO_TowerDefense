package view.guiComponents;

import view.gameScenes.GameScenes;
import java.awt.*;
import static view.gameScenes.GameScenes.MENU;

/***** Class for the panel of error when loading a map that doesn't match the prerequisites of the game *****/
public class ErrorLoadSavedMap {

    /**** Fields ****/
    private MainFrame mainFrame;                // Mainframe reference object
    private Clickable bMenu;                    // Menu button




    /**** Constructors ****/
    public ErrorLoadSavedMap(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.bMenu = new MyButton("Menu", 300, 350, 150, 100);
    }




    /**** Methods ****/
    /** Render the error map page **/
    public void render(Graphics g) {
        this.bMenu.draw(g);                                               // Draw the button menu
        Font font = new Font("Arial", Font.BOLD, 40);           // Changing the font and size of the string
        g.setFont(font);                                                  // Set the font
        g.drawString("THE CHOSEN MAP DOESN'T ", 100, 50);        // Draw the string on the scene
        g.drawString(" MEET THE GAME REQUIREMENTS...", 15, 150); // Draw the string on the scene
        g.drawString(" OR YOU WON THE GAME! :)", 75, 250);       // Draw the string on the scene
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {
        if (this.bMenu.getButtonBounds().contains(x, y)) {          // If it's clicked within the menu button's boundaries
            GameScenes.setGameScene(MENU);                          // Set the game scene as the menu one

            this.mainFrame.getSavedMapGame().initializeMap();                                  // Reset the game map to a new saved map one when back into the menu
            this.mainFrame.getSavedMapGame().initializeEnemies();                              // Reset the game set of enemies for the saved map game
            this.mainFrame.getSavedMapGame().resetTowers();                                    // Reset the towers in the saved map game
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
