package verification;

import java.io.*;

/**
 * Created by natali on 09.10.14.
 */
public class Verification {
    public static String fileInputVerification(String filename) {
        String fileName = null;
        if (filename.toUpperCase().equals("EXIT")) {
            System.exit(0);
        } else if (!filename.contains(".csv")) {
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

    public static String fileOutputVerification(String filename) {
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

    public static String nullDataVerification(String filename) {
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

    public static String fileExistVerification() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean notEntered = true;
        String fileName = null;
        while (notEntered) {
            try {
                System.out.println(" Enter a name of .csv file ");
                String name = reader.readLine();
                fileName = fileInputVerification(name);
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

    public static String columnVerification() {
        String columnName = null;
        boolean notEntered = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (notEntered) {
                System.out.println(" Enter the column name ");
                columnName = reader.readLine();
                if (columnName.toUpperCase().contains("ID")) {
                    notEntered = false;
                } else if (columnName.toUpperCase().contains("MONEY")) {
                    notEntered = false;
                } else if (columnName.toUpperCase().contains("MONTH")) {
                    notEntered = false;
                } else {
                    System.out.println("We have not this name among column names ");
                    System.out.println("Try again. ");
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return columnName;
    }
}
