package mypack;
class MyClass4 {
    protected int par = 1;
    void useProtected(l6_1_3 x){
        System.out.println("Out " + x.member3);
    }

}




public class l6_1_4 {
    public static   void main(String[] args){
        MyClass4 a = new MyClass4();
        l6_1_3 b = new l6_1_3();
        b.member3 = 2;
        a.useProtected(b);
    }
}
