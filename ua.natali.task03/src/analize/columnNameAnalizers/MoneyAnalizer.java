package analize.columnNameAnalizers;

import analize.AnalizerInterface;

/**
 * Created by natali on 08.10.14.
 */
public class MoneyAnalizer implements AnalizerInterface {
    @Override
    public boolean analize(String columnName) {
        if (columnName.toUpperCase().contains("MONEY")) {
            return true;
        }
        return false;
    }
}
