package Student;

import java.util.List;

public class PartTimeStudent extends Student{
    private final boolean type;

    @Override
    public String toString() {
        return "PartTimeStudent{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    public PartTimeStudent(String name, List<String> marks) {
        super(name, marks);
        this.type = true;
    }

    public boolean isPartTime(){
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getMarks() {
        return marks;
    }
}
