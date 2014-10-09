package verification;

import java.io.*;

/**
 * Created by natali on 09.10.14.
 */
public class FileExistVerification {
    public String fileExistVerification(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean notEntered = true;
        String fileName = null;
        while (notEntered) {
            try {
                System.out.println(" Enter a name of .csv file ");
                String name = reader.readLine();
                fileName = Verification.fileInputVerification(name);
                System.out.println("Reading file " + fileName);
                reader = new BufferedReader(new FileReader(fileName));
                notEntered = false;
                reader.close();
            } catch (FileNotFoundException e) {
                System.out.println("This is not a .csv file ");
                System.out.println("Try again. ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileName;
    }
}
