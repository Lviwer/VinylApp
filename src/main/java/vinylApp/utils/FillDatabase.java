package vinylApp.utils;

import vinylApp.database.dao.*;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.database.models.*;
import vinylApp.utils.exceptions.ApplicationException;
import java.util.Calendar;
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

        Label poljazz = new Label();
        poljazz.setNameOfLabel("Poljazz");

        Label kayax = new Label();
        kayax.setNameOfLabel("Kayax");

        Label pronit = new Label();
        pronit.setNameOfLabel("Pronit");

        Label tonpress = new Label();
        tonpress.setNameOfLabel("TonPress");

        Label phonogram = new Label();
        phonogram.setNameOfLabel("Phonogram");


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
            labelDao.createOrUpdate(poljazz);
            labelDao.createOrUpdate(kayax);
            labelDao.createOrUpdate(pronit);
            labelDao.createOrUpdate(tonpress);
            labelDao.createOrUpdate(phonogram);



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

        Author dukeEllington = new Author();
        dukeEllington.setNameOfAuthor("Duke Ellington");

        Author monikaBrodka = new Author();
        monikaBrodka.setNameOfAuthor("Monika Brodka");

        Author gilbertBecaud = new Author();
        gilbertBecaud.setNameOfAuthor("Gilbert Becaud");

        Author edytaGeppert = new Author();
        edytaGeppert.setNameOfAuthor("Edyta Geppert");

        Author peterGreen = new Author();
        peterGreen.setNameOfAuthor("Peter Green");

        Author bryllAndTrzcinski = new Author();
        bryllAndTrzcinski.setNameOfAuthor("Ernest Bryll Wojciech Trzciński");

        Author boneyM = new Author();
        boneyM.setNameOfAuthor("Boney M");

        Author maxCollie = new Author();
        maxCollie.setNameOfAuthor("Max Collie");

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
            authorDao.createOrUpdate(dukeEllington);
            authorDao.createOrUpdate(monikaBrodka);
            authorDao.createOrUpdate(gilbertBecaud);
            authorDao.createOrUpdate(edytaGeppert);
            authorDao.createOrUpdate(peterGreen);
            authorDao.createOrUpdate(bryllAndTrzcinski);
            authorDao.createOrUpdate(boneyM);

            DbManager.closeConnectionSource();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }


        Vinyl vinyl1 = new Vinyl();
        vinyl1.setAuthor(dawidPodsiadlo);
        vinyl1.setGenre(indieRock);
        vinyl1.setLabel(polton);
        vinyl1.setReleaseCountry(polska);
        vinyl1.setAvailable(false);
        vinyl1.setBuyDate(new GregorianCalendar(2019, Calendar.DECEMBER,4).getTime());      vinyl1.setCatalogNumber("KA21231");
        vinyl1.setCondition("VG+");
        vinyl1.setConditionAccessories("-");
        vinyl1.setPrice(99.99);
        vinyl1.setWantTo(true);
        vinyl1.setTitle("Malomiasteczkowy");
        vinyl1.setReleaseDate(2019);
        vinyl1.setSellDate(new GregorianCalendar(2020, Calendar.JANUARY,6).getTime());
        vinyl1.setSellPrice(120.00);


        Vinyl vinyl2 = new Vinyl();
        vinyl2.setGenre(pop);
        vinyl2.setLabel(epic);
        vinyl2.setReleaseCountry(usa);
        vinyl2.setAvailable(false);
        vinyl2.setBuyDate(new GregorianCalendar(2017, Calendar.MAY,11).getTime());
        vinyl2.setCatalogNumber("DBA-123K1");
        vinyl2.setCondition("EX");
        vinyl2.setConditionAccessories("-");
        vinyl2.setPrice(50.50);
        vinyl2.setSellDate(new GregorianCalendar(2020, Calendar.JANUARY,6).getTime());
        vinyl2.setWantTo(true);
        vinyl2.setTitle("Frank");
        vinyl2.setAuthor(whitneyHouston);
        vinyl2.setReleaseDate(2010);
        vinyl2.setSellPrice(70.00);


        Vinyl vinyl3 = new Vinyl();
        vinyl3.setGenre(reggae);
        vinyl3.setLabel(uir);
        vinyl3.setReleaseCountry(niemcy);
        vinyl3.setAvailable(false);
        vinyl3.setBuyDate(new GregorianCalendar(2016, Calendar.APRIL,29).getTime());
        vinyl3.setCatalogNumber("CAT-123KDA");
        vinyl3.setCondition("VG");
        vinyl3.setConditionAccessories("-");
        vinyl3.setPrice(45.00);
        vinyl3.setWantTo(true);
        vinyl3.setTitle("Rastaman Wibration");
        vinyl3.setAuthor(bobMarley);
        vinyl3.setReleaseDate(2016);
        vinyl3.setSellDate(new GregorianCalendar(2020, Calendar.JANUARY,3).getTime());
        vinyl3.setSellPrice(55.00);


        Vinyl vinyl4 = new Vinyl();
        vinyl4.setGenre(rock);
        vinyl4.setLabel(umc);
        vinyl4.setReleaseCountry(holandia);
        vinyl4.setAvailable(false);
        vinyl4.setBuyDate(new GregorianCalendar(2018, Calendar.FEBRUARY,30).getTime());
        vinyl4.setCatalogNumber("EB-KS123D");
        vinyl4.setCondition("VG");
        vinyl4.setConditionAccessories("-");
        vinyl4.setPrice(60.50);
        vinyl4.setWantTo(true);
        vinyl4.setTitle("Brothers in arms");
        vinyl4.setAuthor(direStraits);
        vinyl4.setReleaseDate(1988);
        vinyl4.setSellDate(new GregorianCalendar(2020, Calendar.JANUARY,6).getTime());
        vinyl4.setSellPrice(75.00);

        Vinyl vinyl5 = new Vinyl();
        vinyl5.setGenre(disco);
        vinyl5.setLabel(polskieNagrania);
        vinyl5.setReleaseCountry(polska);
        vinyl5.setAvailable(false);
        vinyl5.setBuyDate(new GregorianCalendar(2019, Calendar.JANUARY,5).getTime());
        vinyl5.setCatalogNumber("KWA-S2312F");
        vinyl5.setCondition("EX");
        vinyl5.setConditionAccessories("-");
        vinyl5.setPrice(66.31);
        vinyl5.setWantTo(true);
        vinyl5.setTitle("O wiedźminie Geralcie");
        vinyl5.setAuthor(jaskier);
        vinyl5.setReleaseDate(2010);
        vinyl5.setSellDate(new GregorianCalendar(2018, Calendar.AUGUST,27).getTime());
        vinyl5.setSellPrice(70.21);


        Vinyl vinyl6 = new Vinyl();
        vinyl6.setGenre(rock);
        vinyl6.setLabel(epic);
        vinyl6.setReleaseCountry(japonia);
        vinyl6.setAvailable(true);
        vinyl6.setBuyDate(new GregorianCalendar(2020, Calendar.JANUARY,3).getTime());
        vinyl6.setCatalogNumber("XFS-1231-DA");
        vinyl6.setCondition("VG+");
        vinyl6.setConditionAccessories("-");
        vinyl6.setPrice(42.31);
        vinyl6.setWantTo(true);
        vinyl6.setTitle("Dust in the wind");
        vinyl6.setAuthor(kansas);
        vinyl6.setReleaseDate(2010);


        Vinyl vinyl7 = new Vinyl();
        vinyl7.setGenre(rock);
        vinyl7.setLabel(warnerBros);
        vinyl7.setReleaseCountry(wegry);
        vinyl7.setAvailable(true);
        vinyl7.setBuyDate(new GregorianCalendar(2020, Calendar.JANUARY,3).getTime());
        vinyl7.setCatalogNumber("POK-0893LD");
        vinyl7.setCondition("VG");
        vinyl7.setConditionAccessories("G");
        vinyl7.setPrice(42.31);
        vinyl7.setWantTo(true);
        vinyl7.setTitle("News of the world");
        vinyl7.setAuthor(queen);
        vinyl7.setReleaseDate(1999);


        Vinyl vinyl8 = new Vinyl();
        vinyl8.setGenre(disco);
        vinyl8.setLabel(pomaton);
        vinyl8.setReleaseCountry(usa);
        vinyl8.setAvailable(true);
        vinyl8.setBuyDate(new GregorianCalendar(2020, Calendar.JANUARY,5).getTime());
        vinyl8.setCatalogNumber("KXI-DD1231");
        vinyl8.setCondition("VG-");
        vinyl8.setConditionAccessories("G");
        vinyl8.setPrice(90.31);
        vinyl8.setWantTo(true);
        vinyl8.setTitle("Once time in year");
        vinyl8.setAuthor(michaelBuble);
        vinyl8.setReleaseDate(2015);



        Vinyl vinyl9 = new Vinyl();
        vinyl9.setGenre(rockPolo);
        vinyl9.setLabel(uir);
        vinyl9.setReleaseCountry(holandia);
        vinyl9.setAvailable(false);
        vinyl9.setBuyDate(new GregorianCalendar(2019, Calendar.FEBRUARY,9).getTime());
        vinyl9.setCatalogNumber("IDS-0909831");
        vinyl9.setCondition("G");
        vinyl9.setConditionAccessories("-");
        vinyl9.setPrice(67.99);
        vinyl9.setWantTo(true);
        vinyl9.setTitle("Dance with me");
        vinyl9.setAuthor(florance);
        vinyl9.setReleaseDate(2019);
        vinyl9.setSellDate(new GregorianCalendar(2019, Calendar.MAY,5).getTime());
        vinyl9.setSellPrice(89.00);


        Vinyl vinyl10 = new Vinyl();
        vinyl10.setGenre(indieRock);
        vinyl10.setLabel(polskieNagrania);
        vinyl10.setReleaseCountry(polska);
        vinyl10.setAvailable(false);
        vinyl10.setBuyDate(new GregorianCalendar(2018, Calendar.SEPTEMBER,19).getTime());
        vinyl10.setCatalogNumber("DWI-1231KD");
        vinyl10.setCondition("VG");
        vinyl10.setConditionAccessories("G");
        vinyl10.setPrice(67.76);
        vinyl10.setWantTo(true);
        vinyl10.setTitle("Kill them all");
        vinyl10.setAuthor(metallica);
        vinyl10.setSellPrice(76.12);
        vinyl10.setReleaseDate(1989);
        vinyl10.setSellDate(new GregorianCalendar(2020, Calendar.JANUARY,2).getTime());


        Vinyl vinyl11 = new Vinyl();
        vinyl11.setGenre(blues);
        vinyl11.setLabel(polydor);
        vinyl11.setReleaseCountry(japonia);
        vinyl11.setAvailable(false);
        vinyl11.setBuyDate(new GregorianCalendar(2017, Calendar.FEBRUARY,25).getTime());
        vinyl11.setCatalogNumber("POR-1029FS");
        vinyl11.setCondition("G-");
        vinyl11.setConditionAccessories("-");
        vinyl11.setPrice(86.99);
        vinyl11.setWantTo(true);
        vinyl11.setTitle("Police need us");
        vinyl11.setAuthor(ericClapton);
        vinyl11.setReleaseDate(2010);
        vinyl11.setSellDate(new GregorianCalendar(2020, Calendar.JANUARY,3).getTime());
        vinyl11.setSellPrice(90.99);


        Vinyl vinyl12 = new Vinyl();
        vinyl12.setGenre(reggae);
        vinyl12.setLabel(uir);
        vinyl12.setReleaseCountry(usa);
        vinyl12.setAvailable(false);
        vinyl12.setBuyDate(new GregorianCalendar(2020, Calendar.JANUARY,3).getTime());
        vinyl12.setCatalogNumber("ODW-1231JD");
        vinyl12.setCondition("VG");
        vinyl12.setConditionAccessories("G");
        vinyl12.setPrice(12.31);
        vinyl12.setWantTo(true);
        vinyl12.setTitle("Smooke");
        vinyl12.setAuthor(bobMarley);
        vinyl12.setReleaseDate(2010);
        vinyl12.setSellDate(new GregorianCalendar(2018, Calendar.SEPTEMBER,3).getTime());
        vinyl12.setSellPrice(15.00);


        Vinyl vinyl13 = new Vinyl();
        vinyl13.setGenre(hardRock);
        vinyl13.setLabel(polskieNagrania);
        vinyl13.setReleaseCountry(polska);
        vinyl13.setAvailable(false);
        vinyl13.setBuyDate(new GregorianCalendar(2018, Calendar.OCTOBER,17).getTime());
        vinyl13.setCatalogNumber("OKS-2131");
        vinyl13.setCondition("VG");
        vinyl13.setConditionAccessories("G");
        vinyl13.setPrice(98.23);
        vinyl13.setWantTo(true);
        vinyl13.setTitle("Kill don't ask");
        vinyl13.setAuthor(direStraits);
        vinyl13.setReleaseDate(1978);
        vinyl13.setSellDate(new GregorianCalendar(2019, Calendar.FEBRUARY,11).getTime());
        vinyl13.setSellPrice(98.20);

