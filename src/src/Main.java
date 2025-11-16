package src;

import src.gui.*;
import src.products.DevOpsTool;
import src.products.Framework;
import src.products.IDE;
import src.products.SoftwareProduct;

public class Main {
    public static void main(String[] args) {
        ObjectSerializer.registerCreator("IDE", IDE::new);
        ObjectSerializer.registerCreator("Framework", Framework::new);
        ObjectSerializer.registerCreator("DevOpsTool", DevOpsTool::new);
        Application application = new Application(new MainController());
    }
}