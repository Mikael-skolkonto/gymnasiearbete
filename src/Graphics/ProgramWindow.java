package Graphics;

import com.sun.net.httpserver.Authenticator;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

public class ProgramWindow extends JFrame implements Runnable, WindowListener {

    private GraphicsPanel currentFullscreenPanel;

    public void run() {
        try {
            while (true) {
                currentFullscreenPanel.repaint();
                Thread.sleep(5);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public ProgramWindow() {
        setSize(900,500);
        //setResizable(false);
        setLocationRelativeTo(null);

        setTitle("Dark Matter Simulator");
        Image windowIcon = Toolkit.getDefaultToolkit().getImage("src\\Resources\\IconPicture.png");
        setIconImage(windowIcon);
        setBackground(new Color(0x000000));

        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(this);
    }

    public void addGraphicsPanel() {
        currentFullscreenPanel = new GraphicsPanel();
        if (getContentPane().getComponentCount() > 0) {
            remove(getComponent(0));
        }
        getContentPane().add(currentFullscreenPanel, 0);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window closed");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
