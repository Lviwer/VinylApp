package vinylApp.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import vinylApp.database.dao.GenreDao;
import vinylApp.database.dao.LabelDao;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.database.dbUtils.converters.ConverterLabel;
import vinylApp.database.models.Genre;
import vinylApp.database.models.Label;
import vinylApp.utils.exceptions.ApplicationException;

import java.util.List;

public class LabelModel {

    private ObservableList<LabelFx> labelList = FXCollections.observableArrayList();
    private ObjectProperty<LabelFx> label = new SimpleObjectProperty<>();
    private TreeItem<String> root = new TreeItem<>();

    public void init() throws ApplicationException {
        LabelDao labelDao = new LabelDao();
        List<Label> labels = labelDao.queryForAll(Label.class);
        initLabelList(labels);
        initRoot(labels);

    }

    private void initRoot(List<Label> labels) {
        this.root.getChildren().clear();
        labels.forEach(a -> {
            TreeItem<String> labelItem = new TreeItem<>(a.getNameOfLabel());
            a.getVinylsLabel().forEach(b -> {
                labelItem.getChildren().add(new TreeItem<>(b.getTitle()));
            });
            root.getChildren().add(labelItem);
        });


    }

    private void initLabelList(List<Label> labels) {
        this.labelList.clear();
        labels.forEach(c -> {
            LabelFx labelFx = ConverterLabel.convertToLabelFx(c);
            this.labelList.add(labelFx);
        });
    }

    public void deleteLabelById() throws ApplicationException {
        LabelDao labelDao = new LabelDao();
        labelDao.deleteById(Label.class, label.getValue().getId());
        init();
    }

    public void saveLabelInDataBase(String name) throws ApplicationException {
        LabelDao labelDao = new LabelDao();
        Label label = new Label();
        label.setNameOfLabel(name);
        labelDao.createOrUpdate(label);
        init();

    }


    public void updateLabelInDatabase() throws ApplicationException {
        LabelDao labelDao = new LabelDao();
        Label tempLabel = labelDao.findById(Label.class, this.getLabel().getId());
        tempLabel.setNameOfLabel(getLabel().getNameOfLabel());
        labelDao.createOrUpdate(tempLabel);
        init();
    }


    public ObservableList<LabelFx> getLabelList() {
        return labelList;
    }

    public void setLabelList(ObservableList<LabelFx> labelList) {
        this.labelList = labelList;
    }

    public LabelFx getLabel() {
        return label.get();
    }

    public ObjectProperty<LabelFx> labelProperty() {
        return label;
    }

    public void setLabel(LabelFx label) {
        this.label.set(label);
    }


    public TreeItem<String> getRoot() {
        return root;
    }

    public void setRoot(TreeItem<String> root) {
        this.root = root;
    }
}
