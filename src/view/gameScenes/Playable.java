package view.gameScenes;

import java.awt.*;

/**** Interface for the GameScenes subclasses ****/
public interface Playable {

    /**** Methods ****/
    /** Render method **/
    void render(Graphics g);

    /** Initialize map method **/
    void initializeMap();

    /** Mouse Clicked method **/
    void mouseClicked(int x, int y);

    /** Mouse Moved method **/
    void mouseMoved(int x, int y);

    /** Mouse Pressed method **/
    void mousePressed(int x, int y);

    /** Mouse Released method **/
    void mouseReleased(int x, int y);

    /** Mouse Dragged method **/
    void mouseDragged(int x, int y);
}