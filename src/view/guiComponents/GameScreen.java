package view.guiComponents;

import javax.swing.*;
import java.awt.*;

/**** Class for the main panel that will handle the different statuses of the game (playing, menu... ) ****/
public class GameScreen extends JPanel {

    /**** Fields ****/
    private MainFrame mainFrame;            // Mainframe object reference





    /**** Constructors ****/
    /** Main constructor **/
    public GameScreen(MainFrame mainFrame) {
        final Dimension size = new Dimension(736, 775);         // Setting the size for the panel
        super.setMinimumSize(size);                                         // Setting the minimum size for the panel
        super.setPreferredSize(size);                                       // Setting the preferred size for the panel
        super.setMaximumSize(size);                                         // Setting the maximum size for the panel

        this.mainFrame = mainFrame;
    }




    /**** Methods ****/
    /** Override of the paint component method, gets automatically called by the JPanel **/
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);                    // Calling the super-method to do the basic chores
                                                    // This will be recalled over and over again to ensure the correct status of the game is displayed
        this.mainFrame.getRender().render(g);       // Plus calling the render method from the render object in the mainFrame class to paint what needed
    }
}