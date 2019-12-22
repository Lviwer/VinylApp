package vinylApp.modelFx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GenreFx {


    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty nameOfGenre = new SimpleStringProperty();


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNameOfGenre() {
        return nameOfGenre.get();
    }

    public StringProperty nameOfGenreProperty() {
        return nameOfGenre;
    }

    public void setNameOfGenre(String nameOfGenre) {
        this.nameOfGenre.set(nameOfGenre);
    }
}
