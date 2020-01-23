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
import vinylApp.modelFx.UserModel;
import vinylApp.utils.DialogsUtils;
import vinylApp.utils.exceptions.ApplicationException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewUserWindowController implements Initializable {


    UserModel userModel;

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
        userModel = new UserModel();
        try {
            userModel.init();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }


    public void enterPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER) & !newPasswordTextField.getText().isEmpty()) {
            saveNewUserOnAction();
        }
    }


    public void saveNewUserOnAction() {

        String newLogin = newUsernameTextField.getText();
        String newPass = newPasswordTextField.getText();

        if ((!newLogin.equals("") && (!newPass.equals(""))) && (!userModel.getLoginList().contains(newLogin))) {

            try {
                userModel.saveUserInDataBase(newLogin, newPass);
                DialogsUtils.createdNewAccount();
                newPasswordTextField.clear();

            } catch (ApplicationException e) {
                e.printStackTrace();
            }
        } else if (userModel.getLoginList().contains(newLogin)) {
            DialogsUtils.createdNewAccountExist();
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
