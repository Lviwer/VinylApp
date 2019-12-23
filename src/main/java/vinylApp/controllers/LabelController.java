package vinylApp.controllers;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import vinylApp.modelFx.LabelFx;
import vinylApp.modelFx.LabelModel;
import vinylApp.utils.DialogsUtils;

public class LabelController {

    @FXML
    private Button editLabelButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TextField labelTextField;

    @FXML
    private Button addLabelButton;

    @FXML
    private ComboBox<LabelFx> labelComboBox;

    private LabelModel labelModel;

    public void initialize() {
        this.labelModel = new LabelModel();
        this.labelModel.init();
        this.labelComboBox.setItems(this.labelModel.getLabelList());
        initBindings();
    }

    private void initBindings() {
        addLabelButton.disableProperty().bind(labelTextField.textProperty().isEmpty());
        this.deleteButton.disableProperty().bind(this.labelModel.labelProperty().isNull());
        this.editLabelButton.disableProperty().bind(this.labelModel.labelProperty().isNull());



    }


    public void addLabelOnAction(ActionEvent actionEvent) {
        labelModel.saveLabelInDataBase(labelTextField.getText());
        labelTextField.clear();
    }

    public void onActionDeleteButton(ActionEvent actionEvent) {
        this.labelModel.deleteLabelById();
    }

    public void onActionComboBox(ActionEvent actionEvent) {
        this.labelModel.setLabel(this.labelComboBox.getSelectionModel().getSelectedItem());
    }

    public void onActionEditLabel(ActionEvent actionEvent) {

        String newLabelName = DialogsUtils.editDialog(this.labelModel.getLabel().getNameOfLabel());
        if(newLabelName != null){
            this.labelModel.getLabel().setNameOfLabel(newLabelName);
            this.labelModel.updateLabelInDatabase();

        }
    }
}
