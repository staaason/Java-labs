package QuadraticEquation;

public class QuadraticEquation {
    private double x1;
    private double x2;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public QuadraticEquation() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public void setEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double discriminant() throws DiscriminantEqnException {
        double d = b*b - 4*a*b;

        if (d < 0) {
            throw new DiscriminantEqnException("Oi!", a, b, c, d);
        }
        return d;
    }

    public void solution() throws  SqrEqnException {
        try {
            if (a == 0) throw new SqrEqnException("Main member is 0.");

            double d = discriminant();
            double x1 = (-b - Math.sqrt(d))/(2*a);
            double x2 = (-b + Math.sqrt(d))/(2*a);

            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
            this.x1 = x1;
            this.x2 = x2;

        } catch (SqrEqnException e) {
            System.out.println(e.getMessage());
            throw new SqrEqnException("Division by 0.");
        }
    }

    public void printRoots() {
        System.out.println("Roots: x1 = " + x1 + ", x2 = " + x2);
    }


    private double a;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    private double b;
    private double c;

}
