package view.guiComponents;

import model.tower.Tower;
import view.gameScenes.EditMap;
import view.gameScenes.GameScenes;
import view.gameScenes.Playable;
import view.imageUtilities.LevelUtilities;
import view.imageUtilities.SpriteUtilities;
import java.awt.*;
import static view.gameScenes.GameScenes.MENU;

/***** Class for the gui component editing toolbar to customize maps *****/
public class EditingToolBar extends Bar {

    /**** Fields ****/
    private EditMap editMap;                 // Object reference to the Editing game scene
    private Clickable bGrass;                // Grass button
    private Clickable bWater;                // Water button
    private Clickable bRoad;                 // Road button
    private Clickable bMenu;                 // Menu button
    private Clickable bSave;                 // Save the map button




    /**** Constructors ****/
    public EditingToolBar(int x, int y, int width, int height, EditMap editMap) {
        super(x, y, width, height);
        this.editMap = editMap;
        this.bGrass = new MyButton("Grass", 250, 680, 48, 48, SpriteUtilities.getSpriteAtlas("layout_atlas/grass_atlas.png"));
        this.bWater = new MyButton("Water", 320, 680, 48, 48, SpriteUtilities.getSpriteAtlas("layout_atlas/water_atlas.png"));
        this.bRoad = new MyButton("Road", 390, 680, 48, 48, SpriteUtilities.getSpriteAtlas("layout_atlas/road_atlas.png"));
        this.bMenu = new MyButton("Menu", 10, 660, 100, 30);
        this.bSave = new MyButton("Save", 10, 710, 100, 30);

    }




    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {

        // Body of the action bar
        g.setColor(new Color(220, 123, 15));                                    // Set color
        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());    // Draw filled rectangle

        // Background of the action bar
        g.setColor(Color.BLACK);                                                        // Set color
        g.drawRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());    // Draw border rectangle

        // Buttons
        this.bGrass.draw(g, this.bGrass.getbImage());                                   // Draw the button grass
        this.bWater.draw(g, this.bWater.getbImage());                                   // Draw the button water
        this.bRoad.draw(g, this.bRoad.getbImage());                                     // Draw the button road
        this.bMenu.draw(g);                                                             // Draw the menu button
        this.bSave.draw(g);                                                             // Draw the save button
    }


    /** Method to convert the lvl in a 2d array of ints (the tile types of the level itself) **/
    private int[][] get2DArrFromLvl() {
        Tile[][] lvlToSave = this.editMap.getLvLArray();            // Reference to the array to save
        int[][] arrToReturn = new int[20][23];                      // Array with the lvl tile types to return

        for (int j = 0; j < 20; j++) {                              // For every value in each row
            for (int i = 0; i < 23; i++) {                          // and column
                arrToReturn[j][i] = lvlToSave[j][i].getTileType();  // Assign that value to the array to return
            }
        }

        return arrToReturn;                                         // Return the array
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {
        if (this.bMenu.getButtonBounds().contains(x, y)) {              // If the click is in the menu button's bounds
            GameScenes.setGameScene(MENU);                              // Set the game scene to the menu
            this.editMap.defaultLvLTilesLoader();                       // Reset the tiles for the default map
        }
        else if (this.bSave.getButtonBounds().contains(x, y)) {                                     // If the click is in the save button's bounds
            LevelUtilities.updateFileCount();                                                       // Update the file counter file txt + 1
            LevelUtilities.initializeTheFilesCount();                                               // Update the files count variable that acts as a counter for the names too
            LevelUtilities.createLevel(LevelUtilities.getnOfEditedMaps(), this.get2DArrFromLvl());  // Create a new txt file to save the int[][] and print it on the txt
            GameScenes.setGameScene(MENU);                                                          // Set the game scene to the menu
            this.editMap.defaultLvLTilesLoader();                                                   // Reset the tiles for the default map
        }
        else if (this.bRoad.getButtonBounds().contains(x, y)) {         // If the click is in the road button's bounds
            this.editMap.setSelectedTileToPaint(this.editMap.getGuiController().getRoad());        // Select the tile to paint as the road one
        }
        else if (this.bWater.getButtonBounds().contains(x, y)) {        // If the click is in the water button's bounds
            this.editMap.setSelectedTileToPaint(this.editMap.getGuiController().getWater());       // Select the tile to paint as the water one
        }
        else if (this.bGrass.getButtonBounds().contains(x, y)) {        // If the click is in the grass button's bounds
            this.editMap.setSelectedTileToPaint(this.editMap.getGuiController().getGrass());        // Select the tile to paint as the grass one
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