package vinylApp.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vinylApp.database.dao.*;
import vinylApp.database.dbUtils.converters.*;
import vinylApp.database.models.*;
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
        ReleaseCountryDao releaseCountryDao = new ReleaseCountryDao();
        List<ReleaseCountry> releaseCountryList = releaseCountryDao.queryForAll(ReleaseCountry.class);
        releaseCountryFxObservableList.clear();
        releaseCountryList.forEach(a -> {
            ReleaseCountryFx releaseCountryFx = ConverterReleaseCountry.convertToReleaseCountryFx(a);
            releaseCountryFxObservableList.add(releaseCountryFx);
        });
    }

    private void initGenreList() throws ApplicationException {
        GenreDao genreDao = new GenreDao();
        List<Genre> genreList = genreDao.queryForAll(Genre.class);
        genreFxObservableList.clear();
        genreList.forEach(a -> {
            GenreFx genreFx = ConverterGenre.convertToGenreFx(a);
            genreFxObservableList.add(genreFx);
        });
    }

    private void initLabelList() throws ApplicationException {
        LabelDao labelDao = new LabelDao();
        List<Label> labelList = labelDao.queryForAll(Label.class);
        labelFxObservableList.clear();
        labelList.forEach(a -> {
            LabelFx labelFx = ConverterLabel.convertToLabelFx(a);
            labelFxObservableList.add(labelFx);
        });

    }

    private void initAuthorList() throws ApplicationException {

        AuthorDao authorDao = new AuthorDao();
        List<Author> authorList = authorDao.queryForAll(Author.class);
        authorFxObservableList.clear();
        authorList.forEach(a -> {
            AuthorFx authorFx = ConverterAuthor.convertToAuthorFx(a);
            authorFxObservableList.add(authorFx);
        });

    }

    public void saveVinylInDatabase() throws ApplicationException, NumberFormatException {
        Vinyl vinyl = ConverterVinyl.convertToVinyl(this.getVinylFxObjectProperty());

        AuthorDao authorDao = new AuthorDao();
        Author author = authorDao.findById(Author.class, this.getVinylFxObjectProperty().getAuthorFx().getId());
        vinyl.setAuthor(author);

        GenreDao genreDao = new GenreDao();
        Genre genre = genreDao.findById(Genre.class, this.getVinylFxObjectProperty().getGenreFx().getId());
        vinyl.setGenre(genre);

        LabelDao labelDao = new LabelDao();
        Label label = labelDao.findById(Label.class, this.getVinylFxObjectProperty().getLabelFx().getId());
        vinyl.setLabel(label);

        ReleaseCountryDao releaseCountryDao = new ReleaseCountryDao();
        ReleaseCountry releaseCountry = releaseCountryDao.findById(ReleaseCountry.class, this.getVinylFxObjectProperty().getCountryFx().getId());
        vinyl.setReleaseCountry(releaseCountry);

        VinylDao vinylDao = new VinylDao();
        vinylDao.createOrUpdate(vinyl);
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
