package HrStructure;

import java.util.ArrayList;
import java.util.List;

public class Resident {
    private String name;
    private boolean taken;

    public Resident(String name) {
        this.name = name;
        taken = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setTaken() {
        taken = true;
    }

    public boolean getTaken() {
        return taken;
    }


    @Override
    public String toString() {
        return name;
    }
}
