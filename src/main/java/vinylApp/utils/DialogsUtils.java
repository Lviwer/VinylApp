package vinylApp.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.WindowEvent;

import java.util.Optional;
import java.util.ResourceBundle;

public class DialogsUtils {

    public static ResourceBundle bundle = FxmlUtils.getResourceBundle();

    public static void dialogAboutApplication() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(bundle.getString("about.title"));
        informationAlert.setHeaderText(bundle.getString("about.header"));
        informationAlert.setContentText(bundle.getString("about.content"));
        informationAlert.showAndWait();

    }

    public static Optional<ButtonType> confirmationDialog() {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle(bundle.getString("exit.title"));
        confirmationDialog.setHeaderText(bundle.getString("exit.header"));
        Optional<ButtonType> result = confirmationDialog.showAndWait();
        return result;
    }

    public static void confirmationDialogExit(WindowEvent event) {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle(bundle.getString("exit.title"));
        confirmationDialog.setHeaderText(bundle.getString("exit.header"));
        ButtonType result = confirmationDialog.showAndWait().orElse(ButtonType.CANCEL);

        if (ButtonType.CANCEL.equals(result)) {
            event.consume();
        }
    }

    public static void errorDialog(String error) {
        Alert errorAlert = new Alert((Alert.AlertType.ERROR));
        errorAlert.setTitle(bundle.getString("error.title"));
        errorAlert.setHeaderText(bundle.getString("error.header"));

        TextArea textArea = new TextArea(error);
        errorAlert.getDialogPane().setContent(textArea);
        errorAlert.showAndWait();
    }


    public static String editDialog(String value) {
        TextInputDialog dialog = new TextInputDialog(value);
        dialog.setTitle(bundle.getString("edit.title"));
        dialog.setHeaderText(bundle.getString("edit.header"));
        dialog.setContentText(bundle.getString("edit.content"));
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    public static void createdNewAccount() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(bundle.getString("create.new.acc.title"));
        informationAlert.setHeaderText(bundle.getString("create.new.acc.header"));
        informationAlert.setContentText(bundle.getString("create.new.acc.text"));
        informationAlert.showAndWait();
    }

    public static void loginError() {
        Alert informationAlert = new Alert(Alert.AlertType.ERROR);
        informationAlert.setTitle(bundle.getString("login.error.title"));
        informationAlert.setHeaderText(bundle.getString("login.error.header"));
        informationAlert.setContentText(bundle.getString("login.error.text"));
        informationAlert.showAndWait();
    }


    public static void createdNewAccountExist() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(bundle.getString("account.exist.title"));
        informationAlert.setHeaderText(bundle.getString("account.exist.header"));
        informationAlert.setContentText(bundle.getString("account.exist.text"));
        informationAlert.showAndWait();
    }

    public static Optional<ButtonType> deleteConfirmationDialog() {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle(bundle.getString("delete"));
        confirmationDialog.setHeaderText(bundle.getString("delete.vinyl.confirm"));
        Optional<ButtonType> result = confirmationDialog.showAndWait();
        return result;
    }


}
