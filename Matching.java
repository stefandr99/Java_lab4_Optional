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
        for(Hospital h : problem.getHospitals()) {
            List<Resident> res = new ArrayList<>(problem.getHosPrefMap().get(h));
            int cap = h.getCapacity();
            for(Resident r : res) {
                if(cap > 0) {
                    if (res.stream().
                            filter(rr -> problem.getResPrefMap().get(rr).contains(h)).count() != 0) {
                        Pair<Resident, Hospital> pair;
                        if (r.getTaken()) {
                            r.setTaken();
                            pair = new Pair<>(r, h);
                            myMatches.add(pair);
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
