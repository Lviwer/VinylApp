package vinylApp.modelFx;

import javafx.beans.property.*;

public class VinylFx {


 private IntegerProperty id = new SimpleIntegerProperty();
 private SimpleStringProperty title = new SimpleStringProperty();
 private ObjectProperty<AuthorFx> authorFx = new SimpleObjectProperty<>();
 private ObjectProperty<LabelFx> labelFx = new SimpleObjectProperty<>();
 private ObjectProperty<ReleaseCountryFx> countryFx = new SimpleObjectProperty<>();
 private SimpleStringProperty released = new SimpleStringProperty();
 private ObjectProperty<GenreFx> genreFx = new SimpleObjectProperty<>();
 private SimpleStringProperty catalogNumber = new SimpleStringProperty();
 private SimpleStringProperty dateOfPurchase = new SimpleStringProperty();
 private SimpleFloatProperty price = new SimpleFloatProperty();
 private SimpleFloatProperty sellingPrice = new SimpleFloatProperty();
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

    public String getReleased() {
        return released.get();
    }

    public SimpleStringProperty releasedProperty() {
        return released;
    }

    public void setReleased(String released) {
        this.released.set(released);
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

    public String getDateOfPurchase() {
        return dateOfPurchase.get();
    }

    public SimpleStringProperty dateOfPurchaseProperty() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase.set(dateOfPurchase);
    }

    public float getPrice() {
        return price.get();
    }

    public SimpleFloatProperty priceProperty() {
        return price;
    }

    public void setPrice(float price) {
        this.price.set(price);
    }

    public float getSellingPrice() {
        return sellingPrice.get();
    }

    public SimpleFloatProperty sellingPriceProperty() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice.set(sellingPrice);
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
}
