package medipro.input;

public class InputController {

    private final InputModel inputModel;

    public InputController(InputModel inputModel) {
        this.inputModel = inputModel;
    }

    public InputModel getModel() {
        return inputModel;
    }

    public void submit(String text) {
        inputModel.setText(text);
    }

    public void start() {
        System.out.println(inputModel.getText());
    }

}
