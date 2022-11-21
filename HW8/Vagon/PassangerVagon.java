package Vagon;

public class PassangerVagon extends Vagon{
    public void setQuantityOfPassangers(int quantityOfPassangers) {
        this.quantityOfPassangers = quantityOfPassangers;
    }

    private int quantityOfPassangers;

    public PassangerVagon(double comfort, int quantityOfPassangers, String type) {
        super(comfort, type);
        setType("Passanger");
        this.quantityOfPassangers = quantityOfPassangers;
    }


    @Override
    public String toString() {
        return "PassangerVagon{" +
                "quantityOfPassangers=" + quantityOfPassangers +
                ", comfort=" + getComfort() +
                '}';
    }

    @Override
    public int getCapacity() {
        return quantityOfPassangers;
    }
}
