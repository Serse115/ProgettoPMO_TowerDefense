package view.imageUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/***** Utility class for the level utilities operations: save, create and load levels *****/
public class LevelUtilities {

    /**** Methods ****/
    /** Static method to create a new file for a new level **/
    public static void createFile(String lvlName) {

        File txtFile = new File("resources/levels/customLvl_" + lvlName + ".txt");      // File name and path

        try {
            txtFile.createNewFile();                // Try to create the file
        }
        catch (IOException e) {                     // If it doesn't work throw and then catch an exception
            e.printStackTrace();
        }
    }

    /** Static sub-method to write the lvl info on a file **/
    private static void writeToFile(File f, int[] idArr) {

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

        File lvlFile = new File("resources/levels/customLvl_" + name + ".txt");     // File name and path

        if (lvlFile.exists()) {                             // If the file exists
            writeToFile(lvlFile, twoToOneDArr(twoDArr));    // Write the data to the file
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

    /** Static sub-method to read from a file **/
    private static ArrayList<Integer> readFromFile(File f) {

        ArrayList<Integer> list = new ArrayList<>();                // List of read values to return

        try {
            Scanner sc = new Scanner(f);                            // Scanner object

            while (sc.hasNextLine()) {                              // While there are still values to read
                list.add(Integer.parseInt(sc.nextLine()));          // Read them and add them to the list
            }
            sc.close();                                             // Then close the scanner object
        }
        catch (FileNotFoundException e) {                           // If there's no such file, throw and catch an exception
            e.printStackTrace();
        }
        return list;                                                // Return the final list
    }

    /** Static method to create a level **/
    public static void createLevel(String name, int[] arrLvl) {

        File newLvl = new File("resources/levels/customLvl_" + name + ".txt");          // File name and path

        if (newLvl.exists()) {
            // Just do nothing and return
        }
        else {
            try {
                newLvl.createNewFile();         // Otherwise, if it does not exist, create a new file
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            writeToFile(newLvl, arrLvl);        // Write the data to the new file
        }
    }

    /** Static sub-method to turn a list into a 2d array **/
    private static int[][] arrayListTo2DInt(ArrayList<Integer> list, int ySize, int xSize) {

        int[][] newArr = new int[ySize][xSize];         // New 2d array to eventually return

        for (int j = 0; j < newArr.length; j++) {               // Get every element from the list
            for (int i = 0; i < newArr[j].length; i++) {
                int index = j * ySize + i;
                newArr[j][i] = list.get(index);                 // And put them into the 2D array to return
            }
        }
        return newArr;                                  // Return the array
    }

    /** Static method to get the level data **/
    public static int[][] getLvlData(String name) {

        File lvlFile = new File("resources/levels/customLvl_" + name + ".txt");     // File name and path

        if (lvlFile.exists()) {                                     // If the file exists
            ArrayList<Integer> list = readFromFile(lvlFile);        // Read from the file and add the data to the list
            return arrayListTo2DInt(list, 20, 20);       // Turn the list into a 2D array and return it
        }
        else {
            return null;                                            // Otherwise, return nothing
        }
    }

    /** Static method to get the distance **/
    public static int getDistance(float x1, float x2) {

        return (int) Math.abs(x1 - x2);
    }
}