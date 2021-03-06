package vinylApp.controllers;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vinylApp.modelFx.*;
import vinylApp.utils.DecimalColumnFactory;
import vinylApp.utils.DialogsUtils;
import vinylApp.utils.FxmlUtils;
import vinylApp.utils.exceptions.ApplicationException;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;


public class ListOfVinylsController {
    @FXML
    private Label allSoldVinylsInMonth;
    @FXML
    private Label priceSoldVinylsInMonth;
    @FXML
    private Label allVinylsLabel;
    @FXML
    private Label spendMonthLabel;
    @FXML
    private Label buyedInMonthLabel;
    @FXML
    private Label collectionValue;
    @FXML
    private ComboBox genreComboBox;
    @FXML
    private ComboBox labelComboBox;
    @FXML
    private ComboBox countryComboBox;
    @FXML
    private ComboBox artistComboBox;
    @FXML
    private TableView<VinylFx> vinylsTableView;
    @FXML
    private TableColumn<VinylFx, String> titleColumn;
    @FXML
    private TableColumn<VinylFx, AuthorFx> artistColumn;
    @FXML
    private TableColumn<VinylFx, LabelFx> labelColumn;
    @FXML
    private TableColumn<VinylFx, ReleaseCountryFx> countryColumn;
    @FXML
    private TableColumn<VinylFx, String> releasedColumn;
    @FXML
    private TableColumn<VinylFx, GenreFx> genreColumn;
    @FXML
    private TableColumn<VinylFx, String> catalogNumberColumn;
    @FXML
    private TableColumn<VinylFx, LocalDate> dateOfPurchaseColumn;
    @FXML
    private TableColumn<VinylFx, Double> priceColumn;
    @FXML
    private TableColumn<VinylFx, Double> sellingPriceColumn;
    @FXML
    private TableColumn<VinylFx, LocalDate> dateOfSellingColumn;
    @FXML
    private TableColumn<VinylFx, String> vinylConditionColumn;
    @FXML
    private TableColumn<VinylFx, String> conditionOfAcColumn;
    @FXML
    private TableColumn<VinylFx, String> availableColumn;
    @FXML
    private TableColumn<VinylFx, String> wantToColumn;
    @FXML
    private TableColumn<VinylFx, VinylFx> deleteColumn;
    @FXML
    private TableColumn<VinylFx, VinylFx> editColumn;

    private ListVinylsModel listVinylsModel;

    public static ResourceBundle bundle = FxmlUtils.getResourceBundle();


