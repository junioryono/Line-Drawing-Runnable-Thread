package LineDrawing;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class LineDrawingTest {

  public static void main(String[] args) {
    JFrame application = new JFrame(); // Creates a Java Frame
    LiningPanel panel = new LiningPanel(); // Creates the drawing panel that will be animated
    Animator animator = new Animator(panel); // Creates instance of Animator class

    animator.button.addActionListener(e -> {
      String command = e.getActionCommand();
      if (command == "Draw") {
        panel.restartCounter(); // Resets the Lining Panel animation counter
        animator.setStopped(false); // Starts the animation
        animator.button.setText("Stop"); // Sets the button text to Stop
      } else if (command == "Resume") {
        animator.setStopped(false); // Resumes the animation
        animator.button.setText("Stop"); // Sets the button text to Stop
      } else if (command == "Stop") {
        animator.setStopped(true); // Stops the animation
        animator.button.setText("Resume"); // Sets the button text to Resume
      }
    });

    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminates the application after clicking the close button
    application.getContentPane().add(animator.button, BorderLayout.NORTH); // Adds the animator button to the top of the application
    application.add(panel); // Adds the drawing panel to the application
    application.setSize(300, 300); // Sets the default size of the application
    application.setTitle("Lining Art"); // Sets the application title
    application.setVisible(true); // Makes the application visible to the user

    animator.run(); // Starts the Animator thread
  }
}
