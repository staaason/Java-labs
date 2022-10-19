import com.mypack2.MyClass2;
public class l6_1_2 {
    protected static void printName(){
        MyClass2 a = new MyClass2();
//        System.out.println(a.getName()); Error
        a.foo();
    }
    public static void main(String[] args){
        printName();
    }
}
