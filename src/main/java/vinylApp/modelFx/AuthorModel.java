package vinylApp.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import vinylApp.database.dao.AuthorDao;
import vinylApp.database.dao.VinylDao;
import vinylApp.database.dbUtils.converters.ConverterAuthor;
import vinylApp.database.models.Author;
import vinylApp.database.models.Vinyl;
import vinylApp.utils.exceptions.ApplicationException;

import java.sql.SQLException;
import java.util.List;


public class AuthorModel {

    private ObservableList<AuthorFx> authorList = FXCollections.observableArrayList();//connect with comboBox
    private ObjectProperty<AuthorFx> author = new SimpleObjectProperty<>();//take choosen from comboBox element
    private TreeItem<String> root = new TreeItem<>();

    public void init() throws ApplicationException {
        AuthorDao authorDao = new AuthorDao();
        List<Author> authors = authorDao.queryForAll(Author.class);
        initAuthorList(authors);
        initRoot(authors);
    }

    private void initRoot(List<Author> authors) {

        this.root.getChildren().clear();
        authors.forEach(a -> {
            TreeItem<String> authorItem = new TreeItem<>(a.getNameOfAuthor());
            a.getVinylsAuthor().forEach(b -> {
                authorItem.getChildren().add(new TreeItem<>(b.getTitle())); // title from vinyls list
            });
            root.getChildren().add(authorItem);
        });


    }

    private void initAuthorList(List<Author> authors) {
        this.authorList.clear();
        authors.forEach(c -> {
            AuthorFx authorFx = ConverterAuthor.convertToAuthorFx(c);
            this.authorList.add(authorFx);
        });
    }


    public void deleteAuthorById() throws ApplicationException, SQLException {
        AuthorDao authorDao = new AuthorDao();
        authorDao.deleteById(Author.class, author.getValue().getId());
        VinylDao vinylDao = new VinylDao();
        vinylDao.deleteByColumnName(Vinyl.AUTHOR, author.getValue().getId());
        init();
    }

    public void saveAuthorInDataBase(String name) throws ApplicationException {
        AuthorDao authorDao = new AuthorDao();
        Author author = new Author();
        author.setNameOfAuthor(name);
        authorDao.createOrUpdate(author);
        init();
    }


    public void updateAuthorInDataBase() throws ApplicationException {
        AuthorDao authorDao = new AuthorDao();
        Author tempAuthor = authorDao.findById(Author.class, this.getAuthor().getId());
        tempAuthor.setNameOfAuthor(getAuthor().getNameOfAuthor());
        authorDao.createOrUpdate(tempAuthor);
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

    public TreeItem<String> getRoot() {
        return root;
    }

    public void setRoot(TreeItem<String> root) {
        this.root = root;
    }
}
