import readFrom.readImpl.ReadFile;
import saveTo.saveImpl.SaveToFile;
import ua.natali.t03.Salaries;
import verification.FileExistVerification;
import verification.NullDataVerification;
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileExistVerification fileExistVerification = new FileExistVerification();
        String filenameInput = fileExistVerification.fileExistVerification();
        System.out.println(filenameInput);
        NullDataVerification nullData = new NullDataVerification();
        String fileName =   nullData.nullDataVerification(filenameInput);
        ReadFile readAndWrite = new ReadFile();
        List<String> lines = readAndWrite.readFile(fileName);
        ColumnNames.names();
        System.out.println("Enter the column name ");
        String word = bufferedReader.readLine();
        System.out.println("Enter delimiter");
        String delimiter = bufferedReader.readLine();
        List<Salaries> salaries = ColumnNames.findColumnAndSort(word, lines, delimiter);
        System.out.println("Enter name of file to save ");
        String fileOutput = bufferedReader.readLine();
        String filenameOutput = Verification.fileOutputVerification(fileOutput);

        SaveToFile writeToFile = new SaveToFile();
        writeToFile.saveLinesToFile(salaries, filenameOutput);
    }
}
