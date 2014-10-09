package readFrom.readImpl;

import readFrom.Read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by natali on 08.10.14.
 */
public class ReadFile implements Read {

    public List<String> readFile(String fileInput) throws IOException {
        List<String> list = new ArrayList<String>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileInput));
            String string;
            while ((string = reader.readLine()) != null) {
                list.add(string);
            }
        } catch (IOException e) {
            System.out.println("Try again. ");
        }
        reader.close();
        return list;
    }
}
