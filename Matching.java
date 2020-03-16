package MyHRProblem;

import HrStructure.Hospital;
import HrStructure.Resident;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Matching {
    Problem problem;
    List<Pair<Resident, Hospital>> myMatches;

    public Matching() {
        problem = new Problem();
        myMatches = new ArrayList<>();
    }

    public void Match(Problem p) {
        for(Hospital h : problem.getHospitals()) { // iteram toate spitalele din problema
            List<Resident> res = new ArrayList<>(problem.getHosPrefMap().get(h)); // obtinem rezidentii din lista de prefeinta a spitalului curent
            int cap = h.getCapacity(); //capacitatea spitalului curent
            for(Resident r : res) { // iteram toti rezidentii din lista de preferinta a spitalului curent
                if(cap > 0) { //mai este loc in spital?
                    if (res.stream().
                            filter(rr -> problem.getResPrefMap().get(rr).contains(h)).count() != 0) { // spitalul curent se afla in lista de preferinte a rezidentului?
                        Pair<Resident, Hospital> pair;
                        if (r.getTaken()) {
                            r.setTaken(); //setam ca "luat" acest rezident de catre spitalul curent
                            pair = new Pair<>(r, h);
                            myMatches.add(pair); //adaugam solutia
                            cap--;
                        }
                    }
                }
                else break;
            }
        }
    }

    @Override
    public String toString() {
        String resolved = problem.toString();

        resolved = resolved + "[";
        for(Pair m : myMatches) {
            resolved = resolved + "(" + m.getKey() + " : " + m.getValue() + "), ";
        }
        return resolved;
    }
}
