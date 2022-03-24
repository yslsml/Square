package square.entity;

import java.util.Objects;

public class Sides {
    private Line a;  // top side
    private Line b;  // right side
    private Line c;  // bottom side
    private Line d;  // left side

    public Sides() {
        this.a = new Line(new Point(0, 1), new Point(1,1));
        this.b = new Line(new Point(1, 1), new Point(1,0));
        this.c = new Line(new Point(1, 0), new Point(0,0));
        this.d = new Line(new Point(0, 0), new Point(0,1));
    }

    public Sides(Line a, Line b, Line c, Line d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Line getA() {
        return a;
    }

    public Line getB() {
        return b;
    }

    public Line getC() {
        return c;
    }

    public Line getD() {
        return d;
    }

    public void setA(Line a) {
        this.a = a;
    }

    public void setB(Line b) {
        this.b = b;
    }

    public void setC(Line c) {
        this.c = c;
    }

    public void setD(Line d) {
        this.d = d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sides sides = (Sides) o;
        return getA().equals(sides.getA()) &&
                getB().equals(sides.getB()) &&
                getC().equals(sides.getC()) &&
                getD().equals(sides.getD());
    }

    @Override
    protected Sides clone() throws CloneNotSupportedException {
        Sides copy;
        copy = (Sides) super.clone();
        copy.a = a.clone();
        copy.b = b.clone();
        copy.c = c.clone();
        copy.d = d.clone();
        return copy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA(), getB(), getC(), getD());
    }

    @Override
    public String toString() {
        return "\n{" +
                "\n a = " + a.toString() +
                "\n b = " + b.toString() +
                "\n c = " + c.toString() +
                "\n d = " + d.toString() +
                "\n}";
    }
}
