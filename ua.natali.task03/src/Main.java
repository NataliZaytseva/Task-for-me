import common.ColumnNames;
import readFrom.readImpl.ReadFile;
import saveTo.saveImpl.SaveToFile;
import ua.natali.t03.Salaries;
import verification.Verification;

import java.io.IOException;
import java.util.List;

/**
 * Created by natali on 08.10.14.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String inputFileName = Verification.fileExistVerification();
        ReadFile readFile = new ReadFile();
        List<String> lines = readFile.readFileLines(inputFileName);
        List<Salaries> salaries = ColumnNames.findColumnAndSort(lines);
        String filenameOutput = Verification.fileOutputVerification();
        SaveToFile writeToFile = new SaveToFile();
        writeToFile.saveLinesToFile(salaries, filenameOutput);

    }
}
