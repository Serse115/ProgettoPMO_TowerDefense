package view.guiComponents;

import javax.swing.*;

/**** Class for the main game frame ****/
public class MainFrame extends JFrame {

    /**** Fields ****/
    private GameScreen gameScreen;                 // Main game screen panel




    /**** Constructors ****/
    /** Main constructor **/
    public MainFrame() {
        super.setTitle("Tower Defense PMO");                          // JFrame's title
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         // JFrame default close settings
        super.setLocation(300, 0);                              // JFrame's location on screen
        super.setResizable(false);                                   // JFrame's resizability as false

        this.gameScreen = new GameScreen();                          // Initializing the game screen
        this.add(gameScreen);                                        // Adding the game screen to the JFrame

        super.pack();                                               // Packing the components
        super.setVisible(true);                                     // Visibility of the JFrame to true

    }



    /**** Methods ****/
    /** Class MainFrame getter **/
    public JFrame getFrame() {
        return this;
    }

    /** GameScreen JPanel getter **/
    public GameScreen getGameScreen() {
        return this.gameScreen;
    }
}