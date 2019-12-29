package vinylApp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import vinylApp.modelFx.*;
import vinylApp.utils.DialogsUtils;
import vinylApp.utils.exceptions.ApplicationException;

public class VinylController {

    @FXML
    private ComboBox<AuthorFx> authorComboBox;
    @FXML
    private ComboBox<LabelFx> labelComboBox;
    @FXML
    private ComboBox<ReleaseCountryFx> countryComboBox;
    @FXML
    private ComboBox<GenreFx> genreComboBox;
    @FXML
    private TextField vinylConditionTextField;
    @FXML
    private TextField conditionAccessoriesTextField;
    @FXML
    public TextField releasedTextField;
    @FXML
    private DatePicker dateOfPurchasePicker;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField sellingPriceTextField;
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField catalogTextField;
    @FXML
    private CheckBox availableCheckBox;
    @FXML
    private CheckBox wantListCheckBox;

    private VinylModel vinylModel;


    @FXML
    public void initialize() {

        this.vinylModel = new VinylModel();
        try {
            this.vinylModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }

        bindings();


    }

    private void bindings() {
        this.authorComboBox.setItems(this.vinylModel.getAuthorFxObservableList());
        this.labelComboBox.setItems(this.vinylModel.getLabelFxObservableList());
        this.countryComboBox.setItems(this.vinylModel.getReleaseCountryFxObservableList());
        this.genreComboBox.setItems(this.vinylModel.getGenreFxObservableList());
        this.vinylModel.getVinylFxObjectProperty().authorFxProperty().bind(this.authorComboBox.valueProperty());
        this.vinylModel.getVinylFxObjectProperty().labelFxProperty().bind(this.labelComboBox.valueProperty());
        this.vinylModel.getVinylFxObjectProperty().countryFxProperty().bind(this.countryComboBox.valueProperty());
        this.vinylModel.getVinylFxObjectProperty().genreFxProperty().bind(this.genreComboBox.valueProperty());
        this.vinylModel.getVinylFxObjectProperty().vinylConditionProperty().bind(this.vinylConditionTextField.textProperty());
        this.vinylModel.getVinylFxObjectProperty().accessoriesConditionProperty().bind(this.conditionAccessoriesTextField.textProperty());
        this.vinylModel.getVinylFxObjectProperty().releasedProperty().bind(this.releasedTextField.textProperty());
        //this.vinylModel.getVinylFxObjectProperty().releasedProperty().bind(this.releasedDatePicker.valueProperty());
        this.vinylModel.getVinylFxObjectProperty().dateOfPurchaseProperty().bind(this.dateOfPurchasePicker.valueProperty());
        this.vinylModel.getVinylFxObjectProperty().priceProperty().bind(this.priceTextField.textProperty());
        this.vinylModel.getVinylFxObjectProperty().sellingPriceProperty().bind(this.sellingPriceTextField.textProperty());
        this.vinylModel.getVinylFxObjectProperty().titleProperty().bind(this.titleTextField.textProperty());
        this.vinylModel.getVinylFxObjectProperty().catalogNumberProperty().bind(this.catalogTextField.textProperty());
        this.vinylModel.getVinylFxObjectProperty().isAvailableProperty().bind(this.availableCheckBox.selectedProperty());
        this.vinylModel.getVinylFxObjectProperty().wantListProperty().bind(this.wantListCheckBox.selectedProperty());
    }


    public void addVinylOnAction() {

        try {
            this.vinylModel.saveVinylInDatabase();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }


    }
}
