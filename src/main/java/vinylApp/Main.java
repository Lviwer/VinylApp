package vinylApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vinylApp.utils.FxmlUtils;


public class Main extends Application {

    public static final String LOGIN_WINDOW_FXML = "/fxml/LoginWindow.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(LOGIN_WINDOW_FXML));

        Scene scene = new Scene(root);
        stage.setTitle(FxmlUtils.getResourceBundle().getString("title.application"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }

}