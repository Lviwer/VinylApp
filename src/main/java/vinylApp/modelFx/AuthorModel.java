package vinylApp.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vinylApp.database.dao.AuthorDao;
import vinylApp.database.dao.GenreDao;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.database.models.Author;
import vinylApp.database.models.Genre;
import vinylApp.utils.exceptions.ApplicationException;

import java.util.List;


//separate javaFx from database
public class AuthorModel {

    private ObservableList<AuthorFx> authorList = FXCollections.observableArrayList();//connect with comboBox
    private ObjectProperty<AuthorFx> author = new SimpleObjectProperty<>();//take choosen from comboBox element


    public void init() throws ApplicationException {
        AuthorDao authorDao = new AuthorDao(DbManager.getConnectionSource());
        List<Author> authors = authorDao.queryForAll(Author.class);
        this.authorList.clear();

        authors.forEach(c -> {
            AuthorFx authorFx = new AuthorFx();
            authorFx.setId(c.getId());
            authorFx.setNameOfAuthor(c.getNameOfAuthor());
            this.authorList.add(authorFx);
        });
        DbManager.closeConnectionSource();

    }


    public void saveAuthorInDataBase(String name) throws ApplicationException {
        AuthorDao authorDao = new AuthorDao(DbManager.getConnectionSource());
        Author author = new Author();
        author.setNameOfAuthor(name);
        authorDao.createOrUpdate(author);
        DbManager.getConnectionSource();
        init();
    }


    public void deleteAuthorById() throws ApplicationException {
        AuthorDao authorDao = new AuthorDao(DbManager.getConnectionSource());
        authorDao.deleteById(Author.class, author.getValue().getId());
        DbManager.closeConnectionSource();
        init();
    }


    public void updateAuthorInDataBase() throws ApplicationException {
        AuthorDao authorDao = new AuthorDao(DbManager.getConnectionSource());
        Author tempAuthor = authorDao.findById(Author.class, this.getAuthor().getId());
        tempAuthor.setNameOfAuthor(getAuthor().getNameOfAuthor());
        authorDao.createOrUpdate(tempAuthor);
        DbManager.closeConnectionSource();
        init();


    }



    public ObservableList<AuthorFx> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(ObservableList<AuthorFx> authorList) {
        this.authorList = authorList;
    }

    public AuthorFx getAuthor() {
        return author.get();
    }

    public ObjectProperty<AuthorFx> authorProperty() {
        return author;
    }

    public void setAuthor(AuthorFx author) {
        this.author.set(author);
    }


}
