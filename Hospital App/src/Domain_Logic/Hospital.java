package Domain_Logic;

import Domain_Objects.*;

import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 4:53 PM
 */
public class Hospital {
    private Vector<ExaminationRoom> allExamRooms = new Vector<ExaminationRoom>();
    private Vector<Office> allOffices = new Vector<Office>();
    private Vector<OperatingRoom> allOperatingRooms = new Vector<OperatingRoom>();
    private Vector<Department> allDepartments = new Vector<Department>();
    private Vector<Insurance> allInsurance = new Vector<Insurance>();
    private Vector<InsurancePolicy> allInsurancePolicy = new Vector<InsurancePolicy>();
    private Stack<Room> allRooms = new Stack<Room>();

    public HashMap<String, Person> allUsers = new HashMap<String, Person>();
    public HashMap<String, Person> allStaff = new HashMap<String, Person>();

    private int NUM_INSURANCE_POLICY = 3;
    private int NUM_INSURANCE = 3;
    private int NUM_SKILLS = 10;
    private int NUM_DEPARTMENTS = 3;
    private int NUM_OPERATING_ROOMS = 3;
    private int NUM_OFFICES = 5;
    private int NUM_BEDS = 20;
    private int NUM_EXAM_ROOMS = 3;
    private int NUM_ROOMS = 30;

    /*
    Person Type will be as followed:
    Surgeon - 1
    Doctor  - 2
    Head    - 3
    Nurse   - 4
    Patient - 5
    */

    public Hospital() {
        build_exam_rooms();
        build_offices();
        build_operating_rooms();
        hire_nurses();
        hire_surgeons();
        hire_doctors();
        hire_heads();
        build_departments();
        build_insurance();
        build_insurance_policy();
        build_rooms();

        generate_users();
    }

    private void generate_users() {
        Person a = new Patient("a", "password", "Sterling", "Archer", "1/1/92", "123-123-123", "Address", "City", "310-123-123",
                "323-123-123", "email.com", "aEC", "AEC", "123-123-123", "323-123-122", "InsuranceProvider",
                "InsuranceAccount", "m", "CA", "20", "middle","spouse","95112", 5);
        allUsers.put(a.getUserName(), a);

        Person b = new Patient("b", "password", "Ray", "Gillette", "1/1/91", "223-124-123", "Address", "City", "311-123-123",
                "323-125-123", "email.com", "bEC", "BEC", "123-153-123", "323-124-122", "InsuranceProvider",
                "InsuranceAccount", "m", "CA", "21", "middle","spouse","95112", 5);
        allUsers.put(b.getUserName(), b);

        Person c = new Patient("c", "password", "Lana", "Kane", "1/1/93", "253-124-123", "Address", "City", "111-123-123",
                "326-122-123", "email.com", "cEC", "CEC", "123-753-523", "323-124-132", "InsuranceProvider",
                "InsuranceAccount", "m", "CA", "26", "middle","spouse","95112", 5);
        allUsers.put(c.getUserName(), c);

        Person d = new Patient("d", "password", "Doctor", "Krieger", "9/1/93", "953-924-123", "Address", "City", "191-123-123",
                "326-822-193", "email.com", "dEC", "DEC", "123-853-528", "393-124-130", "InsuranceProvider",
                "InsuranceAccount", "f", "CA", "29", "middle","spouse","95112", 5);
        allUsers.put(d.getUserName(), d);

        Person e = new Patient("e", "password", "Cyril", "Figgis", "9/8/93", "883-924-123", "Address", "City", "198-123-123",
                "326-822-883", "email.com", "eEC", "EEC", "123-853-828", "393-124-138", "InsuranceProvider",
                "InsuranceAccount", "f", "CA", "27", "middle","spouse","95112", 5);
        allUsers.put(e.getUserName(), e);

        Person James = new Patient("James", "1", "James", "Nguyen", "9/8/93", "88211-924-123", "Address", "City", "198-123-123",
                "326-822-8823", "jamesemail.com", "eEC", "EEC", "123-853-8228", "3923-124-138", "InsuranceProvider",
                "InsuranceAccount", "m", "CA", "20", "","","94542", 5);
        allUsers.put(James.getUserName(), James);

        Person Joel = new Patient("Joel", "Password", "Joel", "Santiago", "12/31/86", "123-45-678", "123 Main St", "Pleasanton", "198-123-123",
                "326-822-8823", "joelsemail.com", "eEC", "EEC", "123-853-8228", "3923-124-138", "InsuranceProvider",
                "InsuranceAccount", "m", "CA", "26", "","","94588", 5);
        allUsers.put(Joel.getUserName(), Joel);
    }

