package Presentation_Layer;

import Domain_Logic.Hospital;
import Domain_Objects.*;
import Relations.Patient_Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 6:11 PM
 */
public class UserPage {

    // Parts of the GUI
    private JButton sendEmailButton;
    private JButton scheduleAppointment_scheduleAppointmentButton;
    private JButton surgeriesButton;
    private JButton viewAppointmentsButton;
    private JButton viewBillingReportButton;
    //private JButton editButton;
    private JButton logOutButton;
    private JPanel userPagePanel;
    private JTabbedPane userPage_tabbedPane;

    // Patient Information
    private JTextField patientInformation_firstName;
    private JTextField patientInformation_dateOfBirth;
    private JTextField patientInformation_age;
    private JTextField patientInformation_gender;
    private JTextField patientInformation_socialSecurity;
    private JTextField patientInformation_address;
    private JTextField patientInformation_city;
    private JTextField patientInformation_zipCode;
    private JTextField patientInformation_lastName;
    private JTextField patientInformation_homePhone;
    private JTextField patientInformation_mobilePhone;
    private JTextField patientInformation_emailAddress;
    private JTextField patientInformation_ECfirstName;
    private JTextField patientInformation_EClastName;
    private JTextField patientInformation_EChomePhone;
    private JTextField patientInformation_ECmobilePhone;
    private JTextField patientInformation_insuranceProvider;
    private JTextField patientInformation_insuranceAccount;
    private JComboBox patientInformation_stateComboBox;
    private JButton patientInformation_editButton;
    private JButton patientInformation_submitButton;

    // Patient History
    private JButton patientHistory_pharmacyButton;
    private JButton patientHistory_scheduleAppointmentButton;
    private JScrollPane patientHistory_appointmentHistoryTable;
    private JScrollPane patientHistory_prescriptionHistoryTable;

    // Email Doctor
    private JComboBox emailDoctor_doctorComboBox;
    private JTextField emailDoctor_recipientEmail;
    private JTextField emailDoctor_ccAddress;
    private JTextField emailDoctor_enterSubject;
    private JEditorPane emailDoctor_message;
    private JTextField emailDoctor_bccAddress;

    private JTable table1;
    private JTable table2;

    private JTree tree1;

    // Schedule Appointment
    private JComboBox scheduleAppointment_locationComboBox;
    private JTextField scheduleAppointment_firstName;
    private JTextField scheduleAppointment_lastName;
    private JTextField scheduleAppointment_emailAddress;
    private JTextField scheduleAppointment_address;
    private JTextField scheduleAppointment_city;
    private JComboBox scheduleAppointment_stateComboBox;
    private JTextField scheduleAppointment_reason;
    private JComboBox scheduleAppointment_doctorComboBox;
    private JTextPane scheduleAppointment_reasonMessage;
    private JButton scheduleAppointmentButton1;
    private JButton selectDateButton;


    private JTable table3;
    private JTextField billingReport_cardNumber;
    private JTextField billingReport_expDate;
    private JTextField billingReport_patientID;
    private JTextField billingReport_statementDate;
    private JTextField billingReport_dateDue;
    private JTextField billingReport_acctNumber;
    private JTextField billingReport_amtOwed;
    private JTextField billingReport_amtPaid;
    private JTextField billingReport_patientAddress;
    private JTextField billingReport_patientName;
    private JTable table4;
    private JTable table5;
    private JTextField userViewSurgeries_patientID;
    private JTable userViewSurgeries_surgerySchedule;
    private JTable userViewSurgeries_surgeryHistory;
    private JButton userViewSurgeries_scheduleSurgeryButton;
    private JComboBox scheduleAppointment_departmentComboBox;

    JPanel contentPane;
    Hospital hospital;

    private String userNameOfCurrentUser; // user name of user who is currently logged in

