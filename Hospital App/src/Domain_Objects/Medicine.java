package Domain_Objects;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:25 PM
 */
public class Medicine {
    public Prescription prescription;
    private int Medicine;
    private float Price;
    private String MedicineDesc;

    /**
     * @param Medicine
     * @param price
     * @param MedicineDesc
     */
    public Medicine(int Medicine, float price, String MedicineDesc) {
        this.Medicine = Medicine;
        this.Price = price;
        this.MedicineDesc = MedicineDesc;
    }
}
