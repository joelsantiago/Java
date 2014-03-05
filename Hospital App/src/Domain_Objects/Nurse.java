package Domain_Objects;

import Relations.Patient_Nurse;
import Relations.Surgery_Nurse;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:26 PM
 */
public class Nurse extends RPerson {

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

    private Surgeon surgeon;
    private Department department;
    private Vector<Patient_Nurse> patientNurse = new Vector<Patient_Nurse>();
    private Vector<Surgery_Nurse> surgeryNurse = new Vector<Surgery_Nurse>();
    private Doctor doctor;
    private Ward ward;

    /**
     *
     */
    public Nurse(String userName, String password, String firstName, String lastName, String middleName,
                 String dateOfBirth, String sex, String socialSecurity,  String emailAddress, String mobilePhone, int type) {
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
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public Surgeon getSurgeon() {
        return surgeon;
    }

    public void setSurgeon(Surgeon surgeon) {
        this.surgeon = surgeon;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Vector<Patient_Nurse> getPatientNurse() {
        return patientNurse;
    }

    public void setPatientNurse(Vector<Patient_Nurse> patientNurse) {
        this.patientNurse = patientNurse;
    }

    public Vector<Surgery_Nurse> getSurgeryNurse() {
        return surgeryNurse;
    }

    public void setSurgeryNurse(Vector<Surgery_Nurse> surgeryNurse) {
        this.surgeryNurse = surgeryNurse;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
