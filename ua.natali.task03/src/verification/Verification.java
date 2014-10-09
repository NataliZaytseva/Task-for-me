package verification;

/**
 * Created by natali on 09.10.14.
 */
public class Verification {
    public static String fileInputVerification(String filename) {
        String fileName = null;
        if (filename.toUpperCase().equals("EXIT")) {
            System.exit(0);
        }else if (!filename.contains(".csv")) {
            fileName = filename + ".csv";
        } else if (!filename.contains("./")) {
            fileName = "./" + filename;
        } else if (!filename.contains(".csv") & !filename.contains("./")) {
            fileName = "./" + filename + ".csv";
        } else {
            fileName = filename;
        }
        return fileName;
    }
    public static String fileOutputVerification(String filename){
        String fileName = null;
        if (filename.isEmpty()) {
            fileName = "./SavedFile.txt";
            System.out.println("You have not entered any name. Default name for file - SavedFile");
        } else if (!filename.contains(".txt")) {
            fileName = filename + ".txt";
        } else if (!filename.contains("./")) {
            fileName = "./" + filename;
        } else if (!filename.contains(".txt") & !filename.contains("./")) {
            fileName = "./" + filename + ".txt";
        } else {
            fileName = filename;
        }
        return fileName;
    }
}
