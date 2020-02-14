package Square;
import Rectangle.*;
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
} 