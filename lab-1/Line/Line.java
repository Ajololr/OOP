package Line;
import Shape.*;

public class Line extends Shape {
  private int starX, startY, endX, endY;

  public Line(int starX, int startY, int endX, int endY) {
    setCoordinates(starX, startY, endX, endY);
  }

  public int[] getCoordinates() {
    int coordinates[] = {starX, startY, endX, endY}; 
    return coordinates;
  }

  public void setCoordinates(int starX, int startY, int endX, int endY) {
    this.starX = starX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
  }

  public void draw() {
    System.out.println("Line");
  }
} 