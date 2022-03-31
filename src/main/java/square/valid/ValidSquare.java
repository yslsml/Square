package square.valid;


import square.entity.Sides;

import static java.lang.Math.abs;

public class ValidSquare {

    public static boolean isValidSquare(Sides sides) {
        if(sides.getA().isPerpendicular(sides.getB()) && sides.getC().isPerpendicular(sides.getD())) {
            return abs(sides.getA().length() - sides.getB().length()) < 0.01;
        }
        return false;
    }
}
