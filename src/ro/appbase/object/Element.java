package ro.appbase.object;

import java.sql.PreparedStatement;
import java.util.*;

public abstract class Element {
    protected int capacity;
    protected String name;

    protected Element(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }

    public abstract void assignTo();

    public abstract void free();

    public abstract boolean isFree();

    public abstract int getCapacity();

    public String getName(){
        return this.name;
    }

    public abstract Map<Integer, ?> getPreferences();

    public abstract String toString();
}
