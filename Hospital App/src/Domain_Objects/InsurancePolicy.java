package Domain_Objects;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:24 PM
 */
public class InsurancePolicy {
    private int authorizationCode;
    public Insurance insurance;
    private int daysApproved;
    protected int groupNumber;
    public Patient patient;
    protected int policyNumber;
    protected int accountNumber;

    /**
     * @param authorizationCode
     * @param daysApproved
     * @param groupNumber
     * @param policyNumber
     * @param accountNumber
     */
    public InsurancePolicy(int authorizationCode, int daysApproved, int groupNumber, int policyNumber, int accountNumber) {
        this.authorizationCode = authorizationCode;
        this.daysApproved = daysApproved;
        this.groupNumber = groupNumber;
        this.policyNumber = policyNumber;
        this.accountNumber = accountNumber;
    }
}
