package src.gui;

import src.ObjectSerializer;
import src.Util;
import src.products.DevOpsTool;
import src.products.IDE;
import src.products.SoftwareProduct;

import javax.swing.*;
import java.util.ArrayList;

public class DevOpsToolsController extends Controller<BaseModel, DevOpsToolForm> {
    private MainController mainController;

    public DevOpsToolsController(MainController mainController) {
        super(new BaseModel(), new DevOpsToolForm());
        this.mainController = mainController;
        initController();
    }

    @Override
    protected void initController() {
        DevOpsToolForm view = this.getView();
        MainModel mainModel = mainController.getModel();

        ArrayList<SoftwareProduct> products = mainModel.getProducts();
        DefaultListModel<String> listModel = (DefaultListModel<String>) view.getList1().getModel();
        for (SoftwareProduct softwareProduct : products) {
            listModel.addElement(softwareProduct.toString());
        }

        view.getDevOpsRadioButton().setSelected(true);

        view.getIdeRadioButton().addActionListener(e -> {
            mainController.setNewController(new IDEController(mainController));
        });
        view.getFrameworkRadioButton().addActionListener(e -> {
            mainController.setNewController(new FrameworkController(mainController));
        });
        view.getDevOpsRadioButton().addActionListener(e -> {

        });

        view.getCreateButton().addActionListener(e -> {
//            mainController.getModel().addProduct(null);
            System.out.println("Create button pressed");
            DevOpsTool devopstool = new DevOpsTool(view.getNameField().getText(), view.getDeveloperField().getText(),
                    view.getDatePicker().getDate(), view.getLicenceField().getText(), Double.parseDouble(view.getSizeField().getText()),
                    view.getDescField().getText(), view.getCategoryField().getText(), view.getCloudBasedBox().isSelected());
            mainModel.addProduct(devopstool);
            listModel.addElement(devopstool.toString());
        });
        view.getImportButton().addActionListener(e -> {
            System.out.println("Import button pressed");
            JFileChooser selectorFichero = Util.crearSelectorFichero();
            int opt = selectorFichero.showOpenDialog(null);
            if (opt == JFileChooser.APPROVE_OPTION) {
                ArrayList<SoftwareProduct> importedProducts = ObjectSerializer.readProductsFromFile(selectorFichero.getSelectedFile());
                if(!importedProducts.isEmpty()){
                    mainModel.setProducts(importedProducts);
                    for (SoftwareProduct softwareProduct : importedProducts) {
                        listModel.addElement(softwareProduct.toString());
                    }
                }
            }
        });
        view.getExportButton().addActionListener(e -> {
            System.out.println("Export button pressed");
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
