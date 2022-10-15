public class l5_3_4 {
    l5_3_4(){
        System.out.println("Class was created");
    }

    l5_3_4(String msg){
        System.out.println("Class was created" + " " + msg);
    }


    public static void main(String[] args){
        l5_3_4 mc = new l5_3_4();
        l5_3_4 mc2 = new l5_3_4("by stanislav");

    }
}
