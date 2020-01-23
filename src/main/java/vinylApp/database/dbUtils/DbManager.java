package vinylApp.database.dbUtils;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import vinylApp.database.models.*;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);

    //public static ArrayList<String> logins;
    //public static ArrayList<String> passwords;

    private static String user;
    private static String pass;


    //--------------default name for database when app run we can change it -------------------------------------

    private static String databaseName = "vinyl";
    private static String JDBC_DRIVER_HD = "jdbc:h2:./src/main/resources/databases/".concat(getDatabaseName()).concat("DB");

    private static ConnectionSource connectionSource;

    public static void initDatabase() {
        createConnectionSource();
        //dropTable();
        createTable();
        closeConnectionSource();
    }


    public static void initDatabaseForNewAccount() {
        createConnectionSource();
        dropTable();
        createTable();
        closeConnectionSource();
    }

    private static void createConnectionSource() {
        try {
//-------------i need to refresh new name for database---------------------------------------------------------
            JDBC_DRIVER_HD = "jdbc:h2:./src/main/resources/databases/".concat(getDatabaseName()).concat("DB");
            connectionSource = new JdbcConnectionSource(JDBC_DRIVER_HD, user, pass);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static void dropTable() {

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

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Database for users

    private static String JDBC_USERS_DRIVER_HD = "jdbc:h2:./src/main/resources/databases/usersDB";
    private static String adminUser = "admin";
    private static String adminPass = "admin";


    private static void createConnectionSourceForUser() {
        try {
            connectionSource = new JdbcConnectionSource(JDBC_USERS_DRIVER_HD, adminUser, adminPass);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private static void createUserTable() {
        try {
            TableUtils.createTableIfNotExists(connectionSource, User.class);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private static void dropUserTable() {

        try {
            TableUtils.dropTable(connectionSource, User.class, true);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }


    public static void initDatabaseUser() {
        createConnectionSourceForUser();
        //dropUserTable();
        createUserTable();
        closeConnectionSource();
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
