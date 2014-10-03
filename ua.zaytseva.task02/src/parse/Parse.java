package parse;

import javax.swing.text.BadLocationException;
import java.io.IOException;
import java.util.List;

/**
 * Created by natali on 02.10.14.
 */
public interface Parse {
    public List<String> parse(String fileName) throws IOException, BadLocationException;
}
