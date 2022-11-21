
import Vagon.*;

import java.util.ArrayList;
import java.util.List;

public class l8_6_8 {
    public static void main(String[] args){
        Vagon luggage = new LuggageVagon(0, "Luggage", 15);
        Vagon luggage2 = new LuggageVagon(0, "Luggage", 20);
        Vagon passenger = new PassangerVagon(0.75, 30, "Passenger");
        Vagon passenger2 = new PassangerVagon(0.56, 25, "Passenger");
        List<Vagon> vagons = new ArrayList<>(){
            {
                add(luggage);
                add(passenger);
                add(luggage2);
                add(passenger2);
            }
        };
        Train train = new Train(vagons);
        System.out.println(train.getVagons());
        train.sortByComfort();
        System.out.println(train.getVagons());
        System.out.println("Загальна кількість пасажирів: " + train.getQuantityOfPassangers());
        System.out.println("Загальна кількість багажу: " + train.getQuantityOfLuggage());
        System.out.printf("Вагони в діапазоні від %d до %d пасажирів " + train.getVagonsFromDiapason(29,40), 29, 40);

    }
}
