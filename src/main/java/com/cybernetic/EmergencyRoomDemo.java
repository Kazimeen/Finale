package com.cybernetic;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

/**
 * Demonstrates the functionality of the EmergencyRoom class by checking in and admitting patients
 * based on their severity and arrival time.
 */
public class EmergencyRoomDemo {

    /**
     * The main method to demonstrate the EmergencyRoom system.
     *
     * @param args command-line arguments (not used).
     * @throws InterruptedException if the thread sleep is interrupted.
     */
    public static void main(String[] args) throws InterruptedException {
        // Create an EmergencyRoom with a custom comparator for patient priority.
        EmergencyRoom eRoom = new EmergencyRoom(new PatientComparator());

        // Check in patients with different severity levels and arrival times.
        eRoom.checkIn(new Patient("PAT-001", "Mirabella Jones", 50, "O+", "HEART", 7, LocalDate.of(2024, 1, 1), "WAITING"), Severity.SEVEN);
        TimeUnit.MILLISECONDS.sleep(10); // Simulate a delay for arrival time differentiation.
        eRoom.checkIn(new Patient("PAT-002", "Ruth Mendez", 58, "A-", "LUNG", 9, LocalDate.of(2024, 1, 2), "WAITING"), Severity.SEVEN);
        TimeUnit.MILLISECONDS.sleep(10);
        eRoom.checkIn(new Patient("PAT-003", "Melvin Ingram", 58, "B+", "LIVER", 6, LocalDate.of(2024, 1, 3), "WAITING"), Severity.SEVEN);
        TimeUnit.MILLISECONDS.sleep(10);
        eRoom.checkIn(new Patient("PAT-004", "Tara Silva", 48, "AB-", "KIDNEY", 8, LocalDate.of(2024, 1, 4), "WAITING"), Severity.EIGHT);
        TimeUnit.MILLISECONDS.sleep(10);
        eRoom.checkIn(new Patient("PAT-005", "Jeff Barnes", 56, "O-", "LUNG", 10, LocalDate.of(2024, 1, 5), "WAITING"), Severity.EIGHT);

        // Admit patients based on priority and print their details.
        System.out.println("\nAdmitting patients:");
        Patient patient;
        while ((patient = eRoom.admit()) != null) {
            System.out.printf("%s\nDOB=%s\nseverity=%s\narrivalTime=%s admitted\n\n",
                    patient.getName(),
                    patient.getRegistrationDate().minusYears(patient.getAge()), // Calculate DOB
                    patient.getSeverity(),
                    patient.getArrivalTime());
        }
    }
}
