package Presentation_Layer;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import Domain_Logic.Hospital;
import Domain_Objects.*;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 6:04 PM
 */
public class AdminPage {
    private JPanel panel1;
    private JTextField searchTextField;
    private JButton searchButton;
    private JButton logoutButton;
    private JTabbedPane adminPage_tabbedPane;
    private JTextField newPatient_lastName;
    private JTextField newPatient_firstName;
    private JTextField mITextField;
    private JComboBox newPatient_physicianComboBox;
    private JTextField newPatient_insuranceProvider;
    private JTextField newPatient_accountNumber;
    private JComboBox newPatient_sexComboBox;
    private JTextField newPatient_age;
    private JTextField newPatient_socialSecurity;
    private JTextField newPatient_ECmobileNumber;
    private JTextField newPatient_EChomeNumber;
    private JTextField admitPatient_state;
    private JTextField newPatient_ECfirstName;
    private JTextField newPatient_EClastName;
    private JTextField newPatient_emailAddress;
    private JTextField newPatient_mobilePhone;
    private JTextField newPatient_homePhone;
    private JTextField newPatient_zip;
    private JTextField newPatient_city;
    private JTextField newPatient_address;
    private JButton newPatient_createPatientButton;
    private JComboBox admitPatient_doctorComboBox;
    private JComboBox admitPatient_roomNumberComboBox;
    private JComboBox admitPatient_locationComboBox;
    private JTextField admitPatient_admissionReason;
    private JTextField admitPatient_lastName;
    private JTextField admitPatient_firstName;
    private JTextField admitPatient_emailAddress;
    private JTextField admitPatient_homeNumber;
    private JButton admitPatient_admitButton;
    private JTextPane admitPatient_comments;
    private JTabbedPane adminPatientServices_tabbedPane;
    private JFormattedTextField roomChange_patientID;

    private JPanel adminPagePanel;
    private JTextField newPatient_DOB;
    private JTextField roomChange_firstName;
    private JTextField roomChange_lastName;
    private JComboBox roomChange_newRoomComboBox;
    private JTextField roomChange_roomNumber;
    private JTextArea roomChange_reason;
    private JTextField scheduleSurgery_patientName;
    private JTextField scheduleSurgery_patientAddress;
    private JTextField scheduleSurgery_dateOfBirth;
    private JTextField scheduleSurgery_homePhone;
    private JTextField scheduleSurgery_mobilePhone;
    private JTextField scheduleSurgery_procedureCode;
    private JTextField scheduleSurgery_diagnosisCode;
    private JTextField scheduleSurgery_surgeryDate;
    private JTextArea scheduleSurgery_comments;
    private JComboBox scheduleSurgery_attnPhysicianComboBox;
    private JComboBox scheduleSurgery_primPhysicianComboBox;
    private JComboBox scheduleSurgery_nurseComboBox;
    private JTextField scheduleSurgery_insProvider;
    private JTextField scheduleSurgery_policyNumber;
    private JTextField scheduleSurgery_groupNumber;
    private JTextField scheduleSurgery_subscriberName;
    private JTextField scheduleSurgery_insPhone;
    private JTextField scheduleSurgery_authorizationNum;
    private JTextField scheduleSurgery_daysApproved;
    private JTextField scheduleSurgery_insContact;
    private JButton scheduleSurgeryButton;
    private JButton clearButton;
    private JButton cancelButton;
    private JTextField scheduleSurgery_procedure;
    private JButton submitRoomChangeButton;
    private JTextField viewSurgeries_patientID;
    private JButton viewSurgery_scheduleSurgeryButton;
    private JTable viewSurgery_surgeryHistoryTable;
    private JTable viewSurgery_surgeryScheduleTable;
    private JComboBox emailPatient_patientComboBox;
    private JButton addPatientButton;
    private JTextField emailPatient_recipientEmail;
    private JTextField emailPatient_ccAddress;
    private JTextField emailPatient_bccAddress;
    private JTextField emailPatient_emailSubject;
    private JButton sendMessageButton;
    private JTree tree1;
    private JTextArea emailPatient_emailMessage;
    private JComboBox newPatient_stateComboBox;
    private JButton admitPatient_findButton;
    private JComboBox admitPatient_patientComboBox;
    private JTextField admitPatient_ECname;
    private JTextField admitPatient_address;
    private JTextField admitPatient_city;
    private JTextField admitPatient_EChomeNumber;
    private JTextField admitPatient_ECmobileNumber;
    private JTextField patientCheck_patientUserName;
    private JTextField patientCheck_firstName;
    private JTextField patientCheck_lastName;
    private JTextField scheduleSurgery_guarantor;
    private JComboBox newPatient_ECrelationComboBox;
    private JButton searchPatient;

