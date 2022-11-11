
import Vagon.*;

import java.util.ArrayList;
import java.util.List;

public class l8_6_8 {
    public static void main(String[] args) throws WrongParametersException {
        Vagon luggage = new LuggageVagon(0, "Luggage", 15);
        Vagon luggage2 = new LuggageVagon(0, "Luggage", 20);
        Vagon passenger = new PassengerVagon(0.75, 30, "Passenger");
        try{
            Vagon passenger2 = new PassengerVagon(0.56, -1, "");

        }catch (WrongParametersException e){
            e.printStackTrace();
        }
        List<Vagon> vagons = new ArrayList<>(){
            {
                add(luggage);
                add(passenger);
                add(luggage2);
            }
        };
        Train train = new Train(vagons);
        System.out.println(train.getVagons());
        train.sortByComfort();
        System.out.println(train.getVagons());
        System.out.println("Загальна кількість пасажирів: " + train.getQuantityOfPassengers());
        System.out.println("Загальна кількість багажу: " + train.getQuantityOfLuggage());
        System.out.printf("Вагони в діапазоні від %d до %d пасажирів " + train.getVagonsFromDiapason(29,40), 29, 40);

    }
}
