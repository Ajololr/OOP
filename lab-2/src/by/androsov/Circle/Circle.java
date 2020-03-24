package by.androsov.Circle;


import by.androsov.Ellipse.*;

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

  @Override
  public void setEndCoordinates(int x, int y) {
    this.setRadius(Math.abs(this.startCoordinate.y - y) > Math.abs(this.startCoordinate.x - x) ? Math.abs(this.startCoordinate.y - y) : Math.abs(this.startCoordinate.x - x));
    if (x < this.startCoordinate.x) this.startCoordinate.x = x;
    if (y < this.startCoordinate.y) this.startCoordinate.y = y;
  }
} 