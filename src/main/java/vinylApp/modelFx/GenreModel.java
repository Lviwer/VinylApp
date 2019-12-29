package vinylApp.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import vinylApp.database.dao.GenreDao;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.database.dbUtils.converters.ConverterGenre;
import vinylApp.database.models.Genre;
import vinylApp.utils.exceptions.ApplicationException;

import java.util.List;


//separate javaFx from database
public class GenreModel {

    private ObservableList<GenreFx> genreList = FXCollections.observableArrayList();//connect with comboBox
    private ObjectProperty<GenreFx> genre = new SimpleObjectProperty<>();//take choosen from comboBox element
    private TreeItem<String> root = new TreeItem<>();

    public void init() throws ApplicationException {
        GenreDao genreDao = new GenreDao();
        List<Genre> genres = genreDao.queryForAll(Genre.class);
        initGenreList(genres);
        initRoot(genres);

    }

    private void initRoot(List<Genre> genres) {
        this.root.getChildren().clear();
        genres.forEach(a -> {
            TreeItem<String> genreItem = new TreeItem<>(a.getNameOfGenre());

            a.getVinylsGenre().forEach(b -> {
                genreItem.getChildren().add(new TreeItem<>(b.getTitle()));
            });
            root.getChildren().add(genreItem);
        });
    }

    private void initGenreList(List<Genre> genres) {
        this.genreList.clear();
        genres.forEach(c -> {
            GenreFx genreFx = ConverterGenre.convertToGenreFx(c);
            this.genreList.add(genreFx);
        });
    }


    public void saveGenreInDataBase(String name) throws ApplicationException {
        GenreDao genreDao = new GenreDao();
        Genre genre = new Genre();
        genre.setNameOfGenre(name);
        genreDao.createOrUpdate(genre);
        init();
    }


    public void deleteGenreById() throws ApplicationException {
        GenreDao genreDao = new GenreDao();
        genreDao.deleteById(Genre.class, genre.getValue().getId());
        init();
    }


    public void updateGenreInDataBase() throws ApplicationException {
        GenreDao genreDao = new GenreDao();
        Genre tempGenre = genreDao.findById(Genre.class, this.getGenre().getId());
        tempGenre.setNameOfGenre(getGenre().getNameOfGenre());
        genreDao.createOrUpdate(tempGenre);
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


    public TreeItem<String> getRoot() {
        return root;
    }

    public void setRoot(TreeItem<String> root) {
        this.root = root;
    }
}
