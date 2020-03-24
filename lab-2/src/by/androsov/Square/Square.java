package by.androsov.Square;
import by.androsov.Rectangle.Rectangle;
import java.awt.Graphics;

public class Square extends Rectangle {
  public Square(int startX, int startY, int length) {
    super(startX, startY, length, length);
  }

  public int getLength() {
    return super.getWidth();
  }

  public void setLength(int length) {
    super.setWidth(length);
    super.setHeight(length);
  }

  public void draw(Graphics g) {
    super.draw(g);
  }

  @Override
  public void setEndCoordinates(int x, int y) {
    this.setLength(Math.abs(this.startCoordinate.y - y) > Math.abs(this.startCoordinate.x - x) ? Math.abs(this.startCoordinate.y - y) : Math.abs(this.startCoordinate.x - x));
    if (x < this.startCoordinate.x) this.startCoordinate.x = x;
    if (y < this.startCoordinate.y) this.startCoordinate.y = y;
  }
}