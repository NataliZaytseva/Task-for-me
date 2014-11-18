package src.implementation;

import java.util.NoSuchElementException;

/**
 * Created by Natali on 07.11.2014.
 */
//public class EvenPageableBehaviour extends PageableBehaviour<Table> {
public class HorizontalEvenPageableBehaviour extends TablePageableBehaviour {
    Table table;
    private int currentPage = 2;

    public HorizontalEvenPageableBehaviour(Table table) {
        this.table = table;
    }

    @Override
    public int getNumberOfPages() {
        if (table.getPageSize() == 0) {
            int defaultPageSize = 1;
            int mod = table.getRows().size() % defaultPageSize;
            int total = (table.getRows().size() / defaultPageSize)/2;
            return total + (mod != 0 ? 1 : 0);
        } else {
            int mod = table.getRows().size() % table.getPageSize();
            int total =(table.getRows().size() / table.getPageSize())/2;
            return  total + (mod != 0 ? 1 : 0) ;

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
        return (currentPage <= table.getNumberOfPagesGeneral() - 1);
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
