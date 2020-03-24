package Circle;
import Ellipse.*;
import java.awt.*;

public class Circle extends Ellipse {
  public Circle(int startX, int startY, int radius) {
    super(startX, startY, radius * 2, radius * 2);
  }

  public int getRadius() {
    return super.getWidth();
  }

  public void setRadius(int radius) {
    super.setWidth(radius);
    super.setHeight(radius);
  }

  public void draw(Graphics g) {
    super.draw(g);
  }
} 