    private void hire_surgeons() {
        Person aSurgeon = new Surgeon("aSurgUser", "aSurPW", "Michael", "Bluth", "M",
                "surgDateOfBirth", "m", "social102323", "surg@email.com", "102302", 5, 3, 1);
        Person bSurgeon = new Surgeon("bSurgUser", "bSurPW", "GOB", "Bluth", "R",
                "surgDbteOfBirth", "m", "socibl102323", "surg@embil.com", "102302", 5, 3, 1);
        Person cSurgeon = new Surgeon("cSurgUser", "cSurPW", "George", "Bluth Sr.", "L",
                "surgDcteOfBirth", "m", "socicl102323", "surg@emcil.com", "102302", 5, 3, 1);
        Person dSurgeon = new Surgeon("dSurgUser", "dSurPW", "Buster", "Bluth", "N",
                "surgDdteOfBirth", "m", "sodidl102323", "surg@emdil.dom", "102302", 5, 3, 1);
        Person eSurgeon = new Surgeon("eSurgUser", "eSurPW", "George Michael", "Bluth", "M",
                "surgDeteOfBirth", "m", "soeiel102323", "surg@emeil.eom", "102302", 5, 3, 1);
        Person fSurgfon = new Surgeon("fSurgUsfr", "fSurPW", "Tobias", "Funke", "G",
                "surgDftfOfBirth", "m", "sofifl102323", "surg@fmfil.fom", "102302", 5, 3, 1);

        allStaff.put(aSurgeon.getUserName(), aSurgeon);
        allStaff.put(bSurgeon.getUserName(), bSurgeon);
        allStaff.put(cSurgeon.getUserName(), cSurgeon);
        allStaff.put(dSurgeon.getUserName(), dSurgeon);
        allStaff.put(eSurgeon.getUserName(), eSurgeon);
        allStaff.put(fSurgfon.getUserName(), fSurgfon);
    }

    private void hire_doctors() {
        Person aDoc = new Doctor("aDoc", "aDocPass", "Walter", "White", "A",
                "dateof", "m", "social", "doc@email", "mobile1232", 2, 1, "3", 3, 2);
        Person bDoc = new Doctor("bDoc", "bDocPbss", "Jesse", "Pinkman", "B",
                "dbteof", "m", "socibl", "doc@embil", "mobile1232", 2, 1, "3", 3, 2);
        Person cDoc = new Doctor("cDoc", "cDocPcss", "Saul", "Goodman", "C",
                "dcteof", "m", "socicl", "doc@emcil", "mobile1232", 2, 1, "3", 3, 2);
        Person dDoc = new Doctor("dDoc", "dDocPdss", "Gustavo", "Fring", "D",
                "ddteof", "m", "socidl", "doc@emdil", "mobile1232", 2, 1, "3", 3, 2);
        Person eDoc = new Doctor("eDoc", "eDocPess", "Skylar", "White", "E",
                "deteof", "m", "sociel", "doc@emeil", "mobile1232", 2, 1, "3", 3, 2);
        Person fDoc = new Doctor("fDoc", "fDocPfss", "Mike", "Ehrmantraut", "F",
                "dfteof", "m", "socifl", "doc@emfil", "mobile1232", 2, 1, "3", 3, 2);
        Person zDoc = new Doctor("zDoc", "zDocPzss", "Hank", "Schrader", "G",
                "dzteof", "m", "socizl", "doc@emzil", "mobile1232", 2, 1, "3", 3, 2);
        allStaff.put(aDoc.getUserName(), aDoc);
        allStaff.put(bDoc.getUserName(), bDoc);
        allStaff.put(cDoc.getUserName(), cDoc);
        allStaff.put(dDoc.getUserName(), dDoc);
        allStaff.put(eDoc.getUserName(), eDoc);
        allStaff.put(fDoc.getUserName(), fDoc);
        allStaff.put(zDoc.getUserName(), zDoc);
    }

