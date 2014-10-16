package saveTo.saveImpl;

import saveTo.SaveTo;
import ua.natali.t03.Salaries;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by natali on 08.10.14.
 */
public class SaveToFile implements SaveTo {
    @Override
    public void saveLinesToFile(List<Salaries> strings, String fileOutput) {

        File file = new File(fileOutput);
        FileWriter fw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            for (Salaries lines : strings) {

                fw.write(String.valueOf(lines) + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println();
        }
        System.out.println("Your file will be save at this direction " + file.getAbsoluteFile());
    }
}
