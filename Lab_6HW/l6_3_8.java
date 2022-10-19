import com.quadrangle.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class l6_3_8 {
    public static boolean checkRectangle(Quadrangle quadrangle){
        double angleA = quadrangle.angle(quadrangle.a, quadrangle.b, quadrangle.c);
        double angleB = quadrangle.angle(quadrangle.b,quadrangle.c,quadrangle.d);
        double angleC = quadrangle.angle(quadrangle.b, quadrangle.a, quadrangle.d);
        double angleD = quadrangle.angle(quadrangle.a, quadrangle.d, quadrangle.c);
        return quadrangle.feq(angleA, 90) && quadrangle.feq(angleB, 90) && quadrangle.feq(angleC, 90)
                && quadrangle.feq(angleD, 90);
    }

public static boolean checkSquare(Quadrangle quadrangle){
    double firstLength = quadrangle.findLength(quadrangle.a, quadrangle.b);;
    double secondLength = quadrangle.findLength(quadrangle.b, quadrangle.c);
    double thirdLength = quadrangle.findLength(quadrangle.c, quadrangle.d);
    double fourthLength = quadrangle.findLength(quadrangle.a, quadrangle.d);
    return checkRectangle(quadrangle) && quadrangle.feq(firstLength, secondLength)
            && quadrangle.feq(firstLength, thirdLength) && quadrangle.feq(firstLength, fourthLength);
}

public static boolean checkRhombus(Quadrangle quadrangle){
    double firstLength = quadrangle.findLength(quadrangle.a, quadrangle.b);
    double secondLength = quadrangle.findLength(quadrangle.b, quadrangle.c);
    double thirdLength = quadrangle.findLength(quadrangle.c, quadrangle.d);
    double fourthLength = quadrangle.findLength(quadrangle.a, quadrangle.d);
    return quadrangle.feq(firstLength, secondLength) && quadrangle.feq(firstLength, thirdLength)
            && quadrangle.feq(firstLength, fourthLength)
            && quadrangle.IsParallel(quadrangle.a, quadrangle.d, quadrangle.b, quadrangle.c)
            && quadrangle.IsParallel(quadrangle.a, quadrangle.b, quadrangle.c, quadrangle.d);
 }


    public static <T extends Quadrangle>  double findMin(List<T> arr, String type){
        if(Objects.equals(type, "area")){
            double min = arr.get(0).findSquare();
            int n = arr.size();
            for (int i = 1; i < n; i++) {
                if (arr.get(i).findSquare() < min) {
                    min = arr.get(i).findSquare();
                }
            }
            return min;
        }else if(Objects.equals(type, "perimeter")){
            double min = arr.get(0).findPerimeter();
            int n = arr.size();
            for (int i = 1; i < n; i++) {
                if (arr.get(i).findPerimeter() < min) {
                    min = arr.get(i).findPerimeter();
                }
            }
            return min;
        }
        return 0;
    }

    public static <T extends Quadrangle> double findMax(List<T> arr, String type){
        if(Objects.equals(type, "area")){
            double max = arr.get(0).findSquare();
            int n = arr.size();
            for (int i = 1; i < n; i++) {
                if (arr.get(i).findSquare() > max) {
                    max = arr.get(i).findSquare();
                }
            }
            return max;
        }else if(Objects.equals(type, "perimeter")){
            double max = arr.get(0).findPerimeter();
            int n = arr.size();
            for (int i = 1; i < n; i++) {
                if (arr.get(i).findSquare() > max) {
                    max = arr.get(i).findPerimeter();
                }
            }
            return max;
        }
        return 0;
    }
    public static List<Quadrangle> generateArr(){
        return new ArrayList<>() {
            {
                add(new Quadrangle(new Point(4, 5), new Point(6, 5), new Point(6, 7),
                        new Point(4, 7)));
                add(new Quadrangle(new Point(-8, 1), new Point(-5, 1), new Point(-4, 4),
                        new Point(-7, 4)));
                add(new Quadrangle(new Point(-4, 0), new Point(0, -5), new Point(4, 0),
                        new Point(0, 5)));
                add(new Quadrangle(new Point(2, 2), new Point(10, 2), new Point(10, 6),
                        new Point(2, 6)));
                add(new Quadrangle(new Point(2, 2), new Point(8, 2), new Point(8, 6),
                        new Point(2, 6)));
                add(new Quadrangle(new Point(2, 2), new Point(6, 2), new Point(6, 6),
                        new Point(2, 6)));
                add(new Quadrangle(new Point(-2.7987881748301375, 0.0), new Point(0.0, 9.564316634449014),
                        new Point(2.7987881748301375, 0.0), new Point(0.0, -9.564316634449014)));
            }
        };
    }

    public static void main(String[] args){
        List<Quadrangle> quadrangles = generateArr();
        List<Square> squareList = new ArrayList<>();
        List<Rectangle> rectangles = new ArrayList<>();
        List<Rhombus> rhombuses = new ArrayList<>();
        List<Quadrangle> anyQuadrangles = new ArrayList<>();
        for(Quadrangle quadrangle : quadrangles){
            if(checkSquare(quadrangle)){
                squareList.add(new Square(quadrangle.a, quadrangle.b, quadrangle.c, quadrangle.d));
            }else if(checkRectangle(quadrangle)){
                rectangles.add(new Rectangle(quadrangle.a, quadrangle.b, quadrangle.c, quadrangle.d));
            }else if(checkRhombus(quadrangle)){
                rhombuses.add(new Rhombus(quadrangle.a, quadrangle.b, quadrangle.c, quadrangle.d));
            }else{
                anyQuadrangles.add(quadrangle);
            }
        }
        String area = "area";
        String perimeter = "perimeter";
        System.out.printf("Max area of %d squares:  %f and min area: %f \n", squareList.size(), findMax(squareList, area),
                findMin(squareList, area));
        System.out.printf("Max area of %d rectangles:  %f and min area: %f \n", rectangles.size(),
                findMax(rectangles, area),
                findMin(rectangles, area));
        System.out.printf("Max area of %d rhombuses:  %f and min area: %f \n", rhombuses.size(), findMax(rhombuses, area),
                findMin(rhombuses, area));
        System.out.printf("Max area  of %d any quadrangles:  %f and min area: %f \n", anyQuadrangles.size(),
                findMax(anyQuadrangles, area),
                findMin(anyQuadrangles, area));

        System.out.printf("Max perimeter of %d squares:  %f and min perimeter: %f \n", squareList.size(),
                findMax(squareList, perimeter), findMin(squareList, perimeter));
        System.out.printf("Max perimeter of %d rectangles:  %f and min perimeter: %f \n", rectangles.size(),
                findMax(rectangles, perimeter), findMin(rectangles, perimeter));
        System.out.printf("Max perimeter of %d rhombuses:  %f and min perimeter: %f \n", rhombuses.size(),
                findMax(rhombuses, perimeter), findMin(rhombuses, perimeter));
        System.out.printf("Max perimeter  of %d any quadrangles:  %f and min perimeter: %f \n", anyQuadrangles.size(),
                findMax(anyQuadrangles, perimeter),
                findMin(anyQuadrangles, perimeter));
    }
}
