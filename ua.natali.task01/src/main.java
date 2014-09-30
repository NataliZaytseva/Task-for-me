import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class main {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a string for identification please ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        Person.processString(s);

    }
}