package view.guiComponents;

import java.awt.*;

/**** Parent class for the bar to add to the game scenes ****/
public class Bar {

    /**** Fields ****/
    private int x;              // X coordinate for the bar
    private int y;              // Y coordinate for the bar
    private int width;          // Width for the bar
    private int height;         // Height for the bar




    /**** Constructors ****/
    /** Main constructor **/
    public Bar(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }



    /**** Methods ****/
    /** Method to draw the buttons feedback **/
    public void drawButtonFeedback(Graphics g, MyButton b) {
        if (b.isMouseOver()) {                                  // If the mouse is over the button
            g.setColor(Color.WHITE);                            // Set the color to white
        }
        else {                                                  // Or else
            g.setColor(Color.BLACK);                            // Set the color to black
        }
        g.drawRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());    // Drawing the button's border

        if (b.isMousePressed()) {                               // If the button is pressed
            g.drawRect(b.getX() + 1, b.getY() + 1, b.getWidth() - 2, b.getHeight() - 2);        // Drawing the effect
            g.drawRect(b.getX() + 2, b.getY() + 2, b.getWidth() - 4, b.getHeight() - 4);        // Drawing the effect
        }
    }

    /** X getter **/
    public int getX() {
        return this.x;
    }

    /** Y getter **/
    public int getY() {
        return this.y;
    }

    /** Width getter **/
    public int getWidth() {
        return this.width;
    }

    /** Height getter **/
    public int getHeight() {
        return this.height;
    }
}