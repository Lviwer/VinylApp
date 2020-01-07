package vinylApp.utils;

import vinylApp.database.dao.*;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.database.models.*;
import vinylApp.utils.exceptions.ApplicationException;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FillDatabase {


    public static void fillDatabase() {

        Genre disco = new Genre();
        disco.setNameOfGenre("Disco");

        Genre jazz = new Genre();
        jazz.setNameOfGenre("Jazz");

        Genre blues = new Genre();
        blues.setNameOfGenre("Blues");

        Genre rock = new Genre();
        rock.setNameOfGenre("Rock");

        Genre rockPolo = new Genre();
        rockPolo.setNameOfGenre("RockPolo");

        Genre metal = new Genre();
        metal.setNameOfGenre("Metal");

        Genre hardRock = new Genre();
        hardRock.setNameOfGenre("HardRock");

        Genre ballady = new Genre();
        ballady.setNameOfGenre("Ballady");

        Genre poezja = new Genre();
        poezja.setNameOfGenre("Poezja");

        Genre klasyczna = new Genre();
        klasyczna.setNameOfGenre("Muzyka Klasyczna");

        Genre pop = new Genre();
        pop.setNameOfGenre("Pop");

        Genre indieRock = new Genre();
        indieRock.setNameOfGenre("IndieRock");

        Genre reggae = new Genre();
        reggae.setNameOfGenre("Reggae");

        GenreDao genreDao = new GenreDao();

        try {
            genreDao.createOrUpdate(disco);
            genreDao.createOrUpdate(jazz);
            genreDao.createOrUpdate(blues);
            genreDao.createOrUpdate(rock);
            genreDao.createOrUpdate(rockPolo);
            genreDao.createOrUpdate(metal);
            genreDao.createOrUpdate(hardRock);
            genreDao.createOrUpdate(ballady);
            genreDao.createOrUpdate(poezja);
            genreDao.createOrUpdate(klasyczna);
            genreDao.createOrUpdate(pop);
            genreDao.createOrUpdate(indieRock);
            genreDao.createOrUpdate(reggae);

            DbManager.closeConnectionSource();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }


        Label pomaton = new Label();
        pomaton.setNameOfLabel("Pomaton");

        Label epic = new Label();
        epic.setNameOfLabel("Epic");

        Label warnerBros = new Label();
        warnerBros.setNameOfLabel("Warner Bros");

        Label polydor = new Label();
        polydor.setNameOfLabel("Polydor");

        Label umc = new Label();
        umc.setNameOfLabel("UMC");

        Label uir = new Label();
        uir.setNameOfLabel("UIR");

        Label polskieNagrania = new Label();
        polskieNagrania.setNameOfLabel("Polskie Nagrania");

        Label amiga = new Label();
        amiga.setNameOfLabel("Amiga");

        Label polton = new Label();
        polton.setNameOfLabel("Polton");



        LabelDao labelDao = new LabelDao();
        try {
            labelDao.createOrUpdate(pomaton);
            labelDao.createOrUpdate(epic);
            labelDao.createOrUpdate(warnerBros);
            labelDao.createOrUpdate(polydor);
            labelDao.createOrUpdate(umc);
            labelDao.createOrUpdate(uir);
            labelDao.createOrUpdate(polskieNagrania);
            labelDao.createOrUpdate(amiga);
            labelDao.createOrUpdate(polton);

            DbManager.closeConnectionSource();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }


        ReleaseCountry polska = new ReleaseCountry();
        polska.setNameOfCountry("Polska");

        ReleaseCountry usa = new ReleaseCountry();
        usa.setNameOfCountry("USA");

        ReleaseCountry holandia = new ReleaseCountry();
        holandia.setNameOfCountry("Holandia");

        ReleaseCountry francja = new ReleaseCountry();
        francja.setNameOfCountry("Francja");

        ReleaseCountry belgia = new ReleaseCountry();
        belgia.setNameOfCountry("Belgia");

        ReleaseCountry wielkaBrytania = new ReleaseCountry();
        wielkaBrytania.setNameOfCountry("Wielka Brytania");

        ReleaseCountry japonia = new ReleaseCountry();
        japonia.setNameOfCountry("Japonia");

        ReleaseCountry wegry = new ReleaseCountry();
        wegry.setNameOfCountry("Węgry");

        ReleaseCountry wlochy = new ReleaseCountry();
        wlochy.setNameOfCountry("Włochy");

        ReleaseCountry niemcy = new ReleaseCountry();
        niemcy.setNameOfCountry("Niemcy");

        ReleaseCountryDao releaseCountryDao = new ReleaseCountryDao();
        try {
            releaseCountryDao.createOrUpdate(polska);
            releaseCountryDao.createOrUpdate(usa);
            releaseCountryDao.createOrUpdate(holandia);
            releaseCountryDao.createOrUpdate(francja);
            releaseCountryDao.createOrUpdate(belgia);
            releaseCountryDao.createOrUpdate(wielkaBrytania);
            releaseCountryDao.createOrUpdate(japonia);
            releaseCountryDao.createOrUpdate(wegry);
            releaseCountryDao.createOrUpdate(wlochy);
            releaseCountryDao.createOrUpdate(niemcy);

            DbManager.closeConnectionSource();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }


        Author jaskier = new Author();
        jaskier.setNameOfAuthor("Jaskier");

        Author queen = new Author();
        queen.setNameOfAuthor("Queen");

        Author metallica = new Author();
        metallica.setNameOfAuthor("Metallica");

        Author bobMarley = new Author();
        bobMarley.setNameOfAuthor("Bob Marley");

        Author michaelBuble = new Author();
        michaelBuble.setNameOfAuthor("Michael Buble");

        Author ericClapton = new Author();
        ericClapton.setNameOfAuthor("Eric Clapton");

        Author kansas = new Author();
        kansas.setNameOfAuthor("Kansas");

        Author florance = new Author();
        florance.setNameOfAuthor("Florence");

        Author amyWinehouse = new Author();
        amyWinehouse.setNameOfAuthor("Amy Winehouse");

        Author direStraits = new Author();
        direStraits.setNameOfAuthor("Dire Straits");

        Author dawidPodsiadlo = new Author();
        dawidPodsiadlo.setNameOfAuthor("Dawid Podsiadło");

        Author whitneyHouston = new Author();
        whitneyHouston.setNameOfAuthor("Whitney Houston");


        AuthorDao authorDao = new AuthorDao();
        try {
            authorDao.createOrUpdate(jaskier);
            authorDao.createOrUpdate(queen);
            authorDao.createOrUpdate(metallica);
            authorDao.createOrUpdate(bobMarley);
            authorDao.createOrUpdate(michaelBuble);
            authorDao.createOrUpdate(ericClapton);
            authorDao.createOrUpdate(kansas);
            authorDao.createOrUpdate(florance);
            authorDao.createOrUpdate(amyWinehouse);
            authorDao.createOrUpdate(direStraits);
            authorDao.createOrUpdate(dawidPodsiadlo);
            authorDao.createOrUpdate(whitneyHouston);

            DbManager.closeConnectionSource();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }


        Vinyl vinyl1 = new Vinyl();
        vinyl1.setAuthor(dawidPodsiadlo);
        vinyl1.setGenre(indieRock);
        vinyl1.setLabel(polton);
        vinyl1.setReleaseCountry(polska);
        vinyl1.setAvailable(true);
        vinyl1.setBuyDate(new Date());
        vinyl1.setCatalogNumber("KA21231");
        vinyl1.setCondition("VG+");
        vinyl1.setConditionAccessories("-");
        vinyl1.setPrice(99.99);
        vinyl1.setWantTo(true);
        vinyl1.setTitle("Malomiasteczkowy");
        vinyl1.setReleaseDate(2019);
        vinyl1.setSellDate(new Date());
        vinyl1.setSellPrice(0);


        Vinyl vinyl2 = new Vinyl();
        vinyl2.setGenre(pop);
        vinyl2.setLabel(epic);
        vinyl2.setReleaseCountry(usa);
        vinyl2.setAvailable(true);
        vinyl2.setBuyDate(new Date());
        vinyl2.setCatalogNumber("DBA-123K1");
        vinyl2.setCondition("EX");
        vinyl2.setConditionAccessories("-");
        vinyl2.setPrice(50.50);
        vinyl2.setSellDate(new Date());
        vinyl2.setWantTo(true);
        vinyl2.setTitle("Frank");
        vinyl2.setAuthor(whitneyHouston);
        vinyl2.setReleaseDate(2010);
        vinyl2.setSellPrice(0);


        Vinyl vinyl3 = new Vinyl();
        vinyl3.setGenre(reggae);
        vinyl3.setLabel(uir);
        vinyl3.setReleaseCountry(niemcy);
        vinyl3.setAvailable(true);
        vinyl3.setBuyDate(new Date(22 - 11 - 2019));
        vinyl3.setCatalogNumber("CAT-123KDA");
        vinyl3.setCondition("VG");
        vinyl3.setConditionAccessories("-");
        vinyl3.setPrice(45.00);
        vinyl3.setWantTo(true);
        vinyl3.setTitle("Rastaman Wibration");
        vinyl3.setAuthor(bobMarley);
        vinyl3.setReleaseDate(2016);
        vinyl3.setSellDate(null);
        vinyl3.setSellPrice(0);


        Vinyl vinyl4 = new Vinyl();
        vinyl4.setGenre(rock);
        vinyl4.setLabel(umc);
        vinyl4.setReleaseCountry(holandia);
        vinyl4.setAvailable(true);
        vinyl4.setBuyDate(new Date(22 - 11 - 2019));
        vinyl4.setCatalogNumber("EB-KS123D");
        vinyl4.setCondition("VG");
        vinyl4.setConditionAccessories("-");
        vinyl4.setPrice(60.50);
        vinyl4.setWantTo(true);
        vinyl4.setTitle("Brothers in arms");
        vinyl4.setAuthor(direStraits);
        vinyl4.setReleaseDate(1988);
        vinyl4.setSellDate(null);
        vinyl4.setSellPrice(0);

        Vinyl vinyl5 = new Vinyl();
        vinyl5.setGenre(disco);
        vinyl5.setLabel(polskieNagrania);
        vinyl5.setReleaseCountry(polska);
        vinyl5.setAvailable(true);
        vinyl5.setBuyDate(new Date(9 - 4 - 2019));
        vinyl5.setCatalogNumber("KWA-S2312F");
        vinyl5.setCondition("EX");
        vinyl5.setConditionAccessories("-");
        vinyl5.setPrice(66.31);
        vinyl5.setWantTo(true);
        vinyl5.setTitle("O wiedźminie Geralcie");
        vinyl5.setAuthor(jaskier);
        vinyl5.setReleaseDate(2010);
        vinyl5.setSellDate(null);
        vinyl5.setSellPrice(0);


        Vinyl vinyl6 = new Vinyl();
        vinyl6.setGenre(rock);
        vinyl6.setLabel(epic);
        vinyl6.setReleaseCountry(japonia);
        vinyl6.setAvailable(true);
        vinyl6.setBuyDate(new Date(17 - 12 - 2017));
        vinyl6.setCatalogNumber("XFS-1231-DA");
        vinyl6.setCondition("VG+");
        vinyl6.setConditionAccessories("-");
        vinyl6.setPrice(42.31);
        vinyl6.setWantTo(true);
        vinyl6.setTitle("Dust in the wind");
        vinyl6.setAuthor(kansas);
        vinyl6.setReleaseDate(2010);
        vinyl6.setSellDate(null);
        vinyl6.setSellPrice(0);

        Vinyl vinyl7 = new Vinyl();
        vinyl7.setGenre(rock);
        vinyl7.setLabel(warnerBros);
        vinyl7.setReleaseCountry(wegry);
        vinyl7.setAvailable(true);
        vinyl7.setBuyDate(new Date(13 - 5 - 2016));
        vinyl7.setCatalogNumber("POK-0893LD");
        vinyl7.setCondition("VG");
        vinyl7.setConditionAccessories("G");
        vinyl7.setPrice(42.31);
        vinyl7.setWantTo(true);
        vinyl7.setTitle("News of the world");
        vinyl7.setAuthor(queen);
        vinyl7.setReleaseDate(1999);
        vinyl7.setSellDate(null);
        vinyl7.setSellPrice(0);

        Vinyl vinyl8 = new Vinyl();
        vinyl8.setGenre(disco);
        vinyl8.setLabel(pomaton);
        vinyl8.setReleaseCountry(usa);
        vinyl8.setAvailable(true);
        vinyl8.setBuyDate(new Date(22 - 10 - 2019));
        vinyl8.setCatalogNumber("KXI-DD1231");
        vinyl8.setCondition("VG-");
        vinyl8.setConditionAccessories("G");
        vinyl8.setPrice(90.31);
        vinyl8.setWantTo(true);
        vinyl8.setTitle("Once time in year");
        vinyl8.setAuthor(michaelBuble);
        vinyl8.setReleaseDate(2015);
        vinyl8.setSellDate(null);
        vinyl8.setSellPrice(0);


        Vinyl vinyl9 = new Vinyl();
        vinyl9.setGenre(rockPolo);
        vinyl9.setLabel(uir);
        vinyl9.setReleaseCountry(holandia);
        vinyl9.setAvailable(true);
        vinyl9.setBuyDate(new Date(12 - 7 - 2014));
        vinyl9.setCatalogNumber("IDS-0909831");
        vinyl9.setCondition("G");
        vinyl9.setConditionAccessories("-");
        vinyl9.setPrice(67.99);
        vinyl9.setWantTo(true);
        vinyl9.setTitle("Dance with me");
        vinyl9.setAuthor(florance);
        vinyl9.setReleaseDate(2019);
        vinyl9.setSellDate(null);
        vinyl9.setSellPrice(0);


        Vinyl vinyl10 = new Vinyl();
        vinyl10.setGenre(indieRock);
        vinyl10.setLabel(polskieNagrania);
        vinyl10.setReleaseCountry(polska);
        vinyl10.setAvailable(true);
        vinyl10.setBuyDate(new Date(10 - 3 - 2019));
        vinyl10.setCatalogNumber("DWI-1231KD");
        vinyl10.setCondition("VG");
        vinyl10.setConditionAccessories("G");
        vinyl10.setPrice(67.76);
        vinyl10.setWantTo(true);
        vinyl10.setTitle("Kill them all");
        vinyl10.setAuthor(metallica);
        vinyl10.setSellPrice(76.12);
        vinyl10.setReleaseDate(1989);
        vinyl10.setSellDate(null);


        Vinyl vinyl11 = new Vinyl();
        vinyl11.setGenre(blues);
        vinyl11.setLabel(polydor);
        vinyl11.setReleaseCountry(japonia);
        vinyl11.setAvailable(true);
        vinyl11.setBuyDate(new Date(10 - 1 - 2019));
        vinyl11.setCatalogNumber("POR-1029FS");
        vinyl11.setCondition("G-");
        vinyl11.setConditionAccessories("-");
        vinyl11.setPrice(86.99);
        vinyl11.setWantTo(true);
        vinyl11.setTitle("Police need us");
        vinyl11.setAuthor(ericClapton);
        vinyl11.setReleaseDate(2010);
        vinyl11.setSellDate(null);
        vinyl11.setSellPrice(0);


        Vinyl vinyl12 = new Vinyl();
        vinyl12.setGenre(reggae);
        vinyl12.setLabel(uir);
        vinyl12.setReleaseCountry(usa);
        vinyl12.setAvailable(true);
        vinyl12.setBuyDate(new Date(29 - 12 - 2019));
        vinyl12.setCatalogNumber("ODW-1231JD");
        vinyl12.setCondition("VG");
        vinyl12.setConditionAccessories("G");
        vinyl12.setPrice(12.31);
        vinyl12.setWantTo(true);
        vinyl12.setTitle("Smooke");
        vinyl12.setAuthor(bobMarley);
        vinyl12.setReleaseDate(2010);
        vinyl12.setSellDate(null);
        vinyl12.setSellPrice(0);


        Vinyl vinyl13 = new Vinyl();
        vinyl13.setGenre(hardRock);
        vinyl13.setLabel(polskieNagrania);
        vinyl13.setReleaseCountry(polska);
        vinyl13.setAvailable(true);
        vinyl13.setBuyDate(new Date(24 - 2 - 2019));
        vinyl13.setCatalogNumber("OKS-2131");
        vinyl13.setCondition("VG");
        vinyl13.setConditionAccessories("G");
        vinyl13.setPrice(98.23);
        vinyl13.setWantTo(true);
        vinyl13.setTitle("Kill don't ask");
        vinyl13.setAuthor(direStraits);
        vinyl13.setReleaseDate(1978);
        vinyl13.setSellDate(null);
        vinyl13.setSellPrice(0);


        VinylDao vinylDao = new VinylDao();


        try {
            vinylDao.createOrUpdate(vinyl1);
            vinylDao.createOrUpdate(vinyl2);
            vinylDao.createOrUpdate(vinyl3);
            vinylDao.createOrUpdate(vinyl4);
            vinylDao.createOrUpdate(vinyl5);
            vinylDao.createOrUpdate(vinyl6);
            vinylDao.createOrUpdate(vinyl7);
            vinylDao.createOrUpdate(vinyl8);
            vinylDao.createOrUpdate(vinyl9);
            vinylDao.createOrUpdate(vinyl10);
            vinylDao.createOrUpdate(vinyl11);
            vinylDao.createOrUpdate(vinyl12);
            vinylDao.createOrUpdate(vinyl13);
//

            DbManager.closeConnectionSource();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
        DbManager.closeConnectionSource();

    }


}
