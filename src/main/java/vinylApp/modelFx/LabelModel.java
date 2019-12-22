package vinylApp.modelFx;

import vinylApp.database.dao.LabelDao;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.database.models.Label;

public class LabelModel {


    public void saveLabelInDataBase(String name) {
        LabelDao labelDao = new LabelDao(DbManager.getConnectionSource());
        Label label = new Label();
        label.setNameOfLabel(name);
        labelDao.createOrUpdate(label);
        DbManager.closeConnectionSource();

    }


}
