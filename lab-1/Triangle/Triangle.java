package Triangle;
import Shapes.*;
import java.awt.*;

public class Triangle extends Shapes {
  private int length;

  public Triangle(int startX, int startY, int length) {
    super(startX, startY);
    setLength(length);
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public void draw(Graphics g) {
    int x[] = {startCoordinate.x, startCoordinate.x + length / 2, startCoordinate.x + length};
    int y[] = {startCoordinate.y, startCoordinate.y - length / 2, startCoordinate.y};
    g.drawPolygon(x, y, 3);
  }
} 