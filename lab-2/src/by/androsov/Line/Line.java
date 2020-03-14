package by.androsov.Line;
import by.androsov.Shapes.Shapes;
import java.awt.*;

public class Line extends Shapes {
  private Point endCoordinate = new Point();

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

  @Override
  public void setEndCoordinates(int x, int y) {
    this.setEndCoordinate(x, y);
  }
}