package view.guiComponents;

import view.gameScenes.*;

import javax.swing.*;

/**** Class for the main game frame ****/
public class MainFrame extends JFrame implements Runnable {

    /**** Fields ****/
    private GameScreen gameScreen;                                    // Main game screen panel
    private Thread gameThread;                                        // Game thread
    private final double FPS_SET = 60.0;                              // FPS counter
    private final double UPS_SET = 60.0;                              // Updates counter
    private MouseInputListener mouseInputListener;                    // Object listener for the inputs received from the mouse
    private Render render;                                            // Render object
    private Playable menu;                                            // Menu game scene
    private Playable play;                                            // Play game scene
    private Playable edit;                                            // Edit game scene
    private Playable endlessWaves;                                    // Endless waves scene
    private Playable temporaryEndlessWaves;                           // Temporary endless waves scene




    /**** Constructors ****/
    /** Main constructor **/
    public MainFrame() {
        super.setTitle("Tower Defense PMO");                                    // JFrame's title
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                   // JFrame default close settings
        super.setLocation(300, 0);                                        // JFrame's location on screen
        super.setResizable(false);                                              // JFrame's resizability as false

        this.render = new Render(this);                              // Initializing the render object

        this.gameScreen = new GameScreen(this);                       // Initializing the game screen
        this.add(gameScreen);                                                  // Adding the game screen to the JFrame

        this.menu = new Menu(this);                                   // Initializing the menu game scene object
        this.temporaryEndlessWaves = new EndlessWaves(this);          // Initializing the temporary endless waves scene object
        this.play = new RandomGame(this, this.temporaryEndlessWaves); // Initializing the play game scene object
        this.edit = new EditMap(this);                                // Initializing the edit game scene object
        this.endlessWaves = new EndlessWaves(this, this.play);        // Initializing the endless waves game scene objet

        this.mouseInputListener = new MouseInputListener(this);       // Initializing the mouse input listener
        super.addMouseListener(this.mouseInputListener);                       // Adding the mouse input listener as a mouse listener
        super.addMouseMotionListener(this.mouseInputListener);                 // Adding the mouse input listener as a mouse motion listener
        super.requestFocus();                                                  // Requesting the focus

        super.pack();                                                          // Packing the components
        super.setVisible(true);                                                // Visibility of the JFrame to true
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

    /** Override of the run method from the runnable interface (for the thread) **/
    /** Takes care of the game loop part with rendering and updates, gets automatically called from the thread itself **/
    public void run() {

        // Local variables
        final double timePerFrame = 1000000000.0 / FPS_SET;       // Time passing through each frame
        final double timePerUpdate = 1000000000.0 / UPS_SET;      // Time passing through each update
        long lastFrame = System.nanoTime();                       // Last time the previous frame was showed
        long lastTimeCheck = System.currentTimeMillis();          // Last time the check was used
        long lastTimeUPS = System.nanoTime();                     // Last time an update happened
        long now;                                                 // Current nano time
        int frames = 0;                                           // Frames number
        int updates = 0;                                          // Updates number

        // Start of the handling
        while (true) {

            now = System.nanoTime();                              // Setting the now time variable

            // Render part
            if (now - lastFrame >= timePerFrame) {                // Checking if every frame is shown for the correct duration
                lastFrame = now;                                  // Reset
                repaint();                                        // And repaint
                frames++;                                         // Increase frames counter
            }

            // Update part
            if (now - lastTimeUPS >= timePerUpdate) {             // Handle the updates, if every update happens for the correct amount of time
                lastTimeUPS = now;                                // Reset
                updates++;                                        // and update
            }

            // Print frames and updates on screen
            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {                   // Every second passing by
                System.out.println("FPS: " + frames + " | UPS: " + updates);            // Printing current frames and updates on the console
                frames = 0;                                                             // Reset the frames
                updates = 0;                                                            // Reset the updates
                lastTimeCheck = System.currentTimeMillis();                             // And reset the timer
            }
        }
    }

    /** Starting method for the game loop **/
    public void start() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    /** Render getter **/
    public Render getRender() {
        return this.render;
    }

    /** Menu getter **/
    public Playable getMenu() {
        return this.menu;
    }

    /** Play getter **/
    public Playable getPlay() {
        return this.play;
    }

    /** Edit getter **/
    public Playable getEdit() {
        return this.edit;
    }

    /** Endless waves getter **/
    public Playable getEndlessWaves() {
        return this.endlessWaves;
    }
}