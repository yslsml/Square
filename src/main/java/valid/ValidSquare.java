package valid;


import square.Sides;

public class ValidSquare {

    public static boolean isValidSquare(Sides sides) {
        if(sides.getA().isPerpendicular(sides.getB()) && sides.getC().isPerpendicular(sides.getD())) {
            return sides.getA().length() == sides.getB().length();
        }
        return false;
    }
}
