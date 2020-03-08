package ro.appbase.utiltiy.graph;

import ro.appbase.object.Element;
import ro.appbase.object.Hospital;
import ro.appbase.object.Resident;

import java.util.*;
import java.util.stream.Collectors;

public class Partition {
    Set<Element> V;

    public Partition(Set<Hospital> V){
        this.V = new TreeSet<>(Comparator.comparing(Element::getName));
        this.V.addAll(V);
    }

    public Partition(List<Resident> V){
        this.V = new TreeSet<>(Comparator.comparing(Element::getName));
        this.V.addAll(V);
    }

    public Set<Element> getV(){
        return this.V;
    }

    public String toString(){
        return "Partition with nodes = " + this.V.toString();
    }
}
