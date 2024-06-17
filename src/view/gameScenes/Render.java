package view.gameScenes;

import view.guiComponents.MainFrame;
import java.awt.*;

/**** Class for the rendering part of the various game scenes (MENU, PLAY...) ****/
public class Render {

    /**** Fields ****/
    private MainFrame mainFrame;




    /**** Constructors ****/
    public Render(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }




    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {

        switch (GameScenes.gameScenes) {                    // According to what game scene is needed
            case MENU:
                this.mainFrame.getMenu().render(g);         // Render and paint the components of the menu page
                break;
            case PLAY:
                this.mainFrame.getRandomGame().render(g);         // Render and paint the components of the play page
                break;
            case EDIT_MAP:
                this.mainFrame.getEdit().render(g);         // Render and paint the components of the edit page
                break;
            case SAVED_GAME:
                break;
            case ENDLESS_WAVES:
                this.mainFrame.getEndlessWaves().render(g); // Render and paint the components of the endless waves page
                break;
            case GAME_OVER:
                this.mainFrame.getGameOver().render(g);     // Render and paint the components of the game over page
                break;
            case GAME_WON:
                this.mainFrame.getGameWon().render(g);     // Render and paint the components of the game won page
                break;
        }
    }
}