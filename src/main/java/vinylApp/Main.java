package vinylApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vinylApp.utils.FxmlUtils;


public class Main extends Application {

    public static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";
    public static final String LOGIN_WINDOW_FXML = "/fxml/LoginWindow.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginWindow.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle(FxmlUtils.getResourceBundle().getString("title.application"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

   //this methods runs when I open app
        //DbManager.initDatabase();
       // FillDatabase.fillDatabase();
    }

    public static void main(String[] args) {

        launch(args);

    }

}