    private void hire_heads() {
        Person aHead = new Head("aHeadusername", "aHeadpassword", "Bob", "Kelso", "A",
                "dateofbirth", "m", "social", "email@email", "mobile", 3, 3, "1", 3);
        Person bHebd = new Head("bHebdusernbme", "bHebdpbssword", "Perry", "Cox", "B",
                "dbteofbirth", "m", "socibl", "embil@embil", "mobile", 3, 3, "1", 3);
        Person cHecd = new Head("cHecduserncme", "cHecdpcssword", "Chris", "Turk", "C",
                "dcteofbirth", "m", "socicl", "emcil@emcil", "mobile", 3, 3, "1", 3);
        Person dHedd = new Head("dHedduserndme", "dHeddpdssword", "Jordan", "Sullivan", "D",
                "ddteofbirth", "m", "socidl", "emdil@emdil", "mobile", 3, 3, "1", 3);
        Person eHeed = new Head("eHeeduserneme", "eHeedpessword", "Peter", "Hooch", "E",
                "deteofbirth", "m", "sociel", "emeil@emeil", "mobile", 3, 3, "1", 3);
        Person fHefd = new Head("fHefdusernfme", "fHefdpfssword", "Doug", "Murphy", "F",
                "dfteofbirth", "m", "socifl", "emfil@emfil", "mobile", 3, 3, "1", 3);

        allStaff.put(aHead.getUserName(), aHead);
        allStaff.put(bHebd.getUserName(), bHebd);
        allStaff.put(cHecd.getUserName(), cHecd);
        allStaff.put(dHedd.getUserName(), dHedd);
        allStaff.put(eHeed.getUserName(), eHeed);
        allStaff.put(fHefd.getUserName(), fHefd);
    }

    private void hire_nurses() {
        Person aNurse = new Nurse("nurseUserName", "nusrePass", "Carla", "Turk", "A",
                "dateofb", "f", "asdfadfsocial", "email", "1212", 4);
        Person bNurse = new Nurse("nurseUserNbme", "nusrePbss", "Laverne", "Roberts", "B",
                "dbteofb", "f", "bsdfbdfsocibl", "embil", "1212", 4);
        Person cNurse = new Nurse("nurseUserNcme", "nusrePcss", "Elliot", "Reid", "C",
                "dcteofb", "f", "csdfcdfsocicl", "emcil", "1212", 4);
        Person dNurse = new Nurse("nurseUserNdme", "nusrePdss", "The", "Todd", "D",
                "ddteofb", "f", "dsdfddfsocidl", "emdil", "1212", 4);
        Person eNurse = new Nurse("nurseUserNeme", "nusrePess", "Ted", "Buckland", "E",
                "deteofb", "f", "esdfedfsociel", "emeil", "1212", 4);
        Person fNurse = new Nurse("nurseUserNfme", "nusrePfss", "Dorian", "Dorian", "F",
                "dfteofb", "f", "fsdffdfsocifl", "emfil", "1212", 4);

        allStaff.put(aNurse.getUserName(), aNurse);
        allStaff.put(bNurse.getUserName(), bNurse);
        allStaff.put(cNurse.getUserName(), cNurse);
        allStaff.put(dNurse.getUserName(), dNurse);
        allStaff.put(eNurse.getUserName(), eNurse);
        allStaff.put(fNurse.getUserName(), fNurse);
    }

    private void build_insurance_policy() {
        for(int i=0; i<NUM_INSURANCE_POLICY; i++) {
            InsurancePolicy newInsurancePolicy = new InsurancePolicy(i, i, i, i, i); //AuthCode, DayApproved, Gnum, Pnum, Anum
            allInsurancePolicy.add(newInsurancePolicy);
        }
    }

