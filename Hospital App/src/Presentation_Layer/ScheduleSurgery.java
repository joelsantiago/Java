package Presentation_Layer;

import Domain_Logic.Hospital;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/4/14
 * Time: 6:10 PM
 */
public class ScheduleSurgery {
    private JPanel scheduleSurgeryPanel;
    private JTextField pIDtextField;
    private JTextField pNametextField;
    private JTextField pAddresstextField;
    private JTextField pDOBtextField;
    private JTextField phomePhonetextField;
    private JTextField pmobilePhonetextField;
    private JTextField pguarantortextField;
    private JTextField proceduretextField;
    private JTextField surgeryDatetextField;
    private JTextField procedureCodetextField;
    private JTextField diagnosisCodetextField;
    private JTextArea commentstextArea;
    private JComboBox comboBox1;
    private JComboBox assistantcomboBox;
    private JComboBox primPhysiciancomboBox;
    private JTextField insProvidertextField;
    private JTextField policytextField;
    private JTextField grouptextField;
    private JTextField subscribertextField;
    private JTextField insPhonetextField;
    private JTextField authNumtextField;
    private JTextField daysApprvtextField;
    private JTextField insContacttextField;
    private JCheckBox inpatientCheckBox;
    private JCheckBox outpatientCheckBox;
    private JButton cancelButton;
    private JButton clearButton;
    private JButton scheduleSurgeryButton;
    private JComboBox attnPhyscomboBox;

    JPanel contentPane;
    Hospital hospital;

    public ScheduleSurgery(JPanel _contentPane, Hospital _hospital) {
        this.contentPane = _contentPane;
        this.hospital = _hospital;

    }

    public JPanel getScheduleSurgeryPanel() {
        return scheduleSurgeryPanel;
    }

    public void setScheduleSurgeryPanel(JPanel scheduleSurgeryPanel) {
        this.scheduleSurgeryPanel = scheduleSurgeryPanel;
    }

    public JTextField getpIDtextField() {
        return pIDtextField;
    }

    public void setpIDtextField(JTextField pIDtextField) {
        this.pIDtextField = pIDtextField;
    }

    public JTextField getpNametextField() {
        return pNametextField;
    }

    public void setpNametextField(JTextField pNametextField) {
        this.pNametextField = pNametextField;
    }

    public JTextField getpAddresstextField() {
        return pAddresstextField;
    }

    public void setpAddresstextField(JTextField pAddresstextField) {
        this.pAddresstextField = pAddresstextField;
    }

    public JTextField getpDOBtextField() {
        return pDOBtextField;
    }

    public void setpDOBtextField(JTextField pDOBtextField) {
        this.pDOBtextField = pDOBtextField;
    }

    public JTextField getPhomePhonetextField() {
        return phomePhonetextField;
    }

    public void setPhomePhonetextField(JTextField phomePhonetextField) {
        this.phomePhonetextField = phomePhonetextField;
    }

    public JTextField getPmobilePhonetextField() {
        return pmobilePhonetextField;
    }

    public void setPmobilePhonetextField(JTextField pmobilePhonetextField) {
        this.pmobilePhonetextField = pmobilePhonetextField;
    }

    public JTextField getPguarantortextField() {
        return pguarantortextField;
    }

    public void setPguarantortextField(JTextField pguarantortextField) {
        this.pguarantortextField = pguarantortextField;
    }

    public JTextField getProceduretextField() {
        return proceduretextField;
    }

    public void setProceduretextField(JTextField proceduretextField) {
        this.proceduretextField = proceduretextField;
    }

    public JTextField getSurgeryDatetextField() {
        return surgeryDatetextField;
    }

    public void setSurgeryDatetextField(JTextField surgeryDatetextField) {
        this.surgeryDatetextField = surgeryDatetextField;
    }

    public JTextField getProcedureCodetextField() {
        return procedureCodetextField;
    }

    public void setProcedureCodetextField(JTextField procedureCodetextField) {
        this.procedureCodetextField = procedureCodetextField;
    }

    public JTextField getDiagnosisCodetextField() {
        return diagnosisCodetextField;
    }

    public void setDiagnosisCodetextField(JTextField diagnosisCodetextField) {
        this.diagnosisCodetextField = diagnosisCodetextField;
    }

    public JTextArea getCommentstextArea() {
        return commentstextArea;
    }

    public void setCommentstextArea(JTextArea commentstextArea) {
        this.commentstextArea = commentstextArea;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public void setComboBox1(JComboBox comboBox1) {
        this.comboBox1 = comboBox1;
    }

    public JComboBox getAssistantcomboBox() {
        return assistantcomboBox;
    }

    public void setAssistantcomboBox(JComboBox assistantcomboBox) {
        this.assistantcomboBox = assistantcomboBox;
    }

    public JComboBox getPrimPhysiciancomboBox() {
        return primPhysiciancomboBox;
    }

    public void setPrimPhysiciancomboBox(JComboBox primPhysiciancomboBox) {
        this.primPhysiciancomboBox = primPhysiciancomboBox;
    }

    public JTextField getInsProvidertextField() {
        return insProvidertextField;
    }

    public void setInsProvidertextField(JTextField insProvidertextField) {
        this.insProvidertextField = insProvidertextField;
    }

    public JTextField getPolicytextField() {
        return policytextField;
    }

    public void setPolicytextField(JTextField policytextField) {
        this.policytextField = policytextField;
    }

    public JTextField getGrouptextField() {
        return grouptextField;
    }

    public void setGrouptextField(JTextField grouptextField) {
        this.grouptextField = grouptextField;
    }

    public JTextField getSubscribertextField() {
        return subscribertextField;
    }

    public void setSubscribertextField(JTextField subscribertextField) {
        this.subscribertextField = subscribertextField;
    }

    public JTextField getInsPhonetextField() {
        return insPhonetextField;
    }

    public void setInsPhonetextField(JTextField insPhonetextField) {
        this.insPhonetextField = insPhonetextField;
    }

    public JTextField getAuthNumtextField() {
        return authNumtextField;
    }

    public void setAuthNumtextField(JTextField authNumtextField) {
        this.authNumtextField = authNumtextField;
    }

    public JTextField getDaysApprvtextField() {
        return daysApprvtextField;
    }

    public void setDaysApprvtextField(JTextField daysApprvtextField) {
        this.daysApprvtextField = daysApprvtextField;
    }

    public JTextField getInsContacttextField() {
        return insContacttextField;
    }

    public void setInsContacttextField(JTextField insContacttextField) {
        this.insContacttextField = insContacttextField;
    }

    public JCheckBox getInpatientCheckBox() {
        return inpatientCheckBox;
    }

    public void setInpatientCheckBox(JCheckBox inpatientCheckBox) {
        this.inpatientCheckBox = inpatientCheckBox;
    }

    public JCheckBox getOutpatientCheckBox() {
        return outpatientCheckBox;
    }

    public void setOutpatientCheckBox(JCheckBox outpatientCheckBox) {
        this.outpatientCheckBox = outpatientCheckBox;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public JButton getScheduleSurgeryButton() {
        return scheduleSurgeryButton;
    }

    public void setScheduleSurgeryButton(JButton scheduleSurgeryButton) {
        this.scheduleSurgeryButton = scheduleSurgeryButton;
    }
}
