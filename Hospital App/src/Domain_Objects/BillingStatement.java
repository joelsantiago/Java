package Domain_Objects;

import java.util.Date;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:10 PM
 */
public class BillingStatement {
    public Cash cash;
    private float amountOwed;
    public Vector<Patient> patient = new Vector<Patient>();
    private float costOfProcedures;
    public Check check;
    private Date dateDue;
    private float totalAdjustments;
    private float amountPayed;
    private String patientResponsibility;
    private Date serviceDate;
    protected int paymentAcctNum;
    private float totalPayments;
    private float totalCharges;
    private Date statementDate;
    public CreditCard creditCard;

    /**
     *
     * @param amountOwed
     * @param costOfProcedures
     * @param dateDue
     * @param totalAdjustments
     * @param amountPayed
     * @param patientResponsibility
     * @param serviceDate
     * @param totalPayments
     * @param totalCharges
     * @param statementDate
     */
    public BillingStatement(float amountOwed, float costOfProcedures, Date dateDue, float totalAdjustments, float amountPayed, String patientResponsibility, Date serviceDate, float totalPayments,
                            float totalCharges, Date statementDate) {
        this.amountOwed = amountOwed;
        this.costOfProcedures = costOfProcedures;
        this.dateDue = dateDue;
        this.totalAdjustments = totalAdjustments;
        this.amountPayed = amountPayed;
        this.patientResponsibility = patientResponsibility;
        this.serviceDate = serviceDate;
        this.totalPayments = totalPayments;
        this.totalCharges = totalCharges;
        this.statementDate = statementDate;
    }
}
