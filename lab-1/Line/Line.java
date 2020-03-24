package Line;
import Shapes.*;
import java.awt.*;

public class Line extends Shapes {
  public Point endCoordinate = new Point();

  public Line(int startX, int startY, int endX, int endY) {
    super(startX, startY);
    setEndCoordinate(endX, endY);
  }

  public void setEndCoordinate(int endX, int endY) {
    endCoordinate.setLocation(endX, endY);
  }

  public void draw(Graphics g) {
    g.drawLine(startCoordinate.x, startCoordinate.y, endCoordinate.x, endCoordinate.y);
  }
} 