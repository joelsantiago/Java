package Domain_Objects;

import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:15 PM
 */
public class CreditCard {
    public BillingStatement billingStatement;
    private int CardNum;
    private Date CardDate;

    /**
     * @param CardNum
     */
    public CreditCard(int CardNum) {
        this.CardNum = CardNum;
    }
}
