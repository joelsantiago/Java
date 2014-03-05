package Domain_Objects;

import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:08 PM
 */
public class Appointment {
    private String date;
    private String notesDescription;
    private Patient patient;
    private Doctor doctor;
    private Room room;
    private String appointmentDate;
    private String basicReason;
    private String fullReason;
    private String time;
    private Department department;

    public Appointment(Doctor doctor, Patient patient, Department department, String basicReason, String fullReason, Room room) {
        this.doctor = doctor;
        this.patient = patient;
        this.basicReason = basicReason;
        this.fullReason = fullReason;
        this.room = room;
        this.department = department;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotesDescription() {
        return notesDescription;
    }

    public void setNotesDescription(String notesDescription) {
        this.notesDescription = notesDescription;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getBasicReason() {
        return basicReason;
    }

    public void setBasicReason(String basicReason) {
        this.basicReason = basicReason;
    }

    public String getFullReason() {
        return fullReason;
    }

    public void setFullReason(String fullReason) {
        this.fullReason = fullReason;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
