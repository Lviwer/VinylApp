package vinylApp.database.dbUtils.converters;

import vinylApp.database.models.Vinyl;
import vinylApp.modelFx.VinylFx;
import vinylApp.utils.Utils;

public class ConverterVinyl {

    public static Vinyl convertToVinyl (VinylFx vinylFx){
        Vinyl vinyl = new Vinyl();
        vinyl.setId(vinylFx.getId());
        vinyl.setTitle(vinylFx.getTitle());
        vinyl.setReleaseDate(Utils.convertToDate(vinylFx.getReleased()));
        vinyl.setCatalogNumber(vinylFx.getCatalogNumber());
        vinyl.setBuyDate(Utils.convertToDate(vinylFx.getDateOfPurchase()));
        vinyl.setPrice(Utils.convertToDouble(vinylFx.getPrice())); // check how it works
        vinyl.setSellPrice(Utils.convertToDouble(vinylFx.getSellingPrice()));// check how it works
        vinyl.setCondition(vinylFx.getVinylCondition());
        vinyl.setConditionAccessories(vinylFx.getAccessoriesCondition());
        vinyl.setAvailable(vinylFx.isIsAvailable());
        vinyl.setWantTo(vinylFx.isWantList());

        return vinyl;
    }








}