//goodOne

        Vinyl vinyl14 = new Vinyl();
        vinyl14.setGenre(jazz);
        vinyl14.setLabel(poljazz);
        vinyl14.setReleaseCountry(polska);
        vinyl14.setAvailable(true);
        vinyl14.setBuyDate(new GregorianCalendar(2019, Calendar.SEPTEMBER,12).getTime());
        vinyl14.setCatalogNumber("ZSK 673");
        vinyl14.setCondition("VG+");
        vinyl14.setConditionAccessories("-");
        vinyl14.setPrice(12.50);
        vinyl14.setWantTo(true);
        vinyl14.setTitle("Klub płytowy PSJ");
        vinyl14.setAuthor(dukeEllington);
        vinyl14.setReleaseDate(1978);
        //vinyl14.setSellDate(null);
        //vinyl14.setSellPrice(0);

        Vinyl vinyl15 = new Vinyl();
        vinyl15.setGenre(pop);
        vinyl15.setLabel(kayax);
        vinyl15.setReleaseCountry(polska);
        vinyl15.setAvailable(true);
        vinyl15.setBuyDate(new GregorianCalendar(2019, Calendar.JUNE,19).getTime());
        vinyl15.setCatalogNumber("5 414940 017977");
        vinyl15.setCondition("EX EX");
        vinyl15.setConditionAccessories("-");
        vinyl15.setPrice(29.99);
        vinyl15.setWantTo(true);
        vinyl15.setTitle("Unplugged");
        vinyl15.setAuthor(monikaBrodka);
        vinyl15.setReleaseDate(2019);
        //vinyl14.setSellDate(null);
        //vinyl14.setSellPrice(0);

        Vinyl vinyl16 = new Vinyl();
        vinyl16.setGenre(klasyczna);
        vinyl16.setLabel(amiga);
        vinyl16.setReleaseCountry(niemcy);
        vinyl16.setAvailable(true);
        vinyl16.setBuyDate(new GregorianCalendar(2018, Calendar.FEBRUARY,1).getTime());
        vinyl16.setCatalogNumber("SHZE 203");
        vinyl16.setCondition("VG+");
        vinyl16.setConditionAccessories("-");
        vinyl16.setPrice(10.99);
        vinyl16.setWantTo(true);
        vinyl16.setTitle("Live International");
        vinyl16.setAuthor(gilbertBecaud);
        vinyl16.setReleaseDate(1988);
        //vinyl14.setSellDate(null);
        //vinyl14.setSellPrice(0);


        Vinyl vinyl17 = new Vinyl();
        vinyl17.setGenre(klasyczna);
        vinyl17.setLabel(pronit);
        vinyl17.setReleaseCountry(polska);
        vinyl17.setAvailable(true);
        vinyl17.setBuyDate(new GregorianCalendar(2018, Calendar.APRIL,22).getTime());
        vinyl17.setCatalogNumber("PLP 0035");
        vinyl17.setCondition("VG+");
        vinyl17.setConditionAccessories("-");
        vinyl17.setPrice(8.99);
        vinyl17.setWantTo(true);
        vinyl17.setTitle("Recital Live");
        vinyl17.setAuthor(edytaGeppert);
        vinyl17.setReleaseDate(1985);
        //vinyl14.setSellDate(null);
        //vinyl14.setSellPrice(0);


        Vinyl vinyl18 = new Vinyl();
        vinyl18.setGenre(jazz);
        vinyl18.setLabel(pronit);
        vinyl18.setReleaseCountry(polska);
        vinyl18.setAvailable(true);
        vinyl18.setBuyDate(new GregorianCalendar(2019, Calendar.APRIL,9).getTime());
        vinyl18.setCatalogNumber("ALP-006");
        vinyl18.setCondition("VG+");
        vinyl18.setConditionAccessories("-");
        vinyl18.setPrice(14.99);
        vinyl18.setWantTo(true);
        vinyl18.setTitle(" Edyta Geppert - Och Życie...");
        vinyl18.setAuthor(edytaGeppert);
        vinyl18.setReleaseDate(1986);
        //vinyl14.setSellDate(null);
        //vinyl14.setSellPrice(0);


        Vinyl vinyl19 = new Vinyl();
        vinyl19.setGenre(blues);
        vinyl19.setLabel(tonpress);
        vinyl19.setReleaseCountry(polska);
        vinyl19.setAvailable(true);
        vinyl19.setBuyDate(new GregorianCalendar(2019, Calendar.SEPTEMBER,1).getTime());
        vinyl19.setCatalogNumber("SX-T39");
        vinyl19.setCondition("VG+");
        vinyl19.setConditionAccessories("-");
        vinyl19.setPrice(4.99);
        vinyl19.setWantTo(true);
        vinyl19.setTitle("Portrait");
        vinyl19.setAuthor(peterGreen);
        vinyl19.setReleaseDate(1985);
        //vinyl14.setSellDate(null);
        //vinyl14.setSellPrice(0);


        Vinyl vinyl20 = new Vinyl();
        vinyl20.setGenre(rock);
        vinyl20.setLabel(phonogram);
        vinyl20.setReleaseCountry(niemcy);
        vinyl20.setAvailable(true);
        vinyl20.setBuyDate(new GregorianCalendar(2019, Calendar.SEPTEMBER,1).getTime());
        vinyl20.setCatalogNumber("6360 162");
        vinyl20.setCondition("VG+");
        vinyl20.setConditionAccessories("-");
        vinyl20.setPrice(15.99);
        vinyl20.setWantTo(true);
        vinyl20.setTitle("Dire Straits");
        vinyl20.setAuthor(direStraits);
        vinyl20.setReleaseDate(1978);
        //vinyl14.setSellDate(null);
        //vinyl14.setSellPrice(0);


        Vinyl vinyl21 = new Vinyl();
        vinyl21.setGenre(rock);
        vinyl21.setLabel(pronit);
        vinyl21.setReleaseCountry(polska);
        vinyl21.setAvailable(true);
        vinyl21.setBuyDate(new GregorianCalendar(2018, Calendar.OCTOBER,10).getTime());
        vinyl21.setCatalogNumber("SLP 4017");
        vinyl21.setCondition("VG+");
        vinyl21.setConditionAccessories("-");
        vinyl21.setPrice(9.99);
        vinyl21.setWantTo(true);
        vinyl21.setTitle("Kolęda Nocka");
        vinyl21.setAuthor(bryllAndTrzcinski);
        vinyl21.setReleaseDate(1980);
        //vinyl14.setSellDate(null);
        //vinyl14.setSellPrice(0);

        Vinyl vinyl22 = new Vinyl();
        vinyl22.setGenre(disco);
        vinyl22.setLabel(polydor);
        vinyl22.setReleaseCountry(wegry);
        vinyl22.setAvailable(true);
        vinyl22.setBuyDate(new GregorianCalendar(2018, Calendar.MAY,25).getTime());
        vinyl22.setCatalogNumber("K 50498");
        vinyl22.setCondition("VG+");
        vinyl22.setConditionAccessories("-");
        vinyl22.setPrice(4.99);
        vinyl22.setWantTo(true);
        vinyl22.setTitle("Night Flight to Venus");
        vinyl22.setAuthor(boneyM);
        vinyl22.setReleaseDate(1980);
        //vinyl14.setSellDate(null);
        //vinyl14.setSellPrice(0);

        Vinyl vinyl23 = new Vinyl();
        vinyl23.setGenre(jazz);
        vinyl23.setLabel(epic);
        vinyl23.setReleaseCountry(wielkaBrytania);
        vinyl23.setAvailable(true);
        vinyl23.setBuyDate(new GregorianCalendar(2019, Calendar.MAY,1).getTime());
        vinyl23.setCatalogNumber("LC 1415");
        vinyl23.setCondition("G+");
        vinyl23.setConditionAccessories("-");
        vinyl23.setPrice(8.99);
        vinyl23.setWantTo(true);
        vinyl23.setTitle("Max Collie & the rhythm aces 'Second'");
        vinyl23.setAuthor(maxCollie);
        vinyl23.setReleaseDate(1972);
        //vinyl14.setSellDate(null);
        //vinyl14.setSellPrice(0);



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
            vinylDao.createOrUpdate(vinyl14);
            vinylDao.createOrUpdate(vinyl15);
            vinylDao.createOrUpdate(vinyl16);
            vinylDao.createOrUpdate(vinyl17);
            vinylDao.createOrUpdate(vinyl18);
            vinylDao.createOrUpdate(vinyl19);
            vinylDao.createOrUpdate(vinyl20);
            vinylDao.createOrUpdate(vinyl21);
            vinylDao.createOrUpdate(vinyl22);
            vinylDao.createOrUpdate(vinyl23);
//

            DbManager.closeConnectionSource();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
        DbManager.closeConnectionSource();

    }


}
