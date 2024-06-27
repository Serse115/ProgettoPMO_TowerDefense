package view.gameScenes;

import view.guiComponents.Clickable;
import view.guiComponents.MainFrame;
import view.guiComponents.MyButton;
import view.guiComponents.SaveFileBar;
import view.imageUtilities.LevelUtilities;
import java.awt.*;
import static view.gameScenes.GameScenes.MENU;

/***** Saved maps gameScene class *****/
public class SavedMaps {

    /**** Fields ****/
    private Clickable bMenu;                                        // Menu button
    private SaveFileBar[] saveFileBar;                              // Array of save files bar
    private int nOfFilesToDisplay;                                  // Number of saved map file txts to display



    /**** Constructor ****/
    public SavedMaps(MainFrame mainFrame) {
        this.bMenu = new MyButton("Menu", 300, 710, 100, 50);
        this.nOfFilesToDisplay = Integer.parseInt(LevelUtilities.getnOfEditedMaps());
        this.saveFileBar = new SaveFileBar[this.nOfFilesToDisplay];
        for (int i = 0; i < this.nOfFilesToDisplay; i++) {
            this.saveFileBar[i] = new SaveFileBar(10, i, mainFrame);
        }
    }



    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {
        this.drawBottomBar(g);              // Draw the bottomBar
        this.bMenu.draw(g);                 // Draw the menu button
        for (int i = 0; i < this.nOfFilesToDisplay; i++) {
            this.saveFileBar[i].render(g);
        }
    }

    /** Draw bottom bar method **/
    private void drawBottomBar(Graphics g) {
        g.setColor(Color.GRAY);                             // Set the color
        g.fillRect(0, 700, 736, 100);     // Draw the filled rectangle
        g.setColor(Color.BLACK);                            // Set the color
        g.drawRect(0, 700, 736, 100);     // Draw the border rectangle
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {
        if (this.bMenu.getButtonBounds().contains(x, y)) {      // If it's clicked within the menu button's boundaries
            GameScenes.setGameScene(MENU);                      // Set the game scene as the menu one

            for (SaveFileBar fileBar : this.saveFileBar) {                      // Else for every file bar available
                fileBar.mouseReleased(x, y);                                 // Use the mouse clicked method of the file bar itself
            }
        }
        else {
            for (SaveFileBar fileBar : this.saveFileBar) {                      // Else for every file bar available
                if (fileBar.getbPlay().getButtonBounds().contains(x, y)) {      // If the button of the bar contains the click
                    fileBar.mouseClicked(x, y);                                 // Use the mouse clicked method of the file bar itself
                }
            }
        }
    }

    /** Mouse moved method **/
    public void mouseMoved(int x, int y) {
        this.bMenu.setMouseOver(false);                     // Set the mouse over by default as false

        if (this.bMenu.getButtonBounds().contains(x, y)) {  // If it's moved over within the menu button
            this.bMenu.setMouseOver(true);                  // Set the mouse over as true to trigger the visive effect
        }
        else {
            for (SaveFileBar fileBar : this.saveFileBar) {                      // Else for every file bar available
                if (fileBar.getbPlay().getButtonBounds().contains(x, y)) {      // If the button of the bar contains the click
                    fileBar.mouseMoved(x, y);                                 // Use the mouse clicked method of the file bar itself
                }
                else {
                    fileBar.getbPlay().setMouseOver(false);
                }
            }
        }
    }

    /** Mouse pressed method **/
    public void mousePressed(int x, int y) {
        if (this.bMenu.getButtonBounds().contains(x, y)) {     // If it's pressed within the menu button's bounds
            this.bMenu.setMousePressed(true);                  // Set the mouse over as true to trigger the visive effect
        }
        else {
            for (SaveFileBar fileBar : this.saveFileBar) {                      // Else for every file bar available
                if (fileBar.getbPlay().getButtonBounds().contains(x, y)) {      // If the button of the bar contains the click
                    fileBar.getbPlay().setMousePressed(true);                                 // Use the mouse clicked method of the file bar itself
                }
                else {
                    fileBar.getbPlay().setMousePressed(false);
                }
            }
        }
    }

    /** Mouse released method **/
    public void mouseReleased(int x, int y) {
        this.bMenu.resetBooleans();
        for (SaveFileBar fileBar : this.saveFileBar) {                      // Else for every file bar available
            if (fileBar.getbPlay().getButtonBounds().contains(x, y)) {      // If the button of the bar contains the click
                fileBar.mouseReleased(x, y);                                // Use the mouse clicked method of the file bar itself
            }
        }
    }

    /** Mouse dragged method **/
    public void mouseDragged(int x, int y) {
        // Not required
    }
}