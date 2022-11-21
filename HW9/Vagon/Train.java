package Vagon;

import java.util.List;
import java.util.stream.Collectors;

public class Train {
    public List<Vagon> getVagons() {
        return vagons;
    }

    public void setVagons(List<Vagon> vagons) {
        this.vagons = vagons;
    }

    public void sortByComfort(){
        ComparatorByComfort comparator = new ComparatorByComfort();
        vagons.sort(comparator);
    }

    public int getQuantityOfPassengers(){
        return vagons.stream().filter(v -> v.getType().equals("Passenger")).mapToInt(Vagon::getCapacity).sum();
    }

    public int getQuantityOfLuggage(){
        return vagons.stream().filter(v -> v.getType().equals("Luggage")).mapToInt(Vagon::getCapacity).sum();

    }

    public List<Vagon> getVagonsFromDiapason(int a, int b){
        return vagons.stream().filter(v ->
                v.getType().equals("Passenger") && (v.getCapacity() >= a && v.getCapacity() <= b )).collect(Collectors.toList());
    }

    public Train(List<Vagon> vagons) {
        this.vagons = vagons;
    }



    private List<Vagon> vagons;



}
