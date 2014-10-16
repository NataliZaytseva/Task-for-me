package readFrom.readImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BufferedReaderClass {
    public static String read() {
        String s = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            s = bufferedReader.readLine();
//            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return s;
    }
}
