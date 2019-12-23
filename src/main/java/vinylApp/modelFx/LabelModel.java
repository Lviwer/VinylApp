package vinylApp.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vinylApp.database.dao.LabelDao;
import vinylApp.database.dbUtils.DbManager;
import vinylApp.database.models.Label;

import java.util.List;

public class LabelModel {

    private ObservableList<LabelFx> labelList = FXCollections.observableArrayList();
    private ObjectProperty<LabelFx> label = new SimpleObjectProperty<>();

    public void init() {
        LabelDao labelDao = new LabelDao(DbManager.getConnectionSource());
        List<Label> labels = labelDao.queryForAll(Label.class);
        this.labelList.clear();
        labels.forEach(c -> {
            LabelFx labelFx = new LabelFx();
            labelFx.setId(c.getId());
            labelFx.setNameOfLabel(c.getNameOfLabel());
            this.labelList.add(labelFx);
        });
        DbManager.closeConnectionSource();

    }

    public void deleteLabelById() {
        LabelDao labelDao = new LabelDao(DbManager.getConnectionSource());
        labelDao.deleteById(Label.class, label.getValue().getId());
        DbManager.closeConnectionSource();
        init();
    }

    public void saveLabelInDataBase(String name) {
        LabelDao labelDao = new LabelDao(DbManager.getConnectionSource());
        Label label = new Label();
        label.setNameOfLabel(name);
        labelDao.createOrUpdate(label);
        DbManager.closeConnectionSource();
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
}
