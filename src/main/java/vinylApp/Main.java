package vinylApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.utils.FillDatabase;
import vinylApp.utils.FxmlUtils;

import java.io.IOException;

public class Main extends Application {

    public static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";
    public static final String LOGIN_WINDOW_FXML = "/fxml/LoginWindow.fxml";
//

    // static private Parent parentTwo;

    // public static Stage window;
    // public static Scene sceneOne;
    // public static Scene sceneTwo;


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginWindow.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle(FxmlUtils.getResourceBundle().getString("title.application"));
        stage.setScene(scene);
        stage.show();


        //  //changeLanguage("pl");
//
        // // Pane pane = FxmlUtils.fxmlLoader(BORDER_PANE_MAIN_FXML);
        //  Pane pane  = FxmlUtils.fxmlLoader("/fxml/LoadingPane.fxml");
        //  Scene scene = new Scene(pane);
        //  primaryStage.setScene(scene);
        //  primaryStage.setTitle(FxmlUtils.getResourceBundle().getString("title.application"));
        //  primaryStage.show();
//
        DbManager.initDatabase();
        FillDatabase.fillDatabase();


    }

    public static void main(String[] args) {

        launch(args);

    }

//  public static void changeLanguage(String lang)
//  {
//      Locale.setDefault(new Locale(lang));
//  }

//  }


    //This part i need to connect with rest, later ->
    // this connect with Login Window.fxml and show first login window
    // @Override
    // public void start(Stage primaryStage) throws Exception {
    //     window = primaryStage;


    //     Parent fxml = FXMLLoader.load(getClass().getResource(LOGIN_WINDOW_FXML));
    //     parentTwo = FXMLLoader.load(getClass().getResource(LOGIN_WINDOW_FXML));
    //     sceneOne = new Scene(fxml);
    //     sceneTwo = new Scene(parentTwo);
    //     sceneOne.setFill(Color.TRANSPARENT);
    //     window.setScene(sceneOne);
    //     window.initStyle(StageStyle.TRANSPARENT);
    //     window.setTitle("VinylApp");
    //     window.show();
    // }


}