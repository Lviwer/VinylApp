package vinylApp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {

    public static final String ADD_VINYL_FXML = "/fxml/AddVinyl.fxml";
    public static final String ADD_RELEASE_COUNTRY_FXML = "/fxml/AddReleaseCountry.fxml";
    public static final String LIST_OF_VINYLS_FXML = "/fxml/ListOfVinyls.fxml";
    public static final String ADD_LABEL_FXML = "/fxml/AddLabel.fxml";
    public static final String ADD_GENRE_FXML = "/fxml/AddGenre.fxml";
    public static final String FXML_SEARCH_FXML = "/fxml/Search.fxml";
    private MainController mainController;
    @FXML
    private ToggleGroup toggleButtons;


    public void openVinylList(ActionEvent actionEvent) {
        mainController.setCenter(LIST_OF_VINYLS_FXML);
    }

    public void addVinyl() {
        if(toggleButtons.getSelectedToggle() != null){  //when we click addVinyl we check &
            toggleButtons.getSelectedToggle().setSelected(false); //erase clicked button in group toggledbutton
        }
        mainController.setCenter(ADD_VINYL_FXML);
    }


    public void addReleaseCountry(ActionEvent actionEvent) {
        mainController.setCenter(ADD_RELEASE_COUNTRY_FXML);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void addLabel(ActionEvent actionEvent) {
        mainController.setCenter(ADD_LABEL_FXML);
    }

    public void addGenre(ActionEvent actionEvent) {
        mainController.setCenter(ADD_GENRE_FXML);
    }

    public void search(ActionEvent actionEvent) {
        mainController.setCenter(FXML_SEARCH_FXML);
    }
}
