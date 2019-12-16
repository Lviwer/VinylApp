package vinylApp.controllers;

import javafx.event.ActionEvent;

public class TopMenuButtonsController {

    private MainController mainController;



    public void openVinylList(ActionEvent actionEvent) {
        System.out.println("Hello 1");
    }

    public void addVinyl(ActionEvent actionEvent) {
        System.out.println("Hello 2");
    }

    public void addReleaseCountry(ActionEvent actionEvent) {
        System.out.println("Hello 3");
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
