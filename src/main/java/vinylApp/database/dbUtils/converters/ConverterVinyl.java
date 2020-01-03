package vinylApp.database.dbUtils.converters;

import vinylApp.database.models.Vinyl;
import vinylApp.modelFx.VinylFx;
import vinylApp.utils.Utils;

public class ConverterVinyl {

    public static Vinyl convertToVinyl(VinylFx vinylFx) throws NumberFormatException{
            Vinyl vinyl = new Vinyl();
            vinyl.setId(vinylFx.getId());
            vinyl.setTitle(vinylFx.getTitle());
            vinyl.setReleaseDate(Integer.parseInt(vinylFx.getReleased()));
            vinyl.setCatalogNumber(vinylFx.getCatalogNumber());
            vinyl.setBuyDate(Utils.convertToDate(vinylFx.getDateOfPurchase()));
//PRICE
            vinyl.setPrice(vinylFx.getPrice());
            vinyl.setSellPrice(vinylFx.getSellingPrice());

            vinyl.setSellDate(Utils.convertToDate(vinylFx.getDateOfSelling()));
            vinyl.setCondition(vinylFx.getVinylCondition());
            vinyl.setConditionAccessories(vinylFx.getAccessoriesCondition());
            vinyl.setAvailable(vinylFx.isIsAvailable());
            vinyl.setWantTo(vinylFx.isWantList());


        return vinyl;
    }


    public static VinylFx convertToVinylFx(Vinyl vinyl) {

        VinylFx vinylFx = new VinylFx();
        vinylFx.setId(vinyl.getId());
        vinylFx.setTitle(vinyl.getTitle());
        vinylFx.setReleased(Integer.toString(vinyl.getReleaseDate()));
        vinylFx.setCatalogNumber(vinyl.getCatalogNumber());
        vinylFx.setDateOfPurchase(Utils.convertToLocalDate(vinyl.getBuyDate()));
//PRICE
        vinylFx.setPrice(vinyl.getPrice());
        vinylFx.setSellingPrice(vinyl.getSellPrice());

        vinylFx.setDateOfSelling(Utils.convertToLocalDate(vinyl.getSellDate()));
        vinylFx.setVinylCondition(vinyl.getCondition());
        vinylFx.setAccessoriesCondition(vinyl.getConditionAccessories());
        vinylFx.setIsAvailable(vinyl.isAvailable());
        vinylFx.setWantList(vinyl.isWantTo());
        vinylFx.setAuthorFx(ConverterAuthor.convertToAuthorFx(vinyl.getAuthor()));
        vinylFx.setGenreFx(ConverterGenre.convertToGenreFx(vinyl.getGenre()));
        vinylFx.setCountryFx(ConverterReleaseCountry.convertToReleaseCountryFx(vinyl.getReleaseCountry()));
        vinylFx.setLabelFx(ConverterLabel.convertToLabelFx(vinyl.getLabel()));

        return vinylFx;
    }
}
