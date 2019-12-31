package vinylApp.modelFx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReleaseCountryFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty nameOfCountry = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNameOfCountry() {
        return nameOfCountry.get();
    }

    public StringProperty nameOfCountryProperty() {
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry.set(nameOfCountry);
    }



    @Override
    public String toString() {
        return nameOfCountry.getValue();
    }
}
