package src.implementation;

import src.interfaces.AddableBehaviour;
import src.interfaces.PageableBehaviour;
import src.interfaces.PrintableBehaviour;
import src.interfaces.SortableBehavior;

import java.util.*;

/**
 * Created by natali on 22.10.14.
 */
public class Table {
    private SortableBehavior<Table> sortableBehaviour;
    private AddableBehaviour<Map<String, Object>> addableBehaviour;
    private PrintableBehaviour<Table> printableBehaviour;
    private PageableBehaviour<Table> pageableBehaviour;
    private List<Map<String, Object>> rows;
    private int pageSize;
    private int defaultValue = 1;
    public List<String> headerList = new ArrayList<>();

    public Table(SortableBehavior<Table> sortableBehaviour, List<Map<String, Object>> list) {
        this.sortableBehaviour = sortableBehaviour;
        this.rows = list;
    }

    public void setSort(String columnName) {
        sortableBehaviour.sort(this, columnName);
    }

    public void setAddableBehaviour(AddableBehaviour<Map<String, Object>> addableBehaviour) {
        this.addableBehaviour = addableBehaviour;
    }

    public void add(TreeMap<String, Object> row) {
        for (String s : row.keySet()) {

            if (!headerList.contains(s)) {
                headerList.add(s);
            }
        }
        addableBehaviour.add(row);
    }

    public void addRows(List<Map<String, Object>> rows) {
        for(Map<String, Object> row2: rows){
           for  (String s : row2.keySet()){
               if (!headerList.contains(s)) {
                   headerList.add(s);
               }
           }
        }
        addableBehaviour.addRows(rows);
    }

    public void remove(int i) {
        addableBehaviour.remove(i);
    }

    public void removeRows(int from, int to) {
        addableBehaviour.removeRows(from, to);
    }

    public void setPrintableBehaviour(PrintableBehaviour printableBehaviour) {
        this.printableBehaviour = printableBehaviour;
    }

    public void print() {
        printableBehaviour.print();
    }

    public void print(int pageNumber) {
        printableBehaviour.print(pageNumber);
    }

    public void printPage(int currentPage) {
        printableBehaviour.printPage(currentPage);
    }

    public void setTablePageableBehaviour(PageableBehaviour pageableBehaviour) {
        this.pageableBehaviour = pageableBehaviour;
    }

    public int getNumberOfPages() {
        return pageableBehaviour.getNumberOfPages();
    }

    public int nextPage() {
        return pageableBehaviour.nextPage();
    }

    public int currentPage() {
        return pageableBehaviour.getCurrentPage();
    }

    public int previousPage() {
        return pageableBehaviour.previousPage();
    }

    public boolean hasNext() {
        return pageableBehaviour.hasNext();
    }

    public boolean hasPrevious() {
        return pageableBehaviour.hasPrevious();
    }

    public void removePage(int pageToRemove) {
        pageableBehaviour.removePage(pageToRemove);
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;

    }

    public int getPageSize() {
        return pageSize;
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public int getFirstRowOfPage(int page) {
        if (pageSize == 0) {
            return (page - 1);
        } else {
            return ((page - 1) * pageSize);
        }
    }

    public int getLastRowOfPage(int page) {
        if (pageSize == 0) {
            return getFirstRowOfPage(page) + defaultValue;
        } else {
            return getFirstRowOfPage(page) + pageSize;
        }
    }

    public int getNumberOfPagesGeneral() {
        if (getPageSize() == 0) {
            int mod = getRows().size() % defaultValue;
            return getRows().size() / defaultValue + (mod != 0 ? 1 : 0);
        } else {
            int mod = getRows().size() % getPageSize();
            return getRows().size() / getPageSize() + (mod != 0 ? 1 : 0);
        }
    }
    public int getVerticalNumberOfPagesGeneral(){
        if (getPageSize() == 0) {
            int mod = getHeaderList().size() % defaultValue;
            return getHeaderList().size() / defaultValue + (mod != 0 ? 1 : 0);
        } else {
            int mod = getHeaderList().size() % getPageSize();
            return getHeaderList().size() / getPageSize() + (mod != 0 ? 1 : 0);
        }
    }

    public List<String> getHeaderList() {
        return headerList;
    }
}
