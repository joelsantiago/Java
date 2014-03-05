package Domain_Objects;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:28 PM
 */
public class OperatingRoom {
    public Surgery surgery;
    public Vector<SurgicalEquipment> surgicalEquipment;
    public Ward ward;
    private int roomNumber;

    /**
     * @param roomNumber
     */
    public OperatingRoom(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
