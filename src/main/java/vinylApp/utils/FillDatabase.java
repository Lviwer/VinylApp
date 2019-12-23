package vinylApp.utils;

import vinylApp.database.models.Genre;
import vinylApp.database.models.Label;
import vinylApp.database.models.ReleaseCountry;
import vinylApp.database.models.Vinyl;

import java.util.Date;

public class FillDatabase {


    public static void fillDatabase(){

        Genre genre1 = new Genre();
        genre1.setNameOfGenre("Disco");
        Genre genre2 = new Genre();
        genre2.setNameOfGenre("Jazz");
        Genre genre3 = new Genre();
        genre3.setNameOfGenre("Blues");

        Label label1 = new Label();
        label1.setNameOfLabel("Amiga");
        Label label2 = new Label();
        label2.setNameOfLabel("Polton");
        Label label3 = new Label();
        label3.setNameOfLabel("Polskie Nagrania");

        ReleaseCountry releaseCountry1 = new ReleaseCountry();
        releaseCountry1.setNameOfCountry("Polska");
        ReleaseCountry releaseCountry2 = new ReleaseCountry();
        releaseCountry2.setNameOfCountry("USA");

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




    }












}
