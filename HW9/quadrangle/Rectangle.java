package quadrangle;

public class Rectangle extends Quadrangle {
    public Rectangle(Point a, Point b, Point c, Point d) throws WrongSideException {
        super(a, b, c, d);
    }

    @Override
    public double findSquare() {
        return findLength(a, b) *
               findLength(c, b);
    }

    @Override
    public double findPerimeter() {
        return 2 * findLength(a, b) +
                2 * findLength(c, b);
    }
}
