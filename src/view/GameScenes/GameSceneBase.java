package view.GameScenes;

import view.guiComponents.MainFrame;

/**** Parent class for the game scenes ****/
public class GameSceneBase {

    /**** Fields ****/
    private MainFrame mainFrame;        // Link to the mainFrame object
    private int animationIndex;         // Index of the animation frames
    private int animationSpeed;         // Animation speed value
    private int tick;                   // Tick variable to keep check of the current frame



    /**** Constructors ****/
    /** Main constructor **/
    public GameSceneBase(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }




    /**** Methods ****/
    /** Get the mainFrame method **/
    public MainFrame getMainFrame() {
        return this.mainFrame;
    }

    /** Update the animation tick **/
    public void updateTick() {

    }

    /** **/
}