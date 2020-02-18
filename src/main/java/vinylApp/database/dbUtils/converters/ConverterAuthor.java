package vinylApp.database.dbUtils.converters;

import vinylApp.database.models.Author;
import vinylApp.modelFx.AuthorFx;


public class ConverterAuthor {

    public static AuthorFx convertToAuthorFx(Author author) {
        AuthorFx authorFx = new AuthorFx();
        authorFx.setId(author.getId());
        authorFx.setNameOfAuthor(author.getNameOfAuthor());

        return authorFx;
    }
}



