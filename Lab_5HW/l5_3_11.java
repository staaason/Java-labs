public class l5_3_11 {
    @Override
    protected void finalize(){
        System.out.println("Class was deleted");
    }


    public static void main(String[] args){
        l5_3_11 mc = new l5_3_11();
        mc = null;
        System.gc(); // Викликаємо garbage collector щоб почистити пам'ять,
        // так як у нас об'єкт mc існує в пам'яті, але не містить посилання,
        // тому перед видаленням викликається finalize
    }
}
