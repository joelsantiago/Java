package Relations;

import Domain_Objects.Patient;
import Domain_Objects.Surgeon;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 6:00 PM
 */
public class Patient_Surgeon {
    public Patient patient;
    public Surgeon surgeon;

    public Patient_Surgeon() {

    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Surgeon getSurgeon() {
        return surgeon;
    }

    public void setSurgeon(Surgeon surgeon) {
        this.surgeon = surgeon;
    }
}
