package src.gui;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;

public class BaseSoftwareForm implements View {
    private JPanel panel1;
    private JTextField nameField;
    private JTextField developerField;
    private DatePicker datePicker;
    private JTextField licenceField;
    private JTextField sizeField;
    private JTextField descField;

    @Override
    public JComponent getSwingViewComponent() {
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
}
