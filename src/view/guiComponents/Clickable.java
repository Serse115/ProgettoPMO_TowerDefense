package view.guiComponents;

import java.awt.*;

/** Interface for the clickable buttons **/
public interface Clickable {

    /** Methods **/
    /** Draw method **/
    void draw(Graphics g);

    /** Reset the boolean variables **/
    void resetBooleans();

    /** Text getter **/
    String getText();

    /** Text setter **/
    void setText(String text);

    /** Id getter **/
    int getId();

    /** Id setter **/
    void setId(int id);

    /** Mouse over getter **/
    boolean isMouseOver();

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
}