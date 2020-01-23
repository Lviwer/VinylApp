package vinylApp.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import vinylApp.database.models.Vinyl;
import vinylApp.utils.exceptions.ApplicationException;

import java.sql.SQLException;

public class VinylDao extends CommonDao{
    public VinylDao() {
        super();
    }

    public void deleteByColumnName(String columnName, int id) throws ApplicationException, SQLException {
        Dao<Vinyl, Object> dao = getDao(Vinyl.class);
        DeleteBuilder<Vinyl, Object> deleteBuilder = dao.deleteBuilder();
        deleteBuilder.where().eq(columnName, id);
        dao.delete(deleteBuilder.prepare());
    }


}
