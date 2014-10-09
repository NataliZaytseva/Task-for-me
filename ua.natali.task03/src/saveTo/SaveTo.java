package saveTo;

import ua.natali.t03.Salaries;

import java.util.List;

/**
 * Created by natali on 08.10.14.
 */
public interface SaveTo {
    public void saveLinesToFile(List<Salaries> strings,String fileOutput);
}
