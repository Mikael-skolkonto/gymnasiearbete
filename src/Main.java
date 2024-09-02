import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import Graphics.Panel;

public class Main extends JFrame {

    Panel thisGraphicsPanel;
    public Main() {
        setSize(900,500);
        setTitle("Dark Matter Simulator");
        Image windowIcon = Toolkit.getDefaultToolkit().getImage("src\\Resources\\IconPicture.png");
        setIconImage(windowIcon);
        thisGraphicsPanel = new Panel();
        setContentPane(thisGraphicsPanel);
        getContentPane().setBackground(new Color(0x6E1486));
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().getGraphics().setPaintMode();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Main programMainWindow = new Main();
        programMainWindow.getGraphicsPanel().painParticle(programMainWindow.getWidth()/2,programMainWindow.getHeight()/2);

    }

    public Panel getGraphicsPanel() {
        return thisGraphicsPanel;
    }
}