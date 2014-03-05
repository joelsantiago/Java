package Domain_Objects;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:35 PM
 */
public class Room {
    public Ward ward;
    private String reasonForNewRoom;
    private int roomNum;
    private int newRoom;

    /**
     * @param reasonForNewRoom
     * @param roomNum
     * @param newRoom
     */
    public Room(String reasonForNewRoom, int roomNum, int newRoom) {
        this.reasonForNewRoom = reasonForNewRoom;
        this.roomNum = roomNum;
        this.newRoom = newRoom;
    }

    public Room(int roomNum){
        this.roomNum = roomNum;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public int getNewRoom() {
        return newRoom;
    }

    public void setNewRoom(int newRoom) {
        this.newRoom = newRoom;
    }

    public String getReasonForNewRoom() {
        return reasonForNewRoom;
    }

    public void setReasonForNewRoom(String reasonForNewRoom) {
        this.reasonForNewRoom = reasonForNewRoom;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }
}
