package mypack;
public class Base {
    int member1;
    private int member2;
    protected int member3;
    public int member4;

    void method1(){
        System.out.println("Method1");
    }

    public void method2(){
        System.out.println("Method2");
    }

    private void method3(){
        System.out.println("Method3");
    }

    protected void method4(){
        System.out.println("Method4");
    }

    public static void main(String[] args){
        Base a = new Base();
        a.member3 = 1;
        a.method3();
    }

}
