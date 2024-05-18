package view.gameScenes;

import view.guiComponents.MainFrame;
import java.awt.*;

/**** Class for the rendering part of the various game scenes (MENU, PLAY...) ****/
public class Render {

    /**** Fields ****/
    private MainFrame mainFrame;

    /* */
    //private BufferedImage grassImg;      // Img to paint grass




    /**** Constructors ****/
    public Render(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        /* */
        //this.grassImg = SpriteUtilities.getSpriteAtlas("layout_atlas/grass_atlas.png");
    }




    /**** Methods ****/
    public void render(Graphics g) {

        switch (GameScenes.gameScenes) {                    // According to what game scene is needed
            case MENU:
                this.mainFrame.getMenu().render(g);         // Render and paint the components of the menu page
                break;
            case PLAY:
                this.mainFrame.getPlay().render(g);         // Render and paint the components of the play page
                break;
            case EDIT_MAP:
                this.mainFrame.getEdit().render(g);         // Render and paint the components of the edit page
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