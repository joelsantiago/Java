package Relations;

import Domain_Objects.Head;
import Domain_Objects.Patient;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:57 PM
 */
public class Patient_Head {
    public Patient patient;
    public Head head;

    public Patient_Head() {

    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }
}
