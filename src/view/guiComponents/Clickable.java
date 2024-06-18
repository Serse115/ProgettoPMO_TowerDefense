package view.guiComponents;

import java.awt.*;
import java.awt.image.BufferedImage;

/** Interface for the clickable buttons **/
public interface Clickable {

    /** Methods **/
    /** Basic draw method **/
    void draw(Graphics g);

    /** Tiles choice draw method **/
    void draw(Graphics g, BufferedImage bImg);

    /** Reset the boolean variables **/
    void resetBooleans();

    /** Mouse over setter **/
    void setMouseOver(boolean mouseOver);

    /** Mouse pressed getter **/
    boolean isMousePressed();

    /** Mouse pressed setter **/
    void setMousePressed(boolean mousePressed);

    /** Rectangle bounds getter **/
    Rectangle getButtonBounds();

    /** X getter **/
    int getX();

    /** Y getter **/
    int getY();

    /** Width getter **/
    int getWidth();

    /** Height getter **/
    int getHeight();

    /** Button image getter **/
    BufferedImage getbImage();
}