package vinylApp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import vinylApp.database.models.Label;
import vinylApp.modelFx.*;
import vinylApp.utils.DialogsUtils;
import vinylApp.utils.exceptions.ApplicationException;

import java.time.LocalDate;

public class ListOfVinylsController {

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
    private TableColumn<VinylFx, String> priceColumn;
    @FXML
    private TableColumn<VinylFx, String> sellingPriceColumn;
    @FXML
    private TableColumn<VinylFx, String> vinylConditionColumn;
    @FXML
    private TableColumn<VinylFx, String> conditionOfAcColumn;
    @FXML
    private TableColumn<VinylFx, Boolean> availableColumn;
    @FXML
    private TableColumn<VinylFx, Boolean> wantToColumn;

    private ListVinylsModel listVinylsModel;


    public void initialize() {

        this.listVinylsModel = new ListVinylsModel();
        try {
            this.listVinylsModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }

        this.vinylsTableView.setItems(this.listVinylsModel.getVinylFxObservableList());
        this.titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        this.artistColumn.setCellValueFactory(cellData -> cellData.getValue().authorFxProperty());
        this.labelColumn.setCellValueFactory(cellData -> cellData.getValue().labelFxProperty());
        this.countryColumn.setCellValueFactory(cellData -> cellData.getValue().countryFxProperty());
        this.releasedColumn.setCellValueFactory(cellData -> cellData.getValue().releasedProperty());
        this.genreColumn.setCellValueFactory(cellData -> cellData.getValue().genreFxProperty());
        this.catalogNumberColumn.setCellValueFactory(cellData -> cellData.getValue().catalogNumberProperty());
        this.dateOfPurchaseColumn.setCellValueFactory(cellData -> cellData.getValue().dateOfPurchaseProperty());
        this.priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        this.sellingPriceColumn.setCellValueFactory(cellData -> cellData.getValue().sellingPriceProperty());
        this.vinylConditionColumn.setCellValueFactory(cellData -> cellData.getValue().vinylConditionProperty());
        this.conditionOfAcColumn.setCellValueFactory(cellData -> cellData.getValue().accessoriesConditionProperty());
        this.availableColumn.setCellValueFactory(cellData -> cellData.getValue().isAvailableProperty());
        this.wantToColumn.setCellValueFactory(cellData -> cellData.getValue().isAvailableProperty());

    }










}
