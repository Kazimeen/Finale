package com.cybernetic;

import java.util.Comparator;

/**
 * A comparator for comparing patients based on severity, age, and arrival time.
 */
public class PatientComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        int severityComparison = p2.getSeverity().ordinal() - p1.getSeverity().ordinal();
        if (severityComparison != 0) return severityComparison;

        int ageComparison = Integer.compare(p2.getAge(), p1.getAge());
        if (ageComparison != 0) return ageComparison;

        return p1.getArrivalTime().compareTo(p2.getArrivalTime());
    }
}
