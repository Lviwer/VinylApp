package vinylApp.modelFx;

import vinylApp.database.dao.ReleaseCountryDao;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.database.models.ReleaseCountry;

public class ReleaseCountryModel {


    public void saveCountryInDataBase(String name)
    {
        ReleaseCountryDao releaseCountryDao = new ReleaseCountryDao(DbManager.getConnectionSource());
        ReleaseCountry releaseCountry = new ReleaseCountry();
        releaseCountry.setNameOfCountry(name);
        releaseCountryDao.createOrUpdate(releaseCountry);
        DbManager.closeConnectionSource();
    }



}
