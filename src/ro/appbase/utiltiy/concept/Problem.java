package ro.appbase.utiltiy.concept;

import javafx.util.converter.ShortStringConverter;
import ro.appbase.object.Element;
import ro.appbase.object.Hospital;
import ro.appbase.object.Resident;
import ro.appbase.utiltiy.algorithm.Algorithm;
import ro.appbase.utiltiy.graph.Partition;

import java.util.*;

public class Problem {
    private Partition s;
    private Partition t;
    private List<Resident> residents;
    private Set<Hospital> hospitals;
    private Solution solution;
    private Algorithm algorithm;

    public static class Builder {
        private ArrayList<Resident> residents;
        private TreeSet<Hospital> hospitals;

        public Builder withHospitals(Hospital ... hospitals){
            this.hospitals = new TreeSet<>(Comparator.comparing(Element::getName));
            this.hospitals.addAll(Arrays.asList(hospitals));

            return this;
        }

        public Builder withResidents(Resident ... residents){
            this.residents = new ArrayList<>();
            this.residents.addAll(Arrays.asList(residents));
            this.residents.sort(Comparator.comparing(Element::getName));

            return this;
        }

        public Problem build(){
            Problem problem = new Problem();

            problem.hospitals = this.hospitals;
            problem.residents = this.residents;

            return problem;
        }
    }

    private Problem(){

    }

    public List<Resident> getResidents() {
        return this.residents;
    }

    public Set<Hospital> getHospitals() {
        return this.hospitals;
    }

    public String toString(){
        return "Problem instance : \nResidents = "
                + this.residents.toString()
                + "\nHospitals = "
                + this.hospitals.toString();
    }

    public void printPreferences(){
        this.printResidentsPreferences();
        this.printHospitalPreferences();
    }

    public void printResidentsPreferences(){
        for(Resident resident : this.residents) {
            System.out.print(resident.getPreferences().toString());
            System.out.print("\n");
        }
    }

    public void printHospitalPreferences(){
        for(Hospital hospital : this.hospitals){
            System.out.print(hospital.getPreferences().toString());
            System.out.print("\n");
        }
    }
}
