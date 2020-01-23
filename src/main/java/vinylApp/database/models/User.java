package vinylApp.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "USERS")
public class User implements BaseModel {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "LOGIN", canBeNull = false, unique = true)
    private String login;

    @DatabaseField(columnName = "PASSWORD", canBeNull = false)
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
