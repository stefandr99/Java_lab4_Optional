package MyHRProblem;

import HrStructure.Hospital;
import HrStructure.Resident;

import java.util.*;

public class Problem {
    List<Resident> residents; //lista de rezidenti
    List<Hospital> hospitals; //lista de spitale
    Map<Resident, List<Hospital>> resPrefMap; //map cu preferintele rezidentilor
    Map<Hospital, List<Resident>> hosPrefMap; //map cu preferintele spitalelor

    public Problem() {
        residents = new ArrayList<>();
        hospitals = new ArrayList<>();
        resPrefMap = new HashMap<>();
        hosPrefMap = new TreeMap<>();
    }

    public Problem(List<Resident> r, List<Hospital> h) {
        residents = new ArrayList<>();
        hospitals = new ArrayList<>();
        resPrefMap = new HashMap<>();
        hosPrefMap = new TreeMap<>();
        for (Resident res : r) {
            residents.add(res);
        }
        for(Hospital hos : h) {
            hospitals.add(hos);
        }
    }

    public void addResident(Resident r) {
        residents.add(r);
    }

    public void addHospital(Hospital h) {
        hospitals.add(h);
    }

    public void fillResMap(Resident r, List<Hospital> h) { //metoda ce are scopul de a umple mapa de preferinte pentru rezidentul r
        resPrefMap.put(r, h);
    }

    public void fillHosMap(Hospital h, List<Resident> r) { //metoda ce are scopul de a umple mapa de preferinte pentru spitalul h
        hosPrefMap.put(h, r);
    }

    public List<Resident> getResidents() {
        return residents;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public Map<Resident, List<Hospital>> getResPrefMap() {
        return resPrefMap;
    }

    public Map<Hospital, List<Resident>> getHosPrefMap() {
        return hosPrefMap;
    }

    @Override
    public String toString() {
        String problem = "Residents: ";
        for(Resident r : residents) {
            problem = problem + r.toString() + ", ";
        }
        problem = problem + '\n';
        for(Hospital h : hospitals) {
            problem = problem + h.toString() + ", ";
        }
        problem = problem + '\n';
        return problem;
    }
}
