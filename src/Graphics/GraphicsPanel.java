package Graphics;

import Physics.Particle;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class GraphicsPanel extends JPanel {

    /**Time in milliseconds
     */
    long t = 0;
    /**Delta-time in milliseconds
     */
    double dt;
    Label infoArea = new Label("NAN",Label.LEFT);
    ArrayList<Particle> universe_actors = new ArrayList<>(1);

    public GraphicsPanel() {
        super();
        setSize(900,500);
        setVisible(true);
        universe_actors.add(new Particle(90,90,90));

        infoArea.setLocation(0,0);
        infoArea.setSize(100,infoArea.getHeight());
        infoArea.setBackground(SystemColor.BLACK);
        infoArea.setForeground(SystemColor.WHITE);
        add(infoArea);
    }

    public void paint(Graphics g) {
        g.setColor(SystemColor.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
        for (Particle p : universe_actors) {
            p.paint(g);
        }
        dt = (System.currentTimeMillis()-t)/1000d;
        t = System.currentTimeMillis();
        infoArea.setText("FPS: " + Math.round(1d/dt));
        g.setColor(SystemColor.WHITE);
        infoArea.paint(g);
    }
}
