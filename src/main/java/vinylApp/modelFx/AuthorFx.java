package vinylApp.modelFx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AuthorFx {


    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty nameOfAuthor = new SimpleStringProperty();
    private StringProperty surnameOfAuthor = new SimpleStringProperty();



    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNameOfAuthor() {
        return nameOfAuthor.get();
    }

    public StringProperty nameOfAuthorProperty() {
        return nameOfAuthor;
    }

    public void setNameOfAuthor(String nameOfAuthor) {
        this.nameOfAuthor.set(nameOfAuthor);
    }

    public String getSurnameOfAuthor() {
        return surnameOfAuthor.get();
    }

    public StringProperty surnameOfAuthorProperty() {
        return surnameOfAuthor;
    }

    public void setSurnameOfAuthor(String surnameOfAuthor) {
        this.surnameOfAuthor.set(surnameOfAuthor);
    }

    @Override
    public String toString() {
        return nameOfAuthor.getValue();
    }
}
