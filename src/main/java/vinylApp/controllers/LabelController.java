package vinylApp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import vinylApp.modelFx.LabelFx;
import vinylApp.modelFx.LabelModel;
import vinylApp.utils.DialogsUtils;
import vinylApp.utils.exceptions.ApplicationException;

import java.sql.SQLException;

public class LabelController {


    @FXML
    private TreeView<String> labelTreeView;
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
        try {
            this.labelModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        this.labelComboBox.setItems(this.labelModel.getLabelList());
        this.labelTreeView.setRoot(this.labelModel.getRoot());
        initBindings();
    }

    private void initBindings() {
        addLabelButton.disableProperty().bind(labelTextField.textProperty().isEmpty());
        this.deleteButton.disableProperty().bind(this.labelModel.labelProperty().isNull());
        this.editLabelButton.disableProperty().bind(this.labelModel.labelProperty().isNull());
    }


    public void addLabelOnAction(ActionEvent actionEvent) {
        try {
            labelModel.saveLabelInDataBase(labelTextField.getText());
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        labelTextField.clear();
    }

    public void onActionDeleteButton(ActionEvent actionEvent) {
        try {
            this.labelModel.deleteLabelById();
        } catch (ApplicationException | SQLException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }

    public void onActionComboBox(ActionEvent actionEvent) {
        this.labelModel.setLabel(this.labelComboBox.getSelectionModel().getSelectedItem());
    }

    public void onActionEditLabel(ActionEvent actionEvent) {

        String newLabelName = DialogsUtils.editDialog(this.labelModel.getLabel().getNameOfLabel());
        if(newLabelName != null){
            this.labelModel.getLabel().setNameOfLabel(newLabelName);
            try {
                this.labelModel.updateLabelInDatabase();
            } catch (ApplicationException e) {
                DialogsUtils.errorDialog(e.getMessage());
            }

        }
    }
}
