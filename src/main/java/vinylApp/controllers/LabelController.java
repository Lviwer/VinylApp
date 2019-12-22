package vinylApp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import vinylApp.modelFx.LabelFx;
import vinylApp.modelFx.LabelModel;

public class LabelController {
    @FXML
    private TextField labelTextField;

    @FXML
    private Button addLabelButton;

    @FXML
    private ComboBox<LabelFx> labelComboBox;

    private LabelModel labelModel;

    public void initialize(){
        this.labelModel = new LabelModel();
        initBindings();
    }

    private void initBindings() {
        addLabelButton.disableProperty().bind(labelTextField.textProperty().isEmpty());
    }


    public void addLabelOnAction(ActionEvent actionEvent) {
    labelModel.saveLabelInDataBase(labelTextField.getText());
    labelTextField.clear();
    }
}
