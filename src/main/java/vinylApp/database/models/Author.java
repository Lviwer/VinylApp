package vinylApp.database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "AUTHOR")
public class Author implements BaseModel {

    public Author() {

    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "NAME", canBeNull = false)
    private String nameOfAuthor;

    @DatabaseField(columnName = "SURNAME", canBeNull = false)
    private String surnameOfAuthor;

    @ForeignCollectionField(columnName = "VINYL_ID")
    private ForeignCollection<Vinyl> vinylsAuthor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfAuthor() {
        return nameOfAuthor;
    }

    public void setNameOfAuthor(String nameOfAuthor) {
        this.nameOfAuthor = nameOfAuthor;
    }

    public String getSurnameOfAuthor() {
        return surnameOfAuthor;
    }

    public void setSurnameOfAuthor(String surnameOfAuthor) {
        this.surnameOfAuthor = surnameOfAuthor;
    }

    public ForeignCollection<Vinyl> getVinylsAuthor() {
        return vinylsAuthor;
    }

    public void setVinylsAuthor(ForeignCollection<Vinyl> vinylsAuthor) {
        this.vinylsAuthor = vinylsAuthor;
    }
}
