package src.gui;

import javax.swing.*;

public class TipoSoftware implements View {
    private JPanel panel;
    private JRadioButton ideRadioButton;
    private JRadioButton frameworkRadioButton;
    private JRadioButton devOpsRadioButton;



    public JRadioButton getIDERadioButton() {
        return ideRadioButton;
    }

    public JRadioButton getFrameworkRadioButton() {
        return frameworkRadioButton;
    }

    public JRadioButton getDevOpsRadioButton() {
        return devOpsRadioButton;
    }

    @Override
    public JComponent getSwingViewComponent() {
        return panel;
    }
}
