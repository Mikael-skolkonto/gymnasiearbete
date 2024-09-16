package Physics;

import java.awt.Color;
import java.awt.Graphics;

public class Particle {

    /**The position-vector with elements x, y, z
     */
    private int[] pos3D = new int[3];

    /**The velocity-vector with elements x, y, z
     */
    private int[] velocity3D = new int[3];

    /**The mass which is needed for physics calculations.
     */
    private final int mass;

    /**The radius which is needed every time the particle is painted.
     */
    private final int r;

    private static final Color particleColor = new Color(0xC90707);

    /**Constructs particle with coordinates 0,0,0 and mass 50 (arbitrary unit)
     */
    public Particle() {
        this(0,0,0);
    }

    /**Constructs particle with default mass 50 (arbitrary unit)
     */
    public Particle(int x, int y, int z) {
        this(x,y,z,50);
    }

    /**Constructs particle with all specified properties.
     */
    public Particle(int x, int y, int z, int m) {
        pos3D[0] = x;
        pos3D[1] = y;
        pos3D[2] = z;
        mass = m;
        r = 4 * (int) Math.round(Math.cbrt(mass));
        velocity3D[0] = 10;
        velocity3D[1] = 5;
    }

    public void paint(Graphics g) {
        physicsStep(g);
        g.setColor(particleColor);
        g.fillOval(pos3D[0]-r,pos3D[1]-r,2*r,2*r);
    }

    private void physicsStep(Graphics g) {
        if (pos3D[0] >= g.getClip().getBounds().width - r || pos3D[0] <= r) {
            velocity3D[0] = -velocity3D[0];
        }
        if (pos3D[1] >= g.getClip().getBounds().height - r || pos3D[1] <= r) {
            velocity3D[1] = -velocity3D[1];
        }
        pos3D[0] += velocity3D[0];
        pos3D[1] += velocity3D[1];
        pos3D[2] += velocity3D[2];
    }
}
