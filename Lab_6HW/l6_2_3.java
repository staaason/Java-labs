import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.patient.Patient;
public class l6_2_3 {
    public static void getPatientWithDiagnosis(Patient[] arr, String diagnosis){
        Set<Patient> allMatches = new HashSet<>();
        for (Patient patient : arr) {
            Matcher m = Pattern.compile(diagnosis,Pattern.CASE_INSENSITIVE).matcher(patient.getDiagnosis());
            while (m.find()) {
                allMatches.add(patient);
            }
        }
        System.out.print("Patients with diagnosis " + diagnosis + ": ");
        for(Patient p: allMatches){
            System.out.println(p);
        }
        System.out.println();
    }

    public static void getPatientWithCardNumber(Patient[] arr,int a, int b){
        System.out.print("Patient with card number from " + a + " to " + b + " : ");
        for (Patient patient : arr) {
            if (patient.getMedicalCardNumber() >= a && patient.getMedicalCardNumber() <= b) {
                System.out.print(patient);
                System.out.println();
            }
        }

    }

    public static void main(String[] args){
        int patientsNumber = 5;
        Patient[] arr = new Patient[patientsNumber];
        arr[0] = new Patient(1, "Vernon", "Lopez", "Martinez", "Kyiv",
                "920-438-0968", 15230,
                "Contusion of unspecified thumb without damage to nail");
        arr[1] = new Patient(2, "Gonzalez", "Harry", "Martinez", "Kyiv",
                "401-574-8757", 15231,
                "Acute mastoiditis without complications, unspecified ear");
        arr[2] = new Patient(3, "Thompson", "James", "Martinez",
                "Kyiv",
                "603-786-8135", 15232, "Pedestrian on skateboard injured in" +
                " collision with pedal cycle," +
                " unspecified whether traffic or nontraffic accident");
        arr[3] = new Patient(4, "Russell", "Joan", "Martinez",
                "Kyiv",
                "732-477-2093", 15233, "Mooren's corneal ulcer, cystic meniscus");
        arr[4] = new Patient(5, "Orville", "Philip", "Martinez",
                "Kyiv",
                "920-468-9728",
                15234, "Cystic meniscus caused by a tear within the meniscus cartilage");
        String diagnosis = "meniscus";
        getPatientWithDiagnosis(arr, diagnosis);
        getPatientWithCardNumber(arr, 15230, 15232);
    }
}
