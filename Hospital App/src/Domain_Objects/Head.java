package Domain_Objects;

import Relations.Patient_Head;

import java.util.Date;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:22 PM
 */
public class Head extends RPerson {
    /*
    INHERITED FROM RPerson
    -----------------------
    public String firstName;
    public String lastName;
    public String middleName;
    public String dateOfBirth;
    public String sex;
    public String socialSecurity;
    public String emailAddress;
    public String password;
    public String userName;
    public String homePhone;
    public String mobilePhone;
    public int type;
    private Vector<String> emailMessages;
    */

    private int yearsOfExperience;
    private String hiredDate;
    private Department department;
    private Vector<Patient_Head> personHead = new Vector<Patient_Head>();

    /**
     * @param yearsOfExperience
     * @param skillID
     * @param hiredDate
     */
    public Head(String userName, String password, String firstName, String lastName, String middleName,
                String dateOfBirth, String sex, String socialSecurity,  String emailAddress, String mobilePhone,
                int yearsOfExperience, int skillID, String hiredDate, int type) {

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setMiddleName(middleName);
        this.setDateOfBirth(dateOfBirth);
        this.setSex(sex);
        this.setSocialSecurity(socialSecurity);
        this.setEmailAddress(emailAddress);
        this.setPassword(password);
        this.setUserName(userName);
        this.setMobilePhone(mobilePhone);
        this.setType(type);

        this.yearsOfExperience = yearsOfExperience;
        this.hiredDate = hiredDate;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Vector<Patient_Head> getPersonHead() {
        return personHead;
    }

    public void setPersonHead(Vector<Patient_Head> personHead) {
        this.personHead = personHead;
    }
}
