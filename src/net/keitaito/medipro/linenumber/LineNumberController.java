package net.keitaito.medipro.linenumber;

public class LineNumberController {
    private final LineNumberModel model;
    private final LineNumberView view;

    public LineNumberController(LineNumberModel model, LineNumberView view) {
        this.model = model;
        this.view = view;
    }
}
