package readFrom;

import java.io.IOException;
import java.util.List;

/**
 * Created by natali on 08.10.14.
 */
public interface Read  {
    List<String> readFileLines(String fileInput) throws IOException;
}
