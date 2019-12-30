package vinylApp.modelFx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vinylApp.database.dao.VinylDao;
import vinylApp.database.dbUtils.converters.ConverterAuthor;
import vinylApp.database.dbUtils.converters.ConverterVinyl;
import vinylApp.database.models.Vinyl;
import vinylApp.utils.exceptions.ApplicationException;

import java.util.List;

public class ListVinylsModel {


    private ObservableList<VinylFx> vinylFxObservableList = FXCollections.observableArrayList();


    public ObservableList<VinylFx> getVinylFxObservableList() {
        return vinylFxObservableList;
    }

    public void setVinylFxObservableList(ObservableList<VinylFx> vinylFxObservableList) {
        this.vinylFxObservableList = vinylFxObservableList;
    }

    public void init () throws ApplicationException {
        VinylDao vinylDao = new VinylDao();
        List<Vinyl> vinyls = vinylDao.queryForAll(Vinyl.class);
        vinyls.forEach(vinyl-> {
            this.vinylFxObservableList.add(ConverterVinyl.convertToVinylFx(vinyl));
        });

    }

}
