package Graphics;

import javax.swing.JPanel;
import java.awt.*;

public class Panel extends JPanel {
    public void painParticle(int x, int y) {
        getGraphics().setColor(new Color(0));
        getGraphics().fillOval(x,y,5,5);

    }
}
