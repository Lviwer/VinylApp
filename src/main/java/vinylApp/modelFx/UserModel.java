package vinylApp.modelFx;

import vinylApp.database.dao.*;
import vinylApp.database.dbUtils.converters.ConverterUser;
import vinylApp.database.models.*;
import vinylApp.utils.exceptions.ApplicationException;

import java.util.ArrayList;
import java.util.List;

public class UserModel {

    private List<UserFx> usersList = new ArrayList<>();
    private List<String> loginList = new ArrayList<>();
    private List<String> passwordList = new ArrayList<>();


    public void init() throws ApplicationException {

        UserDao userDao = new UserDao();
        List<User> users = userDao.queryForAll(User.class);
        initUserList(users);
        initLoginsList(usersList);
        initPasswordsList(usersList);
    }

    private void initUserList(List<User> users) {

        this.usersList.clear();
        users.forEach(c -> {
            UserFx userFx = ConverterUser.convertToUserFx(c);
            this.usersList.add(userFx);
        });
    }

    public void saveUserInDataBase(String login, String password) throws ApplicationException {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        userDao.createOrUpdate(user);
        init();
    }

    public void updateUserInDataBase(String login, String newLogin) throws ApplicationException {

        UserDao userDao = new UserDao();
        User tempUser = userDao.findById(User.class, loginList.indexOf(login));
        tempUser.setLogin(newLogin);
        userDao.createOrUpdate(tempUser);
        init();
    }


    private void initLoginsList(List<UserFx> usersList) {
        this.loginList.clear();
        usersList.forEach(c -> {
            this.loginList.add(c.getLogin());
        });
    }

    private void initPasswordsList(List<UserFx> usersList) {
        this.passwordList.clear();
        usersList.forEach(c -> {
            this.passwordList.add(c.getPassword());
        });
    }


    public List<UserFx> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<UserFx> usersList) {
        this.usersList = usersList;
    }

    public List<String> getLoginList() {
        return loginList;
    }

    public void setLoginList(List<String> loginList) {
        this.loginList = loginList;
    }

    public List<String> getPasswordList() {
        return passwordList;
    }

    public void setPasswordList(List<String> passwordList) {
        this.passwordList = passwordList;
    }
}


