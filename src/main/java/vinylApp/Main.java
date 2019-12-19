package vinylApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import vinylApp.utils.FxmlUtils;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {


    public static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = FxmlUtils.fxmlLoader(BORDER_PANE_MAIN_FXML);

        Scene scene = new Scene(pane);

        primaryStage.setScene(scene);
        primaryStage.setTitle(FxmlUtils.getResourceBundle().getString("title.application"));
        primaryStage.show();


    }


}


    //This part i need to connect with rest, later ->
        // this connect with Login Window.fxml and show first login window
 // @Override
 // public void start(Stage primaryStage) throws Exception {

 //     Parent fxml = FXMLLoader.load(getClass().getResource("/fxml/LoginWindow.fxml"));

 //     Scene scene = new Scene(fxml);

 //   //  scene.fill = Color.TRANSPARENT;
 //     scene.setFill(Color.TRANSPARENT);

 //   //  primaryStage.sceneProperty() = scene;

 //     primaryStage.setScene(scene);

 //     primaryStage.initStyle(StageStyle.TRANSPARENT);

 //     primaryStage.setTitle("VinylApp");

 //     primaryStage.show();

//till here !
