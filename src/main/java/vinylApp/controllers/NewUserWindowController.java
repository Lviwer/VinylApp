package vinylApp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewUserWindowController implements Initializable {
    @FXML
    private AnchorPane anchorPaneIdNewUser;
    private LoginWindowController loginWindowController;

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


    public void saveNewUserOnAction(ActionEvent actionEvent) {


    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/LoginWindow.fxml"));
        anchorPaneIdNewUser.getChildren().setAll(pane);
    }
}


