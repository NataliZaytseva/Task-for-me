package src.implementation;

/**
 * Created by natali on 28.10.14.
 */
class Sort{
    private String columnName;

    Sort(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}