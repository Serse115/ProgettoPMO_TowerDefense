package view.gameScenes;

import view.guiComponents.MainFrame;

/**** Parent class for the game scenes ****/
public class GameSceneBase {

    /**** Fields ****/
    private MainFrame mainFrame;        // Object reference to the mainFrame



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
}