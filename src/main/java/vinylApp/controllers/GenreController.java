package vinylApp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import vinylApp.modelFx.GenreFx;
import vinylApp.modelFx.GenreModel;
import vinylApp.utils.DialogsUtils;
import vinylApp.utils.exceptions.ApplicationException;

public class GenreController {

    @FXML
    private TreeView<String> genreTreeView;
    @FXML
    private Button editGenreButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TextField genreTextField;

    @FXML
    private Button addGenreButton;

    @FXML
    private ComboBox<GenreFx> genreComboBox;

    private GenreModel genreModel;

    @FXML
    public void initialize() {
        this.genreModel = new GenreModel();
        try {
            this.genreModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        this.genreComboBox.setItems(this.genreModel.getGenreList());
        this.genreTreeView.setRoot(this.genreModel.getRoot());
        initBindings();
    }

    private void initBindings() {
        this.addGenreButton.disableProperty().bind(genreTextField.textProperty().isEmpty());
        this.deleteButton.disableProperty().bind(this.genreModel.genreProperty().isNull());
        this.editGenreButton.disableProperty().bind(this.genreModel.genreProperty().isNull());
    }


    public void addGenreOnAction() {
        try {
            genreModel.saveGenreInDataBase(genreTextField.getText());
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        genreTextField.clear();
    }

    public void onActionDeleteButton() {
        try {
            this.genreModel.deleteGenreById();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }

    public void onActionComboBox() {
        this.genreModel.setGenre(this.genreComboBox.getSelectionModel().getSelectedItem());

    }

    public void onActionEditGenre() {
        String newGenreName = DialogsUtils.editDialog(this.genreModel.getGenre().getNameOfGenre());
        if (newGenreName != null) {
            this.genreModel.getGenre().setNameOfGenre(newGenreName);
            try {
                this.genreModel.updateGenreInDataBase();
            } catch (ApplicationException e) {
                DialogsUtils.errorDialog(e.getMessage());
            }
        }
    }
}
