package view.guiComponents;

import view.gameScenes.GameScenes;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**** Class to organize the and handle the inputs coming from the mouse listener and motion listener ****/
public class MouseInputListener implements MouseListener, MouseMotionListener {

    /**** Fields ****/
    private MainFrame mainFrame;            // Link to the main frame object




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
                case PLAY:                                                                      // If it's play
                    this.mainFrame.getPlay().mouseClicked(e.getX() - 5, e.getY() - 30);   // Call the play's mouse clicked methods to do things depending on the position of the click
                case EDIT_MAP:
                    break;
                case SAVED_GAME:
                    break;
                case ENDLESS_WAVES:
                    break;
            }
        }
        else if (e.getButton() == MouseEvent.BUTTON3) {
            System.out.println("Right mouse button clicked");
        }
    }

    /** Mouse moved and its consequences method **/
    @Override
    public void mouseMoved(MouseEvent e) {
        switch (GameScenes.gameScenes) {
            case MENU:                                                                   // If it's menu
                this.mainFrame.getMenu().mouseMoved(e.getX() - 5, e.getY() - 30);  // Call the menu's mouse moved methods to do things depending on the position of the click
                break;
            case PLAY:                                                                   // If it's play
                this.mainFrame.getPlay().mouseMoved(e.getX() - 5, e.getY() - 30);  // Call the play's mouse moved methods to do things depending on the position of the click
            case EDIT_MAP:
                break;
            case SAVED_GAME:
                break;
            case ENDLESS_WAVES:
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
            case PLAY:                                                                     // If it's play
                this.mainFrame.getPlay().mousePressed(e.getX() - 5, e.getY() - 30);  // Call the menu's mouse pressed methods to do things depending on the position of the click
            case EDIT_MAP:
                break;
            case SAVED_GAME:
                break;
            case ENDLESS_WAVES:
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
            case PLAY:                                                                      // If it's play
                this.mainFrame.getPlay().mouseReleased(e.getX() - 5, e.getY() - 30);  // Call the play's mouse released methods to do things depending on the position of the click
            case EDIT_MAP:
                break;
            case SAVED_GAME:
                break;
            case ENDLESS_WAVES:
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Not necessary
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Not necessary
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Not necessary
    }
}