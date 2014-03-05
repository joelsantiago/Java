package Domain_Objects;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:14 PM
 */
public class Check {
    private int CheckNum;
    public BillingStatement billingStatement;

    /**
     * @param CheckNum
     */
    public Check(int CheckNum) {
        this.CheckNum = CheckNum;
    }
}
