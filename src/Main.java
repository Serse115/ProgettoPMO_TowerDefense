import view.guiComponents.MainFrame;

/**** Main class of the project and starting point ****/
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello");

        MainFrame mainFrame = new MainFrame();          // Create the MainFrame object to start the game
        mainFrame.start();                              // Starting the game loop
    }
}