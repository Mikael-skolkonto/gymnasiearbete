package Graphics;

import com.sun.net.httpserver.Authenticator;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class ProgramWindow extends JFrame implements Runnable, WindowStateListener {

    private GraphicsPanel currentFullscreenPanel;

    public void run() {
        try {
            while (true) {
                currentFullscreenPanel.repaint();
                Thread.sleep(1);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public ProgramWindow() {
        setSize(900,500);
        setLocationRelativeTo(null);

        setTitle("Dark Matter Simulator");
        Image windowIcon = Toolkit.getDefaultToolkit().getImage("src\\Resources\\IconPicture.png");
        setIconImage(windowIcon);
        setBackground(new Color(0x000000));

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowStateListener(this);
    }

    public void addGraphicsPanel() {
        currentFullscreenPanel = new GraphicsPanel();
        if (getContentPane().getComponentCount() > 0) {
            remove(getComponent(0));
        }
        getContentPane().add(currentFullscreenPanel, 0);
    }

    public void windowStateChanged(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.out.println("Window thread closed");
            System.exit(0);
        }
        System.out.println("Event heard but missed the if-block");
    }
}
