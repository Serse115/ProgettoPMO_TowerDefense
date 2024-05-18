package view.guiComponents;

import view.gameScenes.GameScenes;
import view.gameScenes.Playable;
import java.awt.*;

import static view.gameScenes.GameScenes.MENU;

/**** Class for the action bar in the Play game scene ****/
public class GameActionBar extends Bar implements Playable {

    /**** Fields ****/
    private Clickable bMenu;                // Go back to the menu button
    private Clickable bPause;               // Pause the game button




    /**** Constructors ****/
    /** Main constructor **/
    public GameActionBar(int x, int y, int width, int height) {
        super(x, y, width, height);             // Using the superclass constructor
        this.bMenu = new MyButton("Menu", 10, 650, 100, 30);
        this.bPause = new MyButton("Pause", 10, 690, 100, 30);
    }




    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {

        // Body of the action bar
        g.setColor(new Color(220, 123, 15));
        g.fillRect(super.getX(), super.getY(), super.getWidth()  , super.getHeight());

        // Background of the action bar
        g.setColor(Color.BLACK);
        g.drawRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());

        // Buttons
        this.bMenu.draw(g);
        this.bPause.draw(g);
    }

    /** Menu button getter **/
    public Clickable getbMenu() {
        return this.bMenu;
    }

    /** Pause menu getter **/
    public Clickable getbPause() {
        return this.bPause;
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {
        if (this.bMenu.getButtonBounds().contains(x, y)) {       // If it's clicked within the menu button's boundaries
            GameScenes.setGameScene(MENU);                                      // Set the game scene back to the menu
        }
        else if (this.bPause.getButtonBounds().contains(x, y)) {  // If it's clicked within the pause game button's boundaries
            // do nothing for now
        }
    }

    /** Mouse moved method **/
    public void mouseMoved(int x, int y) {
        this.bMenu.setMouseOver(false);      // Set the mouse over for the menu button as false
        this.bPause.setMouseOver(false);     // Set the mouse over for the pause button as false

        if (this.bMenu.getButtonBounds().contains(x, y)) {       // If it's moved over the menu button
            this.bMenu.setMouseOver(true);                       // Add the effect
        }
        else if (this.bPause.getButtonBounds().contains(x, y)) {       // If it's moved over the pause button
            this.bPause.setMouseOver(true);                            // Add the effect
        }
    }

    /** Mouse pressed method **/
    public void mousePressed(int x, int y) {
        this.bMenu.setMousePressed(false);      // Set the mouse pressed over for the menu button as false
        this.bPause.setMousePressed(false);     // Set the mouse pressed over for the pause button as false

        if (this.bMenu.getButtonBounds().contains(x, y)) {      // If it's pressed on the menu button
            this.bMenu.setMousePressed(true);                   // Add the effect
        }
        else if (this.bPause.getButtonBounds().contains(x, y)) {    // If it's pressed on the pause button
            this.bPause.setMousePressed(true);                      // Add the effect
        }
    }

    /** Mouse released method **/
    public void mouseReleased(int x, int y) {
        this.bMenu.resetBooleans();                 // Resetting the booleans for the menu button
        this.bPause.resetBooleans();                // Resetting the booleans for the pause button
    }

    /** Mouse dragged method **/
    public void mouseDragged(int x, int y) {
        // Do nothing for now
    }
}