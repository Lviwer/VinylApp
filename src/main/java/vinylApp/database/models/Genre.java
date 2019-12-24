package vinylApp.database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "GENRE")
public class Genre implements BaseModel {

    public Genre() {

    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "NAME", canBeNull = false, unique = true)
    private String nameOfGenre;

    @ForeignCollectionField(columnName = "VINYL_ID")
    private ForeignCollection<Vinyl> vinylsGenre;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfGenre() {
        return nameOfGenre;
    }

    public void setNameOfGenre(String nameOfGenre) {
        this.nameOfGenre = nameOfGenre;
    }

    public ForeignCollection<Vinyl> getVinylsGenre() {
        return vinylsGenre;
    }

    public void setVinylsGenre(ForeignCollection<Vinyl> vinylsGenre) {
        this.vinylsGenre = vinylsGenre;
    }
}
