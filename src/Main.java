import Graphics.ProgramWindow;

public class Main {

    public static void main(String[] args) {
        ProgramWindow mainWindow = new ProgramWindow();
        mainWindow.addGraphicsPanel();
        new Thread(mainWindow, "WindowThread").start();
        System.out.println("Main-thread closed");
    }
}