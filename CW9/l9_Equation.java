import QuadraticEquation.QuadraticEquation;
import QuadraticEquation.IOTool;
import QuadraticEquation.DiscriminantEqnException;
import QuadraticEquation.SqrEqnException;
import java.util.InputMismatchException;

public class l9_Equation {
    public static void main(String[] args){
        double a, b, c;

        IOTool io = new IOTool();

        try {
            QuadraticEquation qadr1 = new QuadraticEquation(2, -6, 4);
            qadr1.solution();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        try {
            QuadraticEquation qadr2 = new QuadraticEquation(1, 2, 3);
            qadr2.solution();
        } catch (DiscriminantEqnException e) {
            e.printStackTrace();
        }

        try {
            QuadraticEquation qadr3 = new QuadraticEquation(0, 2, 3);
            qadr3.solution();
        } catch (SqrEqnException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Input a, b, c:");
            a = io.readDouble();
            b = io.readDouble();
            c = io.readDouble();

            QuadraticEquation qadr = new QuadraticEquation(a, b, c);
            qadr.solution();
            qadr.printRoots();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }
}
