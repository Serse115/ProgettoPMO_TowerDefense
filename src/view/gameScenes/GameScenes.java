package view.gameScenes;

/**** Enum class to organize the various types of possible Game scenes ****/
public enum GameScenes {

    /**** Enum values ****/
    PLAY,
    MENU,
    EDIT_MAP,
    SAVED_MAPS,
    ENDLESS_WAVES,
    GAME_OVER,
    GAME_WON;

    /** Main variable **/
    public static GameScenes gameScenes = MENU;             // Setting the main game scene as the menu

    /** Change the Scene method **/
    public static void setGameScene(GameScenes scene) {     // Change the current scene into the chosen one
        gameScenes = scene;
    }
}
