import Student.*;

import java.util.ArrayList;
import java.util.List;

public class l8_7_2 {
    public static void main(String[] args){
        List<String> marks = new ArrayList<>(){
            {
             add("2");
             add("3");
             add("1");
             add("15");
            }
        };
        Student student = new PartTimeStudent("John", marks);
        System.out.println(student);
        System.out.println(student.getName());
        System.out.println(student.getMarks());
    }
}
