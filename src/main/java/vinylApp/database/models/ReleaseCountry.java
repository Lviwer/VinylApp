package vinylApp.database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "RELEASE_COUNTRY")
public class ReleaseCountry implements BaseModel {

    public ReleaseCountry() {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "NAME", canBeNull = false, unique = true)
    private String nameOfCountry;

    @ForeignCollectionField(columnName = "VINYL_ID")
    private ForeignCollection<Vinyl> vinylsRelease;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }

    public ForeignCollection<Vinyl> getVinylsRelease() {
        return vinylsRelease;
    }

    public void setVinylsRelease(ForeignCollection<Vinyl> vinylsRelease) {
        this.vinylsRelease = vinylsRelease;
    }
}
