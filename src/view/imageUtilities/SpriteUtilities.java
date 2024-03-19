package view.imageUtilities;

import model.enemy.Enemy;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**** Utility Class for the sprite operations ****/
public class SpriteUtilities {

    /**** Methods ****/
    /** Get the requested sprite atlas from the resources folder and return it **/
    public static BufferedImage getSpriteAtlas(String neededAtlasPath) {                           // Uses a string to identify the requested atlas path to return
        BufferedImage img = null;
        InputStream is = Enemy.class.getClassLoader().getResourceAsStream(neededAtlasPath);         // Getting the requested atlas as an input stream of bytes

        try {
            assert is != null;
            img = ImageIO.read(is);                                                                 // Get the requested atlas image from the stream of bytes
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return img;                                                                                 // Return the requested atlas as an image
    }

    /** Get the required sub image from the atlas **/
    private static BufferedImage getSubSprite(int xCord, int yCord, BufferedImage atlas) {
        return atlas.getSubimage(xCord * 32, yCord * 32, 48, 48);                       // Getting the sub image and returning it
    }

    /** Get the sprites for the animated frames as an array of images **/
    public static BufferedImage[] getAniSprites(int xCord, int yCord, BufferedImage atlas, int numOfSubImgs) {

        BufferedImage[] arr = new BufferedImage[numOfSubImgs];                                 // Creating the array for the sub images that will act as frames

        for (int i = 0; i < numOfSubImgs; i++) {
            arr[i] = getSubSprite(xCord + i, yCord, atlas);                              // Using the previous method to assign the frames to the slots of the array
        }

        return arr;                                                                            // Return the array
    }
}
