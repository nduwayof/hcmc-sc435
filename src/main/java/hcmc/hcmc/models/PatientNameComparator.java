package hcmc.hcmc.models;

import java.util.Comparator;

/**
 * The type Patient name comparator.
 * @author nduwayofabrice
 * @version 1.0
 */
public class PatientNameComparator implements Comparator<Patient> {

    @Override
    public int compare(Patient o1, Patient o2) {
        return o1.getFullNames().compareTo(o2.getFullNames());
    }
}
