package vinylApp.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vinylApp.database.dao.AuthorDao;
import vinylApp.database.dao.GenreDao;
import vinylApp.database.dao.LabelDao;
import vinylApp.database.dao.ReleaseCountryDao;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.database.dbUtils.converters.ConverterAuthor;
import vinylApp.database.dbUtils.converters.ConverterGenre;
import vinylApp.database.dbUtils.converters.ConverterLabel;
import vinylApp.database.dbUtils.converters.ConverterReleaseCountry;
import vinylApp.database.models.Author;
import vinylApp.database.models.Genre;
import vinylApp.database.models.Label;
import vinylApp.database.models.ReleaseCountry;
import vinylApp.utils.exceptions.ApplicationException;

import java.util.List;

public class VinylModel {


    private ObjectProperty<VinylFx> vinylFxObjectProperty = new SimpleObjectProperty<>(new VinylFx());
    private ObservableList<AuthorFx> authorFxObservableList = FXCollections.observableArrayList();
    private ObservableList<LabelFx> labelFxObservableList = FXCollections.observableArrayList();
    private ObservableList<GenreFx> genreFxObservableList = FXCollections.observableArrayList();
    private ObservableList<ReleaseCountryFx> releaseCountryFxObservableList = FXCollections.observableArrayList();

    public void init() throws ApplicationException {
        initAuthorList();
        initLabelList();
        initGenreList();
        initReleaseCountryList();



    }

    private void initReleaseCountryList() throws ApplicationException {
        ReleaseCountryDao releaseCountryDao = new ReleaseCountryDao(DbManager.getConnectionSource());
        List<ReleaseCountry> releaseCountryList = releaseCountryDao.queryForAll(ReleaseCountry.class);
        releaseCountryFxObservableList.clear();
        releaseCountryList.forEach(a->{
            ReleaseCountryFx releaseCountryFx = ConverterReleaseCountry.convertToReleaseCountryFx(a);
            releaseCountryFxObservableList.add(releaseCountryFx);
        });
        DbManager.closeConnectionSource();

    }

    private void initGenreList() throws ApplicationException {
        GenreDao genreDao = new GenreDao(DbManager.getConnectionSource());
        List<Genre> genreList = genreDao.queryForAll(Genre.class);
        genreFxObservableList.clear();
        genreList.forEach(a->{
            GenreFx genreFx = ConverterGenre.convertToGenreFx(a);
            genreFxObservableList.add(genreFx);
        });
        DbManager.closeConnectionSource();
    }

    private void initLabelList() throws ApplicationException {
        LabelDao labelDao = new LabelDao(DbManager.getConnectionSource());
        List<Label> labelList = labelDao.queryForAll(Label.class);
        labelFxObservableList.clear();
        labelList.forEach(a->{
            LabelFx labelFx = ConverterLabel.convertToLabelFx(a);
            labelFxObservableList.add(labelFx);
        });
        DbManager.closeConnectionSource();

    }

    private void initAuthorList() throws ApplicationException {

        AuthorDao authorDao = new AuthorDao(DbManager.getConnectionSource());
        List<Author> authorList = authorDao.queryForAll(Author.class);
        authorFxObservableList.clear();
        authorList.forEach(a->{
            AuthorFx authorFx = ConverterAuthor.convertToAuthorFx(a);
            authorFxObservableList.add(authorFx);
        });
        DbManager.closeConnectionSource();
    }


    public VinylFx getVinylFxObjectProperty() {
        return vinylFxObjectProperty.get();
    }

    public ObjectProperty<VinylFx> vinylFxObjectPropertyProperty() {
        return vinylFxObjectProperty;
    }

    public void setVinylFxObjectProperty(VinylFx vinylFxObjectProperty) {
        this.vinylFxObjectProperty.set(vinylFxObjectProperty);
    }

    public ObservableList<AuthorFx> getAuthorFxObservableList() {
        return authorFxObservableList;
    }

    public void setAuthorFxObservableList(ObservableList<AuthorFx> authorFxObservableList) {
        this.authorFxObservableList = authorFxObservableList;
    }

    public ObservableList<LabelFx> getLabelFxObservableList() {
        return labelFxObservableList;
    }

    public void setLabelFxObservableList(ObservableList<LabelFx> labelFxObservableList) {
        this.labelFxObservableList = labelFxObservableList;
    }

    public ObservableList<GenreFx> getGenreFxObservableList() {
        return genreFxObservableList;
    }

    public void setGenreFxObservableList(ObservableList<GenreFx> genreFxObservableList) {
        this.genreFxObservableList = genreFxObservableList;
    }

    public ObservableList<ReleaseCountryFx> getReleaseCountryFxObservableList() {
        return releaseCountryFxObservableList;
    }

    public void setReleaseCountryFxObservableList(ObservableList<ReleaseCountryFx> releaseCountryFxObservableList) {
        this.releaseCountryFxObservableList = releaseCountryFxObservableList;
    }
}
