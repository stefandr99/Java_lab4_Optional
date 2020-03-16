package HrStructure;

import java.util.ArrayList;
import java.util.List;

public class Hospital implements Comparable<Hospital> {
    String name;
    int capacity;

    public Hospital(String name) {
        this.name = name;
        this.capacity = 1; //by default
    }

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public int compareTo(Hospital hospital)
    {
        return this.name.compareTo(hospital.getName());
    }

    @Override
    public String toString() {
        String hos = "";
        hos = hos + name + "with capacity: " + capacity;
        return hos;
    }
}
