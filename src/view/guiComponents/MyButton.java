package view.guiComponents;

import java.awt.*;
import java.awt.image.BufferedImage;

/**** Class that represent the games buttons ****/
public class MyButton implements Clickable {

    /**** Fields ****/
    private String text;            // Text to show on the button
    private int x;                  // X coordinate for the button's position on screen
    private int y;                  // Y coordinate for the button's position on screen
    private int width;              // Width for the button
    private int height;             // Height for the button
    //private int id;                 // Button id
    private BufferedImage bImage;   // Button image if needed
    private boolean mouseOver;      // Boolean variable representing the "mouse moving over the button" situation
    private boolean mousePressed;   // Boolean variable representing the "mouse pressing the button" situation
    private Rectangle buttonBounds; // Class Rectangle is used as a bound to check if the mouse is within its range




    /**** Constructors ****/
    /** Main constructor (Normal buttons for the game settings (Menu, save, pause)) **/
    public MyButton(String text, int x, int y, int width, int height) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        //this.id = -1;                   // Id is not necessary for the normal buttons
        this.bImage = null;             // Button image not needed in this case
        this.mouseOver = false;         // By default the buttons are not considered as moved over by the mouse
        this.mousePressed = false;      // By default  the buttons are not considered as pressed
        this.buttonBounds = new Rectangle(x, y, width, height);     // Setting the bounds
    }

    /** Alternative constructor (For the tiles buttons when creating a map) **/
    public MyButton(String text, int x, int y, int width, int height, BufferedImage bImg/*int id*/) {
        this(text, x, y, width, height);        // Using the previous constructor
        //this.id = id;                           // This time adding the id (the tiles buttons require an id)
        this.bImage = bImg;                       // Adding the image needed for the button
    }



    /**** Methods ****/
    /** Draw the button method 1 (for basic buttons (menu, save, pause) **/
    public void draw(Graphics g) {

        this.drawButtonInside(g);           // Button's inside
        this.drawButtonBorder(g);           // Button's border
        this.drawButtonText(g);             // Button's text
    }

    /** Draw the button method  (for tiles buttons (grass, water, road) **/
    public void draw(Graphics g, BufferedImage bImg) {

        this.drawButtonInside(g, bImg);           // Button's inside
        this.drawButtonBorder(g);                 // Button's border
    }


    /** Draw the button's border sub-method **/
    private void drawButtonBorder(Graphics g) {

        g.setColor(Color.BLACK);                                // Setting the color as black
        g.drawRect(this.x, this.y, this.width, this.height);    // Draw the border

        if (this.mousePressed) {        // If the button is pressed, add an effect
            g.drawRect(this.x + 1, this.y + 1, this.width - 2, this.height - 2);
            g.drawRect(this.x + 2, this.y + 2, this.width -4, this.height - 4);
        }
    }

    /** Draw the button's inside sub-method 1 (for the normal buttons (menu, save, pause)) **/
    private void drawButtonInside(Graphics g) {

        if (this.mouseOver) {           // If the mouse is over the button's bounds
            g.setColor(Color.GRAY);     // Paint the inside as gray to give it an effect
        }
        else {
            g.setColor(Color.WHITE);    // Or else paint the inside as white (normal)
        }
        g.fillRect(this.x, this.y, this.width, this.height);    // Paint the button's inside
    }

    /** Draw the button's inside sub-method 2 (for the tile buttons (grass, water, road)) **/
    private void drawButtonInside(Graphics g, BufferedImage tileImg) {

        g.drawImage(tileImg, this.getX() + 1, this.getY() + 1, this.getWidth() - 1, this.getHeight() - 1, null);      // Paint the button's inside
        if (this.mouseOver) {           // If the mouse is over the button's bounds
            g.setColor(Color.WHITE);     // Paint the inside borders as white to give it an effect
            g.drawRect(this.getX() + 1, this.getY() + 2, this.getWidth() - 3, this.getHeight() - 3);    // Paint the button's effect
        }
    }

    /** Draw the button's text **/
    private void drawButtonText(Graphics g) {

        // Local variables to get the measurements for the text to paint
        int w = g.getFontMetrics().stringWidth(this.text);  // Getting the text's width
        int h = g.getFontMetrics().getHeight();             // Getting the text's height
        g.drawString(this.text, (this.x - (w / 2) + (this.width / 2)), (this.y + (h / 2) + (this.height / 2) - 2));     // Draw the text in the right location
    }

    /** Reset the boolean variables **/
    public void resetBooleans() {

        this.mouseOver = false;
        this.mousePressed = false;
    }

    /** Getters and setters **/
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

    /** Text getter **/
    public String getText() {
        return this.text;
    }

    /** Text setter **/
    public void setText(String text) {
        this.text = text;
    }

    /** Id getter **/
    public int getId() {
        return 0;
    }

    /** Id setter **/
    public void setId(int id) {
    //    this.id = id;
    }

    /** Mouse over getter **/
    public boolean isMouseOver() {
        return this.mouseOver;
    }

    /** Mouse over setter **/
    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    /** Mouse pressed getter **/
    public boolean isMousePressed() {
        return this.mousePressed;
    }

    /** Mouse pressed setter **/
    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    /** Rectangle bounds getter **/
    public Rectangle getButtonBounds() {
        return this.buttonBounds;
    }

    /** Button tile's image getter **/
    public BufferedImage getbImage() {
        return this.bImage;
    }
}