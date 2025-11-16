package src.gui;

import java.awt.event.ActionListener;

public abstract class Controller<M extends Model, V extends View> {
    private M model;
    private V view;

    public Controller(M model, V view) {
        this.model = model;
        this.view = view;
    }
    public Controller() {

    }

    protected void setModel(M model) {
        this.model = model;
    }

    protected void setView(V view) {
        this.view = view;
    }

    protected abstract void initController();

    public M getModel() {
        return model;
    }

    public V getView() {
        return view;
    }
}
