package vinylApp.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import vinylApp.database.dao.GenreDao;
import vinylApp.database.dao.ReleaseCountryDao;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.database.dbUtils.converters.ConverterReleaseCountry;
import vinylApp.database.models.Genre;
import vinylApp.database.models.ReleaseCountry;
import vinylApp.utils.exceptions.ApplicationException;

import java.util.List;

public class ReleaseCountryModel {


    private ObservableList<ReleaseCountryFx> releaseCountryList = FXCollections.observableArrayList();
    private ObjectProperty<ReleaseCountryFx> releaseCountry = new SimpleObjectProperty<>();
    private TreeItem<String> root = new TreeItem<>();

    public void init() throws ApplicationException {
        ReleaseCountryDao releaseCountryDao = new ReleaseCountryDao();
        List<ReleaseCountry> releaseCountries = releaseCountryDao.queryForAll(ReleaseCountry.class);
        initReleaseCountryList(releaseCountries);
        initRoot(releaseCountries);
    }

    private void initRoot(List<ReleaseCountry> releaseCountries) {
        this.root.getChildren().clear();
        releaseCountries.forEach(a -> {
            TreeItem<String> releaseItem = new TreeItem<>(a.getNameOfCountry());
            a.getVinylsRelease().forEach(b -> {
                releaseItem.getChildren().add(new TreeItem<>(b.getTitle()));
            });
            root.getChildren().add(releaseItem);
        });

    }

    private void initReleaseCountryList(List<ReleaseCountry> releaseCountries) {
        this.releaseCountryList.clear();
        releaseCountries.forEach(c -> {
            ReleaseCountryFx releaseCountryFx = ConverterReleaseCountry.convertToReleaseCountryFx(c);
            this.releaseCountryList.add(releaseCountryFx);
        });
    }

    public void deleteReleaseCountryById() throws ApplicationException {
        ReleaseCountryDao releaseCountryDao = new ReleaseCountryDao();
        releaseCountryDao.deleteById(ReleaseCountry.class, releaseCountry.getValue().getId());
        init();
    }


    public void saveCountryInDataBase(String name) throws ApplicationException {
        ReleaseCountryDao releaseCountryDao = new ReleaseCountryDao();
        ReleaseCountry releaseCountry = new ReleaseCountry();
        releaseCountry.setNameOfCountry(name);
        releaseCountryDao.createOrUpdate(releaseCountry);
        init();
    }

    public void updateReleaseCountryInDataBase() throws ApplicationException {
        ReleaseCountryDao releaseCountryDao = new ReleaseCountryDao();
        ReleaseCountry tempReleaseCountry = releaseCountryDao.findById(ReleaseCountry.class, this.getReleaseCountry().getId());
        tempReleaseCountry.setNameOfCountry(getReleaseCountry().getNameOfCountry());
        releaseCountryDao.createOrUpdate(tempReleaseCountry);
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


    public TreeItem<String> getRoot() {
        return root;
    }

    public void setRoot(TreeItem<String> root) {
        this.root = root;
    }
}