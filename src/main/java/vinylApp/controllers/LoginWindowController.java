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
import vinylApp.modelFx.UserModel;
import vinylApp.utils.DialogsUtils;
import vinylApp.utils.FxmlUtils;
import vinylApp.utils.exceptions.ApplicationException;

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

    UserModel userModel;

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

        DbManager.initDatabaseUser();
        userModel = new UserModel();
        try {
            userModel.init();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }


    }

    public void enterPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            enterOnAction();
        }
    }

    public void enterOnAction() {

        if (isTextFieldsNotEmpty() && isDatabaseContainsThisLogAndPass() && isLogIndexEqualPassIndex()) {

            DbManager.setDatabaseName(this.passwordTextField.getText().concat(this.passwordTextField.getText()));

// loading data from database
            DbManager.initDatabase();
            //FillDatabase.fillDatabase(); napełnianie bazy danymi z klasy FillDatabase
            openNewWindowWithApp();

            Stage thisStage = (Stage) anchorPaneId.getScene().getWindow();
            thisStage.close();
        } else if (isTextFieldsNotEmpty() && isDatabaseContainsThisLogAndPassFirstLog() && isNewLogIndexEqualPassIndex()) {


            String normalLogWithoutPlus = usernameTextField.getText();
            String logWithPlus = "+".concat(usernameTextField.getText());

            try {
                userModel.updateUserInDataBase(logWithPlus, normalLogWithoutPlus); // zmiana w baziedanych zapisu z + na normalny

            } catch (ApplicationException e) {
                e.printStackTrace();
            }

            DbManager.setDatabaseName(this.passwordTextField.getText().concat(this.passwordTextField.getText()));
            DbManager.initDatabase();
            openNewWindowWithApp();
            Stage thisStage = (Stage) anchorPaneId.getScene().getWindow();
            thisStage.close();

        } else {

            DialogsUtils.loginError();

        }


    }

    private boolean isLogIndexEqualPassIndex() {

        return userModel.getLoginList().indexOf(usernameTextField.getText()) == userModel.getPasswordList().indexOf(passwordTextField.getText());
    }


    private boolean isDatabaseContainsThisLogAndPass() {
        return (userModel.getLoginList().contains(usernameTextField.getText()) && userModel.getPasswordList().contains(passwordTextField.getText()));

    }


    private boolean isDatabaseContainsThisLogAndPassFirstLog() {

        return (userModel.getLoginList().contains("+".concat(usernameTextField.getText())) && userModel.getPasswordList().contains(passwordTextField.getText()));
    }

    private boolean isNewLogIndexEqualPassIndex() {

        return userModel.getLoginList().indexOf("+".concat(usernameTextField.getText())) == userModel.getPasswordList().indexOf(passwordTextField.getText());
    }


    private boolean isTextFieldsNotEmpty() {
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


    private void openNewWindowWithApp() {

        Main main = new Main();
        Stage stage = new Stage();
        Pane pane = FxmlUtils.fxmlLoader(BORDER_PANE_MAIN_FXML);

        Scene scene = new Scene(pane);
        String vinylAppAndName = FxmlUtils.getResourceBundle().getString("title.application.with.login").concat(this.passwordTextField.getText());
        stage.setTitle(vinylAppAndName);
        stage.setScene(scene);
        stage.show();
    }


    public void polishOnAction(ActionEvent actionEvent) {
        Locale.setDefault(new Locale("pl"));
    }


    public void englishOnAction(ActionEvent actionEvent) {
        Locale.setDefault(new Locale("en"));
    }
}



/*


//new account działa pojawia się tylko ten sam problem z zamkniętym strumieniem dlatego wyskakuje błąd
        //new account
        else if (isTextFieldsNotEmpty() && isTxtContainsThisLogAndPassFirstLog() && isNewLogIndexEqualPassIndex()) {

            String normalLogWithoutPlus = usernameTextField.getText();
            String logWithPlus = "+".concat(usernameTextField.getText());
            try {
                SaveReadFile.changeLoginWithPlusToNormal(normalLogWithoutPlus);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //      // try { //PO CO TO WCZYTYWANIE  ? KURWA
            //        //   DbManager.readAllLoginsAndPasswordsFromTxt();
            //       } catch (IOException e) {
            //           e.printStackTrace();
            //       }
//set login adn pass index
            DbManager.setLogAndPassIndex(DbManager.logins.indexOf(normalLogWithoutPlus));
            DbManager.setLoginPassDatabase();
// loading data from database
            DbManager.initDatabase();

            // DbManager.initDatabaseForNewAccount();  dla nowych kont było to ale wyłaczam bo nie działa
            openNewWindowWithApp();
//close login window
            Stage thisStage = (Stage) anchorPaneId.getScene().getWindow();
            thisStage.close();
        } else {
            DialogsUtils.loginError();
        }
    }
*/


//wyłaczam to :
    /*


//if / check login and pass from textFields. If everything ok we can run app
          if (isTextFieldsNotEmpty() && (isTxtContainsThisLogAndPass() && isLogIndexEqualPassIndex())) {
//set login adn pass index
            DbManager.setLogAndPassIndex(DbManager.logins.indexOf(usernameTextField.getText()));
            DbManager.setLoginPassDatabase();
// loading data from database
            DbManager.initDatabase();
            //FillDatabase.fillDatabase();
            openNewWindowWithApp();
//close login window
           Stage thisStage = (Stage) anchorPaneId.getScene().getWindow();
           thisStage.close();
       }

//new account działa pojawia się tylko ten sam problem z zamkniętym strumieniem dlatego wyskakuje błąd
        //new account
       else if (isTextFieldsNotEmpty() && isTxtContainsThisLogAndPassFirstLog() && isNewLogIndexEqualPassIndex()) {

            String normalLogWithoutPlus = usernameTextField.getText();
            String logWithPlus = "+".concat(usernameTextField.getText());
            try {
                SaveReadFile.changeLoginWithPlusToNormal(normalLogWithoutPlus);
            } catch (IOException e) {
                e.printStackTrace();
            }
     //      // try { //PO CO TO WCZYTYWANIE  ? KURWA
     //        //   DbManager.readAllLoginsAndPasswordsFromTxt();
     //       } catch (IOException e) {
     //           e.printStackTrace();
     //       }
//set login adn pass index
            DbManager.setLogAndPassIndex(DbManager.logins.indexOf(normalLogWithoutPlus));
            DbManager.setLoginPassDatabase();
// loading data from database
              DbManager.initDatabase();

             // DbManager.initDatabaseForNewAccount();  dla nowych kont było to ale wyłaczam bo nie działa
            openNewWindowWithApp();
//close login window
            Stage thisStage = (Stage) anchorPaneId.getScene().getWindow();
            thisStage.close();
        } else {
            DialogsUtils.loginError();
        }
    }
*/


// private boolean isLogIndexEqualPassIndex() {
//     return DbManager.logins.indexOf(usernameTextField.getText()) == DbManager.passwords.indexOf(passwordTextField.getText());
// }
/*
    private boolean isTxtContainsThisLogAndPass() {
        return (DbManager.logins.contains(usernameTextField.getText()) && DbManager.passwords.contains(passwordTextField.getText()));
    }

    private boolean isNewLogIndexEqualPassIndex() {
        return DbManager.logins.indexOf("+".concat(usernameTextField.getText())) == DbManager.passwords.indexOf(passwordTextField.getText());
    }
*/


//   private boolean isTxtContainsThisLogAndPassFirstLog() {
//       return (DbManager.logins.contains("+".concat(usernameTextField.getText())) && DbManager.passwords.contains(passwordTextField.getText()));
//   }



