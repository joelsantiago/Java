package Domain_Objects;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:23 PM
 */
public class Insurance {
    public Vector<Person> person = new Vector<Person>();
    private String insuranceContact;
    private int contactNumber;
    private String provider;
    public InsurancePolicy insurancePolicy;

    /**
     * @param insuranceContact
     * @param contactNumber
     * @param provider
     */
    public Insurance(String insuranceContact, int contactNumber, String provider) {
        this.insuranceContact = insuranceContact;
        this.contactNumber = contactNumber;
        this.provider = provider;
    }
}
