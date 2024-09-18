package polyinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Square implements Geom2D {

	private int side;

	public Square(int side) {
		this.side = side;
	}

	@Override
	public double getArea() {
		return side * side;
	}

	@Override
	public double getPerimeter() {
		return 4 * side;
	}

	@Override
	public void drawIllustration() {

		JFrame fr = new JFrame();
		fr.setBounds(50, 50, 450, 500);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pn1 = new JPanel() {
			@Override
			public void paint(Graphics g) {
				g.setColor(Color.BLUE);
				g.fillRect(100, 100, side, side); // Menggambar persegi
			}
		};

		fr.add(pn1);
		fr.setVisible(true);
	}

	@Override
	public String toString() {
		return "This is a square with sides of length: " + side;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// Menggambar persegi ke dalam objek BufferedImage menggunakan Graphics2D
		g2d.setColor(Color.BLUE);
		g2d.fillRect(50, 50, side, side); // Menggambar persegi di posisi (50, 50)
	}
}
