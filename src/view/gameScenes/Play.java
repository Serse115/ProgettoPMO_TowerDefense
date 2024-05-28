package view.gameScenes;

import view.guiComponents.GameActionBar;
import view.guiComponents.MainFrame;
import view.imageUtilities.SpriteUtilities;
import java.awt.*;
import java.awt.image.BufferedImage;

/**** Class for the play game scene ****/
public class Play extends GameSceneBase implements Playable {

    /**** Fields ****/
    private GameActionBar bottomBar;            // Action bar at the bottom of the screen
    private BufferedImage grassImg;             // Img to paint grass




    /**** Constructors ****/
    /** Main constructor **/
    public Play(MainFrame mainFrame) {
        super(mainFrame);
        this.bottomBar = new GameActionBar(0, 640, 736, 160);
        this.grassImg = SpriteUtilities.getSpriteAtlas("layout_atlas/grass_atlas.png");
    }




    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {
        this.drawLevel(g);
        this.bottomBar.render(g);
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

    /** Mouse released method **/
    public void mouseReleased(int x, int y) {

        this.bottomBar.mouseReleased(x, y);         // Use the mouse released method from the bottom game action bar object
    }

    /** Mouse dragged method **/
    public void mouseDragged(int x, int y) {

        // Do nothing for now
    }

    /** Drawing the default level method**/
    private void drawLevel(Graphics g) {

        if (this.grassImg != null) {
            for (int j = 0; j < 20; j++) {
                for (int i = 0; i < 23; i++) {
                    g.drawImage(this.grassImg, 32 * i, (32 * j), null);
                }
            }
        }
    }
}