    public UserPage(JPanel _contentPane, Hospital _hospital) {
        this.hospital = _hospital;
        this.contentPane = _contentPane;
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.show(contentPane, "Login Page");
            }
        });

        patientInformation_editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateUserInfoInPatientInformationTab();
                updateViewWithNewUserInfoInPatientInformationTab();
            }
        });

        sendEmailButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendEmailToDoctor();
            }

        });

        // Schedules an appointment.
        scheduleAppointment_scheduleAppointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setUpAnAppointment();
            }
        });

        // Button sends user 2 tabs ahead to the Schedule Appointment tab
        patientHistory_scheduleAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPage_tabbedPane.setSelectedIndex(3);
            }
        });

        // Logs User out of User Page and throws back to Login Page for admin to log in
        userViewSurgeries_scheduleSurgeryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.show(contentPane, "Login Page");
            }
        });
    }


    public void updateUserInfoInPatientInformationTab() {
        Patient currentUser = (Patient) hospital.getAllUsers().get(userNameOfCurrentUser);
        currentUser.setFirstName(patientInformation_firstName.getText());
        currentUser.setDateOfBirth(patientInformation_dateOfBirth.getText());
        currentUser.setAge(patientInformation_age.getText());
        currentUser.setSex(patientInformation_gender.getText());
        currentUser.setAddress(patientInformation_address.getText());
        currentUser.setCity(patientInformation_city.getText());
        currentUser.setZip(patientInformation_zipCode.getText());
        currentUser.setLastName(patientInformation_lastName.getText());
        currentUser.setHomePhone(patientInformation_homePhone.getText());
        currentUser.setMobilePhone(patientInformation_mobilePhone.getText());
        currentUser.setEmailAddress(patientInformation_emailAddress.getText());
        currentUser.setECfirstName(patientInformation_ECfirstName.getText());
        currentUser.setEClastName(patientInformation_EClastName.getText());
        currentUser.setEChomePhone(patientInformation_EChomePhone.getText());
        currentUser.setECmobilePhone(patientInformation_ECmobilePhone.getText());
        currentUser.setInsuranceProvider(patientInformation_insuranceProvider.getText());
        currentUser.setInsuranceAccount(patientInformation_insuranceAccount.getText());
        currentUser.setState((String) patientInformation_stateComboBox.getSelectedItem());
    }

    public void updateViewWithNewUserInfoInPatientInformationTab() {
        Patient currentUser = (Patient) hospital.getAllUsers().get(userNameOfCurrentUser);
        patientInformation_firstName.setText(currentUser.getFirstName());
        patientInformation_dateOfBirth.setText(currentUser.getDateOfBirth());
        patientInformation_age.setText(currentUser.getAge());
        patientInformation_gender.setText(currentUser.getSex());
        patientInformation_socialSecurity.setText(currentUser.getSocialSecurity()); // social won't change
        patientInformation_address.setText(currentUser.getAddress());
        patientInformation_city.setText(currentUser.getCity());
        patientInformation_zipCode.setText(currentUser.getZip());
        patientInformation_lastName.setText(currentUser.getLastName());
        patientInformation_homePhone.setText(currentUser.getHomePhone());
        patientInformation_mobilePhone.setText(currentUser.getMobilePhone());
        patientInformation_emailAddress.setText(currentUser.getEmailAddress());
        patientInformation_ECfirstName.setText(currentUser.getECfirstName());
        patientInformation_EClastName.setText(currentUser.getEClastName());
        patientInformation_EChomePhone.setText(currentUser.getEChomePhone());
        patientInformation_ECmobilePhone.setText(currentUser.getECmobilePhone());
        patientInformation_insuranceProvider.setText(currentUser.getInsuranceProvider());
        patientInformation_insuranceAccount.setText(currentUser.getInsuranceAccount());
    }

    public void sendEmailToDoctor() {
        String docUserName = (String) emailDoctor_doctorComboBox.getSelectedItem();
        String subjectOfMessage = emailDoctor_enterSubject.getText();
        String bodyOfMessage = emailDoctor_message.getText();
        // in the form of user:subject:message
        String emailMessage = userNameOfCurrentUser + ":" +  subjectOfMessage + ":" + bodyOfMessage;
        Doctor docUserPicked = (Doctor) hospital.getAllStaff().get(docUserName);
        docUserPicked.getEmailMessages().add(emailMessage);

        // TODO: WRITE A EMAIL SUCCESS DIALOG
        System.out.println("You have emailed Doctor " + docUserPicked.getLastName() + ".");
    }

    public void updateViewWithNewUserInfoInEmailToDoctorTab() {

        // TODO: REMOVE THE 'Enter Recipient Email Address', 'Enter CC Address', 'Enter BCC Address'
        emailDoctor_bccAddress.setText("REMOVE THIS");
        emailDoctor_ccAddress.setText("REMOVE THIS");
        emailDoctor_recipientEmail.setText("REMOVE THIS");
        Patient currentUser = (Patient) hospital.getAllUsers().get(userNameOfCurrentUser);
        updateDoctorComboBoxHelper(currentUser, emailDoctor_doctorComboBox);
    }

    public void setUpAnAppointment() {
        String locationPicked = (String) scheduleAppointment_locationComboBox.getSelectedItem();
        String firstName = scheduleAppointment_firstName.getText();
        String lastName = scheduleAppointment_lastName.getText();
        String emailAddress = scheduleAppointment_emailAddress.getText();
        String address = scheduleAppointment_address.getText();
        String city = scheduleAppointment_city.getText();
        String state = (String) scheduleAppointment_stateComboBox.getSelectedItem();
        String basicReason = scheduleAppointment_reason.getText();
        String fullReason = scheduleAppointment_reasonMessage.getText();
        Department department = new Department((String) scheduleAppointment_departmentComboBox.getSelectedItem());
        String docName = (String) scheduleAppointment_doctorComboBox.getSelectedItem();

        // This lines adds a a relation between a doctor and a patient with the middling happening with the Appointment.
        Doctor docWithAppointment = (Doctor) hospital.getAllStaff().get(docName);
        Patient currentUser = (Patient) hospital.getAllUsers().get(userNameOfCurrentUser);
        Patient_Doctor newPatientDoctorRelation = new Patient_Doctor(docWithAppointment, currentUser);
        currentUser.getPersonDoctor().add(newPatientDoctorRelation);
        docWithAppointment.getPersonDoctor().add(newPatientDoctorRelation);
        Room room = hospital.getAllRooms().pop();
        Appointment newAppointment = new Appointment(docWithAppointment, currentUser, department, basicReason, fullReason, room);
        docWithAppointment.getAppointment().add(newAppointment);
        currentUser.getAppointment().add(newAppointment);

        // TODO: ADD A SUCCESS ALERT THAT THE USER SUCCESSFULLY ADDED AN APPOINTMENT.
        updateViewWithNewUserInfoInEmailToDoctorTab();
        System.out.println("You have set an appointment.");

    }

    public void updateUserInfoInAppointmentTab() {
        Patient currentUser = (Patient) hospital.getAllUsers().get(userNameOfCurrentUser);
        scheduleAppointment_firstName.setText(currentUser.getFirstName());
        scheduleAppointment_lastName.setText(currentUser.getLastName());
        scheduleAppointment_emailAddress.setText(currentUser.getEmailAddress());
        scheduleAppointment_address.setText(currentUser.getAddress());
        scheduleAppointment_city.setText(currentUser.getCity());
        scheduleAppointment_stateComboBox.removeAllItems();
        scheduleAppointment_stateComboBox.addItem(currentUser.getState());
        scheduleAppointment_reason.setText("Reason For Appointment");
        scheduleAppointment_reasonMessage.setText("Detailed Reasons Here.");
        updateDocComboBoxInScheduleAppointment(hospital, scheduleAppointment_doctorComboBox);
    }

    private void updateDocComboBoxInScheduleAppointment(Hospital hospital, JComboBox<String> comboBox) {
        comboBox.removeAllItems();
        HashMap<String, Person> allStaff = hospital.getAllStaff();
        for(Person person : allStaff.values()) {
            if(person.getType() == 2) {
                Doctor doc = (Doctor) person;
                comboBox.addItem(doc.getUserName());
            }
        }
    }

    private void updateDoctorComboBoxHelper(Patient currentUser, JComboBox<String> comboBox) {
        // This method takes any combobox that relates to a doctor and fills it up with a user's related doctors.
        Vector<Patient_Doctor> person_Doctor = currentUser.getPersonDoctor();
        comboBox.removeAllItems();
        for (Patient_Doctor getDoc : person_Doctor) {
            comboBox.addItem(getDoc.getDoctor().getUserName());
        }

        if (comboBox.getItemCount() == 0) {
            comboBox.addItem("No Doctors Available");
        }
    }

    public JPanel getUserPagePanel() {
        return userPagePanel;
    }

    public void setUserPagePanel(JPanel userPagePanel) {
        this.userPagePanel = userPagePanel;
    }

    public JButton getLogOutButton() {
        return logOutButton;
    }

    public void setLogOutButton(JButton logOutButton) {
        this.logOutButton = logOutButton;
    }

    public String getUserNameOfCurrentUser() {
        return userNameOfCurrentUser;
    }

    public void setUserNameOfCurrentUser(String userNameOfCurrentUser) {
        this.userNameOfCurrentUser = userNameOfCurrentUser;
    }
}
