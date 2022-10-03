



public class Dog {
    private String name;
    private String say;

    Dog(String name, String say){
        this.name = name;
        this.say = say;
    }

    public void displayInfo(){
        System.out.printf("%s says %s \n", this.name, this.say);
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog("spot", "Ruff!");
        Dog dog2 = new Dog("scruffy", "Wurf!");
        dog1.displayInfo();
        dog2.displayInfo();
        Dog dog3 = dog1;
        System.out.println(dog3 == dog1);
        System.out.println(dog3.equals(dog1));
    }
}
