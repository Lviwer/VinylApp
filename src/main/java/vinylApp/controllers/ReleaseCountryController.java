package vinylApp.controllers;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import vinylApp.modelFx.ReleaseCountryFx;
import vinylApp.modelFx.ReleaseCountryModel;
import vinylApp.utils.DialogsUtils;

public class ReleaseCountryController {

    @FXML
    private Button editReleaseCountryButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TextField releaseCountryTextField;

    @FXML
    private Button addReleaseCountryButton;

    @FXML
    private ComboBox<ReleaseCountryFx> releaseCountryComboBox;

    private ReleaseCountryModel releaseCountryModel;

    public void initialize() {
        this.releaseCountryModel = new ReleaseCountryModel();
        this.releaseCountryModel.init();
        this.releaseCountryComboBox.setItems(this.releaseCountryModel.getReleaseCountryList());
        initBindings();
    }

    private void initBindings() {
        addReleaseCountryButton.disableProperty().bind(releaseCountryTextField.textProperty().isEmpty());
        //when textfield is empty it doesnt work. When we start writing smthg button starts working
        this.deleteButton.disableProperty().bind(this.releaseCountryModel.releaseCountryProperty().isNull());
        this.editReleaseCountryButton.disableProperty().bind(this.releaseCountryModel.releaseCountryProperty().isNull());
    }


    public void addReleaseCountryOnAction(ActionEvent actionEvent) {
        releaseCountryModel.saveCountryInDataBase(releaseCountryTextField.getText());
        releaseCountryTextField.clear();
    }

    public void onActionDeleteButton(ActionEvent actionEvent) {
        this.releaseCountryModel.deleteReleaseCountryById();
    }

    public void onActionComboBox(ActionEvent actionEvent) {
        this.releaseCountryModel.setReleaseCountry(this.releaseCountryComboBox.getSelectionModel().getSelectedItem());
    }

    public void onActionEditReleaseCountry(ActionEvent actionEvent) {
        String newReleaseCountryName = DialogsUtils.editDialog(this.releaseCountryModel.getReleaseCountry().getNameOfCountry());
        if(newReleaseCountryName !=null)
        {
            this.releaseCountryModel.getReleaseCountry().setNameOfCountry(newReleaseCountryName);
            this.releaseCountryModel.updateReleaseCountryInDataBase();
        }
    }


}