package OutputTo;

import java.io.IOException;
import java.util.List;

/**
 * Created by natali on 02.10.14.
 */
public interface SaveTo {
    void save(List<String> references, String fileNameTo) throws IOException;
}
