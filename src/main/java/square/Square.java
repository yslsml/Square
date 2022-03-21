package square;

import exception.BadSquareException;
import line.Line;
import point.Point;
import valid.ValidSquare;

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
        if (ValidSquare.isValidSquare(sides)) {
            this.sides = sides;
            color = Color.BLACK;
        }
        else throw new BadSquareException("Square sides are incorrect!");
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

    public void setSides(Sides sides) {
        this.sides = sides;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    protected Square clone() throws CloneNotSupportedException {  // добавить
        Square copy = null;
        try {
            copy = (Square) super.clone();
            copy.sides = (Sides) sides.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
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
