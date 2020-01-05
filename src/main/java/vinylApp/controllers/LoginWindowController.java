package vinylApp.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import vinylApp.Main;
import vinylApp.utils.FxmlUtils;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController implements Initializable {

    @FXML
    public AnchorPane anchorPaneId;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;

    public static final String NEW_USER_WINDOW_FXML = "/fxml/NewUserWindow.fxml";

    private MainController mainController;

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

    public void enterOnAction() throws IOException {
//---close first window--------------------------------------------------------
        Stage thisStage = (Stage) anchorPaneId.getScene().getWindow();
        thisStage.close();

//---open new with application-------------------------------------------------
        Main main = new Main();
        Stage stage = new Stage();
        Pane pane = FxmlUtils.fxmlLoader("/fxml/BorderPaneMain.fxml");

        Scene scene = new Scene(pane);
        stage.setTitle(FxmlUtils.getResourceBundle().getString("title.application"));
        stage.setScene(scene);
        stage.show();
    }

    public void newUserOnAction() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource(NEW_USER_WINDOW_FXML));
        anchorPaneId.getChildren().setAll(pane);
    }


    public void exitOnAction(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }

}
