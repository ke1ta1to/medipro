package medipro.workspace;

public class WorkspaceController {

    private WorkspaceModel model;

    public WorkspaceController(WorkspaceModel model) {
        this.model = model;
    }

    public WorkspaceModel getModel() {
        return model;
    }

}
