package view.guiComponents;

import model.enemy.Reaper;
import model.enemy.Skeleton;
import view.imageUtilities.SpriteUtilities;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**** Class for the main panel that will handle the different statuses of the game (playing, menu... ) ****/
public class GameScreen extends JPanel {

    /**** Fields ****/
    /* */
    private BufferedImage img;          // Img to paint try
    private BufferedImage skeletonImg;  // Img to paint try skeleton
    private BufferedImage grassImg;     // Img to paint grass
    private Reaper reaper;               // Reaper try
    private Skeleton skeleton;           // Skeleton try



    /**** Constructors ****/
    /** Main constructor **/
    public GameScreen() {
        final Dimension size = new Dimension(750, 775);         // Setting the size for the panel
        super.setMinimumSize(size);                                         // Setting the minimum size for the panel
        super.setPreferredSize(size);                                       // Setting the preferred size for the panel
        super.setMaximumSize(size);                                         // Setting the maximum size for the panel

        /* */
        this.reaper = new Reaper((short) 100, (byte) 1, (short) 50);
        this.img = this.reaper.getWalkingImages()[0];

        this.skeleton = new Skeleton((short) 75, (byte) 2, (short) 25);
        this.skeletonImg = this.skeleton.getWalkingImages()[0];

        this.grassImg = SpriteUtilities.getSpriteAtlas("layout_atlas/grass_atlas.png");

    }



    /**** Methods ****/
    /** Override of the paint component method **/
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        if (this.grassImg != null) {
            for (int j = 0; j < 20; j++) {
                for (int i = 0; i < 23; i++) {
                    g.drawImage(this.grassImg, 32 * i, (32 * j) + 10, null);
                }
            }
        }

        if (this.img != null) {
            g.drawImage(this.img, 350, 0, null);
        }

        if (this.skeletonImg != null) {
            g.drawImage(this.skeletonImg, 350, 40, null);
        }


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