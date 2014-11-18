package src.implementation;

import java.util.NoSuchElementException;

/**
 * Created by Natali on 07.11.2014.
 */
//public class UnEvenPageableBehaviour extends PageableBehaviour<Table> {
public class HorizontalUnEvenPageableBehaviour extends TablePageableBehaviour {
    Table table;
    private int currentPage = 1;

    public HorizontalUnEvenPageableBehaviour(Table table) {
        this.table = table;
    }

    @Override
    public int getNumberOfPages() {
        if (table.getPageSize() == 0) {
            int mod = table.getRows().size() % 2;
            int total = table.getRows().size() / 2;
            return total + (mod != 0 ? 1 : 0);
        } else {
            int total =(table.getRows().size() / table.getPageSize())/2;
            return total + 1;
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

    public boolean hasNext() {
        return (currentPage < table.getNumberOfPagesGeneral());
    }

    @Override
    public boolean hasPrevious() {
        return (currentPage - 2 > 0);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    @Override
    public void removePage(int pageToRemove) {
        int firstRowOfPage = table.getFirstRowOfPage(pageToRemove);
        int lastRowOfPage = table.getLastRowOfPage(pageToRemove);
        if (pageToRemove > table.getNumberOfPagesGeneral()|| pageToRemove <= 0) {
            throw new NoSuchElementException("Sorry we don't have this page");
        }
        for (int i = firstRowOfPage; i < lastRowOfPage; i++) {
            table.getRows().remove(firstRowOfPage);
        }
    }
}
