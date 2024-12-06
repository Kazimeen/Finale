package com.cybernetic;

import java.time.LocalTime;

/**
 * Represents an Emergency Room system that uses a priority queue for managing patients.
 */
public class EmergencyRoom {
    private final Heap<Patient> priorityQueue;

    /**
     * Constructs an EmergencyRoom with a specified comparator for prioritizing patients.
     *
     * @param comparator the comparator used to prioritize patients.
     */
    public EmergencyRoom(PatientComparator comparator) {
        this.priorityQueue = new Heap<>(comparator);
    }

    /**
     * Checks in a patient to the emergency room with the specified severity level.
     *
     * @param patient  the patient to check in.
     * @param severity the severity level of the patient.
     */
    public void checkIn(Patient patient, Severity severity) {
        patient.setSeverity(severity);
        patient.setArrivalTime(LocalTime.now());
        priorityQueue.add(patient);
    }

    /**
     * Admits the highest-priority patient from the emergency room.
     *
     * @return the admitted patient, or null if no patients are in the queue.
     */
    public Patient admit() {
        return priorityQueue.remove();
    }
}
