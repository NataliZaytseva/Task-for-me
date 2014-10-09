package analize.columnNameAnalizers;

import analize.AnalizerInterface;

/**
 * Created by natali on 08.10.14.
 */
public class MonthAnalizer implements AnalizerInterface {
    @Override
    public boolean analize(String columnName) {
        if (columnName.toUpperCase().contains("MONTH")) {
            return true;
        }
        return false;
    }
}
