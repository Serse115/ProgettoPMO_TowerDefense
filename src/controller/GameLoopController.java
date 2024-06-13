package controller;

import view.gameScenes.RandomGame;

/***** Game loop controller class *****/
public class GameLoopController extends Thread {

    /**** Fields ****/
    private RandomGame randomGame;                                              // Object reference to the randomGame object
    private boolean running;                                                    // Thread status variable
    private final int FPS = 60;                                                 // Frames per second
    private final long TARGET_TIME = 1000 / FPS;                                // Milliseconds per frame


    /**** Constructors ****/
    /** Main constructor **/
    public GameLoopController(RandomGame randomGame) {
        this.randomGame = randomGame;
        this.running = true;
    }



    /**** Variables ****/
    /** Run method **/
    public void run() {

        long startTime;                     // Starting time
        long elapsedTime;                   // Elapsed time
        long waitTime;                      // Wait time


        while (this.running) {                                   // While the status is running
            startTime = System.nanoTime();                  // Update the starting time with the system nano time

            this.randomGame.update();
            // this.randomGame.render(this.g);

            elapsedTime = System.nanoTime() - startTime;             // Update the elapsed time
            waitTime = this.TARGET_TIME - (elapsedTime / 1000000);   // Convert to milliseconds

            if (waitTime < 0) {
                waitTime = 5;                                   // Prevent negative sleep time
            }

            try {
                Thread.sleep(waitTime);                         // Use the sleep method to keep the thread operating in a synchronized time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /** Stop the game loop **/
    public void stopGameLoop() {
        this.running = false;
    }

    /** Restart the game loop **/
    public void restartGameLoop() {
        if (!this.running) {
            this.running = true;
            Thread thread = new Thread(this); // Create a new thread instance
            thread.start(); // Start the new thread
        }
    }
}