package vinylApp.database.dao;

import com.j256.ormlite.support.ConnectionSource;

public class VinylDao extends CommonDao{
    protected VinylDao(ConnectionSource connectionSource) {
        super(connectionSource);
    }
}
