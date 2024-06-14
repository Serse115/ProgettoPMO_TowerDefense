package view.gameScenes;

import controller.GUIController;
import controller.GameLoopController;
import controller.ModelController;
import model.tower.Tower;
import view.guiComponents.EditingToolBar;
import view.guiComponents.MainFrame;
import view.guiComponents.Tile;
import view.imageUtilities.SpriteUtilities;
import java.awt.*;
import java.awt.image.BufferedImage;

/***** Class for the editing game scene *****/
public class EditMap extends GameSceneBase implements Playable {

    /**** Fields ****/
    private EditingToolBar editingToolBar;                  // Editing toolbar for the editing game scene
    private BufferedImage grassImg;                         // Img to paint grass
    private Tile[][] lvLArray;                              // Default level array for the edit menu
    private Tile selectedTileToPaint;                       // Tile selected for painting in case the map needs to be repainted
    private GUIController guiController;                    // GUI controller object for the map editing and the tiles
    private boolean drawSelectedTile;                       // Boolean variable to decide if the selected tile needs to be painted with some sprite
    private int xMouseCoord;                                // Coordinate x for the current mouse location
    private int yMouseCoord;                                // Coordinate y for the current mouse location
    private int lastTileX;                                  // Coordinate x for the location of the last tile highlighted
    private int lastTileY;                                  // Coordinate y for the location of the last tile highlighted
    private int lastTileType;                               // Type of the last tile highlighted




    /**** Constructors ****/
    public EditMap(MainFrame mainFrame) {
        super(mainFrame);
        this.editingToolBar = new EditingToolBar(0, 640, 736, 160, this);
        this.grassImg = SpriteUtilities.getSpriteAtlas("layout_atlas/grass_atlas.png");
        this.lvLArray = new Tile[20][23];
        this.selectedTileToPaint = null;
        this.guiController = new GUIController();
        this.defaultLvLTilesLoader();
        this.drawSelectedTile = false;
        this.xMouseCoord = 0;
        this.yMouseCoord = 0;
        this.lastTileX = 0;
        this.lastTileY = 0;
        this.lastTileType = -1;
    }




    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {
        this.drawLevel(g);
        this.editingToolBar.render(g);
        this.drawSelectedTile(g);
    }

    /** Update method **/
    public void update() {
        // Not required
    }

    /** Initialize map method **/
    public void initializeMap() {
        // Not required
    }

    /** Initialize the enemies method **/
    public void initializeEnemies() {
        // Not required
    }

    /** Drawing the default level method**/
    private void drawLevel(Graphics g) {

        if (this.grassImg != null) {
            for (int j = 0; j < this.lvLArray.length; j++) {                             // For all the rows and columns of the 2d array composing the map
                for (int i = 0; i < this.lvLArray[j].length; i++) {
                    g.drawImage(this.lvLArray[j][i].getSprite(), 32 * i, (32 * j), null);       // Draw the corresponding image (grass in this case since it's a default map)
                }
            }
        }
    }

    /** Default level tiles' loader (set all the tiles of the lvl array by default to grass ones) **/
    public void defaultLvLTilesLoader() {
        for (int j = 0; j < this.lvLArray.length; j++) {
            for (int i = 0; i < this.lvLArray[j].length; i++) {
                this.lvLArray[j][i] = this.getGuiController().getGrass();
            }
        }
    }

    /** Tile change method **/
    private void changeTile(int x, int y) {

        if (this.selectedTileToPaint != null) {                 // If the selected tile to paint has been chosen

            int tileX = x / 32;                                 // X position of the tile to change
            int tileY = y / 32;                                 // Y position of the tile to change

            if (this.selectedTileToPaint.getTileType() >= 0 && this.selectedTileToPaint.getTileType() <= 2) {      // If the tile type is a field layout type

                if (this.lastTileX == tileX && this.lastTileY == tileY && this.lastTileType == this.selectedTileToPaint.getTileType()) {    // If the tile highlighted has the
                    return;                                      // Same type of the one who is going to be repainted, then do nothing and return
                }
                else {                                                              // Else
                    this.lastTileX = x;                                             // Update the last tile position coord x to the current x
                    this.lastTileY = y;                                             // Update the last tile position coord y to the current y
                    this.lastTileType = this.selectedTileToPaint.getTileType();     // Update the last tile type to the current one selected to paint
                    this.lvLArray[tileY][tileX] = this.selectedTileToPaint;
                }
            }
        }
    }

    /** Draw the selected tile method **/
    private void drawSelectedTile(Graphics g) {
        if (this.selectedTileToPaint != null && this.drawSelectedTile) {            // If the tile to paint is chosen and the change tile option is active
            g.drawImage(this.selectedTileToPaint.getSprite(), this.xMouseCoord, this.yMouseCoord, 32, 32, null);        // Draw the tile
        }
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {

        if (y >= 640) {                             // If the mouse click is located inside the bottom game action bar bounds
            this.editingToolBar.mouseClicked(x, y);      // Use the bottom bar's mouse clicked method passing it the coordinates of where its clicked
        }
        else {
            this.changeTile(this.xMouseCoord, this.yMouseCoord);
        }
    }

    /** Mouse moved method **/
    public void mouseMoved(int x, int y) {

        if (y >= 640) {                             // If the mouse moved position is located inside the bottom game action bar bounds
            this.editingToolBar.mouseMoved(x, y);        // Use the bottom bar's mouse moved method passing it the coordinates of where its clicked
            this.drawSelectedTile = false;               // No need for any selected tile to be focused on or painted since the mouse is on the toolbar
        }
        else {
            this.drawSelectedTile = true;                // Now there's need to focus on a tile to eventually paint since the mouse is not on the toolbar
            this.xMouseCoord = (x / 32) * 32;            // Giving the coordinate of x divided and then multiplied to assure the closest value to 32 multipliers
            this.yMouseCoord = (y / 32) * 32;            // Giving the coordinate of y divided and then multiplied to assure the closest value to 32 multipliers
        }
    }

    /** Mouse pressed method **/
    public void mousePressed(int x, int y) {

        if (y >= 640) {                             // If the mouse pressed position is located inside the bottom game action bar bounds
            this.editingToolBar.mousePressed(x, y);      // Use the bottom bar's mouse pressed method passing it the coordinates of where its clicked
        }
    }

    /** Mouse released method **/
    public void mouseReleased(int x, int y) {

        this.editingToolBar.mouseReleased(x, y);         // Use the mouse released method from the bottom game action bar object
    }

    /** Mouse dragged method **/
    public void mouseDragged(int x, int y) {

        // Do nothing for now
    }

    /** Get game loop controller method (not needed) **/
    public GameLoopController getGameLoopController() {
        return null;
    }

    @Override
    public void setSelectedTower(Tower tower) {

    }

    @Override
    public ModelController getModelController() {
        return null;
    }

    /** Level getter **/
    public Tile[][] getLvLArray() {
        return this.lvLArray;
    }

    /** Selected tile getter **/
    public Tile getSelectedTileToPaint() {
        return this.selectedTileToPaint;
    }

    /** Selected tile setter **/
    public void setSelectedTileToPaint(Tile selectedTileToPaint) {
        this.selectedTileToPaint = selectedTileToPaint;                 // Giving the selected tile to paint value to the chosen one
        this.drawSelectedTile = true;                                   // Change the possibility of the selected tile to be needed to be repainted
    }

    /** GUI controller getter **/
    public GUIController getGuiController() {
        return this.guiController;
    }
}