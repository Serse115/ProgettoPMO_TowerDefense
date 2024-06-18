package view.gameScenes;

import model.tower.Tower;
import view.guiComponents.Clickable;
import view.guiComponents.MainFrame;
import view.guiComponents.MyButton;
import java.awt.*;
import static view.gameScenes.GameScenes.MENU;

/**** Class for the game won scene ****/
public class GameWon extends GameSceneBase implements Playable {

    /**** Fields ****/
    private Clickable bMenu;                    // Menu button




    /**** Constructors ****/
    /** Main constructor **/
    public GameWon(MainFrame mainFrame) {
        super(mainFrame);
        this.bMenu = new MyButton("Menu", 300, 350, 150, 100);
    }




    /**** Methods ****/
    /** Render the Game over page **/
    public void render(Graphics g) {
        this.bMenu.draw(g);                                               // Draw the button menu
        Font font = new Font("Arial", Font.BOLD, 45);           // Changing the font and size of the string
        g.setFont(font);                                                  // Set the font
        g.drawString("YOU HAVE WON! :) ", 150, 150);            // Draw the string on the scene
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {
        if (this.bMenu.getButtonBounds().contains(x, y)) {          // If it's clicked within the menu button's boundaries
            GameScenes.setGameScene(MENU);                          // Set the game scene as the menu one
            super.getMainFrame().getRandomgame().initializeMap();                                    // Reset the game map to a new random one when back into the menu
            super.getMainFrame().getRandomgame().initializeEnemies();                                // Reset the game set of enemies for the new random game
            super.getMainFrame().getRandomgame().resetTowers();                                      // Reset the towers in the random game
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

    /** Reset towers (not required) **/
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