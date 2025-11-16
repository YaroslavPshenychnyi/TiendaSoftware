package src.gui;

import org.xml.sax.SAXException;
import src.ObjectSerializer;
import src.Util;
import src.products.IDE;
import src.products.SoftwareProduct;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IDEController extends Controller<BaseModel, IDEForm> {

    private MainController mainController;

    public IDEController(MainController mainController) {
        super(new BaseModel(), new IDEForm());
        this.mainController = mainController;
        initController();
    }

    @Override
    protected void initController() {
        IDEForm view = this.getView();
        MainModel mainModel = mainController.getModel();

        ArrayList<SoftwareProduct> products = mainModel.getProducts();
        DefaultListModel<String> listModel = (DefaultListModel<String>) view.getList1().getModel();
        for (SoftwareProduct softwareProduct : products) {
            listModel.addElement(softwareProduct.toString());
        }

        view.getIdeRadioButton().setSelected(true);

        view.getIdeRadioButton().addActionListener(e -> {

        });
        view.getFrameworkRadioButton().addActionListener(e -> {
            mainController.setNewController(new FrameworkController(mainController));
        });
        view.getDevOpsRadioButton().addActionListener(e -> {
            mainController.setNewController(new DevOpsToolsController(mainController));
        });


        view.getCreateButton().addActionListener(e -> {
            System.out.println("Create button pressed");
            IDE ide = new IDE(view.getNameField().getText(), view.getDeveloperField().getText(),
                    view.getDatePicker().getDate(), view.getLicenceField().getText(), Double.parseDouble(view.getSizeField().getText()),
                    view.getDescField().getText(), view.getSupportLanguageField().getText(), view.getSupportedPluginsBox().isSelected());
            mainModel.addProduct(ide);
            listModel.addElement(ide.toString());
        });
        view.getImportButton().addActionListener(e -> {
            JFileChooser selectorFichero = Util.crearSelectorFichero();
            int opt = selectorFichero.showOpenDialog(null);
            if (opt == JFileChooser.APPROVE_OPTION) {
                ArrayList<SoftwareProduct> importedProducts = ObjectSerializer.readProductsFromFile(selectorFichero.getSelectedFile());
                if (!importedProducts.isEmpty()) {
                    mainModel.setProducts(importedProducts);
                    for (SoftwareProduct softwareProduct : importedProducts) {
                        listModel.addElement(softwareProduct.toString());
                    }

                }
            }
        });
        view.getExportButton().addActionListener(e -> {
            System.out.println("Export button pressed");
            JFileChooser selectorFichero = Util.crearSelectorFichero();
            int opt = selectorFichero.showSaveDialog(null);
            if (opt == JFileChooser.APPROVE_OPTION) {
                ObjectSerializer.writeProductsToFile(mainModel.getProducts(), selectorFichero.getSelectedFile());
            }
        });
        view.getDeleteButton().addActionListener(e -> {
            DefaultListModel model = (DefaultListModel) view.getList1().getModel();

            while (!view.getList1().isSelectionEmpty()) {
                model.remove(view.getList1().getSelectedIndex());
            }

        });

    }
}
