package view.guiComponents;

import view.gameScenes.EditMap;
import view.gameScenes.GameScenes;
import view.gameScenes.Playable;
import java.awt.*;
import static view.gameScenes.GameScenes.MENU;

/***** Class for the gui component editing toolbar to customize maps *****/
public class EditingToolBar extends Bar implements Playable {

    /**** Fields ****/
    private EditMap editMap;                // Object reference to the Editing game scene
    private MyButton bGrass;                // Grass button
    private MyButton bWater;                // Water button
    private MyButton bRoad;                 // Road button
    private MyButton bMenu;                 // Menu button
    private MyButton bSave;                 // Save the map button




    /**** Constructors ****/
    public EditingToolBar(int x, int y, int width, int height, EditMap editMap) {
        super(x, y, width, height);
        this.editMap = editMap;
        this.bGrass = new MyButton("Grass", 130, 650, 100, 100);
        this.bWater = new MyButton("Water", 250, 650, 100, 100);
        this.bRoad = new MyButton("Road", 370, 650, 100, 100);
        this.bMenu = new MyButton("Menu", 10, 650, 100, 30);
        this.bSave = new MyButton("Save", 10, 690, 100, 30);

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
        this.bGrass.draw(g);
        this.bWater.draw(g);
        this.bRoad.draw(g);
        this.bMenu.draw(g);
        this.bSave.draw(g);
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {
        if (this.bMenu.getButtonBounds().contains(x, y)) {              // If the click is in the menu button's bounds
            GameScenes.setGameScene(MENU);                              // Set the game scene to the menu
        }
        else if (this.bSave.getButtonBounds().contains(x, y)) {         // If the click is in the save button's bounds
            // Do nothing for now                                       // Do nothing just for now
        }
        else if (this.bRoad.getButtonBounds().contains(x, y)) {         // If the click is in the road button's bounds
            // Use the road sprite
        }
        else if (this.bWater.getButtonBounds().contains(x, y)) {        // If the click is in the water button's bounds
            // Use the water sprite
        }
        else if (this.bGrass.getButtonBounds().contains(x, y)) {        // If the click is in the grass button's bounds
            // Use the grass sprite
        }
    }

    /** Mouse moved method **/
    public void mouseMoved(int x, int y) {
        this.bGrass.setMouseOver(false);        // Set the mouse over for the grass button as false
        this.bWater.setMouseOver(false);        // Set the mouse over for the water button as false
        this.bRoad.setMouseOver(false);         // Set the mouse over for the road button as false
        this.bMenu.setMouseOver(false);         // Set the mouse over for the menu button as false
        this.bSave.setMouseOver(false);         // Set the mouse over for the save button as false

        if (this.bMenu.getButtonBounds().contains(x, y)) {              // If it's moved over the menu button
            this.bMenu.setMouseOver(true);                              // Add the effect
        }
        else if (this.bSave.getButtonBounds().contains(x, y)) {         // If it's moved over the save button
            this.bSave.setMouseOver(true);                              // Add the effect
        }
        else if (this.bGrass.getButtonBounds().contains(x, y)) {        // If it's moved over the grass button
            this.bGrass.setMouseOver(true);                             // Add the effect
        }
        else if (this.bWater.getButtonBounds().contains(x, y)) {        // If it's moved over the water button
            this.bWater.setMouseOver(true);                             // Add the effect
        }
        else if (this.bRoad.getButtonBounds().contains(x, y)) {         // If it's moved over the road button
            this.bRoad.setMouseOver(true);                              // Add the effect
        }
    }

    /** Mouse pressed method **/
    public void mousePressed(int x, int y) {
        this.bMenu.setMousePressed(false);      // Set the mouse pressed over for the menu button as false
        this.bSave.setMousePressed(false);      // Set the mouse pressed over for the save button as false

        if (this.bMenu.getButtonBounds().contains(x, y)) {      // If it's pressed on the menu button
            this.bMenu.setMousePressed(true);                   // Add the effect
        }
        else if (this.bSave.getButtonBounds().contains(x, y)) {    // If it's pressed on the save button
            this.bSave.setMousePressed(true);                      // Add the effect
        }
        else if (this.bGrass.getButtonBounds().contains(x, y)) {    // If it's pressed on the grass button
            this.bGrass.setMousePressed(true);                      // Add the effect
        }
        else if (this.bWater.getButtonBounds().contains(x, y)) {    // If it's pressed on the water button
            this.bWater.setMousePressed(true);                      // Add the effect
        }
        else if (this.bRoad.getButtonBounds().contains(x, y)) {     // If it's pressed on the road button
            this.bRoad.setMousePressed(true);                       // Add the effect
        }
    }

    /** Mouse released method **/
    public void mouseReleased(int x, int y) {
        this.bMenu.resetBooleans();                 // Resetting the booleans for the menu button
        this.bSave.resetBooleans();                 // Resetting the booleans for the save button
        this.bGrass.resetBooleans();                // Resetting the booleans for the grass button
        this.bWater.resetBooleans();                // Resetting the booleans for the water button
        this.bRoad.resetBooleans();                 // Resetting the booleans for the road button
    }

    /** Mouse dragged method **/
    public void mouseDragged(int x, int y) {
        // Do nothing for now
    }
}