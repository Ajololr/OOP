import Shapes.*;
import Ellipse.*;
import Rectangle.*;
import Square.*;
import Triangle.*;
import Circle.*;
import Line.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Frame;
import java.awt.Dimension;

public class lab_1 extends Frame {
  public Line line = new Line(30, 40, 100, 100);
  public Circle circle = new Circle(150, 40, 45);
  public Ellipse ellipse = new Ellipse(300, 40, 200, 100);
  public Rectangle rectangle =new Rectangle(30, 150, 100, 150);
  public Square square = new Square(150, 150, 100);
  public Triangle triangle = new Triangle(300, 200, 100);

  public lab_1() {
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
      System.exit(0);
      }
    });
  }

  public void paint(Graphics g) {
    line.draw(g);
    circle.draw(g);
    ellipse.draw(g);
    rectangle.draw(g);
    square.draw(g);
    triangle.draw(g);
  }

  public static void main(String[] args) {
    lab_1 app = new lab_1();
    app.setSize(new Dimension(640, 480));
    app.setTitle("lab_1");
    app.setVisible(true);
  }
}
