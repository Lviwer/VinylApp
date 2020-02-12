package vinylApp.modelFx;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vinylApp.database.dao.*;
import vinylApp.database.dbUtils.converters.*;
import vinylApp.database.models.*;
import vinylApp.utils.exceptions.ApplicationException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListVinylsModel {


    private ObservableList<VinylFx> vinylFxObservableList = FXCollections.observableArrayList();

    private ObservableList<AuthorFx> authorFxObservableList = FXCollections.observableArrayList();
    private ObservableList<GenreFx> genreFxObservableList = FXCollections.observableArrayList();
    private ObservableList<ReleaseCountryFx> releaseCountryFxObservableList = FXCollections.observableArrayList();
    private ObservableList<LabelFx> labelFxObservableList = FXCollections.observableArrayList();

    //for choosen in comboBox
    private ObjectProperty<AuthorFx> authorFxObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<GenreFx> genreFxObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<ReleaseCountryFx> releaseCountryFxObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<LabelFx> labelFxObjectProperty = new SimpleObjectProperty<>();

    private List<VinylFx> vinylFxList = new ArrayList<>();
    private double oneMonthSpend;
    private int thisMonthBuyed;
    private int allVinyls;
    private double oneMonthEarn;
    private int oneMonthSoldVinyl;
    private double allCollectionValue;


    public void init() throws ApplicationException {
        VinylDao vinylDao = new VinylDao();
        List<Vinyl> vinyls = vinylDao.queryForAll(Vinyl.class);
        vinylFxList.clear();

        vinyls.forEach(vinyl -> {
            this.vinylFxList.add(ConverterVinyl.convertToVinylFx(vinyl));

        });

        getMoneyAndVinylsBuyInMonth();  // + allCollectionValue
        getMoneyVinylsSoldInMonth();
        allVinyls = vinylFxList.size();

        this.vinylFxObservableList.setAll(vinylFxList);
        initAuthors();
        initGenres();
        initCountries();
        initLabels();
    }

    private void getMoneyVinylsSoldInMonth() {
        for (VinylFx a : vinylFxList) {
            if (a.getDateOfSelling() == null) {
                continue;
            } else if (a.getDateOfSelling().getYear() == LocalDate.now().getYear() &&
                    a.getDateOfSelling().getMonth() == LocalDate.now().getMonth()) {
                oneMonthEarn += a.getSellingPrice();
                oneMonthSoldVinyl++;
            }
        }
    }

    private void getMoneyAndVinylsBuyInMonth() {
        for (VinylFx a : vinylFxList) {
            allCollectionValue += a.getPrice();
            if (a.getDateOfPurchase().getYear() == LocalDate.now().getYear() &&
                    a.getDateOfPurchase().getMonth() == LocalDate.now().getMonth()) {
                oneMonthSpend += a.getPrice();
                thisMonthBuyed++;

            }
        }
    }


    public void filterVinylList() {
        if (getAuthorFxObjectProperty() != null && getGenreFxObjectProperty() != null && getLabelFxObjectProperty() != null
                && getReleaseCountryFxObjectProperty() != null) {
            filterPredicate(predicateAuthor().and(predicateGenre().and(predicateLabel().and(predicateReleaseCountry()))));

        } else if (getGenreFxObjectProperty() != null && getLabelFxObjectProperty() != null && getReleaseCountryFxObjectProperty() != null) {
            filterPredicate(predicateGenre().and(predicateLabel().and(predicateReleaseCountry())));

        } else if (getAuthorFxObjectProperty() != null && getLabelFxObjectProperty() != null && getReleaseCountryFxObjectProperty()
                != null) {
            filterPredicate(predicateAuthor().and(predicateLabel().and(predicateReleaseCountry())));

        } else if (getAuthorFxObjectProperty() != null && getGenreFxObjectProperty() != null && getLabelFxObjectProperty()
                != null) {
            filterPredicate(predicateAuthor().and(predicateGenre().and(predicateLabel())));

        } else if (getAuthorFxObjectProperty() != null && getGenreFxObjectProperty() != null &&
                getReleaseCountryFxObjectProperty() != null) {
            filterPredicate(predicateAuthor().and(predicateLabel().and(predicateReleaseCountry())));

        } else if (getAuthorFxObjectProperty() != null && getGenreFxObjectProperty() != null) {
            filterPredicate(predicateAuthor().and(predicateGenre()));

        } else if (getAuthorFxObjectProperty() != null && getLabelFxObjectProperty() != null) {
            filterPredicate(predicateAuthor().and(predicateLabel()));

        } else if (getAuthorFxObjectProperty() != null && getReleaseCountryFxObjectProperty() != null) {
            filterPredicate(predicateAuthor().and(predicateReleaseCountry()));

        } else if (getGenreFxObjectProperty() != null && getLabelFxObjectProperty() != null) {
            filterPredicate(predicateGenre().and(predicateLabel()));

        } else if (getGenreFxObjectProperty() != null && getReleaseCountryFxObjectProperty() != null) {
            filterPredicate(predicateGenre().and(predicateReleaseCountry()));

        } else if (getLabelFxObjectProperty() != null && getReleaseCountryFxObjectProperty() != null) {
            filterPredicate(predicateLabel().and(predicateReleaseCountry()));

        } else if (getAuthorFxObjectProperty() != null) {
            filterPredicate(predicateAuthor());

        } else if (getGenreFxObjectProperty() != null) {
            filterPredicate(predicateGenre());

        } else if (getLabelFxObjectProperty() != null) {
            filterPredicate(predicateLabel());

        } else if (getReleaseCountryFxObjectProperty() != null) {
            filterPredicate(predicateReleaseCountry());

        } else
            this.vinylFxObservableList.setAll(this.vinylFxList);
    }


    private void initAuthors() throws ApplicationException {
        AuthorDao authorDao = new AuthorDao();
        List<Author> authorList = authorDao.queryForAll(Author.class);
        this.authorFxObservableList.clear();
        authorList.forEach(author -> {
            AuthorFx authorFx = ConverterAuthor.convertToAuthorFx(author);
            this.authorFxObservableList.add(authorFx);
        });
    }

    private void initGenres() throws ApplicationException {
        GenreDao genreDao = new GenreDao();
        List<Genre> genreList = genreDao.queryForAll(Genre.class);
        this.genreFxObservableList.clear();
        genreList.forEach(genre -> {
            GenreFx genreFx = ConverterGenre.convertToGenreFx(genre);
            this.genreFxObservableList.add(genreFx);
        });
    }

    private void initCountries() throws ApplicationException {
        ReleaseCountryDao releaseCountryDao = new ReleaseCountryDao();
        List<ReleaseCountry> releaseCountryList = releaseCountryDao.queryForAll(ReleaseCountry.class);
        this.releaseCountryFxObservableList.clear();
        releaseCountryList.forEach(releaseCountry -> {
            ReleaseCountryFx releaseCountryFx = ConverterReleaseCountry.convertToReleaseCountryFx(releaseCountry);
            this.releaseCountryFxObservableList.add(releaseCountryFx);
        });
    }

    private void initLabels() throws ApplicationException {
        LabelDao labelDao = new LabelDao();
        List<Label> labelList = labelDao.queryForAll(Label.class);
        this.labelFxObservableList.clear();
        labelList.forEach(label -> {
            LabelFx labelFx = ConverterLabel.convertToLabelFx(label);
            this.labelFxObservableList.add(labelFx);
        });
    }

    //predicate for table filtering
    private Predicate<VinylFx> predicateAuthor() {
        Predicate<VinylFx> predicate = vinylFx -> vinylFx.getAuthorFx().getId() == getAuthorFxObjectProperty().getId();
        return predicate;
    }

    private Predicate<VinylFx> predicateGenre() {

        Predicate<VinylFx> predicate = genreFx -> genreFx.getGenreFx().getId() == getGenreFxObjectProperty().getId();
        return predicate;
    }

    private Predicate<VinylFx> predicateReleaseCountry() {
        Predicate<VinylFx> predicate = releaseCountryFx -> releaseCountryFx.getCountryFx().getId()
                == getReleaseCountryFxObjectProperty().getId();
        return predicate;
    }

    private Predicate<VinylFx> predicateLabel() {
        Predicate<VinylFx> predicate = labelFx -> labelFx.getLabelFx().getId() == getLabelFxObjectProperty().getId();
        return predicate;
    }

    private void filterPredicate(Predicate<VinylFx> predicate) {
        //stream filters our list, creates a new one and saves in newList
        List<VinylFx> newList = vinylFxList.stream().filter(predicate).collect(Collectors.toList());
        this.vinylFxObservableList.setAll(newList);
    }


    public void deleteVinyl(VinylFx vinylFx) throws ApplicationException {
        VinylDao vinylDao = new VinylDao();
        vinylDao.deleteById(Vinyl.class, vinylFx.getId());
        init();

    }

    public ObservableList<VinylFx> getVinylFxObservableList() {
        return vinylFxObservableList;
    }

    public void setVinylFxObservableList(ObservableList<VinylFx> vinylFxObservableList) {
        this.vinylFxObservableList = vinylFxObservableList;
    }

    public ObservableList<AuthorFx> getAuthorFxObservableList() {
        return authorFxObservableList;
    }

    public void setAuthorFxObservableList(ObservableList<AuthorFx> authorFxObservableList) {
        this.authorFxObservableList = authorFxObservableList;
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

    public ObservableList<LabelFx> getLabelFxObservableList() {
        return labelFxObservableList;
    }

    public void setLabelFxObservableList(ObservableList<LabelFx> labelFxObservableList) {
        this.labelFxObservableList = labelFxObservableList;
    }


    public AuthorFx getAuthorFxObjectProperty() {
        return authorFxObjectProperty.get();
    }

    public ObjectProperty<AuthorFx> authorFxObjectPropertyProperty() {
        return authorFxObjectProperty;
    }

    public void setAuthorFxObjectProperty(AuthorFx authorFxObjectProperty) {
        this.authorFxObjectProperty.set(authorFxObjectProperty);
    }

    public GenreFx getGenreFxObjectProperty() {
        return genreFxObjectProperty.get();
    }

    public ObjectProperty<GenreFx> genreFxObjectPropertyProperty() {
        return genreFxObjectProperty;
    }

    public void setGenreFxObjectProperty(GenreFx genreFxObjectProperty) {
        this.genreFxObjectProperty.set(genreFxObjectProperty);
    }

    public ReleaseCountryFx getReleaseCountryFxObjectProperty() {
        return releaseCountryFxObjectProperty.get();
    }

    public ObjectProperty<ReleaseCountryFx> releaseCountryFxObjectPropertyProperty() {
        return releaseCountryFxObjectProperty;
    }

    public void setReleaseCountryFxObjectProperty(ReleaseCountryFx releaseCountryFxObjectProperty) {
        this.releaseCountryFxObjectProperty.set(releaseCountryFxObjectProperty);
    }

    public LabelFx getLabelFxObjectProperty() {
        return labelFxObjectProperty.get();
    }

    public ObjectProperty<LabelFx> labelFxObjectPropertyProperty() {
        return labelFxObjectProperty;
    }

    public void setLabelFxObjectProperty(LabelFx labelFxObjectProperty) {
        this.labelFxObjectProperty.set(labelFxObjectProperty);
    }

    public double getOneMonthSpend() {
        return oneMonthSpend;
    }

    public int getThisMonthBuyed() {
        return thisMonthBuyed;
    }

    public int getAllVinyls() {
        return allVinyls;
    }

    public double getOneMonthEarn() {
        return oneMonthEarn;
    }

    public int getOneMonthSoldVinyl() {
        return oneMonthSoldVinyl;
    }

    public double getAllCollectionValue() {
        return allCollectionValue;
    }
}
