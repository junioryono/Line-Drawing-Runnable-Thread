package LineDrawing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class LiningPanel extends javax.swing.JPanel {
    private int counter = 0; // Animation counter, or the current number of lines that are be displayed
    private double lines = 15.0; // Total number of lines that will be displayed at the end
    private Color rectangleColors[] = new Color[(int) lines]; // The array that will hold the color of each rectangle

    // This function increases the animation counter. Once the animation is
    // complete, it will change JButton text and set the animation to stopped.
    public void increaseCounter(Animator animator) {
        if (this.counter < lines) {
            this.counter++;
        } else {
            animator.button.setText("Draw");
            animator.setStopped(true);
        }
    }

    // This function restarts the animation counter and resets the previously saved rectangle colors
    public void restartCounter() {
        this.counter = 0;
        rectangleColors = new Color[(int) this.lines];
    }

    // This function paints on the lining panel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth(); // Gets the current width of the panel
        int h = getHeight(); // Gets the current height of the panel

        // Creates an instance of a random number generator
        Random randonNumber = new Random();

        // Draws lines in the panel according to the animation counter
        for (int i = 0; i < counter; i++) {
            int w2 = (int) (i / lines * w);
            int h2 = (int) (i / lines * h);

            Color rectangleColor; // The color of the lines of a rectangle

            // Check if array index exists
            if (this.rectangleColors[i] != null) {
                // If the array index exists, set rectangleColor to the array value
                rectangleColor = this.rectangleColors[i];
            } else {
                // If the array index does not exist, create a new random rectangle color and set it's value inside rectangleColors array
                rectangleColor = new Color(randonNumber.nextFloat(), randonNumber.nextFloat(), randonNumber.nextFloat());
                this.rectangleColors[i] = rectangleColor;
            }

            g.setColor(rectangleColor); // Sets the color of the rectangle lines that will be drawn below

            g.drawLine(0, h2, w2, h); // Draws bottom left lines (given)
            g.drawLine(w2, h, w, h - h2); // Draws bottom right lines
            g.drawLine(w, h - h2, w - w2, 0); // Draws top right lines
            g.drawLine(w - w2, 0, 0, h2); // Draws top left lines
        }
    }
}
