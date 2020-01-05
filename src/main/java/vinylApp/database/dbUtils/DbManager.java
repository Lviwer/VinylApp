package vinylApp.database.dbUtils;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import javafx.scene.control.Tab;
import vinylApp.database.models.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DbManager {



    private static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);

    public static List<String> logins;


    private static String user = "admin";
    private static String pass = "admin";
    private static final String JDBC_DRIVER_HD = "jdbc:h2:./databases/vinylDB";
    //private static final String JDBC_DRIVER_HD = "jdbc:h2:./databases/".concat(user).concat("DB");


    private static ConnectionSource connectionSource;


    public static void initDatabase() {
        createConnectionSource();
        dropTable();
        createTable();
        closeConnectionSource();
    }


    private static void createConnectionSource() {
        try {
            connectionSource = new JdbcConnectionSource(JDBC_DRIVER_HD, user, pass);
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
            TableUtils.dropTable(connectionSource, Author.class, true);
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
            TableUtils.createTableIfNotExists(connectionSource, Author.class);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static void closeConnectionSource() {
        if (connectionSource != null) {
            try {
                connectionSource.close();
            } catch (IOException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    public static ConnectionSource getConnectionSource() {
        if (connectionSource == null) {
            createConnectionSource();
        }
        return connectionSource;
    }

    public static void setUser(String user) {
        DbManager.user = user;
    }

    public static void setPass(String pass) {
        DbManager.pass = pass;
    }
}
