package view.gameScenes;

import view.guiComponents.MainFrame;
import java.awt.*;

/**** Class for the rendering part of the various game scenes (MENU, PLAY...) ****/
public class Render {

    /**** Fields ****/
    private MainFrame mainFrame;                    // Object reference to the mainframe




    /**** Constructors ****/
    public Render(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }




    /**** Methods ****/
    /** Render method **/
    public void render(Graphics g) {

        switch (GameScenes.gameScenes) {                            // According to what game scene is needed
            case MENU:                                              // Case menu
                this.mainFrame.getMenu().render(g);                 // Render and paint the components of the menu page
                break;
            case PLAY:                                              // Case play
                this.mainFrame.getRandomGame().render(g);           // Render and paint the components of the play page
                break;
            case EDIT_MAP:                                          // Case edit map
                this.mainFrame.getEdit().render(g);                 // Render and paint the components of the edit page
                break;
            case SAVED_MAPS:                                        // Case saved maps
                this.mainFrame.getSavedMaps().render(g);            // Render and paint the components of the saved maps page
                break;
            case SAVED_MAPS_GAME:                                   // Case saved maps game
                this.mainFrame.getSavedMapGame().render(g);         // Render and paint the components of the saved maps game page
                break;
            case ERROR_SAVED_MAPS:                                  // Case error saved maps game
                this.mainFrame.getErrorLoadSavedMap().render(g);    // Render and paint the components of the error saved maps game page
                break;
            case ENDLESS_WAVES:                                     // Case endless waves
                this.mainFrame.getEndlessWaves().render(g);         // Render and paint the components of the endless waves page
                break;
            case GAME_OVER:                                         // Case game over
                this.mainFrame.getGameOver().render(g);             // Render and paint the components of the game over page
                break;
            case GAME_WON:                                          // Case game won
                this.mainFrame.getGameWon().render(g);              // Render and paint the components of the game won page
                break;
        }
    }
}