package Circle;
import Shape.*;

public class Circle extends Shape {
  private int radius;

  public Circle(int radius) {
    getRadius(radius);
  }

  public int getRadius() {
    return radius;
  }

  public void getRadius(int radius) {
    this.radius = radius;
  }

  public void draw() {
    System.out.println('x');
  }
} 