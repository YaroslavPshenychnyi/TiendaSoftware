package src;

import src.gui.Application;
import src.gui.Controller;
import src.gui.Model;
import src.gui.View;

public class Main {
    public static void main(String[] args) {
        Application application = new Application(new Controller(new Model(), new View()));
    }
}