    JPanel contentPane;
    Patient p;
    Hospital hospital = new Hospital();
    Doctor d = new Doctor();

    public AdminPage(JPanel _contentPane) {
        this.contentPane = _contentPane;

        ghostText();

        //populate patient combobox
        fillComboBox();

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout c1 = (CardLayout) contentPane.getLayout();
                c1.show(contentPane,"Login Page");
            }
        });

        searchPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPatient();
            }
        });

        viewSurgery_scheduleSurgeryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPatientServices_tabbedPane.setSelectedIndex(1);
            }
        });

        newPatient_createPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPatient();
            }
        });

        admitPatient_findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findAdmitPatient();
            }
        });

        admitPatient_admitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admitPatient();

            }
        });

        submitRoomChangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitRoomChange();
            }
        });
    }

    private void submitRoomChange() {
        String roomChangeFirstName = roomChange_firstName.getText();
        String roomChangeLastName = roomChange_lastName.getText();
        String roomChangeReason = roomChange_reason.getText();

        for(int i = 0; i < d.getAppointment().size(); i++) {
            if(d.getAppointment().get(i).getPatient().getFirstName().equals(roomChangeFirstName) &&
                    d.getAppointment().get(i).getPatient().getLastName().equals(roomChangeLastName)) {

                d.getAppointment().get(i).getRoom().setNewRoom(roomChange_newRoomComboBox.getSelectedItem().hashCode());
                d.getAppointment().get(i).getRoom().setReasonForNewRoom(roomChangeReason);

                JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
                JOptionPane.showMessageDialog(frame, "Room Changed");

                System.out.println(d.getAppointment().get(i).getRoom().getNewRoom());
                System.out.println(d.getAppointment().get(i).getRoom().getReasonForNewRoom());
            }
        }
    }

    public void fillComboBox() {
        for(Person p: hospital.allUsers.values()){
            Patient patient = (Patient)p;
            admitPatient_patientComboBox.addItem(patient.getFirstName());
            emailPatient_patientComboBox.addItem(patient.getFirstName());
        }

        //location/department combobox
        for(Department d: hospital.getAllDepartments())
            admitPatient_locationComboBox.addItem(d.getDepartmentName());

        //Room number combobox
        for(Room room: hospital.getAllRooms()){
            admitPatient_roomNumberComboBox.addItem(room.getRoomNum());
            roomChange_newRoomComboBox.addItem(room.getRoomNum());
        }

        //Doctor combobox admit Patient Page
        for(Person o: hospital.allStaff.values()){
            if(o.getType() == 2) {
                Doctor doctor = (Doctor)o;
                admitPatient_doctorComboBox.addItem("Dr. " + doctor.getLastName());
                newPatient_physicianComboBox.addItem("Dr. " + doctor.getLastName());
                scheduleSurgery_primPhysicianComboBox.addItem("Dr. " + doctor.getLastName());
            }
        }

        //Doctor combobox admit Patient Page
        for(Person o: hospital.allStaff.values()){
            if(o.getType() == 1) {
                Surgeon surgeon = (Surgeon)o;
                scheduleSurgery_attnPhysicianComboBox.addItem("Dr. " + surgeon.getLastName());
            }
        }

        //Doctor combobox admit Patient Page
        for(Person o: hospital.allStaff.values()){
            if(o.getType() == 4) {
                Nurse nurse = (Nurse)o;
                scheduleSurgery_nurseComboBox.addItem("Nurse " + nurse.getLastName());
            }
        }
    }

    public JPanel getAdminPagePanel() {
        return adminPagePanel;
    }

    public void setAdminPagePanel(JPanel adminPagePanel) {
        this.adminPagePanel = adminPagePanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void findAdmitPatient() {
        for(Person person: hospital.allUsers.values()){
            Patient patient = (Patient) person;
            if(patient.getFirstName() == admitPatient_patientComboBox.getSelectedItem()){
                admitPatient_firstName.setText(patient.getFirstName());
                admitPatient_lastName.setText(patient.getLastName());
                admitPatient_emailAddress.setText(patient.getEmailAddress());
                admitPatient_homeNumber.setText(patient.getHomePhone());
                admitPatient_address.setText(patient.getAddress());
                admitPatient_city.setText(patient.getCity());
                admitPatient_state.setText(patient.getState());
                admitPatient_ECname.setText(patient.getECfirstName() + " " + patient.getEClastName());
                admitPatient_EChomeNumber.setText(patient.getEChomePhone());
                admitPatient_ECmobileNumber.setText(patient.getECmobilePhone());
            }
        }
    }

    public void newPatient() {
        String nFirstName = newPatient_firstName.getText();
        String nLastName = newPatient_lastName.getText();
        String nMiddleName = mITextField.getText();
        String nDOB = newPatient_DOB.getText();
        String nAge = newPatient_age.getText();
        String nSSN = newPatient_socialSecurity.getText();
        String nAddress = newPatient_address.getText();
        String nCity = newPatient_city.getText();
        String nZip = newPatient_zip.getText();
        String nHomePhone = newPatient_homePhone.getText();
        String nMobilePhone = newPatient_mobilePhone.getText();
        String nEmail = newPatient_emailAddress.getText();
        String nECFirstName = newPatient_ECfirstName.getText();
        String nECLastName = newPatient_EClastName.getText();
        String nECHomePhone = newPatient_EChomeNumber.getText();
        String nECMobilePhone = newPatient_ECmobileNumber.getText();
        String nInsuranceProvider = newPatient_insuranceProvider.getText();
        String nInsuranceAccountNum = newPatient_accountNumber.getText();

        Person g = new Patient("PLACEHOLDER_USERNAME", "PLACHOLDER_PASSWORD", nFirstName, nLastName, nDOB,
                nSSN, nAddress, nCity, nHomePhone, nMobilePhone, nEmail, nECFirstName, nECLastName, nECHomePhone,
                nECMobilePhone, nInsuranceProvider, nInsuranceAccountNum, newPatient_sexComboBox.getSelectedItem().toString(),
                newPatient_stateComboBox.getSelectedItem().toString(), nAge, nMiddleName,
                newPatient_ECrelationComboBox.getSelectedItem().toString(), nZip, 5);
        hospital.getAllUsers().put(nFirstName, g);

        newPatient_firstName.setText("");
        newPatient_lastName.setText("");
        mITextField.setText("");
        newPatient_DOB.setText("");
        newPatient_age.setText("");
        newPatient_socialSecurity.setText("");
        newPatient_address.setText("");
        newPatient_city.setText("");
        newPatient_zip.setText("");
        newPatient_homePhone.setText("");
        newPatient_mobilePhone.setText("");
        newPatient_emailAddress.setText("");
        newPatient_ECfirstName.setText("");
        newPatient_EClastName.setText("");
        newPatient_EChomeNumber.setText("");
        newPatient_ECmobileNumber.setText("");
        newPatient_insuranceProvider.setText("");
        newPatient_accountNumber.setText("");

        admitPatient_patientComboBox.addItem(nFirstName);

    }

    public void searchPatient() {
        String first = patientCheck_firstName.getText();
        String last = patientCheck_lastName.getText();

        for(int i = 0; i < d.getAppointment().size(); i++) {
            if(d.getAppointment().get(i).getPatient().getFirstName().equals(first) &&
                    d.getAppointment().get(i).getPatient().getLastName().equals(last)) {
                JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
                JOptionPane.showMessageDialog(frame, "Patient Found");

                roomChange_firstName.setText(first);
                roomChange_lastName.setText(last);
                roomChange_roomNumber.setText(""+d.getAppointment().get(i).getRoom().getRoomNum());
            }
        }
    }

    public void admitPatient() {

        String reason = admitPatient_admissionReason.getText();
        String description = admitPatient_comments.getText();

        for(Person person: hospital.allUsers.values()){
            Patient patient = (Patient)person;
            if(patient.getFirstName().equals(admitPatient_patientComboBox.getSelectedItem()))
                for(Person person1: hospital.allStaff.values())
                    if(person1.getType() == 2){
                        Doctor doctor = (Doctor)person1;
                        if(admitPatient_doctorComboBox.getSelectedItem().equals("Dr. " + doctor.getLastName())){
                            for(Room room: hospital.getAllRooms()){
                                if(admitPatient_roomNumberComboBox.getSelectedItem().equals(room.getRoomNum())){
                                    for(Department department: hospital.getAllDepartments()){
                                        if(department.getDepartmentName().equals(admitPatient_locationComboBox.getSelectedItem())){
                                            d.getAppointment().add(new Appointment(doctor, patient, department, reason, description, room));
                                            /*
                                            System.out.println("" + appointment.getDoctor().getFirstName());
                                            System.out.println(appointment.getPatient().getFirstName());
                                            System.out.println(appointment.getDepartment().getDepartmentName());
                                            System.out.println(appointment.getBasicReason());
                                            System.out.println(appointment.getFullReason());
                                            System.out.println(appointment.getRoom().getRoomNum());
                                            */
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
        }
    }

    public void ghostText() {
        GhostText PC_firstName = new GhostText(patientCheck_firstName,"First Name");
        GhostText PC_lastName = new GhostText(patientCheck_lastName,"Last Name");
        GhostText PC_enterPatient = new GhostText(patientCheck_patientUserName, "Enter Patient User Name");
    }

    public static class GhostText implements FocusListener, DocumentListener, PropertyChangeListener {
        private final JTextField textfield;
        private boolean isEmpty;
        private Color ghostColor;
        private Color foregroundColor;
        private final String ghostText;

        protected GhostText(final JTextField textfield, String ghostText) {
            super();
            this.textfield = textfield;
            this.ghostText = ghostText;
            this.ghostColor = Color.LIGHT_GRAY;
            textfield.addFocusListener(this);
            registerListeners();
            updateState();
            if (!this.textfield.hasFocus()) {
                focusLost(null);
            }
        }

        public void delete() {
            unregisterListeners();
            textfield.removeFocusListener(this);
        }

        private void registerListeners() {
            textfield.getDocument().addDocumentListener(this);
            textfield.addPropertyChangeListener("foreground", this);
        }

        private void unregisterListeners() {
            textfield.getDocument().removeDocumentListener(this);
            textfield.removePropertyChangeListener("foreground", this);
        }

        public Color getGhostColor() {
            return ghostColor;
        }

        public void setGhostColor(Color ghostColor) {
            this.ghostColor = ghostColor;
        }

        private void updateState() {
            isEmpty = textfield.getText().length() == 0;
            foregroundColor = textfield.getForeground();
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (isEmpty) {
                unregisterListeners();
                try {
                    textfield.setText("");
                    textfield.setForeground(foregroundColor);
                } finally {
                    registerListeners();
                }
            }

        }

        @Override
        public void focusLost(FocusEvent e) {
            if (isEmpty) {
                unregisterListeners();
                try {
                    textfield.setText(ghostText);
                    textfield.setForeground(ghostColor);
                } finally {
                    registerListeners();
                }
            }
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            updateState();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateState();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            updateState();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateState();
        }
    }
}
