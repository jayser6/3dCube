package cube;

import processing.core.PApplet;
import java.awt.Color;

public class DrawingSurface extends PApplet {

	private final int WIDTH = 800, HEIGHT = 600, xLoc = -400, yLoc = -300;
	private final float rate = 0.1f;

	private final Color red = new Color(255, 0, 0), blue = new Color(0, 0, 255), green = new Color(0, 255, 0),
			yellow = new Color(255, 255, 0), orange = new Color(255, 165, 0),
			white = new Color(255, 255, 255), nonVisible = new Color(0, 0, 0, 0);

	private float x, y;

	public DrawingSurface() {

	}

	@Override
	public void settings() {
		size(WIDTH, HEIGHT, P3D);
	}

	@Override
	public void setup() {

	}

	@Override
	public void mouseDragged() {
		if (mousePressed) {
			y += (mouseX - pmouseX) * rate;
			x += (pmouseY - mouseY) * rate;
		}
	}

	public void multiColoredBox(Color f1, Color f2, Color f3, Color f4, Color f5, Color f6, float x, float y,
			float z) {
		pushStyle();
		pushMatrix();
		translate(x, y, z);
		noStroke();
		scale(45);
		beginShape(QUADS);
		fill(f1.getRGB());
		vertex(-1, -1, 1);
		vertex(1, -1, 1);
		vertex(1, 1, 1);
		vertex(-1, 1, 1);
		endShape();

		beginShape(QUADS);
		fill(f2.getRGB());
		vertex(1, -1, -1);
		vertex(-1, -1, -1);
		vertex(-1, 1, -1);
		vertex(1, 1, -1);
		endShape();
		beginShape(QUADS);
		fill(f3.getRGB());
		vertex(-1, 1, 1);
		vertex(1, 1, 1);
		vertex(1, 1, -1);
		vertex(-1, 1, -1);
		endShape();
		beginShape(QUADS);
		fill(f4.getRGB());
		vertex(-1, -1, -1);
		vertex(1, -1, -1);
		vertex(1, -1, 1);
		vertex(-1, -1, 1);
		endShape();

		beginShape(QUADS);
		fill(f5.getRGB());
		vertex(1, -1, 1);
		vertex(1, -1, -1);
		vertex(1, 1, -1);
		vertex(1, 1, 1);
		endShape();

		beginShape(QUADS);
		fill(f6.getRGB());
		vertex(-1, -1, -1);
		vertex(-1, -1, 1);
		vertex(-1, 1, 1);
		vertex(-1, 1, -1);
		endShape();

		popStyle();
		popMatrix();
	}

	@Override
	public void draw() {
		rotateX(this.x);
		rotateY(this.y);

		// Top Left Section
		multiColoredBox(red, nonVisible, nonVisible, blue, nonVisible, green, -xLoc, -yLoc, 0);
		multiColoredBox(nonVisible, white, nonVisible, blue, nonVisible, green, -xLoc, -yLoc, -95);

		// Top Right Section
		multiColoredBox(red, nonVisible, nonVisible, blue, yellow, nonVisible, 10, -yLoc, 0);
		multiColoredBox(nonVisible, white, nonVisible, blue, yellow, nonVisible, 10, -yLoc, -95);

		// Bottom Left Section
		multiColoredBox(red, nonVisible, orange, nonVisible, nonVisible, green, -xLoc, 10, 0);
		multiColoredBox(nonVisible, white, orange, nonVisible, nonVisible, green, -yLoc, 10, -95);

		// Bottom Right Section
		multiColoredBox(red, nonVisible, orange, nonVisible, yellow, nonVisible, 10, 10, 0);
		multiColoredBox(nonVisible, white, orange, nonVisible, yellow, nonVisible, 10, 10, -95);

	}

}