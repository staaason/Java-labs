package quadrangle;

public class Rhombus extends Quadrangle {

    public Rhombus(Point a, Point b, Point c, Point d) throws WrongSideException {
        super(a, b, c, d);

    }

    @Override
    public double findSquare() {
        return (double) (findLength(a,c) * findLength(b,d) )/ 2;
    }

    @Override
    public double findPerimeter() {
        return 4 * findLength(a, b);
    }
}
