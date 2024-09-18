package polyinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rectangle implements Geom2D {

    public int width;
    public int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void drawIllustration() {
        JFrame fr = new JFrame();
        fr.setBounds(10, 10, 500, 500);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pn = new JPanel() {
            @Override
            public void paint(Graphics g) {
                g.setColor(Color.MAGENTA);
                g.fillRect(20, 10, width, height);  // Menggambar persegi panjang
            }
        };
        fr.add(pn);
        fr.setVisible(true);
    }

    @Override
    public String toString() {
        return "This is a rectangle with width: " + width + " and height: " + height;
    }

    @Override
    public void draw(Graphics2D g2d) {
        // Menggambar persegi panjang ke dalam BufferedImage menggunakan Graphics2D
        g2d.setColor(Color.MAGENTA);
        g2d.fillRect(50, 50, width, height);  // Menggambar persegi panjang pada koordinat (50, 50)
    }
}
