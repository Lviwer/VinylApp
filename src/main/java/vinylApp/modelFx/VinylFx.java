package vinylApp.modelFx;

import javafx.beans.property.*;

import java.time.LocalDate;

public class VinylFx {


 private IntegerProperty id = new SimpleIntegerProperty();
 private SimpleStringProperty title = new SimpleStringProperty();
 private ObjectProperty<AuthorFx> authorFx = new SimpleObjectProperty<>();
 private ObjectProperty<LabelFx> labelFx = new SimpleObjectProperty<>();
 private ObjectProperty<ReleaseCountryFx> countryFx = new SimpleObjectProperty<>();
 private SimpleStringProperty released = new SimpleStringProperty();
 private ObjectProperty<GenreFx> genreFx = new SimpleObjectProperty<>();
 private SimpleStringProperty catalogNumber = new SimpleStringProperty();
 private ObjectProperty<LocalDate> dateOfPurchase = new SimpleObjectProperty<>();
 //PRICE
 private SimpleDoubleProperty price = new SimpleDoubleProperty();
 private SimpleDoubleProperty sellingPrice = new SimpleDoubleProperty();

 private SimpleStringProperty vinylCondition = new SimpleStringProperty();
 private SimpleStringProperty accessoriesCondition = new SimpleStringProperty();
 private SimpleBooleanProperty isAvailable = new SimpleBooleanProperty();
 private SimpleBooleanProperty wantList = new SimpleBooleanProperty();


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public AuthorFx getAuthorFx() {
        return authorFx.get();
    }

    public ObjectProperty<AuthorFx> authorFxProperty() {
        return authorFx;
    }

    public void setAuthorFx(AuthorFx authorFx) {
        this.authorFx.set(authorFx);
    }

    public LabelFx getLabelFx() {
        return labelFx.get();
    }

    public ObjectProperty<LabelFx> labelFxProperty() {
        return labelFx;
    }

    public void setLabelFx(LabelFx labelFx) {
        this.labelFx.set(labelFx);
    }

    public ReleaseCountryFx getCountryFx() {
        return countryFx.get();
    }

    public ObjectProperty<ReleaseCountryFx> countryFxProperty() {
        return countryFx;
    }

    public void setCountryFx(ReleaseCountryFx countryFx) {
        this.countryFx.set(countryFx);
    }

    public GenreFx getGenreFx() {
        return genreFx.get();
    }

    public ObjectProperty<GenreFx> genreFxProperty() {
        return genreFx;
    }

    public void setGenreFx(GenreFx genreFx) {
        this.genreFx.set(genreFx);
    }

    public String getCatalogNumber() {
        return catalogNumber.get();
    }

    public SimpleStringProperty catalogNumberProperty() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber.set(catalogNumber);
    }

    public String getVinylCondition() {
        return vinylCondition.get();
    }

    public SimpleStringProperty vinylConditionProperty() {
        return vinylCondition;
    }

    public void setVinylCondition(String vinylCondition) {
        this.vinylCondition.set(vinylCondition);
    }

    public String getAccessoriesCondition() {
        return accessoriesCondition.get();
    }

    public SimpleStringProperty accessoriesConditionProperty() {
        return accessoriesCondition;
    }

    public void setAccessoriesCondition(String accessoriesCondition) {
        this.accessoriesCondition.set(accessoriesCondition);
    }

    public boolean isIsAvailable() {
        return isAvailable.get();
    }

    public SimpleBooleanProperty isAvailableProperty() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable.set(isAvailable);
    }

    public boolean isWantList() {
        return wantList.get();
    }

    public SimpleBooleanProperty wantListProperty() {
        return wantList;
    }

    public void setWantList(boolean wantList) {
        this.wantList.set(wantList);
    }

    public String getReleased() {
        return released.get();
    }

    public SimpleStringProperty releasedProperty() {
        return released;
    }

    public void setReleased(String released) {
        this.released.set(released);
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase.get();
    }

    public ObjectProperty<LocalDate> dateOfPurchaseProperty() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase.set(dateOfPurchase);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public double getSellingPrice() {
        return sellingPrice.get();
    }

    public SimpleDoubleProperty sellingPriceProperty() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice.set(sellingPrice);
    }

    @Override
    public String toString() {
        return "VinylFx{" +
                "id=" + id.get() +
                ", title=" + title.get() +
                ", authorFx=" + authorFx.get() +
                ", labelFx=" + labelFx.get() +
                ", countryFx=" + countryFx.get() +
                ", released=" + released.get() +
                ", genreFx=" + genreFx.get() +
                ", catalogNumber=" + catalogNumber.get() +
                ", dateOfPurchase=" + dateOfPurchase.get() +
                ", price=" + price.get() +
                ", sellingPrice=" + sellingPrice.get() +
                ", vinylCondition=" + vinylCondition.get() +
                ", accessoriesCondition=" + accessoriesCondition.get() +
                ", isAvailable=" + isAvailable.get() +
                ", wantList=" + wantList.get() +
                '}';
    }
}
