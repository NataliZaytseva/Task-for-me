package src.implementation;

import src.interfaces.PageableBehaviour;

/**
 * Created by Natali on 17.11.2014.
 */
public class TablePageableBehaviour extends PageableBehaviour<Table> {

    @Override
    public void setPageSize(int rowCount) {

    }

    @Override
    public int nextPage() {
        return 0;
    }

    @Override
    public int previousPage() {
        return 0;
    }

    @Override
    public int getNumberOfPages() {
        return 0;
    }

    @Override
    public void removePage(int pageNumber) {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public int getCurrentPage() {
        return 0;
    }
}
