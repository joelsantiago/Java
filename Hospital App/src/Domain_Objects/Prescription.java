package Domain_Objects;

import java.util.Date;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:34 PM
 */
public class Prescription {
    public Vector<Medicine> medicine = new Vector<Medicine>();
    private Date date;
    public Patient patient;
    private float amount;
    private int prescripID;
    private String notes;
    private String medicineName;
    private String prescribingPhysician;

    /**
     * @param amount
     * @param prescripID
     * @param notes
     * @param medicineName
     * @param prescribingPhysician
     */
    public Prescription(float amount, int prescripID, String notes, String medicineName, String prescribingPhysician) {
        this.amount = amount;
        this.prescripID = prescripID;
        this.notes = notes;
        this.medicineName = medicineName;
        this.prescribingPhysician = prescribingPhysician;
    }
}
