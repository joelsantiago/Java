package Presentation_Layer;

import Domain_Logic.Hospital;
import Domain_Objects.Doctor;
import Domain_Objects.Patient;
import Domain_Objects.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 6:06 PM
 */
public class MainForm {
    private JButton loginButton;
    private JButton clearButton;
    private JTextField userIdTextField;
    private JPasswordField passwordPasswordField;
    private JPanel MainPanel;
    private JButton signUpButton;

    JPanel contentPane;
    private JFrame frame;

    // Holds all the predefined domain objects to be used with other pages.
    // Send specific data structures to other pages in order to use.
    private Hospital hospital = new Hospital();

    // PAGES
    UserPage userPage;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainForm();
            }
        });
    }

    private void init_frame() {
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());

        createEnterAction(); // pressing enter activates login button
        addPanelsToContentPane(); // all panels are added here at the start
        frame = new JFrame("MainForm");
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MainForm() {
        init_frame();

        // Make a user to test functionality. Userid = 100, Password = 100.
        Person testPerson = new Patient("James", "1", "James", "Test", "9/8/93", "88211-924-123", "Address", "City", "198-123-123",
                "326-822-8823", "jamesemail.com", "eEC", "EEC", "123-853-8228", "3923-124-138", "InsuranceProvider",
                "InsuranceAccount", "m", "CA", "20", "","","94542", 5);

        Person testPerson2 = new Patient("Joel", "Password", "Joel", "Santiago", "12/31/86", "123-45-678", "123 Main St", "Pleasanton", "198-123-123",
                "326-822-8823", "joelsemail.com", "eEC", "EEC", "123-853-8228", "3923-124-138", "InsuranceProvider",
                "InsuranceAccount", "m", "CA", "26", "","","94588", 5);

        Person testDoc = new Doctor("admin", "admin", "Mutahar", "Ahmed", "docmiddle",
                "dateof", "m", "social", "doc@email", "mobile1232", 2, 1, "3", 3, 2);

        hospital.getAllUsers().put(testPerson.getUserName(), testPerson);
        hospital.getAllUsers().put(testPerson2.getUserName(),testPerson2);
        hospital.getAllStaff().put(testDoc.getUserName(), testDoc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                useLoginButtonAction();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTextFields();
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.show(contentPane, "New User Page");
            }

        });
    }

    private void addPanelsToContentPane() {
        // Default Page user sees, the Login Page.
        contentPane.add(MainPanel, "Login Page");

        // Page User sees after logging in.
        userPage = new UserPage(contentPane, hospital);
        JScrollPane scrollUserPage = new JScrollPane(userPage.getUserPagePanel());
        contentPane.add(scrollUserPage, "User Page");

        // Page User sees if they are Staff after logging in.
        AdminPage adminPage = new AdminPage(contentPane);
        JScrollPane scrollAdminPage = new JScrollPane(adminPage.getAdminPagePanel());
        contentPane.add(scrollAdminPage, "Admin Page");

        // Page User sees when signing up.
        NewUserPage newUserPage = new NewUserPage(contentPane, hospital);
        JScrollPane scrollNewUserPage = new JScrollPane(newUserPage.getNewUserPagePanel()); // NewUserPage requires scrolling.
        contentPane.add(scrollNewUserPage, "New User Page");

        // Page User sees when clicking on the View Surgery button in the Surgery Page.
        ScheduleSurgery scheduleSurgery = new ScheduleSurgery(contentPane, hospital);
        JScrollPane scrollScheduleSurgery = new JScrollPane(scheduleSurgery.getScheduleSurgeryPanel());
        contentPane.add(scrollScheduleSurgery, "Schedule Surgery Page");
    }

    private void clearTextFields() {
        userIdTextField.setText("");
        passwordPasswordField.setText("");
    }

    public void createEnterAction() {
        passwordPasswordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    useLoginButtonAction();
                }
            }
        });
    }

    public void useLoginButtonAction() {
        String enteredUserName = userIdTextField.getText();
        char[] pass = passwordPasswordField.getPassword();
        String enteredPassword = new String (pass);
        if(hospital.getAllUsers().containsKey(enteredUserName)) {
            String realPassword = hospital.getAllUsers().get(enteredUserName).getPassword();
            if(realPassword.equals(enteredPassword)) {
                goToUserPage(enteredUserName);
                return;
            } else {
                System.out.println("Wrong Password");
                clearTextFields();
                return;
            }
        }

        if(hospital.getAllStaff().containsKey(enteredUserName)) {
            String realPassword = hospital.getAllStaff().get(enteredUserName).getPassword();
            if(realPassword.equals(enteredPassword)) {
                goToAdminPage(enteredUserName);
                return;
            } else {
                System.out.println("Wrong Password");
                clearTextFields();
                return;
            }
        }
        System.out.println("Wrong User Name.");
    }

    private void goToAdminPage(String enteredUserName) {
        clearTextFields();
        CardLayout cl = (CardLayout) contentPane.getLayout();
        cl.show(contentPane, "Admin Page");
    }

    private void goToUserPage(String enteredUserName) {
        clearTextFields();
        userPage.setUserNameOfCurrentUser(enteredUserName); // send the user's information to the next view
        userPage.updateViewWithNewUserInfoInPatientInformationTab();
        userPage.updateViewWithNewUserInfoInEmailToDoctorTab();
        userPage.updateUserInfoInAppointmentTab();
        CardLayout c1 = (CardLayout) contentPane.getLayout();
        c1.show(contentPane, "User Page");
    }

    // Getters and Setters
    // TODO: Remove some getters and setters. Some shouldn't be public.
    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public JTextField getUserIdTextField() {
        return userIdTextField;
    }

    public void setUserIdTextField(JTextField userIdTextField) {
        this.userIdTextField = userIdTextField;
    }

    public JPasswordField getPasswordPasswordField() {
        return passwordPasswordField;
    }

    public void setPasswordPasswordField(JPasswordField passwordPasswordField) {
        this.passwordPasswordField = passwordPasswordField;
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        MainPanel = mainPanel;
    }
}
