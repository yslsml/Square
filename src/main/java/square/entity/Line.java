package square.entity;

import java.util.Objects;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Line implements Cloneable {
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
    public Line clone() throws CloneNotSupportedException {
        Line copy;
        copy = (Line)super.clone();
        copy.p1 = p1.clone();
        copy.p2 = p2.clone();
        return copy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getP1(), getP2());
    }

    @Override
    public String toString() {
        return "\n Line {" +
                "\n p1 = " + p1.toString() +
                "\n p2 = " + p2.toString() +
                "\n }";
    }

    public double length() {
        return sqrt(pow(p2.getX() - p1.getX(), 2) + pow(p2.getY() - p1.getY(), 2));
    }

    public boolean isPerpendicular(Line l) {
        double x1 = this.p2.getX() - this.p1.getX();
        double y1 = this.p2.getY() - this.p1.getY();
        double x2 = l.p2.getX() - l.p1.getX();
        double y2 = l.p2.getY() - l.p1.getY();

        return (x1*x2 + y1*y2) == 0;
    }
}
