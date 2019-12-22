package vinylApp.database.dbUtils;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import javafx.scene.control.Tab;
import vinylApp.database.models.Genre;
import vinylApp.database.models.Label;
import vinylApp.database.models.ReleaseCountry;
import vinylApp.database.models.Vinyl;

import java.io.IOException;
import java.sql.SQLException;

public class DbManager {


    private static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);

    private static final String JDBC_DRIVER_HD = "jdbc:h2:/vinylDB";
    private static final String USER = "admin";
    private static final String PASS = "admin";

    private static ConnectionSource connectionSource;


    public static void initDatabase() {
        createConnectionSource();
        dropTable();
        createTable();
        closeConnectionSource();
    }


    private static void createConnectionSource() {
        try {
            connectionSource = new JdbcConnectionSource(JDBC_DRIVER_HD, USER, PASS);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private static void dropTable() {

        try {
            TableUtils.dropTable(connectionSource, Genre.class, true);
            TableUtils.dropTable(connectionSource, Label.class, true);
            TableUtils.dropTable(connectionSource, ReleaseCountry.class, true);
            TableUtils.dropTable(connectionSource, Vinyl.class, true);

        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private static void createTable() {

        try {
            TableUtils.createTableIfNotExists(connectionSource, Genre.class);
            TableUtils.createTableIfNotExists(connectionSource, Label.class);
            TableUtils.createTableIfNotExists(connectionSource, ReleaseCountry.class);
            TableUtils.createTableIfNotExists(connectionSource, Vinyl.class);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private static void closeConnectionSource() {
        if (connectionSource != null) {
            try {
                connectionSource.close();
            } catch (IOException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }


}
