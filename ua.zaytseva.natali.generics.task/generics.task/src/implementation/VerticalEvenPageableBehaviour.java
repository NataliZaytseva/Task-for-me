package src.implementation;

import java.util.NoSuchElementException;

/**
 * Created by Natali on 17.11.2014.
 */
public class VerticalEvenPageableBehaviour extends TablePageableBehaviour {
    Table table;
    private int currentPage = 2;

    public VerticalEvenPageableBehaviour(Table table) {
        this.table = table;
    }

    @Override
    public int getNumberOfPages() {
        if (table.getPageSize() == 0) {
            return table.getHeaderList().size();
        } else {
            int total =(table.getHeaderList().size() / table.getPageSize())/2;
            return  total ;

        }
    }

    @Override
    public int nextPage() {
        if (hasNext()) {
            if (table.getPageSize() == 0){
                return currentPage = currentPage + 2;

            }else {
                return currentPage = currentPage + table.getPageSize();
            }
        } else {
            throw new NoSuchElementException("Sorry we don't have next page");
        }
    }

    @Override
    public int previousPage() {
        if (hasPrevious()) {
            if(table.getPageSize() == 0) {
                return currentPage = currentPage - 2;
            }else{
                return currentPage = currentPage - table.getPageSize();
            }
        } else {
            throw new NoSuchElementException("Sorry we don't have previous page");
        }
    }

    @Override
    public boolean hasNext() {
        return (currentPage <= table.getNumberOfPages()-1);
    }

    @Override
    public boolean hasPrevious() {
        return (currentPage - 2 > 0);
    }

    @Override
    public int getCurrentPage() {
        return currentPage;
    }

    @Override
    public void removePage(int pageToRemove) {
        int firstRowOfPage = table.getFirstRowOfPage(pageToRemove);
        int lastRowOfPage = table.getLastRowOfPage(pageToRemove);

        for (int i = firstRowOfPage; i < lastRowOfPage && i < table.getRows().size(); i++) {
            table.getRows().remove(firstRowOfPage);

        }
    }
}
