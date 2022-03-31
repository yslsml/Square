package squaretest.valid;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import square.entity.Line;
import square.entity.Point;
import square.entity.Sides;
import square.entity.Square;
import square.exception.BadSquareException;
import square.valid.ValidSquare;

public class ValidSquareTest {
    static Logger log = LogManager.getLogger();

    @Test
    public void testIsValidSquarePositive() throws BadSquareException {
        Line a = new Line(new Point(1,4), new Point(4,4));
        Line b = new Line(new Point(4,4), new Point(4,1));
        Line c = new Line(new Point(4,1), new Point(1,1));
        Line d = new Line(new Point(1,1), new Point(1,4));
        Sides sides = new Sides(a,b,c,d);
        boolean actual = ValidSquare.isValidSquare(sides);
        boolean expected = true;
        //Square sq = new Square(sides);
        //log.log(Level.INFO, sq);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testIsValidSquareNegative() {
        Line a = new Line(new Point(1,4), new Point(4,4));
        Line b = new Line(new Point(4,4), new Point(3,2));
        Line c = new Line(new Point(3,2), new Point(1,1));
        Line d = new Line(new Point(1,1), new Point(1,4));
        Sides sides = new Sides(a,b,c,d);
        boolean actual = ValidSquare.isValidSquare(sides);
        boolean expected = true;
        Assert.assertNotEquals(actual, expected);
    }
}