    private void build_insurance() {
        String[] contactName = {"Michael Scott", "Jim Halpert", "Dwight Schrute"};
        String[] providerName = {"Liberty Mutual", "State Farm", "Farmers"};
        for(int i=0; i<NUM_INSURANCE; i++) {
            Insurance newInsurance = new Insurance(contactName[i], i, providerName[i]); //Contact, Contact#, Provider
            allInsurance.add(newInsurance);
        }
    }

    private void build_rooms(){
        int[] roomNum = {101,102,103,104,105,106,107,108,109,110,
                201,202,203,204,205,206,207,208,209,210,
                301,302,303,304,305,306,307,308,309,310};

        for(int i=0; i<NUM_ROOMS;i++){
            Room room = new Room(roomNum[i]);
            allRooms.push(room);
        }
    }

    private void build_departments() {
        String[] departmentName = {"Accident and Emergency", "Anaesthetics", "Breast screening","Cardiology","Chaplaincy",
                "Critical care","Diagnostic imaging","Discharge lounge","Ear nose and throat (ENT)","Elderly services department",
                "Gastroenterology","General surgery","Gynaecology","Haematology","Maternity departments","Microbiology","Neonatal unit",
                "Nephrology","Neurology","Nutrition and dietetics","Obstetrics and gynaecology units","Occupational therapy",
                "Oncology","Ophthalmology","Orthopaedics","Pain management clinics","Pharmacy","Physiotherapy","Radiotherapy",
                "Renal unit","Rheumatology","Sexual health (genitourinary medicine)","Urology"};
        for(int i=0; i<departmentName.length; i++) {
            Department newDepartment = new Department(departmentName[i]); //Dname
            allDepartments.add(newDepartment);
        }
    }

    private void build_operating_rooms() {
        for(int i=0; i<NUM_OPERATING_ROOMS; i++) {
            OperatingRoom newOpRoom = new OperatingRoom(i+1); //Room Number
            allOperatingRooms.add(newOpRoom);
        }
    }

    private void build_offices() {
        for(int i=0; i<NUM_OFFICES; i++) {
            Office newOffice = new Office(i, "Placeholder", "Placeholder");
            allOffices.add(newOffice);
        }
    }

    private void build_exam_rooms() {
        for(int i=0; i<NUM_EXAM_ROOMS; i++) {
            ExaminationRoom newRoom = new ExaminationRoom(i, i); // use i for tools and table: placeholder
            allExamRooms.add(newRoom);
        }
    }

    public HashMap<String, Person> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(HashMap<String, Person> allUsers) {
        this.allUsers = allUsers;
    }

    public Vector<ExaminationRoom> getAllExamRooms() {
        return allExamRooms;
    }

    public void setAllExamRooms(Vector<ExaminationRoom> allExamRooms) {
        this.allExamRooms = allExamRooms;
    }

    public Vector<Office> getAllOffices() {
        return allOffices;
    }

    public void setAllOffices(Vector<Office> allOffices) {
        this.allOffices = allOffices;
    }

    public Vector<OperatingRoom> getAllOperatingRooms() {
        return allOperatingRooms;
    }

    public void setAllOperatingRooms(Vector<OperatingRoom> allOperatingRooms) {
        this.allOperatingRooms = allOperatingRooms;
    }

    public Vector<Department> getAllDepartments() {
        return allDepartments;
    }

    public void setAllDepartments(Vector<Department> allDepartments) {
        this.allDepartments = allDepartments;
    }

    public Vector<InsurancePolicy> getAllInsurancePolicy() {
        return allInsurancePolicy;
    }

    public void setAllInsurancePolicy(Vector<InsurancePolicy> allInsurancePolicy) {
        this.allInsurancePolicy = allInsurancePolicy;
    }

    public Vector<Insurance> getAllInsurance() {
        return allInsurance;
    }

    public void setAllInsurance(Vector<Insurance> allInsurance) {
        this.allInsurance = allInsurance;
    }

    public HashMap<String, Person> getAllStaff() {
        return this.allStaff;
    }

    public void setAllStaff(HashMap<String, Person> allStaff) {
        this.allStaff = allStaff;
    }

    public Stack<Room> getAllRooms(){
        return this.allRooms;
    }

    public void setAllRooms(Stack<Room> allRooms) {
        this.allRooms = allRooms;
    }
}