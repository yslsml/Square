package line;

import point.Point;

import java.util.Objects;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Line {
    private Point p1;
    private Point p2;

    public Line() {
        this.p1 = new Point(0,0);
        this.p2 = new Point(1,0);
    }

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return getP1().equals(line.getP1()) && getP2().equals(line.getP2());
    }

    @Override
    protected Line clone() throws CloneNotSupportedException {
        Line copy = null;
        try {
            copy = (Line)super.clone();
            copy.p1 = (Point) p1.clone();
            copy.p2 = (Point) p2.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getP1(), getP2());
    }

    @Override
    public String toString() {
        return "\nLine {" +
                "\np1= " + p1 +
                "\np2= " + p2 +
                "\n}";
    }

    public double getLength() {
        return sqrt(pow(p2.getX() - p1.getX(), 2) + pow(p2.getY() - p1.getY(), 2));
    }
}
