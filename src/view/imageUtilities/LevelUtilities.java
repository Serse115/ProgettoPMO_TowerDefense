package view.imageUtilities;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/***** Utility class for the level utilities operations: save, create and load levels *****/
public class LevelUtilities {

    /**** Static fields ****/
    private static int nOfEditedMaps = initializeTheFilesVariableCount();             // Integer representing the number of edited maps saved
    private static final String COUNT_FILE_PATH = "resources/levels/lvl_count.txt";   // Path to the file that keeps count of the saved files


    /**** Methods ****/
    /** Static method to initialize the files count variable in the beginning **/
    private static int initializeTheFilesVariableCount() {
        try (BufferedReader reader = new BufferedReader(new FileReader(COUNT_FILE_PATH))) {   // Use the buffered reader to read the value corresponding to the number of files
            return Integer.parseInt(reader.readLine());                                       // Read the line and return it
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;                                                                             // If something goes wrong return 0
    }

    /** Static method to update the files count variable **/
    public static void initializeTheFilesCount() {
        try (BufferedReader reader = new BufferedReader(new FileReader(COUNT_FILE_PATH))) {   // Use the buffered reader to read the value corresponding to the number of files
            String line = reader.readLine();                                                  // Read the line
            if (line != null) {                                                               // If the line is not null
                nOfEditedMaps = Integer.parseInt(line);                                       // Initialize the variable to the number of files
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Static method to update the files count on the txt file **/
    public static void updateFileCount() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(COUNT_FILE_PATH))) {   // Use the buffered writer to create a new writer with the chosen file path
            writer.write(String.valueOf(nOfEditedMaps + 1));                                  // Then write the value increased on the text file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    private static void writeToFile(File f, int[][] idArr) {

        try {
            PrintWriter p = new PrintWriter(f);             // PrintWriter object to write on the txt file
            for (int i = 0; i < 20; i++) {                  // For every id of the array of values to write
                for (int j = 0; j < 23; j++) {
                    int x = idArr[i][j];                        // Save the corresponding value in a variable on its own
                    p.println(x);                               // Print the value of the variable on the txt
                }

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
            writeToFile(lvlFile, twoDArr);                  // Write the data to the file
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
    private static int[][] readFromFile(File f) {

        int[][] tilesArray = new int[20][23];                       // Array of int values to read and return

        try {
            Scanner sc = new Scanner(f);                            // Scanner object

            for (int i = 0; i < 20; i++) {                          // For every row to form
                for (int j = 0; j < 23; j++) {                      // And column to form
                    tilesArray[i][j] = sc.nextInt();                // Read the int and assign it to the position in the array list
                }
            }
            sc.close();                                             // Then close the scanner object
        }
        catch (FileNotFoundException e) {                           // If there's no such file, throw and catch an exception
            e.printStackTrace();
        }
        return tilesArray;                                          // Return the final array
    }

    /** Static method to create a level **/
    public static void createLevel(String name, int[][] arrLvl) {


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

        File lvlFile = new File(name);                              // File name and path

        if (lvlFile.exists()) {                                     // If the file exists
            return readFromFile(lvlFile);                           // Return the 2D array of tiles corresponding to the map layout through the previous method
        }
        else {
            return null;                                            // Otherwise, return nothing
        }
    }

    /** Static method to get the distance **/
    public static int getDistance(float x1, float x2) {

        return (int) Math.abs(x1 - x2);
    }

    /** Get the number of maps as a string **/
    public static String getnOfEditedMaps() {
        return String.valueOf(nOfEditedMaps);
    }
}