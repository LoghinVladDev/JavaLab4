package ro.appbase.object;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.stream.Stream;

public class Resident extends Element {

    protected Map<Integer, Hospital> preferences;

    public Resident(String name){
        super(name, 1);
    }

    @Override
    public String toString(){
        return "Resident "
                + this.name;
    }

    @Override
    public void assignTo() {

    }

    @Override
    public void free() {

    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    public void setPreferences(Hospital ... preferences){
        this.preferences = new HashMap<>();
        for(int i = 0; i < preferences.length; i++)
            this.preferences.put(i, preferences[i]);
    }

    @Override
    public Map<Integer, ?> getPreferences() {
        return this.preferences;
    }
}
