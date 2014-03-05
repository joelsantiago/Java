package Domain_Objects;

import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:54 PM
 */
public class Visit {
    private int visitID;
    private int personID;
    public Patient patient;
    private String description;
    private Date visitDate;

    /**
     * @param visitID
     * @param personID
     * @param description
     * @param visitDate
     */
    public Visit(int visitID, int personID, String description, Date visitDate) {
        this.visitDate = visitDate;
        this.personID = personID;
        this.description = description;
        this.visitDate = visitDate;
    }
}
