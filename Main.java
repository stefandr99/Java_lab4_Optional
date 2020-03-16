package Solution;

import HrStructure.Hospital;
import HrStructure.Resident;
import MyHRProblem.Matching;
import MyHRProblem.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Resident[] r = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("R" + i) )
                .toArray(Resident[]::new);

        Hospital[] h = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Hospital("H" + i, i + 1))
                .toArray(Hospital[]::new);

        List<Resident> residentList = new ArrayList<>();
        residentList.addAll( Arrays.asList(r) );
        Collections.sort(residentList,
                ((r1, r2) -> r1.getName().compareTo(r2.getName())));

        List<Hospital> hospitalList = new ArrayList<>();
        hospitalList.addAll(Arrays.asList(h));

        Problem prob = new Problem(residentList, hospitalList);
        prob.fillResMap(r[0], Arrays.asList(h[0], h[1], h[2]));
        prob.fillResMap(r[1], Arrays.asList(h[0], h[1], h[2]));
        prob.fillResMap(r[2], Arrays.asList(h[0], h[1]));
        prob.fillResMap(r[3], Arrays.asList(h[0], h[2]));

        prob.fillHosMap(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        prob.fillHosMap(h[1], Arrays.asList(r[0], r[2], r[1]));
        prob.fillHosMap(h[2], Arrays.asList(r[0], r[1], r[3]));


        Matching matching = new Matching();
        matching.Match(prob);
        matching.toString();

        /*Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();

        resPrefMap.put(r[0], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[1], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[2], Arrays.asList(h[0], h[1]));
        resPrefMap.put(r[3], Arrays.asList(h[0], h[2]));

        Map<Hospital, List<Resident>> hosPrefMap = new TreeMap<>();
        hosPrefMap.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        hosPrefMap.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        hosPrefMap.put(h[2], Arrays.asList(r[0], r[1], r[3]));

        System.out.println(resPrefMap.toString());
        System.out.println(hosPrefMap.toString());

        residentList.stream()
                .filter(res -> resPrefMap.get(res).contains(h[0]))
                .forEach(System.out::println);*/
    }
}
