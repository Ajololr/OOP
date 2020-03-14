package by.androsov.Ellipse;
import by.androsov.Shapes.*;
import java.awt.*;

public class Ellipse extends Shapes {
  private int width;
  private int height;

  public Ellipse(int startX, int startY, int width, int height) {
    super(startX, startY);
    setWidth(width);
    setHeight(height);
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public void draw(Graphics g) {
    g.drawOval(startCoordinate.x, startCoordinate.y, width, height);
  }

  @Override
  public void setEndCoordinates(int x, int y) {
    this.setHeight(Math.abs(this.startCoordinate.y - y));
    this.setWidth(Math.abs(this.startCoordinate.x - x));
    if (x < this.startCoordinate.x) this.startCoordinate.x = x;
    if (y < this.startCoordinate.y) this.startCoordinate.y = y;
  }
}