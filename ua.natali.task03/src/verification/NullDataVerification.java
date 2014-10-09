package verification;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by natali on 09.10.14.
 */
public class NullDataVerification {
    public String nullDataVerification(String filename){
        BufferedReader reader1 = null;
        String line;
        try {
            reader1 = new BufferedReader(new FileReader(filename));
            if ((line = reader1.readLine()) != null) {
                return filename;
            } else {
                System.out.println("File is empty");
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }
}
