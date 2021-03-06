package vinylApp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import vinylApp.modelFx.AuthorFx;
import vinylApp.modelFx.AuthorModel;
import vinylApp.utils.DialogsUtils;
import vinylApp.utils.exceptions.ApplicationException;

import java.sql.SQLException;

public class AuthorController {

    @FXML
    private TreeView<String> authorTreeView;
    @FXML
    private TextField authorTextField;
    @FXML
    private Button addAuthorButton;
    @FXML
    private ComboBox<AuthorFx> authorComboBox;
    @FXML
    private Button editAuthorButton;
    @FXML
    private Button deleteButton;

    private AuthorModel authorModel;


    @FXML
    public void initialize() {
        this.authorModel = new AuthorModel();
        try {
            this.authorModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        this.authorComboBox.setItems(this.authorModel.getAuthorList());
        this.authorTreeView.setRoot(this.authorModel.getRoot());
        initBindings();
    }

    private void initBindings() {
        this.addAuthorButton.disableProperty().bind(authorTextField.textProperty().isEmpty());
        this.deleteButton.disableProperty().bind(this.authorModel.authorProperty().isNull());
        this.editAuthorButton.disableProperty().bind(this.authorModel.authorProperty().isNull());
    }

    public void addAuthorOnAction() {

        try {
            authorModel.saveAuthorInDataBase(authorTextField.getText());
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        authorTextField.clear();
    }

    public void onActionComboBox() {
        this.authorModel.setAuthor(this.authorComboBox.getSelectionModel().getSelectedItem());
    }

    public void onActionEditAuthor() {
        String newAuthorName = DialogsUtils.editDialog(this.authorModel.getAuthor().getNameOfAuthor());
        if (newAuthorName != null) {
            this.authorModel.getAuthor().setNameOfAuthor(newAuthorName);
            try {
                this.authorModel.updateAuthorInDataBase();
            } catch (ApplicationException e) {
                DialogsUtils.errorDialog(e.getMessage());
            }
        }
    }

    public void onActionDeleteButton() {
        try {
            this.authorModel.deleteAuthorById();
        } catch (ApplicationException | SQLException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }
}
