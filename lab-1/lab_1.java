import Shape.*;
import Circle.*;
import java.awt.event.*;
import java.awt.*;

public class lab_1 extends Frame {
  public lab_1() {
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
      System.exit(0);
      }
    });
  }

  public static void main(String[] args) {
    lab_1 app = new lab_1();
    app.setSize(new Dimension(640, 480));
    app.setTitle("lab_1");
    app.setVisible(true);
  }
}
