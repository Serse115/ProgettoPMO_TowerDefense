package view.guiComponents;

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