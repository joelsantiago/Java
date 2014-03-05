package Relations;

import Domain_Objects.Nurse;
import Domain_Objects.Patient;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:58 PM
 */
public class Patient_Nurse {
    public Patient patient;
    public Nurse nurse;

    public Patient_Nurse() {

    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }
}
