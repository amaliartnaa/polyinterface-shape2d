package polyinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Circle implements Geom2D {

    public int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
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
                int diameter = 2 * radius;
                g.fillOval(100, 100, diameter, diameter); // Menggambar lingkaran dengan diameter
            }
        };

        fr.add(pn1);
        fr.setVisible(true);

    }

    @Override
    public String toString() {
        return "This is a circle with radius of length: " + radius;
    }

    @Override
    public void draw(Graphics2D g2d) {
        // Menggambar lingkaran ke dalam BufferedImage menggunakan Graphics2D
        g2d.setColor(Color.RED);
        int diameter = 2 * radius;
        g2d.fillOval(50, 50, diameter, diameter); // Menggambar lingkaran dengan diameter
    }
}
