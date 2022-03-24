package square.entity;

import square.exception.BadSquareException;
import square.valid.ValidSquare;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.PI;

import java.util.Objects;

//Методы: задание размеров, растяжение, сжатие, поворот, изменение цвета

public class Square {
    private Sides sides;
    private Color color;

    public Square() {
        sides = new Sides();
        color = Color.BLACK;
    }

    public Square(Sides sides) throws BadSquareException {
        setSides(sides);
        color = Color.BLACK;
    }

    public Square(Sides sides, Color color) throws BadSquareException {
        this(sides);
        this.color = color;
    }

    public Sides getSides() {
        return sides;
    }

    public Color getColor() {
        return color;
    }

    public void setSides(Sides sides) throws BadSquareException {
        if (ValidSquare.isValidSquare(sides)) {
            this.sides = sides;
        }
        else throw new BadSquareException("Square sides are incorrect!");
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSize(double size) {
        Point A = this.sides.getA().getP1();  // top left fixed point
        Point B = new Point(A.getX() + size, A.getY());  // top right point
        Point C = new Point(B.getX(), A.getY() - size);  //bottom right point
        Point D = new Point(A.getX(), A.getY() - size);

        this.sides.setA(new Line(A, B));
        this.sides.setB(new Line(B, C));
        this.sides.setC(new Line(C, D));
        this.sides.setD(new Line(D, A));
    }

    public void stretch(double k) {  // stretching or compression
        double length = this.getSides().getA().length();
        setSize(length * k);
    }

    public void rotate(double alfa) throws BadSquareException {
        // Implementation of the formulas (for 0 <= alfa <= PI):
        // B.x = |AB|*cos(alfa) +- A.x;
        // B.y = |AB|*sin(alfa) -+ A.y;
        // D.x = A.x -+ |AD|*sin(alfa);
        // D.y = A.y -+ |AD|*cos(alfa);
        // C.x = newB.x -+ |CB|*sin(alfa);
        // C.y = newB.y -+ |CB|*cos(alfa);

        double newBx, newBy, newCx, newCy, newDx, newDy;
        Point newA = sides.getA().getP1();  // Point A is fixed

        if ( alfa % (2 * PI) < PI) {
            newBx = sides.getA().length() * cos(alfa) + sides.getA().getP1().getX();
            newBy = sides.getA().length() * sin(alfa) - sides.getA().getP1().getY();
            newDx = sides.getA().getP1().getX() - sides.getD().length() * sin(alfa);
            newDy = sides.getA().getP1().getY() - sides.getD().length() * cos(alfa);
            newCx = newBx - sides.getB().length() * sin(alfa);
            newCy = newBy - sides.getB().length() * cos(alfa);
        }
        else {
            newBx = sides.getA().length() * cos(alfa) - sides.getA().getP1().getX();
            newBy = sides.getA().length() * sin(alfa) + sides.getA().getP1().getY();
            newDx = sides.getA().getP1().getX() + sides.getD().length() * sin(alfa);
            newDy = sides.getA().getP1().getY() + sides.getD().length() * cos(alfa);
            newCx = newBx + sides.getB().length() * sin(alfa);
            newCy = newBy + sides.getB().length() * cos(alfa);
        }

        Line newLineA = new Line(newA, new Point(newBx, newBy));
        Line newLineB = new Line(new Point(newBx, newBy), new Point(newCx, newCy));
        Line newLineC = new Line(new Point(newCx, newCy), new Point(newDx, newDy));
        Line newLineD = new Line(new Point(newDx, newDy), newA);

        Sides newSides = new Sides(newLineA, newLineB, newLineC, newLineD);
        this.setSides(newSides);
    }

    @Override
    protected Square clone() throws CloneNotSupportedException {
        Square copy;
        copy = (Square) super.clone();
        copy.sides = sides.clone();
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return getSides().equals(square.getSides()) && getColor() == square.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSides(), getColor());
    }

    @Override
    public String toString() {
        return "Square {" +
                "sides=" + sides +
                ", color=" + color +
                '}';
    }
}
