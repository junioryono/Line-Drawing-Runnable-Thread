package LineDrawing;

import javax.swing.*;

// Creates a thread that holds all of the panel components
public class Animator implements Runnable {
    private LiningPanel dpanel; // The panel that will be drawn on
    private boolean stopped = true; // Indicates whether the animation is active or not
    public JButton button = new JButton("Draw"); // Creates a button with default value of Draw

    // This constructor initializes the drawing panel
    public Animator(LiningPanel panel) {
        dpanel = panel;
    }

    // This function creates the animator thread
    public void run() {
        // Prevents thread from terminating
        while (true) {
            // Check if the animator is active
            if (!this.stopped) {
                dpanel.repaint(); // Redraw the entire panel
                dpanel.increaseCounter(this); // Increments the number of rectangles in the panel
            }

            // Prevents thread from terminating
            // Also sets the interval that each rectangle is drawn to 300ms
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Sets the animation status to the boolean paramater
    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
