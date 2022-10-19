package com.quadrangle;


public class Square extends Quadrangle {
    public Square(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
    }

    @Override
    public double findSquare() {
        return findLength(a, b);
    }

    @Override
    public double findPerimeter() {
        return 4 * findLength(a, b);
    }
}



