package src.gui;

import javax.swing.*;

public class MainForm implements View {
    private JPanel panel1;
    private JScrollPane scrollPane;
    private JPanel scrollablePanel;

    private JFrame window;
    private View childView;

    public MainForm(View childView) {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.childView = childView;
        scrollPane.setViewportView(this.childView.getSwingViewComponent());
        window.add(panel1);
        window.setSize(1600, 600);
        window.setVisible(true);
    }

    public View getChildView() {
        return childView;
    }

    public void setChildView(View childView) {
        this.childView = childView;
        scrollPane.setViewportView(this.childView.getSwingViewComponent());
    }

//    public void setNewContentToScrollPanel(JPanel newpPanel) {
//        scrollPane.setViewportView(newpPanel);
//        scrollPane.revalidate();
//        scrollPane.repaint();
//    }

    public JFrame getWindow() {
        return window;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JPanel getScrollablePanel() {
        return scrollablePanel;
    }

    @Override
    public JComponent getSwingViewComponent() {
        return panel1;
    }
}
