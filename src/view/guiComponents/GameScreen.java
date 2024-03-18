package view.guiComponents;

import javax.swing.*;
import java.awt.*;

/**** Class for the main panel that will handle the different statuses of the game (playing, menu... )****/
public class GameScreen extends JPanel {

    /**** Fields ****/
    private Dimension size;             // Size for the JPanel



    /**** Constructors ****/
    /** Main constructor **/
    public GameScreen() {
        this.size = new Dimension(640, 775);        // Setting the size for the panel
        super.setMinimumSize(this.size);                        // Setting the minimum size for the panel
        super.setPreferredSize(this.size);                      // Setting the preferred size for the panel
        super.setMaximumSize(this.size);                        // Setting the maximum size for the panel
    }
}
