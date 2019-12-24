package vinylApp.database.dbUtils.converters;

import vinylApp.database.models.Author;
import vinylApp.modelFx.AuthorFx;

//converting from author to authorfx and reverse
public class ConverterAuthor {

    public static AuthorFx convertToAuthorFx(Author author) {
        AuthorFx authorFx = new AuthorFx();
        authorFx.setId(author.getId());
        authorFx.setNameOfAuthor(author.getNameOfAuthor());
        authorFx.setSurnameOfAuthor(author.getSurnameOfAuthor());

        return authorFx;
    }


}
