package view.guiComponents;

import model.enemy.Reaper;
import model.enemy.Skeleton;
import model.enemy.Zombie;
import view.imageUtilities.SpriteUtilities;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**** Class for the main panel that will handle the different statuses of the game (playing, menu... ) ****/
public class GameScreen extends JPanel {

    /**** Fields ****/
    /* */

    private Reaper reaper;               // Reaper try
    private Skeleton skeleton;           // Skeleton try
    private Zombie zombie;               // Zombie try
    private BufferedImage[] zombieWalking;  // Zombie walk array
    private BufferedImage[] reaperWalking;  // Reaper walk array
    private BufferedImage[] skeletonWalking;    // Skeleton walk array
    private MainFrame mainFrame;            // Main frame object





    /**** Constructors ****/
    /** Main constructor **/
    public GameScreen(MainFrame mainFrame) {
        final Dimension size = new Dimension(750, 775);         // Setting the size for the panel
        super.setMinimumSize(size);                                         // Setting the minimum size for the panel
        super.setPreferredSize(size);                                       // Setting the preferred size for the panel
        super.setMaximumSize(size);                                         // Setting the maximum size for the panel

        this.mainFrame = mainFrame;

        /* */
        this.reaper = new Reaper((short) 150, (byte) 1, (short) 50);

        this.skeleton = new Skeleton((short) 75, (byte) 2, (short) 35);

        this.zombie = new Zombie((short) 100, (byte) 3, (short) 25);

        this.zombieWalking = this.zombie.getWalkingImages();
        this.reaperWalking = this.reaper.getWalkingImages();
        this.skeletonWalking = this.skeleton.getWalkingImages();

    }




    /**** Methods ****/
    /** Override of the paint component method, gets automatically called by the JPanel **/
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);                    // Calling the super-method to do the basic chores

        this.mainFrame.getRender().render(g);       // Plus calling the render method from the render object in the mainFrame class to paint what needed


    }
}

/* import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SimpleAnimation extends JPanel implements Runnable {

    private BufferedImage[] frames;
    private int currentFrameIndex;
    private int frameDelay;
    private Thread animationThread;

    public SimpleAnimation() {
        // Load images into the frames array
        frames = new BufferedImage[3]; // Assuming you have 3 frames
        frames[0] = loadImage("frame1.png");
        frames[1] = loadImage("frame2.png");
        frames[2] = loadImage("frame3.png");

        currentFrameIndex = 0;
        frameDelay = 100; // Milliseconds between frames

        // Start the animation thread
        animationThread = new Thread(this);
        animationThread.start();
    }

    private BufferedImage loadImage(String filename) {
        // Load image from file (implementation not shown for brevity)
        // This method should load and return a BufferedImage
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the current frame
        if (frames[currentFrameIndex] != null) {
            g.drawImage(frames[currentFrameIndex], 0, 0, null);
        }
    }

    @Override
    public void run() {
        while (true) {
            // Update the current frame index
            currentFrameIndex = (currentFrameIndex + 1) % frames.length;

            // Repaint the panel to display the updated frame
            repaint();

            try {
                // Delay between frames
                Thread.sleep(frameDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("Simple Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an instance of SimpleAnimation
        SimpleAnimation animation = new SimpleAnimation();

        // Add the animation panel to the frame
        frame.add(animation);

        // Set the size of the frame
        frame.setSize(400, 400);

        // Make the frame visible
        frame.setVisible(true);
    }
} */

/*
// Draw the current frame
        //if (this.zombieWalking[currentFrameIndex] != null) {
        //    g.drawImage(this.zombieWalking[currentFrameIndex], 300, 100, null);
        //    g.drawImage(this.reaperWalking[currentFrameIndex], 300, 150, null);
        //    g.drawImage(this.skeletonWalking[currentFrameIndex], 300, 200, null);
        //}
 */