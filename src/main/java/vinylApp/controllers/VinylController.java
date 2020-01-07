package vinylApp.controllers;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import vinylApp.modelFx.*;
import vinylApp.utils.DialogsUtils;
import vinylApp.utils.exceptions.ApplicationException;


public class VinylController {

    @FXML
    private CheckBox sellCheckBox;
    @FXML
    private Button addButton;
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
    private DatePicker dateOfSellingPicker;
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
        validation();
        validationSelling();
    }

    private void validation() {
        this.addButton.disableProperty().bind(this.authorComboBox.valueProperty().isNull()
                .or(this.genreComboBox.valueProperty().isNull())
                .or(this.countryComboBox.valueProperty().isNull())
                .or(this.labelComboBox.valueProperty().isNull())
                .or(this.vinylConditionTextField.textProperty().isEmpty())
                .or(this.releasedTextField.textProperty().isEmpty())
                .or(this.dateOfPurchasePicker.valueProperty().isNull())
                .or(this.priceTextField.textProperty().isEmpty())
                .or(this.titleTextField.textProperty().isEmpty())
                .or(this.catalogTextField.textProperty().isEmpty()));
    }


    public void bindings() {
        this.authorComboBox.setItems(this.vinylModel.getAuthorFxObservableList());
        this.labelComboBox.setItems(this.vinylModel.getLabelFxObservableList());
        this.countryComboBox.setItems(this.vinylModel.getReleaseCountryFxObservableList());
        this.genreComboBox.setItems(this.vinylModel.getGenreFxObservableList());

        this.authorComboBox.valueProperty().bindBidirectional(this.vinylModel.getVinylFxObjectProperty().authorFxProperty());
        this.labelComboBox.valueProperty().bindBidirectional(this.vinylModel.getVinylFxObjectProperty().labelFxProperty());
        this.countryComboBox.valueProperty().bindBidirectional(this.vinylModel.getVinylFxObjectProperty().countryFxProperty());
        this.genreComboBox.valueProperty().bindBidirectional(this.vinylModel.getVinylFxObjectProperty().genreFxProperty());
        this.vinylConditionTextField.textProperty().bindBidirectional(this.vinylModel.getVinylFxObjectProperty().vinylConditionProperty());
        this.conditionAccessoriesTextField.textProperty().bindBidirectional(this.vinylModel.getVinylFxObjectProperty().accessoriesConditionProperty());
        this.releasedTextField.textProperty().bindBidirectional(this.vinylModel.getVinylFxObjectProperty().releasedProperty());
        this.dateOfPurchasePicker.valueProperty().bindBidirectional(this.vinylModel.getVinylFxObjectProperty().dateOfPurchaseProperty());
//PRICE AND SELLING PRICE CONVERTER TO 0,00 -------------------------------------------
// I had to create second textFormatter - with one common it doesn't work for two textfields!------------
        StringConverter<Number> converter = new NumberStringConverter("#.##");
        TextFormatter textFormatterPrice = new TextFormatter(converter);
        TextFormatter textFormatterSell = new TextFormatter(converter);
        priceTextField.setTextFormatter(textFormatterPrice);
        sellingPriceTextField.setTextFormatter(textFormatterSell);
        //------------------------------------------------------------------------------------
        Bindings.bindBidirectional(this.priceTextField.textProperty(), this.vinylModel.getVinylFxObjectProperty().priceProperty(), converter);
        Bindings.bindBidirectional(this.sellingPriceTextField.textProperty(), this.vinylModel.getVinylFxObjectProperty().sellingPriceProperty(), converter);

        this.dateOfSellingPicker.valueProperty().bindBidirectional(this.vinylModel.getVinylFxObjectProperty().dateOfSellingProperty());
        this.titleTextField.textProperty().bindBidirectional(this.vinylModel.getVinylFxObjectProperty().titleProperty());
        this.catalogTextField.textProperty().bindBidirectional(this.vinylModel.getVinylFxObjectProperty().catalogNumberProperty());

        this.availableCheckBox.selectedProperty().bindBidirectional(this.vinylModel.getVinylFxObjectProperty().isAvailableProperty());
        this.wantListCheckBox.selectedProperty().bindBidirectional(this.vinylModel.getVinylFxObjectProperty().wantListProperty());
    }


    public VinylModel getVinylModel() {
        return vinylModel;
    }

    public void addVinylOnAction() {

        try {
            this.vinylModel.saveVinylInDatabase();
            clearFields();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        } catch (NumberFormatException e) {
            DialogsUtils.errorDialog(DialogsUtils.bundle.getString("error.string.not.number"));
        }
    }

    private void clearFields() {
        this.genreComboBox.getSelectionModel().clearSelection();
        this.countryComboBox.getSelectionModel().clearSelection();
        this.labelComboBox.getSelectionModel().clearSelection();
        this.authorComboBox.getSelectionModel().clearSelection();
        this.titleTextField.clear();
        this.releasedTextField.clear();
        this.catalogTextField.clear();
        this.dateOfPurchasePicker.getEditor().clear();
        this.dateOfSellingPicker.getEditor().clear();
        this.priceTextField.clear();
        this.sellingPriceTextField.clear();
        this.vinylConditionTextField.clear();
        this.conditionAccessoriesTextField.clear();
        this.availableCheckBox.setSelected(false);
        this.wantListCheckBox.setSelected(false);
    }

    private void validationSelling() {
        this.dateOfSellingPicker.disableProperty().bind(this.sellCheckBox.selectedProperty().not());
        this.sellingPriceTextField.disableProperty().bind(this.sellCheckBox.selectedProperty().not());
    }

}
