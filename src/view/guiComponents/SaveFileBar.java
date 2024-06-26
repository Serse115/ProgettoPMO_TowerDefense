package view.guiComponents;

import view.gameScenes.GameScenes;
import java.awt.*;
import static view.gameScenes.GameScenes.SAVED_MAPS_GAME;

/***** Class for the GUI component bar to show and select the save files *****/
public class SaveFileBar {

    /**** Fields ****/
    private Clickable bPlay;                    // Play button
    private int y;                              // Coordinate y
    private int fileIndex;                      // Index that will represent the index of the file that will be loaded when chosen
    private MainFrame mainFrame;                // Object reference to the mainframe




    /**** Constructors ****/
    public SaveFileBar(int baseY, int index, MainFrame mainFrame) {
        this.y = baseY + index * 100;                                                       // Set the y coordinate based on the base position and index
        this.bPlay = new MyButton("Play", 650, this.y + 30, 60, 40);  // Set the y coordinate for the play button
        this.fileIndex = index;
        this.mainFrame = mainFrame;
    }




    /**** Methods ****/
    /** Render the Game over page **/
    public void render(Graphics g) {
        this.drawRectangle(g);                          // Draw the rectangle
        this.bPlay.draw(g);                             // Draw the play button
    }

    private void drawRectangle(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, this.y, 736, 100);                 // Using y for the filled rectangle position
        g.setColor(Color.BLACK);
        g.drawRect(0, this.y, 736, 100);                 // Using y for the drawn rectangle border
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {
        if (this.bPlay.getButtonBounds().contains(x, y)) {      // If it's clicked within the menu button's boundaries

            this.mainFrame.getSavedMapGame().setSavedMapPath("resources/levels/CustomMaps/customLvl_" + (this.fileIndex + 1) + ".txt");
            this.mainFrame.getSavedMapGame().initializeRealMap();
            GameScenes.setGameScene(SAVED_MAPS_GAME);                      // Set the game scene as the menu one
        }
    }

    /** Mouse moved method **/
    public void mouseMoved(int x, int y) {
        this.bPlay.setMouseOver(false);                     // Set the mouse over by default as false

        if (this.bPlay.getButtonBounds().contains(x, y)) {  // If it's moved over within the play button
            this.bPlay.setMouseOver(true);                  // Set the mouse over as true to trigger the visive effect
        }
    }

    /** Mouse pressed method **/
    public void mousePressed(int x, int y) {
        if (this.bPlay.getButtonBounds().contains(x, y)) {     // If it's pressed within the play button's bounds
            this.bPlay.setMousePressed(true);                  // Set the mouse over as true to trigger the visive effect
        }
    }

    /** Mouse released method **/
    public void mouseReleased(int x, int y) {
        this.bPlay.resetBooleans();
    }

    /** Mouse dragged method **/
    public void mouseDragged(int x, int y) {
        // Not required
    }

    /** Play button getter **/
    public Clickable getbPlay() {
        return this.bPlay;
    }
}
