package Presentation_Layer;

import Domain_Logic.Hospital;
import Domain_Objects.Person;
import Domain_Objects.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 6:08 PM
 */
public class NewUserPage {
    private JTextField firstNameTextField;
    private JPanel newUserPagePanel;
    private JTextField lastNameTextField;
    private JTextField dateOfBirthTextField;
    private JTextField socialSecurityTextField;
    private JTextField addressTextField;
    private JTextField cityTextField;
    private JTextField homePhoneTextField;
    private JTextField mobilePhoneTextField;
    private JTextField emailAddressTextField;
    private JTextField ECfirstNameTextField;
    private JTextField EClastNameTextField;
    private JTextField EChomePhoneTextField;
    private JTextField ECmobilePhoneTextField;
    private JTextField insuranceProviderTextField;
    private JTextField insuranceAccountTextField;
    private JButton clearButton;
    private JButton registerButton;
    private JButton cancelButton;
    private JTextField userNameTextField;
    private JComboBox sexComboBox;
    private JComboBox stateComboBox;
    private JComboBox ageComboBox;
    private JPasswordField passwordPasswordField;

    JPanel contentPane;
    Hospital hospital;

    public NewUserPage(JPanel _contentPage, Hospital _hospital) {

        this.contentPane = _contentPage;
        this.hospital = _hospital;

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTextFields();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // They canceled the sign up so go back to the login page.
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.show(contentPane, "Login Page");
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Get all the input fields.
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String dateOfBirth = dateOfBirthTextField.getText();
                String socialSecurity = socialSecurityTextField.getText();
                String addressField = addressTextField.getText();
                String city = cityTextField.getText();
                String homePhone = homePhoneTextField.getText();
                String mobilePhone = mobilePhoneTextField.getText();
                String emailAddress = emailAddressTextField.getText();
                String ECfirstName = ECfirstNameTextField.getText();
                String EClastName = EClastNameTextField.getText();
                String EChomePhone= EChomePhoneTextField.getText();
                String ECmobilePhone = ECmobilePhoneTextField.getText();
                String insuranceProvider = insuranceProviderTextField.getText();
                String insuranceAccount = insuranceAccountTextField.getText();
                String userName = userNameTextField.getText();
                String sex = (String) sexComboBox.getSelectedItem();
                String state = (String) stateComboBox.getSelectedItem();
                String age = (String) ageComboBox.getSelectedItem();
                char[] pass = passwordPasswordField.getPassword();
                String password = new String (pass);

                // Check against user hash map.
                HashMap<String, Person> allUsers = hospital.getAllUsers();
                Boolean differentUser = true;
                for(Person person : allUsers.values()) {
                    if(person.getSocialSecurity().equals(socialSecurity)) {
                        // If the unique Social Security matches, the user is already registered
                        // in the system. Prompt them about it. Do not sign them up.
                        // TODO: WRITE A PROMPT.
                        System.out.println("Entered Social Security: " + socialSecurity +
                                " matches a user in our system.");
                        differentUser = false;
                    }
                }

                if(differentUser) {
                    // The user doesn't match any in the system, so create the user and add it.
                    Person newPerson = new Patient(userName, password, firstName, lastName,
                            dateOfBirth, socialSecurity, addressField, city, homePhone, mobilePhone,
                            emailAddress, ECfirstName, EClastName, EChomePhone, ECmobilePhone,
                            insuranceProvider, insuranceAccount, sex, state, age, "","","", 5);
                    allUsers.put(newPerson.getUserName(), newPerson);
                }

                /*
                HashMap<String, Person>testAllUsers = hospital.getAllUsers();
                for(Person person : testAllUsers.values()) {
                    Patient sPerson = (Patient) person;
                    System.out.println(sPerson.getUserName()); //test
                }
                */
            }
        });
    }

    public JPanel getNewUserPagePanel() {
        return newUserPagePanel;
    }

    public void setNewUserPagePanel(JPanel newUserPagePanel) {
        this.newUserPagePanel = newUserPagePanel;
    }

    private void clearTextFields() {
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        dateOfBirthTextField.setText("");
        socialSecurityTextField.setText("");
        addressTextField.setText("");
        cityTextField.setText("");
        homePhoneTextField.setText("");
        mobilePhoneTextField.setText("");
        emailAddressTextField.setText("");
        ECfirstNameTextField.setText("");
        EClastNameTextField.setText("");
        EChomePhoneTextField.setText("");
        ECmobilePhoneTextField.setText("");
        insuranceProviderTextField.setText("");
        insuranceAccountTextField.setText("");
        userNameTextField.setText("");
        passwordPasswordField.setText("");
    }
}
