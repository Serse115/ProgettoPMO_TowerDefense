package view.GameScenes;

import view.guiComponents.MainFrame;
import view.imageUtilities.SpriteUtilities;
import java.awt.*;
import java.awt.image.BufferedImage;

/**** Class for the rendering part of the various game scenes (MENU, PLAY...) ****/
public class Render {

    /**** Fields ****/
    private MainFrame mainFrame;

    /* */
    private BufferedImage grassImg;      // Img to paint grass




    /**** Constructors ****/
    public Render(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        /* */
        this.grassImg = SpriteUtilities.getSpriteAtlas("layout_atlas/grass_atlas.png");
    }




    /**** Methods ****/
    public void render(Graphics g) {

        switch (GameScenes.gameScenes) {                    // According to what game scene is needed
            case MENU:
                this.mainFrame.getMenu().render(g);         // Render and paint the components of every page
                break;
            case PLAY:
                if (this.grassImg != null) {
                    for (int j = 0; j < 20; j++) {
                        for (int i = 0; i < 23; i++) {
                            g.drawImage(this.grassImg, 32 * i, (32 * j) + 10, null);
                        }
                    }
                }
                break;
            case EDIT_MAP:
                break;
            case SAVED_GAME:
                break;
            case ENDLESS_WAVES:
                break;
            case GAME_OVER:
                break;
        }

    }
}