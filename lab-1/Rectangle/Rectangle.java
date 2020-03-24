package Rectangle;
import Shapes.*;
import java.awt.*;

public class Rectangle extends Shapes {
  private int width;
  private int height;

  public Rectangle(int startX, int startY, int width, int height) {
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
    g.drawRect(startCoordinate.x, startCoordinate.y, width, height);
  }
} 