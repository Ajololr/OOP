package by.androsov;

import by.androsov.Circle.Circle;
import by.androsov.Ellipse.Ellipse;
import by.androsov.Line.Line;
import by.androsov.Rectangle.Rectangle;
import by.androsov.Shapes.Shapes;
import by.androsov.Square.Square;
import by.androsov.Triangle.Triangle;
import by.androsov.creator.Creator;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main extends Frame implements KeyListener, MouseListener {
    private static Map<Integer, Creator> shapesTable;
    private Creator currentCreator;
    private Shapes currentShape;

    public Main() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private static void initTable() {
        shapesTable = new HashMap<>();
        shapesTable.put(KeyEvent.VK_L, (x, y) -> {
            return new Line(x, y, x, y);
        });
        shapesTable.put(KeyEvent.VK_C, (x, y) -> {
            return new Circle(x, y, 0);
        });
        shapesTable.put(KeyEvent.VK_E, (x, y) -> {
            return new Ellipse(x, y, 0, 0);
        });
        shapesTable.put(KeyEvent.VK_R, (x, y) -> {
            return new Rectangle(x, y, 0, 0);
        });
        shapesTable.put(KeyEvent.VK_S, (x, y) -> {
            return new Square(x, y, 0);
        });
        shapesTable.put(KeyEvent.VK_T, (x, y) -> {
            return new Triangle(x, y, 0);
        });
    }

    public static void main(String[] args) {
        var app = new Main();
        app.setSize(new Dimension(640, 480));
        app.setTitle("lab_2");
        app.setVisible(true);
        initTable();
        app.addKeyListener(app);
        app.addMouseListener(app);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {


    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println(keyEvent.getKeyCode());
        currentCreator = shapesTable.get(keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        System.out.println("pres");
        if (currentCreator != null) currentShape = currentCreator.create(mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        System.out.println("rel");
        if (currentShape != null) {
            currentShape.setEndCoordinates(mouseEvent.getX(), mouseEvent.getY());
            currentShape.draw(getGraphics());
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
