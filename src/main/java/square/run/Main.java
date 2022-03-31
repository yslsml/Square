package square.run;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import square.entity.Color;
import square.entity.Point;
import square.entity.Square;
import square.exception.BadSquareException;

public class Main {
    static Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            Square sq1 = new Square(new Point(1,4),new Point(4,4),new Point(4,1), new Point(1,1));
            log.log(Level.INFO, sq1);

            sq1.stretch(2);  // растяжение в 2 раза
            log.log(Level.INFO, sq1);

            sq1.setColor(Color.BLUE);
            log.log(Level.INFO, sq1.getColor());

            sq1.rotate(Math.PI/3);
            log.log(Level.INFO, sq1);


        } catch (BadSquareException e) {
            e.printStackTrace();
        }
    }
}
