package vinylApp.database.dbUtils.converters;

import vinylApp.database.models.Genre;
import vinylApp.database.models.User;
import vinylApp.modelFx.GenreFx;
import vinylApp.modelFx.UserFx;

public class ConverterUser {

    public static UserFx convertToUserFx (User user){
        UserFx userFx = new UserFx();
        userFx.setId(user.getId());
        userFx.setLogin(user.getLogin());
        userFx.setPassword(user.getPassword());

        return userFx;
    }

}


