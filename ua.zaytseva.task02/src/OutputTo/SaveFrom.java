package OutputTo;

import java.io.IOException;

/**
 * Created by natali on 02.10.14.
 */
public interface SaveFrom {
    void save(String siteName, String filename) throws IOException;
}
