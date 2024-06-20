package view.gameScenes;

import model.tower.Tower;
import view.guiComponents.Clickable;
import view.guiComponents.MyButton;
import java.awt.*;
import static view.gameScenes.GameScenes.MENU;

/***** Saved maps gameScene class *****/
public class SavedMaps extends GameSceneBase implements Playable {

    /**** Fields ****/
    private Clickable bMenu;                                        // Menu button



    /**** Constructor ****/
    public SavedMaps() {
        super();
        this.bMenu = new MyButton("Menu", 300, 710, 100, 50);
    }



    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {
        this.drawBottomBar(g);              // Draw the bottomBar
        this.bMenu.draw(g);                 // Draw the menu button
        this.drawPanel(g);                  // Draw the information panel
    }

    /** Draw bottom bar method **/
    private void drawBottomBar(Graphics g) {
        g.setColor(Color.GRAY);                             // Set the color
        g.fillRect(0, 700, 736, 100);     // Draw the filled rectangle
        g.setColor(Color.BLACK);                            // Set the color
        g.drawRect(0, 700, 736, 100);     // Draw the border rectangle
    }

    /** Draw the info panel method **/
    private void drawPanel(Graphics g) {
        Font font = new Font("Arial", Font.BOLD, 15);           // Changing the font and size of the string
        g.setFont(font);                                                  // Setting the font
        g.drawString("Coming soon!", 325, 150);                  // Draw the string
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {
        if (this.bMenu.getButtonBounds().contains(x, y)) {      // If it's clicked within the menu button's boundaries
            GameScenes.setGameScene(MENU);                      // Set the game scene as the menu one
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

    /** Not required methods (got from the interface)* */
    /** Update method (not required) **/
    public void update() {
        // Not required
    }

    /** Initialize map method (not required) **/
    public void initializeMap() {
        // Not required
    }

    /** Initialize enemies method (not required) **/
    public void initializeEnemies() {
        // Not required
    }

    /** Selected tower setter (not required) **/
    public void setSelectedTower(Tower tower) {
        // Not required
    }

    /** Reset the towers method (not required) **/
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

    /** Wave counter setter (not required) **/
    public void setWaveCounter(int waveCounter) {
        // Not required
    }

    /** BottomBar setter (not required) **/
    public void setBottomBar(Playable bottomBar) {
        // Not required
    }
}