package Domain_Objects;

import Relations.Doctor_ExaminationRoom;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:21 PM
 */
public class ExaminationRoom {
    public Vector<Doctor_ExaminationRoom> doctorExaminationRoom = new Vector<Doctor_ExaminationRoom>();
    private int examinationTable;
    private int examinationTools;

    /**
     *
     * @param examinationTable
     * @param examinationTools
     */
    public ExaminationRoom(int examinationTable, int examinationTools) {
        this.examinationTable = examinationTable;
        this.examinationTools = examinationTools;
    }
}
