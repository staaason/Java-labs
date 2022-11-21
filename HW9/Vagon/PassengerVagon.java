package Vagon;

public class PassengerVagon extends Vagon{
    public void setQuantityOfPassengers(int quantityOfPassangers) {
        this.quantityOfPassengers = quantityOfPassangers;
    }

    private int quantityOfPassengers;

    public PassengerVagon(double comfort, int quantityOfPassengers, String type) throws WrongParametersException{
        super(comfort, type);
        if(comfort < 0){
            throw new WrongParametersException("Comfort is lower than 0");
        }
        if(type == null || type.trim().isEmpty()){
            throw new WrongParametersException("Type is empty");
        }
        if(!type.equals("Passenger")){
            throw new WrongParametersException("Incorrect type");
        }
        setType(type);
        this.quantityOfPassengers = quantityOfPassengers;
    }


    @Override
    public String toString() {
        return "PassengerVagon{" +
                "quantityOfPassengers=" + quantityOfPassengers +
                ", comfort=" + getComfort() +
                '}';
    }

    @Override
    public int getCapacity() {
        return quantityOfPassengers;
    }
}
