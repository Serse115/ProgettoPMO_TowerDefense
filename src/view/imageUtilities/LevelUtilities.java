package view.imageUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/***** Utility class for the level utilities operations: save, create and load levels *****/
public class LevelUtilities {

    /**** Methods ****/
    /** Static method to create a new file for a new level **/
    public static void createFile(String lvlName) {

        File txtFile = new File("resources/levels/customLvl_" + lvlName + ".txt");      // File name

        try {
            txtFile.createNewFile();                // Try to create the file
        }
        catch (IOException e) {                     // If it doesn't work throw and then catch an exception
            e.printStackTrace();
        }
    }

    /** Static method to write the lvl info on a file **/
    public static void WriteToFile(File f, int[] idArr) {

        try {
            PrintWriter p = new PrintWriter(f);             // PrintWriter object to write on the txt file
            for (int i : idArr) {                           // For every id of te array of values to write
                p.println(i);                               // Print the value on the txt
            }
            p.close();                                      // Close the PrintWriter object
        }
        catch (FileNotFoundException e) {                   // If the file is not found throw and catch an exception
            e.printStackTrace();
        }
    }

    /** Static method to save the file **/
    public static void saveLvl(String name, int [][] twoDArr) {

        File lvlFile = new File("resources/levels/customLvl_" + name + ".txt");     // File name

        if (lvlFile.exists()) {                             // If the file exists
            WriteToFile(lvlFile, twoToOneDArr(twoDArr));    // Write the data to the file
        }
        else {
            // Impossible to save
        }
    }

    /** Static sub-method to turn the 2 dimensional arrays into a 1 dimensional one **/
    private static int[] twoToOneDArr(int[][] twoDArr) {

        int[] oneArr = new int[twoDArr.length * twoDArr[0].length];     // Final one dimensional array to return

        for (int j = 0; j < twoDArr.length; j++) {                      // Convert the 2d array into 1d array
            for (int i = 0; i < twoDArr[j].length; i++) {
                int index = j * twoDArr.length + 1;
                oneArr[index] = twoDArr[j][i];
            }
        }
        return oneArr;                                                  // Return the newly converted array
    }
}