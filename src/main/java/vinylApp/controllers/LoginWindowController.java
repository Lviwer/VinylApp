package vinylApp.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import vinylApp.Main;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.utils.DialogsUtils;
import vinylApp.utils.FillDatabase;
import vinylApp.utils.FxmlUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginWindowController implements Initializable {

    public static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";
    public static final String NEW_USER_WINDOW_FXML = "/fxml/NewUserWindow.fxml";

    @FXML
    public AnchorPane anchorPaneId;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;


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

        try {
            DbManager.readAllLoginsAndPasswordsFromTxt();
        } catch (IOException e) {
            e.printStackTrace();
            DialogsUtils.errorDialog(e.getMessage());
            System.out.println("WIELKA DUPA");
        }
    }

    //enter to log in
    public void enterPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            enterOnAction();
        }
    }

    public void enterOnAction() {

//if / check login and pass from textFields. If everything ok we can run app
        if (isTextFieldsEmpty() && (isTxtContainsThisLogAndPass() && isLogIndexEqualPassIndex())) {
//set login adn pass index


            DbManager.setLogAndPassIndex(DbManager.logins.indexOf(usernameTextField.getText()));
            DbManager.setLoginPassDatabase();
// loading data from database
            DbManager.initDatabase();
            FillDatabase.fillDatabase();
//open new window with APP
            Main main = new Main();
            Stage stage = new Stage();
            Pane pane = FxmlUtils.fxmlLoader(BORDER_PANE_MAIN_FXML);

            Scene scene = new Scene(pane);
            String vinylAppAndName = FxmlUtils.getResourceBundle().getString("title.application.with.login").concat(DbManager.getUser());
            stage.setTitle(vinylAppAndName);
            stage.setScene(scene);
            stage.show();
//close login window
            Stage thisStage = (Stage) anchorPaneId.getScene().getWindow();
            thisStage.close();
        } else {
            DialogsUtils.loginError();
        }
    }

    private boolean isLogIndexEqualPassIndex() {
        return DbManager.logins.indexOf(usernameTextField.getText()) == DbManager.passwords.indexOf(passwordTextField.getText());
    }

    private boolean isTxtContainsThisLogAndPass() {
        return DbManager.logins.contains(usernameTextField.getText()) && DbManager.passwords.contains(passwordTextField.getText());
    }

    private boolean isTextFieldsEmpty() {
        return (!usernameTextField.getText().equals("")) && !passwordTextField.getText().equals("");
    }


    public void newUserOnAction() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource(NEW_USER_WINDOW_FXML));
        anchorPaneId.getChildren().setAll(pane);
    }


    public void exitOnAction(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }

    public void polishOnAction(ActionEvent actionEvent) {
        Locale.setDefault(new Locale("pl"));
    }

    public void englishOnAction(ActionEvent actionEvent) {
        Locale.setDefault(new Locale("en"));
    }

}
