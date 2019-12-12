package vinylApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {


    public static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";

    public static void main(String[] args) {

        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        //Pane borderPabe = FxmlUtils


        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(BORDER_PANE_MAIN_FXML));
        BorderPane borderPane = loader.load();
        Scene scene = new Scene(borderPane);

                primaryStage.setTitle("VinylApp");
        primaryStage.show();


    }
}
