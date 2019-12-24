package vinylApp.utils;

import vinylApp.database.dao.*;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.database.models.*;
import vinylApp.utils.exceptions.ApplicationException;

import java.util.Date;

public class FillDatabase {


    public static void fillDatabase() {

        Genre genre1 = new Genre();
        genre1.setNameOfGenre("Disco");
        Genre genre2 = new Genre();
        genre2.setNameOfGenre("Jazz");
        Genre genre3 = new Genre();
        genre3.setNameOfGenre("Blues");

        GenreDao genreDao = new GenreDao(DbManager.getConnectionSource());

        try {
            genreDao.createOrUpdate(genre1);
            genreDao.createOrUpdate(genre2);
            genreDao.createOrUpdate(genre3);
        } catch (ApplicationException e) {
            e.printStackTrace();
        }


        Label label1 = new Label();
        label1.setNameOfLabel("Amiga");
        Label label2 = new Label();
        label2.setNameOfLabel("Polton");
        Label label3 = new Label();
        label3.setNameOfLabel("Polskie Nagrania");

        LabelDao labelDao = new LabelDao(DbManager.getConnectionSource());


        try {
            labelDao.createOrUpdate(label1);
            labelDao.createOrUpdate(label2);
            labelDao.createOrUpdate(label3);
            DbManager.closeConnectionSource();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }


        ReleaseCountry releaseCountry1 = new ReleaseCountry();
        releaseCountry1.setNameOfCountry("Polska");
        ReleaseCountry releaseCountry2 = new ReleaseCountry();
        releaseCountry2.setNameOfCountry("USA");

        ReleaseCountryDao releaseCountryDao = new ReleaseCountryDao(DbManager.getConnectionSource());


        try {
            releaseCountryDao.createOrUpdate(releaseCountry1);
            releaseCountryDao.createOrUpdate(releaseCountry2);
            DbManager.closeConnectionSource();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }


        Author author1 = new Author();
        author1.setNameOfAuthor("Biały Wilk");
        author1.setSurnameOfAuthor("Z Rivii");
        Author author2 = new Author();
        author2.setNameOfAuthor("Jaskier");
        author2.setSurnameOfAuthor("Pinda");

        AuthorDao authorDao = new AuthorDao(DbManager.getConnectionSource());

        try {
            authorDao.createOrUpdate(author1);
            authorDao.createOrUpdate(author2);
            DbManager.closeConnectionSource();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }


        Vinyl vinyl1 = new Vinyl();
        vinyl1.setGenre(genre1);
        vinyl1.setLabel(label1);
        vinyl1.setReleaseCountry(releaseCountry1);
        vinyl1.setAvailable(true);
        vinyl1.setBuyDate(new Date());
        vinyl1.setCatalogNumber(2122222);
        vinyl1.setCondition("G+");
        vinyl1.setConditionAccessories("-");
        vinyl1.setPrice(22.30f);
        vinyl1.setWantTo(true);
        vinyl1.setTitle("W");
        vinyl1.setAuthor(author1);
        vinyl1.setSellPrice(12.0f);
        vinyl1.setReleaseDate(new Date());


        Vinyl vinyl2 = new Vinyl();
        vinyl2.setGenre(genre2);
        vinyl2.setLabel(label2);
        vinyl2.setReleaseCountry(releaseCountry2);
        vinyl2.setAvailable(true);
        vinyl2.setBuyDate(new Date());
        vinyl2.setCatalogNumber(21222422);
        vinyl2.setCondition("VG");
        vinyl2.setConditionAccessories("G");
        vinyl2.setPrice(122.30f);
        vinyl2.setWantTo(true);
        vinyl2.setTitle("Winchester");
        vinyl2.setAuthor(author2);
        vinyl2.setSellPrice(112.2f);
        vinyl2.setReleaseDate(new Date());



        VinylDao vinylDao = new VinylDao(DbManager.getConnectionSource());


        try {
            vinylDao.createOrUpdate(vinyl1);
            vinylDao.createOrUpdate(vinyl2);
            DbManager.closeConnectionSource();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
        DbManager.closeConnectionSource();

    }


}