    public void initialize() {

        this.listVinylsModel = new ListVinylsModel();
        try {
            this.listVinylsModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }

        this.artistComboBox.setItems(this.listVinylsModel.getAuthorFxObservableList());
        this.genreComboBox.setItems(this.listVinylsModel.getGenreFxObservableList());
        this.countryComboBox.setItems(this.listVinylsModel.getReleaseCountryFxObservableList());
        this.labelComboBox.setItems(this.listVinylsModel.getLabelFxObservableList());

        //bindings
        this.listVinylsModel.authorFxObjectPropertyProperty().bind(this.artistComboBox.valueProperty());
        this.listVinylsModel.genreFxObjectPropertyProperty().bind(this.genreComboBox.valueProperty());
        this.listVinylsModel.releaseCountryFxObjectPropertyProperty().bind(this.countryComboBox.valueProperty());
        this.listVinylsModel.labelFxObjectPropertyProperty().bind(this.labelComboBox.valueProperty());


        this.vinylsTableView.setItems(this.listVinylsModel.getVinylFxObservableList());
        this.titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        this.artistColumn.setCellValueFactory(cellData -> cellData.getValue().authorFxProperty());
        this.labelColumn.setCellValueFactory(cellData -> cellData.getValue().labelFxProperty());
        this.countryColumn.setCellValueFactory(cellData -> cellData.getValue().countryFxProperty());
        this.releasedColumn.setCellValueFactory(cellData -> cellData.getValue().releasedProperty());
        this.genreColumn.setCellValueFactory(cellData -> cellData.getValue().genreFxProperty());
        this.catalogNumberColumn.setCellValueFactory(cellData -> cellData.getValue().catalogNumberProperty());
        this.dateOfPurchaseColumn.setCellValueFactory(cellData -> cellData.getValue().dateOfPurchaseProperty());

//PRICE -----------

        this.priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        this.priceColumn.setCellFactory(new DecimalColumnFactory<>(new DecimalFormat("0.00")));
        this.sellingPriceColumn.setCellValueFactory(cellData -> cellData.getValue().sellingPriceProperty().asObject());
        this.sellingPriceColumn.setCellFactory(new DecimalColumnFactory<>(new DecimalFormat("0.00")));
//-----------------
        this.dateOfSellingColumn.setCellValueFactory(cellData -> cellData.getValue().dateOfSellingProperty());
        this.vinylConditionColumn.setCellValueFactory(cellData -> cellData.getValue().vinylConditionProperty());
        this.conditionOfAcColumn.setCellValueFactory(cellData -> cellData.getValue().accessoriesConditionProperty());
//-----------------Boolean columns

        this.wantToColumn.setCellValueFactory(cellData -> cellData.getValue().wantListProperty().asString());
        changeBooleanToStringWantToColumn();
        this.availableColumn.setCellValueFactory(cellData -> cellData.getValue().isAvailableProperty().asString());
        changeBooleanToStringAvailableColumn();

//-------Extra informations-----------------------------------------------------------------------------
        DecimalFormat df = new DecimalFormat("0.00");
        this.buyedInMonthLabel.setText(String.valueOf(listVinylsModel.getThisMonthBuyed()));
        this.allVinylsLabel.setText(String.valueOf(listVinylsModel.getAllVinyls()));
        this.spendMonthLabel.setText(String.valueOf(df.format(listVinylsModel.getOneMonthSpend())));
        this.allSoldVinylsInMonth.setText(String.valueOf(listVinylsModel.getOneMonthSoldVinyl()));
        this.priceSoldVinylsInMonth.setText(String.valueOf(df.format(listVinylsModel.getOneMonthEarn())));
        this.collectionValue.setText(String.valueOf(df.format(listVinylsModel.getAllCollectionValue())));
//--------Edit--Column-----------------------------------------------------------------------------------
        this.editColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
//---------------------Delete--Column--------------------------------------------------------------------
        this.deleteColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));

        this.deleteColumn.setCellFactory(param -> new TableCell<VinylFx, VinylFx>() {
            Button button = createButton("/icons/trashIcon.png");

            @Override
            protected void updateItem(VinylFx item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {  //buttons don't disappear without this
                    setGraphic(null);
                    return;
                }
                if (!empty) {
                    setGraphic(button);
                    button.setOnAction(event -> {
                        Optional<ButtonType> result = DialogsUtils.deleteConfirmationDialog();
                        if(result.get() == ButtonType.OK)
                        {
                            try {
                                listVinylsModel.deleteVinyl(item);
                                initialize();
                            } catch (ApplicationException e) {
                                DialogsUtils.errorDialog(e.getMessage());
                            }
                        }

                    });
                }
            }
        });

        this.editColumn.setCellFactory(param -> new TableCell<VinylFx, VinylFx>() {
            Button button = createButton("/icons/editIcon.png");

            @Override
            protected void updateItem(VinylFx item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {  //buttons don't dissapear without this
                    setGraphic(null);
                    return;
                }
                if (!empty) {
                    setGraphic(button);
                    button.setOnAction(event -> {
                        FXMLLoader loader = FxmlUtils.getLoader("/fxml/AddVinyl.fxml");
                        Scene scene = null;
                        try {
                            scene = new Scene(loader.load());
                        } catch (IOException e) {
                            DialogsUtils.errorDialog(e.getMessage());
                        }
                        VinylController controller = loader.getController();
                        controller.getVinylModel().setVinylFxObjectProperty(item);
                        controller.bindings();
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.showAndWait();
                        initialize();//to refresh vinylTab

                    });
                }
            }
        });

    }

    private void changeBooleanToStringAvailableColumn() {
        availableColumn.setCellValueFactory(cellData -> {
            boolean available = cellData.getValue().isAvailable();
            String availableAsString;
            if (available) {
                availableAsString = bundle.getString("yes");
            } else {
                availableAsString = bundle.getString("no");
            }
            return new ReadOnlyStringWrapper(availableAsString);
        });
    }

    private void changeBooleanToStringWantToColumn() {
        wantToColumn.setCellValueFactory(cellData -> {
            boolean wantTo = cellData.getValue().isWantList();
            String wantToAsString;
            if (wantTo) {
                wantToAsString = bundle.getString("yes");
            } else {
                wantToAsString = bundle.getString("no");
            }
            return new ReadOnlyStringWrapper(wantToAsString);
        });
    }


    private Button createButton(String path) {
        Button button = new Button();
        Image image = new Image(this.getClass().getResource(path).toString());
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);
        return button;
    }

    public void filterOnActionComboBox() {
        this.listVinylsModel.filterVinylList();
    }

    public void clearArtistComboBox() {
        this.artistComboBox.getSelectionModel().clearSelection();
    }

    public void clearGenreComboBox() {
        this.genreComboBox.getSelectionModel().clearSelection();
    }

    public void clearLabelComboBox() {
        this.labelComboBox.getSelectionModel().clearSelection();
    }

    public void clearCountryComboBox() {
        this.countryComboBox.getSelectionModel().clearSelection();
    }
}
