package view.gameScenes;

import controller.GUIController;
import model.tower.Tower;
import view.guiComponents.GameActionBar;
import view.guiComponents.MainFrame;
import view.imageUtilities.LevelUtilities;
import java.awt.*;

/***** Class for the endless waves game scene *****/
public class EndlessWaves extends GameSceneBase implements Playable {

    /**** Fields ****/
    private GameActionBar bottomBar;                    // Game action bar at the bottom of the screen
    private GUIController guiController;                // GUI controller object for the map generating and tiles
    private int[][] mapArrayTile;                       // Array of ints forming the tiles array for the map





    /**** Constructors ****/
    /** Main constructor for the real endless waves game scene **/
    public EndlessWaves(MainFrame mainFrame, Playable randomGame) {
        super(mainFrame);
        this.bottomBar = new GameActionBar(0, 640, 736, 160, randomGame, this);
        this.guiController = new GUIController();
        this.mapArrayTile = new int[23][23];
        this.initializeMap();
    }

    /** Secondary constructor for the temporary endless waves game scene to initialize the random game scene on the mainframe class **/
    public EndlessWaves(MainFrame mainFrame) {
        super(mainFrame);
        this.bottomBar = new GameActionBar(0, 640, 736, 160, this);
        this.guiController = new GUIController();
        this.mapArrayTile = new int[23][23];
        this.initializeMap();
    }




    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {
        this.drawLevel(g);
        this.bottomBar.render(g);

    }

    @Override
    public void update() {

    }

    /** Initialize the map method **/
    public void initializeMap() {

        this.mapArrayTile = LevelUtilities.getLvlData("resources/levels/EndlessWavesMap.txt");     // Initialize the mao array tiles layout with the data from the chosen txt file

    }

    @Override
    public void initializeEnemies() {

    }

    /** Draw level method **/
    private void drawLevel(Graphics g) {

        for (int j = 0; j < 20; j++) {                                                                                                  // For every row
            for (int i = 0; i < 23; i++) {                                                                                              // And column
                g.drawImage(this.guiController.getTileTypeReturnImage(this.mapArrayTile[j][i]), 32 * i, (32 * j), null);     // Draw the right tile image
            }
        }
    }

    /** Mouse clicked method **/
    public void mouseClicked(int x, int y) {

        if (y >= 640) {                             // If the mouse click is located inside the bottom game action bar bounds
            this.bottomBar.mouseClicked(x, y);      // Use the bottom bar's mouse clicked method passing it the coordinates of where its clicked
        }
    }

    /** Mouse moved method **/
    public void mouseMoved(int x, int y) {

        if (y >= 640) {                             // If the mouse moved position is located inside the bottom game action bar bounds
            this.bottomBar.mouseMoved(x, y);        // Use the bottom bar's mouse moved method passing it the coordinates of where its clicked
        }
    }

    /** Mouse pressed method **/
    public void mousePressed(int x, int y) {

        if (y >= 640) {                             // If the mouse pressed position is located inside the bottom game action bar bounds
            this.bottomBar.mousePressed(x, y);      // Use the bottom bar's mouse pressed method passing it the coordinates of where its clicked
        }
    }

    @Override
    public void mouseReleased(int x, int y) {

        this.bottomBar.mouseReleased(x, y);         // Use the mouse released method from the bottom game action bar object
    }

    @Override
    public void mouseDragged(int x, int y) {

        // Do nothing for now
    }

    @Override
    public void setSelectedTower(Tower tower) {

    }

    @Override
    public void resetTowers() {

    }

    @Override
    public int getGold() {
        return 0;
    }
}