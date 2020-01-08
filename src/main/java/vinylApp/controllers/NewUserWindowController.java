package vinylApp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import vinylApp.Main;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.utils.DialogsUtils;
import vinylApp.utils.SaveReadFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewUserWindowController implements Initializable {

    @FXML
    private AnchorPane anchorPaneIdNewUser;

    @FXML
    private TextField newUsernameTextField;
    @FXML
    private TextField newPasswordTextField;

    double x = 0;
    double y = 0;

    @FXML
    void dragged(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void enterPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER) & !newPasswordTextField.getText().isEmpty()) {
            saveNewUserOnAction();
        }
    }


    public void saveNewUserOnAction() {
        String newLogin = newUsernameTextField.getText();
        System.out.println(newLogin);
        ;
        String newPass = newPasswordTextField.getText();
        if ((!DbManager.logins.contains(newLogin)) && (!newLogin.equals("")) && (!newPass.equals(""))) {

            try {
                SaveReadFile.saveOneMoreInFile(newLogin, SaveReadFile.LOG_FILE_PATH);
                SaveReadFile.saveOneMoreInFile(newPass, SaveReadFile.PASS_FILE_PATH);
                DialogsUtils.createdNewAccount();
                newPasswordTextField.clear();
            } catch (FileNotFoundException e) {
                DialogsUtils.errorDialog(e.getMessage());
            }

        } else if (DbManager.logins.contains(newLogin)) {
            DialogsUtils.createdNewAccountExist();
        } else {
            DialogsUtils.loginError();
        }
    }

    public void backOnAction() {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource(Main.LOGIN_WINDOW_FXML));
        } catch (IOException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        anchorPaneIdNewUser.getChildren().setAll(pane);
    }

}



