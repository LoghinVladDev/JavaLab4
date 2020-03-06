package ro.appbase.object;

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
}
