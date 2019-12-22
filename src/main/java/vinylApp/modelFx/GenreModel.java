package vinylApp.modelFx;

import vinylApp.database.dao.GenreDao;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.database.models.Genre;


//separate javaFx from database
public class GenreModel {

    public void saveGenreInDataBase(String name)
    {
        GenreDao genreDao = new GenreDao(DbManager.getConnectionSource());
        Genre genre = new Genre();
        genre.setNameOfGenre(name);
        genreDao.createOrUpdate(genre);
        DbManager.getConnectionSource();
    }





}
