package com.quadrangle;

public  class Quadrangle {
    public Point a, b, c, d;
    static final double SMALL_NUMBER = 1.0E-6;
    public double diagonal1, diagonal2;

    public double angle(Point a_, Point b_, Point c_){
        double firstLength = findLength(a_, b_);
        double secondLength= findLength(b_, c_);
        double diagonal = findLength( a_, c_);
        double d= -((Math.pow((diagonal), 2) - Math.pow((secondLength), 2) - Math.pow((firstLength), 2)) /
                (2 * firstLength * secondLength));
        double radianAngle = Math.acos(d);
        return Math.toDegrees(radianAngle);

    }
     public boolean feq(double x, double y){
        return (Math.abs(x-y) < SMALL_NUMBER);
    }

    public boolean IsParallel(Point a_, Point b_, Point c_, Point d_) {
        if (feq(a_.x - b_.x ,0) && feq(c_.x - d_.x , 0)) {
            return true;
        }
        else return feq((a_.y - b_.y) / (a_.x - b_.x), (d_.y - c_.y) / (d_.x - c_.x));
    }
    public Quadrangle(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        diagonal1 = findLength(a, c);
        diagonal2 = findLength(b, d);

    }

    public double findLength(Point a1, Point a2){
        return Math.sqrt(Math.pow(a2.x - a1.x, 2) + Math.pow(a2.y - a1.y, 2));
    }

    public double findSquare() {
        return 0.25 * Math.sqrt( 4 * Math.pow(findLength(a,c), 2) * Math.pow(findLength(b,d), 2) -
                Math.pow(Math.pow(findLength(a, b), 2) + Math.pow(findLength(c,d), 2) - Math.pow(findLength(b, c), 2) -
                        Math.pow(findLength(d, a), 2),2));
    }

    public double findPerimeter() {
        return findLength(a, b) + findLength(b, c) + findLength(c, d) + findLength(d, a);
    }


}
