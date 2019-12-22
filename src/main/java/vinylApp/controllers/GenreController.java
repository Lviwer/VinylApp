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
    private TextField genreTextField;

    @FXML
    private Button addGenreButton;

    @FXML
    private ComboBox<GenreFx> genreComboBox;

    private GenreModel genreModel;

    @FXML
    public void initialize()
    {
        this.genreModel = new GenreModel();
        initBindings();
    }

    private void initBindings() {
        addGenreButton.disableProperty().bind(genreTextField.textProperty().isEmpty());
    }


    public void addGenreOnAction(ActionEvent actionEvent) {
       genreModel.saveGenreInDataBase(genreTextField.getText());
       genreTextField.clear();
    }
}
