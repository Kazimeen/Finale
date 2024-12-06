package com.cybernetic;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents a patient in the emergency room system.
 */
public class Patient {
    private final String id;
    private final String name;
    private final int age;
    private final String bloodType;
    private final String organNeeded;
    private final int urgencyLevel;
    private final LocalDate registrationDate;
    private final String status;

    private Severity severity;
    private LocalTime arrivalTime;

    /**
     * Constructs a new Patient with the specified details.
     *
     * @param id               the unique identifier of the patient.
     * @param name             the name of the patient.
     * @param age              the age of the patient.
     * @param bloodType        the blood type of the patient.
     * @param organNeeded      the organ needed by the patient.
     * @param urgencyLevel     the urgency level of the patient's condition.
     * @param registrationDate the date the patient was registered.
     * @param status           the current status of the patient (e.g., "WAITING").
     */
    public Patient(String id, String name, int age, String bloodType, String organNeeded, int urgencyLevel, LocalDate registrationDate, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bloodType = bloodType;
        this.organNeeded = organNeeded;
        this.urgencyLevel = urgencyLevel;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    /**
     * Gets the unique identifier of the patient.
     *
     * @return the patient's ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the name of the patient.
     *
     * @return the patient's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the age of the patient.
     *
     * @return the patient's age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the blood type of the patient.
     *
     * @return the patient's blood type.
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * Gets the organ needed by the patient.
     *
     * @return the organ needed by the patient.
     */
    public String getOrganNeeded() {
        return organNeeded;
    }

    /**
     * Gets the urgency level of the patient.
     *
     * @return the patient's urgency level.
     */
    public int getUrgencyLevel() {
        return urgencyLevel;
    }

    /**
     * Gets the registration date of the patient.
     *
     * @return the patient's registration date.
     */
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Gets the current status of the patient.
     *
     * @return the patient's status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets the severity level of the patient's condition.
     *
     * @return the patient's severity level.
     */
    public Severity getSeverity() {
        return severity;
    }

    /**
     * Sets the severity level of the patient's condition.
     *
     * @param severity the new severity level.
     */
    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    /**
     * Gets the arrival time of the patient in the emergency room.
     *
     * @return the patient's arrival time.
     */
    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets the arrival time of the patient in the emergency room.
     *
     * @param arrivalTime the new arrival time.
     */
    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return String.format("Patient{id='%s', name='%s', age=%d, bloodType='%s', organNeeded='%s', urgencyLevel=%d, " +
                        "registrationDate=%s, status='%s', severity=%s, arrivalTime=%s}",
                id, name, age, bloodType, organNeeded, urgencyLevel, registrationDate, status, severity, arrivalTime);
    }
}
