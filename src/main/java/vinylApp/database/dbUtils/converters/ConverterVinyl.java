package vinylApp.database.dbUtils.converters;

import vinylApp.database.models.Vinyl;
import vinylApp.modelFx.VinylFx;
import vinylApp.utils.Utils;

public class ConverterVinyl {

    public static Vinyl convertToVinyl(VinylFx vinylFx) {
        Vinyl vinyl = new Vinyl();
        vinyl.setId(vinylFx.getId());
        vinyl.setTitle(vinylFx.getTitle());
        vinyl.setReleaseDate(Integer.parseInt(vinylFx.getReleased()));
        vinyl.setCatalogNumber(vinylFx.getCatalogNumber());
        vinyl.setBuyDate(Utils.convertToDate(vinylFx.getDateOfPurchase()));
        //Convert from String -> double -> decimalString -> double -> add ;/
//----------------------------------------------------------------------------------------------------------------------

        //double vinylPrice = Utils.convertToDouble(vinylFx.getPrice());
        //String vinylPrice2 = Utils.cutDoubleToDecimal(vinylPrice);
        //vinyl.setPrice(Utils.convertToDouble(vinylPrice2));
        vinyl.setPrice(Utils.convertToDouble(vinylFx.getPrice()));
        vinyl.setSellPrice(Utils.convertToDouble(vinylFx.getSellingPrice()));
        //save whole number in database REMEMBER LATER ! Show only 2 digits after coma

        // double vinylSellPrice = Utils.convertToDouble(vinylFx.getSellingPrice());
        // String vinylSellPrice2 = Utils.cutDoubleToDecimal(vinylSellPrice);
        // vinyl.setSellPrice(Utils.convertToDouble(vinylSellPrice2));
//----------------------------------------------------------------------------------------------------------------------
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
        vinylFx.setPrice(Double.toString(vinyl.getPrice()));
        vinylFx.setSellingPrice(Double.toString(vinyl.getSellPrice()));
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