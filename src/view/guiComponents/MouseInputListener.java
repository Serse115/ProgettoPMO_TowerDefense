package view.guiComponents;

import view.gameScenes.GameScenes;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**** Class to organize the and handle the inputs coming from the mouse listener and motion listener ****/
public class MouseInputListener implements MouseListener, MouseMotionListener {

    /**** Fields ****/
    private MainFrame mainFrame;            // MainFrame object reference




    /**** Constructors ****/
    /** Main constructor **/
    public MouseInputListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }




    /**** Methods ****/
    /** Methods are overrides for the methods provided in the interfaces **/
    /** Mouse clicked and its consequences method **/
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {                                              // If the left mouse button is clicked
            switch (GameScenes.gameScenes) {                                                    // Depending on the game scene
                case MENU:                                                                      // If it's menu
                    this.mainFrame.getMenu().mouseClicked(e.getX() - 5, e.getY() - 30);   // Call the menu's mouse clicked methods to do things depending on the position of the click
                    break;
                case PLAY:                                                                            // If it's play
                    this.mainFrame.getRandomGame().mouseClicked(e.getX() - 5, e.getY() - 30);   // Call the random game's mouse clicked methods to do things depending on the position of the click
                    break;
                case EDIT_MAP:                                                                  // If it's edit map
                    this.mainFrame.getEdit().mouseClicked(e.getX() - 5, e.getY() - 30);   // Call the edit's mouse clicked methods to do things depending on the position of the click
                    break;
                case SAVED_MAPS:                                                                     // If it's saved maps
                    this.mainFrame.getSavedMaps().mouseClicked(e.getX() - 5, e.getY() - 30);   // Call the saved map's mouse clicked methods to do things depending on the position of the clicks
                    break;
                case SAVED_MAPS_GAME:                                                                  // If it's saved maps game
                    this.mainFrame.getSavedMapGame().mouseClicked(e.getX() - 5, e.getY() - 30);   // Call the saved maps game's mouse clicked methods to do things depending on the position of the clicks
                    break;
                case ERROR_SAVED_MAPS:                                                                     // If it's saved maps errors
                    this.mainFrame.getErrorLoadSavedMap().mouseClicked(e.getX() - 5, e.getY() - 30); // Call the saved maps game's errors mouse clicked methods to do things depending on the position of the clicks
                    break;
                case ENDLESS_WAVES:                                                                     // If it's endless waves
                    this.mainFrame.getEndlessWaves().mouseClicked(e.getX() - 5, e.getY() - 30);   // Call the endless waves mouse clicked methods to do things depending on the position of the click
                    break;
                case GAME_OVER:                                                                        // If it's game over
                    this.mainFrame.getGameOver().mouseClicked(e.getX() - 5, e.getY() - 30);     // Call the game over's mouse clicked methods to do things depending on the position of the click
                    break;
                case GAME_WON:                                                                        // If it's game won
                    this.mainFrame.getGameWon().mouseClicked(e.getX() - 5, e.getY() - 30);     // Call the game won's mouse clicked methods to do things depending on the position of the click
                    break;
            }
        }
    }

    /** Mouse moved and its consequences method **/
    @Override
    public void mouseMoved(MouseEvent e) {
        switch (GameScenes.gameScenes) {                                                 // Depending on the game scene
            case MENU:                                                                   // If it's menu
                this.mainFrame.getMenu().mouseMoved(e.getX() - 5, e.getY() - 30);  // Call the menu's mouse moved methods to do things depending on the position of the click
                break;
            case PLAY:                                                                         // If it's play
                this.mainFrame.getRandomGame().mouseMoved(e.getX() - 5, e.getY() - 30);  // Call the play's mouse moved methods to do things depending on the position of the click
                break;
            case EDIT_MAP:                                                                // If it's edit
                this.mainFrame.getEdit().mouseMoved(e.getX() - 5, e.getY() - 30);   // Call the edit's mouse moved methods to do things depending on the position of the click
                break;
            case SAVED_MAPS:                                                                   // If it's saved maps
                this.mainFrame.getSavedMaps().mouseMoved(e.getX() - 5, e.getY() - 30);   // Call the saved map's mouse moved methods to do things depending on the position of the clicks
                break;
            case SAVED_MAPS_GAME:                                                                 // If it's saved maps game
                this.mainFrame.getSavedMapGame().mouseMoved(e.getX() - 5, e.getY() - 30);   // Call the saved maps game's mouse moved methods to do things depending on the position of the clicks
                break;
            case ERROR_SAVED_MAPS:                                                                     // If it's saved maps errors
                this.mainFrame.getErrorLoadSavedMap().mouseMoved(e.getX() - 5, e.getY() - 30);  // Call the saved maps game's errors mouse moved methods to do things depending on the position of the clicks
                break;
            case ENDLESS_WAVES:                                                                   // If it's endless waves
                this.mainFrame.getEndlessWaves().mouseMoved(e.getX() - 5, e.getY() - 30);   // Call the edit's mouse moved methods to do things depending on the position of the click
                break;
            case GAME_OVER:                                                                        // If it's game over
                this.mainFrame.getGameOver().mouseMoved(e.getX() - 5, e.getY() - 30);       // Call the game over's mouse moved methods to do things depending on the position of the click
                break;
            case GAME_WON:                                                                     // If it's game won
                this.mainFrame.getGameWon().mouseMoved(e.getX() - 5, e.getY() - 30);     // Call the game over's mouse moved methods to do things depending on the position of the click
                break;
        }
    }

    /** Mouse pressed and its consequences method **/
    @Override
    public void mousePressed(MouseEvent e) {
        switch (GameScenes.gameScenes) {
            case MENU:                                                                     // If it's menu
                this.mainFrame.getMenu().mousePressed(e.getX() - 5, e.getY() - 30);  // Call the menu's mouse pressed methods to do things depending on the position of the click
                break;
            case PLAY:                                                                           // If it's play
                this.mainFrame.getRandomGame().mousePressed(e.getX() - 5, e.getY() - 30);  // Call the menu's mouse pressed methods to do things depending on the position of the click
                break;
            case EDIT_MAP:                                                                  // If it's edit
                this.mainFrame.getEdit().mousePressed(e.getX() - 5, e.getY() - 30);   // Call the edit's mouse pressed methods to do things depending on the position of the click
                break;
            case SAVED_MAPS:                                                                     // If it's saved maps
                this.mainFrame.getSavedMaps().mousePressed(e.getX() - 5, e.getY() - 30);   // Call the saved map's mouse pressed methods to do things depending on the position of the clicks
                break;
            case SAVED_MAPS_GAME:                                                                   // If it's saved maps game
                this.mainFrame.getSavedMapGame().mousePressed(e.getX() - 5, e.getY() - 30);   // Call the saved maps game's mouse pressed methods to do things depending on the position of the clicks
                break;
            case ERROR_SAVED_MAPS:                                                                     // If it's saved maps errors
                this.mainFrame.getErrorLoadSavedMap().mousePressed(e.getX() - 5, e.getY() - 30);  // Call the saved maps game's errors mouse pressed methods to do things depending on the position of the clicks
                break;
            case ENDLESS_WAVES:                                                                     // If it's endless waves
                this.mainFrame.getEndlessWaves().mousePressed(e.getX() - 5, e.getY() - 30);   // Call the edit's mouse pressed methods to do things depending on the position of the click
                break;
            case GAME_OVER:                                                                       // If it's game over
                this.mainFrame.getGameOver().mousePressed(e.getX() - 5, e.getY() - 30);     // Call the game over's mouse pressed methods to do things depending on the position of the click
                break;
            case GAME_WON:                                                                       // If it's game won
                this.mainFrame.getGameWon().mousePressed(e.getX() - 5, e.getY() - 30);     // Call the game over's mouse pressed methods to do things depending on the position of the click
                break;
        }
    }

    /** Mouse released and its consequences method **/
    @Override
    public void mouseReleased(MouseEvent e) {
        switch (GameScenes.gameScenes) {
            case MENU:                                                                      // If it's menu
                this.mainFrame.getMenu().mouseReleased(e.getX() - 5, e.getY() - 30);  // Call the menu's mouse released methods to do things depending on the position of the click
                break;
            case PLAY:                                                                            // If it's play
                this.mainFrame.getRandomGame().mouseReleased(e.getX() - 5, e.getY() - 30);  // Call the play's mouse released methods to do things depending on the position of the click
                break;
            case EDIT_MAP:                                                                  // If it's edit
                this.mainFrame.getEdit().mouseReleased(e.getX() - 5, e.getY() - 30);  // Call the edit's mouse released methods to do things depending on the position of the click
                break;
            case SAVED_MAPS:                                                                      // If it's saved maps
                this.mainFrame.getSavedMaps().mouseReleased(e.getX() - 5, e.getY() - 30);   // Call the saved map's mouse released methods to do things depending on the position of the clicks
                break;
            case SAVED_MAPS_GAME:                                                                    // If it's saved maps game
                this.mainFrame.getSavedMapGame().mouseReleased(e.getX() - 5, e.getY() - 30);   // Call the saved maps game's mouse released methods to do things depending on the position of the clicks
                break;
            case ERROR_SAVED_MAPS:                                                                       // If it's saved maps errors
                this.mainFrame.getErrorLoadSavedMap().mouseReleased(e.getX() - 5, e.getY() - 30);  // Call the saved maps game's errors mouse released methods to do things depending on the position of the clicks
                break;
            case ENDLESS_WAVES:                                                                      // If it's endless waves
                this.mainFrame.getEndlessWaves().mouseReleased(e.getX() - 5, e.getY() - 30);   // Call the endless waves mouse released methods to do things depending on the position of the click
                break;
            case GAME_OVER:                                                                        // If it's game over
                this.mainFrame.getGameOver().mouseReleased(e.getX() - 5, e.getY() - 30);     // Call the game over's mouse released methods to do things depending on the position of the click
                break;
            case GAME_WON:                                                                        // If it's game won
                this.mainFrame.getGameWon().mouseReleased(e.getX() - 5, e.getY() - 30);     // Call the game over's mouse released methods to do things depending on the position of the click
                break;
        }
    }

    /** Mouse entered method **/
    @Override
    public void mouseEntered(MouseEvent e) {
        // Not necessary
    }

    /** Mouse exited method **/
    @Override
    public void mouseExited(MouseEvent e) {
        // Not necessary
    }

    /** Mouse dragged method **/
    @Override
    public void mouseDragged(MouseEvent e) {
        // Not necessary
    }
}