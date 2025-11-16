package src.gui;

import com.github.lgooddatepicker.components.DatePicker;
import src.products.SoftwareProduct;

import javax.swing.*;
import java.util.ArrayList;

public class IDEForm implements View {
    private JPanel mainPanel;
    private JPanel panel;
    private JRadioButton ideRadioButton;
    private JRadioButton frameworkRadioButton;
    private JRadioButton devOpsRadioButton;
    private JPanel panel1;
    private JTextField nameField;
    private JTextField developerField;
    private DatePicker datePicker;
    private JTextField licenceField;
    private JTextField sizeField;
    private JTextField descField;
    private JTextField supportLanguageField;
    private JCheckBox supportPluginsBox;
    private JButton createButton;
    private JButton importButton;
    private JButton exportButton;
    private JList<SoftwareProduct> list1;
    private JButton deleteButton;

    public IDEForm() {
        ideRadioButton.setSelected(true);
        list1.setModel(new DefaultListModel<SoftwareProduct>());
    }

    public JList getList1() {
        return list1;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JPanel getPanel() {
        return panel;
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

    public JPanel getPanel1() {
        return panel1;
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

    public JTextField getSupportLanguageField() {
        return supportLanguageField;
    }

    public JCheckBox getSupportedPluginsBox() {
        return supportPluginsBox;
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


    @Override
    public JComponent getSwingViewComponent() {
        return mainPanel;
    }
}
