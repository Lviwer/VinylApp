package vinylApp.database.dbUtils.converters;

import vinylApp.database.models.Genre;
import vinylApp.modelFx.AuthorFx;
import vinylApp.modelFx.GenreFx;

public class ConverterGenre {

    public static GenreFx convertToGenreFx(Genre genre) {
        GenreFx genreFx = new GenreFx();
        genreFx.setId(genre.getId());
        genreFx.setNameOfGenre(genre.getNameOfGenre());

        return genreFx;
    }
}
