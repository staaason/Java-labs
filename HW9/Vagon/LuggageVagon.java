package Vagon;

import java.util.Objects;

public class LuggageVagon extends Vagon{
    private int capacity;
    public LuggageVagon(double comfort, String type, int capacity) throws WrongParametersException{
        super(comfort, type);
        if(comfort != 0){
            throw new WrongParametersException("Comfort can be only zero");
        }
        if(type == null || type.trim().isEmpty()){
            throw new WrongParametersException("Type is empty");
        }
        if(!type.equals("Luggage")){
            throw new WrongParametersException("Incorrect type");
        }
        setType(type);
        setComfort(0);
        this.capacity = capacity;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LuggageVagon)) return false;
        if (!super.equals(o)) return false;
        LuggageVagon that = (LuggageVagon) o;
        return getCapacity() == that.getCapacity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCapacity());
    }

    @Override
    public String toString() {
        return "LuggageVagon{" +
                "capacity=" + capacity +
                '}';
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}
