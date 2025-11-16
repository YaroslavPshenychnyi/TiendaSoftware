package src.gui;

import src.Util;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainController extends Controller<MainModel, MainForm> implements WindowListener {

    private Controller subController;

    public MainController() {
        setModel(new MainModel());
        subController = new IDEController(this);
        setView(new MainForm(subController.getView()));
        initController();
    }

    public void setNewController(Controller newController) {
        subController = newController;
        this.getView().setChildView(newController.getView());
    }

    @Override
    protected void initController() {
        MainForm view = this.getView();
        view.getWindow().addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int resp = Util.mensajeConfirmacion("¿Desea cerrar la ventana?", "Salir");
        if (resp == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
