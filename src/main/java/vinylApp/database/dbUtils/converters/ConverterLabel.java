package vinylApp.database.dbUtils.converters;

import vinylApp.database.models.Label;
import vinylApp.modelFx.LabelFx;

public class ConverterLabel {


    public static LabelFx convertToLabelFx(Label label)
    {
        LabelFx labelFx = new LabelFx();
        labelFx.setId(label.getId());
        labelFx.setNameOfLabel(label.getNameOfLabel());
        return labelFx;
    }

}
