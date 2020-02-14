package Shapes;
import IntDraw.*;
import java.awt.*;

public abstract class Shapes implements IntDraw {
  public Point startCoordinate = new Point();

  public Shapes(int x, int y) {
    startCoordinate.setLocation(x, y);
  }
}