package Domain_Objects;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:54 PM
 */
public class Ward {
    private int WardID;
    public Nurse nurse;
    public Room room;
    public OperatingRoom operatingRoom;
    private String WardDesc;

    /**
     * @param WardID
     * @param WardDesc
     */
    public Ward(int WardID, String WardDesc) {
        this.WardDesc = WardDesc;
        this.WardID = WardID;
    }
}
