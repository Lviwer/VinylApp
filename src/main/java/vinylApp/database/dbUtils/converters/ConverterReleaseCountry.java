package vinylApp.database.dbUtils.converters;

import vinylApp.database.models.ReleaseCountry;
import vinylApp.modelFx.ReleaseCountryFx;

public class ConverterReleaseCountry {

    public static ReleaseCountryFx convertToReleaseCountryFx (ReleaseCountry releaseCountry)
    {
        ReleaseCountryFx releaseCountryFx = new ReleaseCountryFx();
        releaseCountryFx.setId(releaseCountry.getId());
        releaseCountryFx.setNameOfCountry(releaseCountry.getNameOfCountry());
        return releaseCountryFx;
    }


}
