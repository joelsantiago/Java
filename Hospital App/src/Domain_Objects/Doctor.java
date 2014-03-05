package Domain_Objects;

import Relations.Doctor_ExaminationRoom;
import Relations.Patient_Doctor;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:20 PM
 */
public class Doctor extends RPerson {

    /*
    INHERITED FROM RPerson
    -----------------------
    public String firstName;
    public String lastName;
    public String middleName;
    public String dateOfBirth;
    public String sex;
    public String socialSecurity;
    public String emailAddress;
    public String password;
    public String userName;
    public String homePhone;
    public String mobilePhone;
    public int type;
    private Vector<String> emailMessages;
     */

    private Vector<Appointment> appointment = new Vector<Appointment>();
    private Vector<Doctor_ExaminationRoom> doctorExaminationRoom = new Vector<Doctor_ExaminationRoom>();
    private Office office;
    private Vector<Patient> patient = new Vector<Patient>();
    private int yearsOfExperience;
    private String hiredDate;
    private Vector<Diagnosis> diagnosis = new Vector<Diagnosis>();
    private int departmentID;
    private Vector<Patient_Doctor> personDoctor = new Vector<Patient_Doctor>();
    private Vector<Nurse> nurse = new Vector<Nurse>();
    private Department department;

    /**
     *
     * @param skillId
     * @param yearsOfExperience
     * @param hiredDate
     * @param departmentID
     */
    public Doctor(String userName, String password, String firstName, String lastName, String middleName,
                  String dateOfBirth, String sex, String socialSecurity,  String emailAddress, String mobilePhone,
                  int skillId, int yearsOfExperience, String hiredDate, int departmentID, int type) {

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setMiddleName(middleName);
        this.setDateOfBirth(dateOfBirth);
        this.setSex(sex);
        this.setSocialSecurity(socialSecurity);
        this.setEmailAddress(emailAddress);
        this.setPassword(password);
        this.setUserName(userName);
        this.setMobilePhone(mobilePhone);
        this.setType(type);

        this.yearsOfExperience = yearsOfExperience;
        this.hiredDate = hiredDate;
        this.departmentID = departmentID;

    }

    public Doctor() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public Vector<Appointment> getAppointment() {
        return this.appointment;
    }

    public void setAppointment(Vector<Appointment> appointment) {
        this.appointment = appointment;
    }

    public Vector<Doctor_ExaminationRoom> getDoctorExaminationRoom() {
        return doctorExaminationRoom;
    }

    public void setDoctorExaminationRoom(Vector<Doctor_ExaminationRoom> doctorExaminationRoom) {
        this.doctorExaminationRoom = doctorExaminationRoom;
    }

    public Office getOffice() {
        return this.office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Vector<Patient> getPatient() {
        return this.patient;
    }

    public void setPatient(Vector<Patient> patient) {
        this.patient = patient;
    }

    public int getYearsOfExperience() {
        return this.yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getHiredDate() {
        return this.hiredDate;
    }

    public void setHiredDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }

    public Vector<Diagnosis> getDiagnosis() {
        return this.diagnosis;
    }

    public void setDiagnosis(Vector<Diagnosis> diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getDepartmentID() {
        return this.departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public Vector<Patient_Doctor> getPersonDoctor() {
        return this.personDoctor;
    }

    public void setPersonDoctor(Vector<Patient_Doctor> personDoctor) {
        this.personDoctor = this.personDoctor;
    }

    public Vector<Nurse> getNurse() {
        return this.nurse;
    }

    public void setNurse(Vector<Nurse> nurse) {
        this.nurse = this.nurse;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = this.department;
    }
}
