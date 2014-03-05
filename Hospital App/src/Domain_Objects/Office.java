package Domain_Objects;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:26 PM
 */
public class Office {
    private int roomNumber;
    public Doctor doctor;
    private String referenceFiles;
    private String patientFiles;
    public Surgeon surgeon;

    /**
     * @param roomNumber
     * @param referenceFiles
     * @param patientFiles
     */
    public Office(int roomNumber, String referenceFiles, String patientFiles) {
        this.roomNumber = roomNumber;
        this.referenceFiles = referenceFiles;
        this.patientFiles = patientFiles;
    }
}
