package src.gui;

import src.products.SoftwareProduct;

import java.util.ArrayList;

public class MainModel implements Model {
    private ArrayList<SoftwareProduct> products;

    public MainModel() {
        this.products = new ArrayList<SoftwareProduct>();
    }

    public void addProduct(SoftwareProduct product) {
        this.products.add(product);
    }

    public ArrayList<SoftwareProduct> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<SoftwareProduct> products) {
        this.products = products;
    }
}
