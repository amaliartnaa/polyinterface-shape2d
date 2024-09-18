package polyinterface;

import java.awt.Graphics2D;

interface Geom2D {

    double getArea();
    double getPerimeter();
    void drawIllustration();
    void draw(Graphics2D g2d);
}
