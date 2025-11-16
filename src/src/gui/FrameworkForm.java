package src.gui;

import com.github.lgooddatepicker.components.DatePicker;
import src.products.SoftwareProduct;

import javax.swing.*;
import java.util.ArrayList;

public class FrameworkForm implements View{
    private JPanel mainPanel;
    private JRadioButton ideRadioButton;
    private JRadioButton frameworkRadioButton;
    private JRadioButton devOpsRadioButton;
    private JTextField nameField;
    private JTextField developerField;
    private DatePicker datePicker;
    private JTextField licenceField;
    private JTextField sizeField;
    private JTextField descField;
    private JTextField supportedLanguageField;
    private JButton createButton;
    private JButton importButton;
    private JButton exportButton;
    private JList<SoftwareProduct> list1;
    private JTextField currentVersionField;
    private JButton deleteButton;


    public FrameworkForm() {
        frameworkRadioButton.setSelected(true);
        list1.setModel(new DefaultListModel<SoftwareProduct>());
    }

    @Override
    public JComponent getSwingViewComponent() {
        return mainPanel;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JRadioButton getIdeRadioButton() {
        return ideRadioButton;
    }

    public JRadioButton getFrameworkRadioButton() {
        return frameworkRadioButton;
    }

    public JRadioButton getDevOpsRadioButton() {
        return devOpsRadioButton;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getDeveloperField() {
        return developerField;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public JTextField getLicenceField() {
        return licenceField;
    }

    public JTextField getSizeField() {
        return sizeField;
    }

    public JTextField getDescField() {
        return descField;
    }

    public JTextField getSupportedLanguageField() {
        return supportedLanguageField;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public JButton getImportButton() {
        return importButton;
    }

    public JButton getExportButton() {
        return exportButton;
    }

    public JList getList1() {
        return list1;
    }

    public JTextField getCurrentVersionField() {
        return currentVersionField;
    }
}
