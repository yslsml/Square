package squaretest.entity;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import square.entity.*;
import square.exception.BadSquareException;

public class SquareTest {

    @BeforeMethod
    public Square setUp() throws BadSquareException {
        Line a = new Line(new Point(1,4), new Point(4,4));
        Line b = new Line(new Point(4,4), new Point(4,1));
        Line c = new Line(new Point(4,1), new Point(1,1));
        Line d = new Line(new Point(1,1), new Point(1,4));
        Sides sides = new Sides(a,b,c,d);
        Square sq = new Square(sides, Color.BLACK);
        return sq;
    }

    @Test
    public void testSetColor() throws BadSquareException {
        Square sq = setUp();
        sq.setColor(Color.RED);
        Color actual = sq.getColor();
        Color expected = Color.RED;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSetSize() throws BadSquareException {
        Square actual = setUp();
        actual.setSize(6);
        Square expected = new Square(new Point(1,4), new Point(7,4), new Point(7,-2), new Point(1,-2));
        Assert.assertEquals(actual, expected);
    }

}
