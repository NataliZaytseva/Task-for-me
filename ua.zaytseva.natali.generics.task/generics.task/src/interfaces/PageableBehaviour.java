package src.interfaces;

/**
 * Created by Natali on 06.11.2014.
 */
public abstract class PageableBehaviour <T>  {

    public abstract void setPageSize(int rowCount);

    public abstract int nextPage();

    public abstract int previousPage();

    public abstract int getNumberOfPages();

    public abstract void removePage(int pageNumber);

    public abstract boolean hasNext();

    public abstract boolean hasPrevious();

    public abstract int getCurrentPage();
}
