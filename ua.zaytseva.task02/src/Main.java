import OutputTo.SaveTo;
import OutputTo.impl.SaveFromURL;
import OutputTo.impl.SaveToFile;
//import parse.impl.RefParse;
import parse.impl.RefParseFromFile;

import javax.swing.text.BadLocationException;
import java.io.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException, BadLocationException {
        System.out.println("Enter full address of web site ");
        //         http://google.com   http://www.oracle.com
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String siteName = reader.readLine();
        if (!siteName.contains("http://")) {
            siteName = "http://" + siteName;
        }
        System.out.println("Enter a name of the file ");
        String fileName1 = reader.readLine();
        if (fileName1.isEmpty()) {
            fileName1 = "./task.txt";
            System.out.println("You have not entered any name. Default name for file - task");
        } else {
            fileName1 = "./" + fileName1 + ".txt";
        }
        SaveFromURL saveFromURL = new SaveFromURL();
        saveFromURL.save(siteName, fileName1);
        RefParseFromFile refParseFromFile = new RefParseFromFile();
        List<String> references = refParseFromFile.parse(fileName1);

        System.out.println("Enter a name for references file ");
        String fileName2 = reader.readLine();
        SaveTo saveTo = new SaveToFile();
        saveTo.save(references, fileName2);

    }
}
