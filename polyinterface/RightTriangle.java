package polyinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RightTriangle implements Geom2D {

    public int base;
    public int height;

    public RightTriangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public double getPerimeter() {
        double hypotenuse = Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
        return base + height + hypotenuse;
    }

    @Override
    public void drawIllustration() {

        JFrame fr = new JFrame();
        fr.setBounds(50, 50, 450, 500);
        fr.setDefaultCloseOperation(3);

        JPanel pn1 = new JPanel() {
            @Override
            public void paint(Graphics g) {
                g.setColor(Color.RED);

                // Menggambar segitiga siku-siku di JFrame
                int[] xPoints = {100, 100, 100 + base};
                int[] yPoints = {100, 100 + height, 100 + height};
                g.fillPolygon(xPoints, yPoints, 3);
            }
        };

        fr.add(pn1);
        fr.setVisible(true);
    }

    @Override
    public String toString() {
        return "This is a Right Triangle with base: " + base + " and height: " + height;
    }

    @Override
    public void draw(Graphics2D g2d) {
        // Menggambar segitiga siku-siku ke dalam BufferedImage menggunakan Graphics2D
        g2d.setColor(Color.RED);

        // Titik koordinat untuk segitiga siku-siku
        int[] xPoints = {50, 50, 50 + base};
        int[] yPoints = {50, 50 + height, 50 + height};
        g2d.fillPolygon(xPoints, yPoints, 3);
    }
}
