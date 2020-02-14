package Circle;
import Shapes.*;
import java.awt.*;

public class Circle extends Shapes {
  private int radius;

  public Circle(int startX, int startY, int radius) {
    super(startX, startY);
    setRadius(radius);
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public void draw(Graphics g) {
    g.drawOval(startCoordinate.x, startCoordinate.y, radius, radius);
  }
} 