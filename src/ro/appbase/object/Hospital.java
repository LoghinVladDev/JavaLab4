package ro.appbase.object;

import javafx.beans.binding.IntegerExpression;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Hospital extends Element {
    private Map<Integer, Resident> preferences;

    public Hospital(String name, int capacity){
        super(name, capacity);
    }

    @Override
    public void assignTo() {

    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public Map<Integer, ?> getPreferences() {
        return this.preferences;
    }

    public void setPreferences(Resident ... preferences){
        this.preferences = new LinkedHashMap<>();
        for(int i = 0; i < preferences.length; i++)
            this.preferences.put(i, preferences[i]);
    }

    @Override
    public String toString() {
            return "Hospital \""
                    + this.name
                    + "\", capacity = "
                    + this.capacity;
    }

    @Override
    public Element getNextTryout() {
        return this.preferences
                .entrySet()
                .stream()
                .filter(e -> !this.tryouts.contains(e))
                .findFirst()
                .orElse(null)
                .getValue();
    }

    @Override
    public Element getLeastAppealingAssignee() {
        //System.out.println("\t...Start find worst match debug");
        Element leastAppealing = null;
        for(Element pair : this.preferences.values()){
           // System.out.println("\t" + this);
            //System.out.println("\t" + pair);
            if(this.assignedTo.contains(pair)){
                leastAppealing = pair;
                //System.out.println("\t\t" + pair);
            }
        }
        //System.out.println("\t...End find worst match debug");
        return leastAppealing;
    }
    public int getPreference(Element obj){
        for(Integer key : this.preferences.keySet()){
            if( this.preferences.get(key).equals(obj) ) {
                //System.out.println("For " + this + "," + obj + "'s priority is " + key);
                return key;
            }
        }
        return Integer.MAX_VALUE;
    }
}
