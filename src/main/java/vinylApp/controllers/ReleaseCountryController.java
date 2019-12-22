package vinylApp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import vinylApp.modelFx.ReleaseCountryFx;
import vinylApp.modelFx.ReleaseCountryModel;

public class ReleaseCountryController {

   @FXML
   private TextField releaseCountryTextField;

   @FXML
   private Button addReleaseCountryButton;

   @FXML
   private ComboBox<ReleaseCountryFx> releaseCountryComboBox;

   private ReleaseCountryModel releaseCountryModel;

   public void initialize()
   {
       this.releaseCountryModel = new ReleaseCountryModel();
       initBindings();
   }

    private void initBindings() {
       addReleaseCountryButton.disableProperty().bind(releaseCountryTextField.textProperty().isEmpty());
       //when textfield is empty it doesnt work. When we start writing smthg button starts working
    }


    public void addReleaseCountryOnAction(ActionEvent actionEvent) {
       releaseCountryModel.saveCountryInDataBase(releaseCountryTextField.getText());
       releaseCountryTextField.clear();
    }
}
