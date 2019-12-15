package vinylApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {


    //public static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";

    public static void main(String[] args) {

        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent fxml = FXMLLoader.load(getClass().getResource("/fxml/LoginWindow.fxml"));

        Scene scene = new Scene(fxml);

      //  scene.fill = Color.TRANSPARENT;
        scene.setFill(Color.TRANSPARENT);

      //  primaryStage.sceneProperty() = scene;

        primaryStage.setScene(scene);

        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.setTitle("VinylApp");

        primaryStage.show();






     //  FXMLLoader loader = new FXMLLoader(this.getClass().getResource(BORDER_PANE_MAIN_FXML));
     //  BorderPane borderPane = loader.load();
     //  Scene scene = new Scene(borderPane);

     //          primaryStage.setTitle("VinylApp");
     //  primaryStage.show();


    }
}
