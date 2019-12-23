package vinylApp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import vinylApp.modelFx.GenreFx;
import vinylApp.modelFx.GenreModel;

public class GenreController {

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
        this.genreModel.init();
        this.genreComboBox.setItems(this.genreModel.getGenreList());
        initBindings();
    }

    private void initBindings() {
        this.addGenreButton.disableProperty().bind(genreTextField.textProperty().isEmpty());
        this.deleteButton.disableProperty().bind(this.genreModel.genreProperty().isNull());
    }


    public void addGenreOnAction() {
        genreModel.saveGenreInDataBase(genreTextField.getText());
        genreTextField.clear();
    }

    public void onActionDeleteButton() {
        this.genreModel.deleteGenreById();
    }

    public void onActionComboBox() {
        this.genreModel.setGenre(this.genreComboBox.getSelectionModel().getSelectedItem());

    }
}
