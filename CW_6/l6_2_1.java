import com.student.Student;

import java.util.*;

public class l6_2_1 {

    static List<Student> findStudentsByFac(List<Student> arr, String fac){
        List<Student> temp = new ArrayList<>();
        for(Student student: arr){
            if(fac.equals(student.getFac())){
                temp.add(student);
            }
        }
        return temp;
    }

    static  List<Student> findStudentsByGroup(List<Student> arr, String group){
        List<Student> temp = new ArrayList<>();
        for(Student student: arr){
            if(group.equals(student.getGroup())){
                temp.add(student);
            }
        }
        return temp;
    }


    static List<Student> getStudentsByYear(List<Student> arr, String year){
        List<Student> temp = new ArrayList<>();
        for(Student student: arr){
            if(student.getYear() > Integer.parseInt(year)){
                temp.add(student);
            }
        }
        return temp;
    }

    static public void printList(List<Student> arr){
        for(Student student: arr){
            System.out.println(student);
        }
    }

    public static void main(String[] args){
        List<Student> arr = new ArrayList<>(){
            {
                add(new Student(1, "Name2", "Surname2", "Patronymic2","18.02.2005",
                        "Address2","2","Faculty2", "1","1"));
                add(new Student(2, "Name3", "Surname3", "Patronymic3","09.09.2002",
                        "Address3","3","Faculty3", "4","2"));
                add(new Student(3, "Name4", "Surname4", "Patronymic4","15.11.2005",
                        "Address4","4","Faculty2", "1","1"));
                add(new Student(4, "Name5", "Surname5", "Patronymic5","01.01.2004",
                        "Address5","5","MMF", "2","2"));
            }
        };
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть факультет, список студентів якого ви хочете отримати: ");
        String fac = sc.nextLine();

        System.out.println("\nСтуденти, що навчаються на цьому факультеті: ");
        printList(findStudentsByFac(arr, fac));
        System.out.println('\n');
        Set<String> faculties = new HashSet<String>();
        Set<String> years = new HashSet<String>();
        for(Student student: arr){
            faculties.add(student.getFac());
            years.add(student.getCourse());
        }
        for(String faculty: faculties){
            System.out.printf("Список студентів, що навчаються на %s факультеті \n", faculty);
            for(Student student: arr){
                if(student.getFac().equals(faculty)){
                    System.out.println(student);
                }
            }
            System.out.println("\n");
        }
        for(String year: years){
            System.out.printf("Список студентів, що навчаються на %s курсі \n", year);
            for(Student student: arr){
                if(student.getCourse().equals(year)){
                    System.out.println(student);
                }
            }
            System.out.println("\n");
        }

        System.out.print("Введіть рік, щоб отримати список студентів, що народились після цього року: ");
        int year = sc.nextInt();
        System.out.println("\nСтуденти, що народились після цього року: ");
        printList(getStudentsByYear(arr, String.valueOf(year)));
        System.out.println('\n');
        System.out.print("Введіть групу, список студентів якої ви хочете отримати: ");
        sc.nextLine();
        String group = sc.nextLine();
        System.out.println("\nСтуденти, що навчаються в цій групі: ");
        printList(findStudentsByGroup(arr, group));
        System.out.println('\n');
    }
}
