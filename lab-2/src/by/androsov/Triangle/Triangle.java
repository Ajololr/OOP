package by.androsov.Triangle;
import by.androsov.Shapes.Shapes;
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
    int x[] = {startCoordinate.x, startCoordinate.x + length, startCoordinate.x + length};
    int y[] = {startCoordinate.y, startCoordinate.y - length, startCoordinate.y};
    g.drawPolygon(x, y, 3);
  }

  @Override
  public void setEndCoordinates(int x, int y) {
    this.setLength(this.startCoordinate.y - y);
  }
}