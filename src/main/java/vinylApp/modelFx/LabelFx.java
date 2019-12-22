package vinylApp.modelFx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LabelFx {


    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty nameOfLabel = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNameOfLabel() {
        return nameOfLabel.get();
    }

    public StringProperty nameOfLabelProperty() {
        return nameOfLabel;
    }

    public void setNameOfLabel(String nameOfLabel) {
        this.nameOfLabel.set(nameOfLabel);
    }
}
