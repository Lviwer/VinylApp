package vinylApp.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vinylApp.database.dao.ReleaseCountryDao;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.database.models.ReleaseCountry;

import java.util.List;

public class ReleaseCountryModel {


    private ObservableList<ReleaseCountryFx> releaseCountryList = FXCollections.observableArrayList();
    private ObjectProperty<ReleaseCountryFx> releaseCountry = new SimpleObjectProperty<>();

    public void init()
    {
        ReleaseCountryDao releaseCountryDao = new ReleaseCountryDao(DbManager.getConnectionSource());
        List<ReleaseCountry> releaseCountries = releaseCountryDao.queryForAll(ReleaseCountry.class);
        this.releaseCountryList.clear();

        releaseCountries.forEach(c->{
            ReleaseCountryFx releaseCountryFx = new ReleaseCountryFx();
            releaseCountryFx.setId(c.getId());
            releaseCountryFx.setNameOfCountry(c.getNameOfCountry());
            this.releaseCountryList.add(releaseCountryFx);
        });
        DbManager.closeConnectionSource();
    }

    public void deleteReleaseCountryById(){
        ReleaseCountryDao releaseCountryDao = new ReleaseCountryDao(DbManager.getConnectionSource());
        releaseCountryDao.deleteById(ReleaseCountry.class, releaseCountry.getValue().getId());
        DbManager.closeConnectionSource();
        init();
    }


    public void saveCountryInDataBase(String name)
    {
        ReleaseCountryDao releaseCountryDao = new ReleaseCountryDao(DbManager.getConnectionSource());
        ReleaseCountry releaseCountry = new ReleaseCountry();
        releaseCountry.setNameOfCountry(name);
        releaseCountryDao.createOrUpdate(releaseCountry);
        DbManager.closeConnectionSource();
        init();
    }

    public ObservableList<ReleaseCountryFx> getReleaseCountryList() {
        return releaseCountryList;
    }

    public void setReleaseCountryList(ObservableList<ReleaseCountryFx> releaseCountryList) {
        this.releaseCountryList = releaseCountryList;
    }

    public ReleaseCountryFx getReleaseCountry() {
        return releaseCountry.get();
    }

    public ObjectProperty<ReleaseCountryFx> releaseCountryProperty() {
        return releaseCountry;
    }

    public void setReleaseCountry(ReleaseCountryFx releaseCountry) {
        this.releaseCountry.set(releaseCountry);
    }
}
