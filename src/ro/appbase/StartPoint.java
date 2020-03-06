package ro.appbase;

import javafx.util.Builder;
import ro.appbase.object.Hospital;
import ro.appbase.object.Resident;
import ro.appbase.utiltiy.concept.Problem;

public class StartPoint {
    public static void main(String[] args){
        Resident[] residents = new Resident[]{
                new Resident("R0"),
                new Resident("R1"),
                new Resident("R2"),
                new Resident("R3")
        };

        Hospital[] hospitals = new Hospital[]{
                new Hospital("H0",1),
                new Hospital("H1",2),
                new Hospital("H2",2)
        };

        residents[0].setPreferences(hospitals[0], hospitals[1], hospitals[2]);
        residents[1].setPreferences(hospitals[0], hospitals[1], hospitals[2]);
        residents[2].setPreferences(hospitals[0], hospitals[1]);
        residents[3].setPreferences(hospitals[0], hospitals[2]);

        hospitals[0].setPreferences(residents[3], residents[0], residents[1], residents[2]);
        hospitals[1].setPreferences(residents[0], residents[2], residents[1]);
        hospitals[2].setPreferences(residents[0], residents[1], residents[3]);

        Problem p = new Problem.Builder()
                .withHospitals(hospitals)
                .withResidents(residents)
                .build();

        p.printPreferences();
    }
}
