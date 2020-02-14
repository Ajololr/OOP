package Circle;
import Shape.*;

public class Circle extends Shape {
  private int radius;

  public Circle(int radius) {
    setRadius(radius);
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public void draw() {
    System.out.println("Circle");
  }
} 