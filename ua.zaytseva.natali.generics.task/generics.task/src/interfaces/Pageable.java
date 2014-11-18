package src.interfaces;

/**
 * Created by natali on 22.10.14.
 */
public interface Pageable<Table>  {

    void setPageSize(int rowCount);

    int nextPage();

    int previousPage();

    int getNumberOfPages();

    void removePage(int pageNumber);

    boolean hasNext();

    boolean hasPrevious();

}
