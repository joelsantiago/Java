package Domain_Objects;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:30 PM
 */
public interface Person {

    public String getFirstName();
    public void setFirstName(String firstName);

    public String getLastName();
    public void setLastName(String lastName);

    public String getMiddleName();
    public void setMiddleName(String middleName);

    public String getDateOfBirth();
    public void setDateOfBirth(String dateOfBirth);

    public String getSex();
    public void setSex(String sex);

    public String getSocialSecurity();
    public void setSocialSecurity(String socialSecurity);

    public String getEmailAddress();
    public void setEmailAddress(String emailAddress);

    public String getPassword();
    public void setPassword(String password);

    public String getUserName();
    public void setUserName(String userName);

    public String getHomePhone();
    public void setHomePhone(String homePhone);

    public String getMobilePhone();
    public void setMobilePhone(String mobilePhone);

    public int getType();
    public void setType(int type);

    public Vector<String> getEmailMessages();
    public void setEmailMessages(Vector<String> emailMessages);
}
