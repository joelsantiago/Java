package Domain_Objects;

import Relations.*;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 5:29 PM
 */
public class Patient extends RPerson {

    /*
    INHERITS THESE VARIABLES FROM RPerson
    -------------------------------------
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

    private String ECfirstName;
    private String EClastName;
    private String EChomePhone;
    private String ECmobilePhone;
    private String ECRelationship;
    private String insuranceProvider;
    private String insuranceAccount;
    private String state;
    private String age;
    private String zip;
    private String address;
    private String city;

    public Vector<Patient_Doctor> personDoctor = new Vector<Patient_Doctor>();
    public Vector<Patient_Head> personHead = new Vector<Patient_Head>();
    public Vector<Patient_Nurse> patientNurse = new Vector<Patient_Nurse>();

    public Vector<Visit> visit = new Vector<Visit>();
    public Vector<Appointment> appointment = new Vector<Appointment>();
    public Vector<Patient_Surgeon> patientSurgeon = new Vector<Patient_Surgeon>();
    public Vector<Diagnosis> diagnosis = new Vector<Diagnosis>();
    public Vector<BillingStatement> billingStatement = new Vector<BillingStatement>();
    public Vector<Prescription> prescription = new Vector<Prescription>();
    public InsurancePolicy insurancePolicy;

    public Patient(String userName, String password, String firstName, String lastName,
                   String dateOfBirth, String socialSecurity, String address,
                   String city, String homePhone, String mobilePhone,
                   String emailAddress, String ECfirstName, String EClastName,
                   String EChomePhone, String ECmobilePhone,
                   String insuranceProvider, String insuranceAccount,
                   String sex, String state, String age, String middleName,
                   String ECRelationship, String zip, int type) {

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setMiddleName(middleName);
        this.setDateOfBirth(dateOfBirth);
        this.setSex(sex);
        this.setSocialSecurity(socialSecurity);
        this.setEmailAddress(emailAddress);
        this.setPassword(password);
        this.setUserName(userName);
        this.setHomePhone(homePhone);
        this.setMobilePhone(mobilePhone);
        this.setType(type);
        this.ECfirstName = ECfirstName;
        this.EClastName = EClastName;
        this.EChomePhone = EChomePhone;
        this.ECmobilePhone = ECmobilePhone;
        this.ECRelationship = ECRelationship;
        this.insuranceProvider = insuranceProvider;
        this.insuranceAccount = insuranceAccount;
        this.state = state;
        this.zip = zip;
        this.address = address;
        this.city = city;
        this.age = age;
    }

    public String getECfirstName() {
        return ECfirstName;
    }

    public void setECfirstName(String ECfirstName) {
        this.ECfirstName = ECfirstName;
    }

    public String getEClastName() {
        return EClastName;
    }

    public void setEClastName(String EClastName) {
        this.EClastName = EClastName;
    }

    public String getEChomePhone() {
        return EChomePhone;
    }

    public void setEChomePhone(String EChomePhone) {
        this.EChomePhone = EChomePhone;
    }

    public String getECmobilePhone() {
        return ECmobilePhone;
    }

    public void setECmobilePhone(String ECmobilePhone) {
        this.ECmobilePhone = ECmobilePhone;
    }

    public String getECRelationship() {
        return ECRelationship;
    }

    public void setECRelationship(String ECRelationship) {
        this.ECRelationship = ECRelationship;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public String getInsuranceAccount() {
        return insuranceAccount;
    }

    public void setInsuranceAccount(String insuranceAccount) {
        this.insuranceAccount = insuranceAccount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Vector<Patient_Doctor> getPersonDoctor() {
        return personDoctor;
    }

    public void setPersonDoctor(Vector<Patient_Doctor> personDoctor) {
        this.personDoctor = personDoctor;
    }

    public Vector<Patient_Head> getPersonHead() {
        return personHead;
    }

    public void setPersonHead(Vector<Patient_Head> personHead) {
        this.personHead = personHead;
    }

    public Vector<Patient_Nurse> getPatientNurse() {
        return patientNurse;
    }

    public void setPatientNurse(Vector<Patient_Nurse> patientNurse) {
        this.patientNurse = patientNurse;
    }

    public Vector<Visit> getVisit() {
        return visit;
    }

    public void setVisit(Vector<Visit> visit) {
        this.visit = visit;
    }

    public Vector<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(Vector<Appointment> appointment) {
        this.appointment = appointment;
    }

    public Vector<Patient_Surgeon> getPatientSurgeon() {
        return patientSurgeon;
    }

    public void setPatientSurgeon(Vector<Patient_Surgeon> patientSurgeon) {
        this.patientSurgeon = patientSurgeon;
    }

    public Vector<Diagnosis> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Vector<Diagnosis> diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Vector<BillingStatement> getBillingStatement() {
        return billingStatement;
    }

    public void setBillingStatement(Vector<BillingStatement> billingStatement) {
        this.billingStatement = billingStatement;
    }

    public Vector<Prescription> getPrescription() {
        return prescription;
    }

    public void setPrescription(Vector<Prescription> prescription) {
        this.prescription = prescription;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }
}
