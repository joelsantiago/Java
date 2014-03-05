package Domain_Objects;

import Relations.Surgeon_Surgery;
import Relations.Surgery_Nurse;

import java.util.Date;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:52 PM
 */
public class Surgery {
    private String surgeryType;
    public Vector<Surgeon_Surgery> surgeonSurgery = new Vector<Surgeon_Surgery>();
    private String guarantor;
    private String attendingSurgeon;
    public Date date;
    private int diagnosisCode;
    private String procedure;
    private String attendingAssistant;
    public Vector<Surgery_Nurse> surgeryNurse = new Vector<Surgery_Nurse>();
    private int procedureCode;
    public OperatingRoom operatingRoom;
    private String description;

    /**
     * @param surgeryType
     * @param guarantor
     * @param attendingSurgeon
     * @param date
     * @param diagnosisCode
     * @param procedure
     * @param attendingAssistant
     * @param procedureCode
     * @param description
     */
    public Surgery(String surgeryType, String guarantor, String attendingSurgeon,Date date, int diagnosisCode, String procedure, String attendingAssistant,
                   int procedureCode, String description) {
        this.surgeryType = surgeryType;
        this.guarantor = guarantor;
        this.attendingSurgeon = attendingSurgeon;
        this.date = date;
        this.diagnosisCode = diagnosisCode;
        this.procedure = procedure;
        this.attendingAssistant = attendingAssistant;
        this.procedureCode = procedureCode;
        this.description = description;
    }
}
