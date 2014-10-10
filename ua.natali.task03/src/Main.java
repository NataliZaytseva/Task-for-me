import readFrom.readImpl.ReadFile;
import saveTo.saveImpl.SaveToFile;
import ua.natali.t03.Salaries;
import verification.Verification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by natali on 08.10.14.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String filenameInput = Verification.fileExistVerification();
//        System.out.println(filenameInput);
        String fileName =   Verification.nullDataVerification(filenameInput);
        ReadFile readFile = new ReadFile();
        List<String> lines = readFile.readFile(fileName);
        ColumnNames.names();
        String word = Verification.columnVerification();
        List<Salaries> salaries = ColumnNames.findColumnAndSort(word, lines);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name of file to save ");
        String fileOutput = bufferedReader.readLine();
        String filenameOutput = Verification.fileOutputVerification(fileOutput);

        SaveToFile writeToFile = new SaveToFile();
        writeToFile.saveLinesToFile(salaries, filenameOutput);
    }
}
