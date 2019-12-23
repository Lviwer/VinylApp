package vinylApp.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vinylApp.database.dao.GenreDao;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.database.models.Genre;
import vinylApp.utils.exceptions.ApplicationException;

import java.util.List;


//separate javaFx from database
public class GenreModel {

    private ObservableList<GenreFx> genreList = FXCollections.observableArrayList();//connect with comboBox
    private ObjectProperty<GenreFx> genre = new SimpleObjectProperty<>();//take choosen from comboBox element


    public void init() throws ApplicationException {
        GenreDao genreDao = new GenreDao(DbManager.getConnectionSource());
        List<Genre> genres = genreDao.queryForAll(Genre.class);
        this.genreList.clear();

        genres.forEach(c -> {
            GenreFx genreFx = new GenreFx();
            genreFx.setId(c.getId());
            genreFx.setNameOfGenre(c.getNameOfGenre());
            this.genreList.add(genreFx);
        });
        DbManager.closeConnectionSource();

    }


    public void saveGenreInDataBase(String name) throws ApplicationException {
        GenreDao genreDao = new GenreDao(DbManager.getConnectionSource());
        Genre genre = new Genre();
        genre.setNameOfGenre(name);
        genreDao.createOrUpdate(genre);
        DbManager.getConnectionSource();
        init();
    }


    public void deleteGenreById() throws ApplicationException {
        GenreDao genreDao = new GenreDao(DbManager.getConnectionSource());
        genreDao.deleteById(Genre.class, genre.getValue().getId());
        DbManager.closeConnectionSource();
        init();
    }


    public void updateGenreInDataBase() throws ApplicationException {
        GenreDao genreDao = new GenreDao(DbManager.getConnectionSource());
        Genre tempGenre = genreDao.findById(Genre.class, this.getGenre().getId());
        tempGenre.setNameOfGenre(getGenre().getNameOfGenre());
        genreDao.createOrUpdate(tempGenre);
        DbManager.closeConnectionSource();
        init();


    }



    public ObservableList<GenreFx> getGenreList() {
        return genreList;
    }

    public void setGenreList(ObservableList<GenreFx> genreList) {
        this.genreList = genreList;
    }

    public GenreFx getGenre() {
        return genre.get();
    }

    public ObjectProperty<GenreFx> genreProperty() {
        return genre;
    }

    public void setGenre(GenreFx genre) {
        this.genre.set(genre);
    }


}
