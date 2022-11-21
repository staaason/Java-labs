package Student;

import java.util.List;

public abstract class Student implements Abiturient{
    public Student(String name, List<String> marks) {
        this.name = name;
        this.marks = marks;
    }

    public String name = null;
    public List<String> marks;
    abstract public List<String> getMarks();
}
