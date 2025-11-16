package src.gui;

public class TipoSoftwareController extends Controller<BaseModel, TipoSoftware> {
    private MainController mainController;
    public TipoSoftwareController(MainController mainController) {
        super(new BaseModel(), new TipoSoftware());
        this.mainController = mainController;
    }

    @Override
    protected void initController() {
        TipoSoftware view = getView();
        view.getIDERadioButton().addActionListener(e -> {

        });
        view.getFrameworkRadioButton().addActionListener(e -> {

        });

        view.getDevOpsRadioButton().addActionListener(e -> {

        });
    }
}
