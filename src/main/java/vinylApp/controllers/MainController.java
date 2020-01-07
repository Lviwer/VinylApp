package vinylApp.controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import vinylApp.utils.DialogsUtils;
import vinylApp.utils.FxmlUtils;

import java.util.Optional;

public class MainController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private TopMenuButtonsController topMenuButtonsController;


    @FXML
    private void initialize() {

        topMenuButtonsController.setMainController(this); //przekazuje całą ref do topMenuButtons
    }

    public void setCenter(String fxmlPath) {

        borderPane.setCenter(FxmlUtils.fxmlLoader(fxmlPath));
    }


    public void closeApp() {

        Optional<ButtonType> result = DialogsUtils.confirmationDialog();

        if (result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }

    public void setCaspian() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
    }


    public void setModena() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    }


    public void setAlwaysOnTop(ActionEvent actionEvent) {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        boolean value = ((CheckMenuItem) actionEvent.getSource()).selectedProperty().get();
        stage.setAlwaysOnTop(value);
    }


    public void about() {
        DialogsUtils.dialogAboutApplication();
    }

}
