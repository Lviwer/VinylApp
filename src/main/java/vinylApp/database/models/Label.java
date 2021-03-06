package vinylApp.database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "LABEL")
public class Label implements BaseModel {

    public Label() {

    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "NAME", canBeNull = false, unique = true)
    private String nameOfLabel;

    @ForeignCollectionField(columnName = "VINYL_ID")
    private ForeignCollection<Vinyl> vinylsLabel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfLabel() {
        return nameOfLabel;
    }

    public void setNameOfLabel(String nameOfLabel) {
        this.nameOfLabel = nameOfLabel;
    }

    public ForeignCollection<Vinyl> getVinylsLabel() {
        return vinylsLabel;
    }

    public void setVinylsLabel(ForeignCollection<Vinyl> vinylsLabel) {
        this.vinylsLabel = vinylsLabel;
    }
}
