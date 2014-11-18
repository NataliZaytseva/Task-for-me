package src.interfaces;

/**
 * Created by Natali on 05.11.2014.
 */
public abstract class PrintableBehaviour <T> {
    public abstract void print();

    public abstract void print(int printToPage);

    public abstract void printPage(int pageNumber);


}
