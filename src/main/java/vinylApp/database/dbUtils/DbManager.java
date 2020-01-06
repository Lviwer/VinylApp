package vinylApp.database.dbUtils;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.h2.engine.Database;
import vinylApp.controllers.LoginWindowController;
import vinylApp.database.models.*;
import vinylApp.utils.SaveReadFile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class DbManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);


    public static ArrayList<String> logins;
    public static ArrayList<String> passwords;

    public static int loginAndPassIndex;
    private static String user;
    private static String pass;

    //--------------default name for database when app run can change it -------------------------------------
    private static String databaseName = "vinyl";
    private static String JDBC_DRIVER_HD = "jdbc:h2:./databases/".concat(getDatabaseName()).concat("DB");


    private static ConnectionSource connectionSource;

    public static void initDatabase() {
        createConnectionSource();
        dropTable();
        createTable();
        closeConnectionSource();
    }

    private static void createConnectionSource() {
        try {
//-------------i need to refresh new name for database---------------------------------------------------------
            JDBC_DRIVER_HD = "jdbc:h2:./databases/".concat(getDatabaseName()).concat("DB");
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

//---------------methods responsible for validate log/pass and databases------------------

    public static void readAllLoginsAndPasswordsFromTxt() throws IOException {
        logins = SaveReadFile.readAllFromFile(SaveReadFile.LOG_FILE_PATH);
        passwords = SaveReadFile.readAllFromFile(SaveReadFile.PASS_FILE_PATH);
    }

    public static void setLogAndPassIndex(int logIndex) {
        loginAndPassIndex = logIndex;
    }

    public static void setLoginPassDatabase() {
        user = logins.get(loginAndPassIndex);
        pass = passwords.get(loginAndPassIndex);
        setDatabaseName(user.concat(pass));
    }

    public static void setPass(String pass) {
        DbManager.pass = pass;
    }

    public static String getDatabaseName() {
        return databaseName;
    }

    public static void setDatabaseName(String databaseName) {
        DbManager.databaseName = databaseName;
    }

    public static String getUser() {
        return user;
    }
}
