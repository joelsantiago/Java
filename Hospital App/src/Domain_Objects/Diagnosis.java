package Domain_Objects;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:19 PM
 */
public class Diagnosis {
    private String result;
    public Doctor doctor;
    private String notes;
    public Patient patient;
    private String test;

    /**
     * @param result
     * @param notes
     * @param test
     */
    public Diagnosis(String result, String notes, String test) {
        this.result = result;
        this.notes = notes;
        this.test = test;
    }
}
