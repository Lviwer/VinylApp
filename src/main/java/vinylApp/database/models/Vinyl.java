package vinylApp.database.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "VINYLS")
public class Vinyl implements BaseModel {

    public Vinyl() {

    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "TITLE", canBeNull = false)
    private String title;

    @DatabaseField(columnName = "RELEASE_DATE")
    private int releaseDate;

    @DatabaseField(columnName = "LABEL", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Label label;

    @DatabaseField(columnName = "GENRE", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Genre genre;

    @DatabaseField(columnName = "RELEASE_COUNTRY", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private ReleaseCountry releaseCountry;

    @DatabaseField(columnName = "AUTHOR", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = true)
    private Author author;

    @DatabaseField(columnName = "CATALOG_NUMBER")
    private String catalogNumber;

    @DatabaseField(columnName = "PRICE", canBeNull = false)
    private double price;

    @DatabaseField(columnName = "SELL_PRICE")
    private double sellPrice;

    @DatabaseField(columnName = "BUY_DATE")
    private Date buyDate;

    @DatabaseField(columnName = "CONDITION")
    private String condition;

    @DatabaseField(columnName = "CONDITION_ACCESSORIES")
    private String conditionAccessories;

    @DatabaseField(columnName = "AVAILABLE")
    private boolean available;

    @DatabaseField(columnName = "WANT_TO")
    private boolean wantTo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public ReleaseCountry getReleaseCountry() {
        return releaseCountry;
    }

    public void setReleaseCountry(ReleaseCountry releaseCountry) {
        this.releaseCountry = releaseCountry;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getConditionAccessories() {
        return conditionAccessories;
    }

    public void setConditionAccessories(String conditionAccessories) {
        this.conditionAccessories = conditionAccessories;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isWantTo() {
        return wantTo;
    }

    public void setWantTo(boolean wantTo) {
        this.wantTo = wantTo;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
}
