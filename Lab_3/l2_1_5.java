public class l2_1_5 {
    float x = 2.0f;
    String name = "Stanislav";

    public void method(){
        System.out.print(this.name + this.x);
    }

    public static void main(String[] args) {
        l2_1_5 tmp = new l2_1_5();
        tmp.method();



    }
}
