package verification;

import common.ColumnNames;
import readFrom.readImpl.BufferedReaderClass;

import java.io.*;

/**
 * Created by natali on 09.10.14.
 */
public class Verification {
    private static final String FILE_EXTENSION_CSV = ".csv";
    private static final String FILE_EXTENSION_TXT = ".txt";
    private static final String FILE_SEPARATOR = "./";
    private static final String DEFAULT_FILE_NAME = "./SavedFile.txt";

    public static String fileInputVerification(String filename) {
        String inputFileName = null;
        if (filename.toUpperCase().equals("EXIT")) {
            System.exit(0);
        } else if (!filename.contains(FILE_EXTENSION_CSV)) {
            inputFileName = filename + FILE_EXTENSION_CSV;
        } else if (!filename.contains(FILE_SEPARATOR)) {
            inputFileName = FILE_SEPARATOR + filename;
        } else if (!filename.contains(FILE_EXTENSION_CSV) & !filename.contains(FILE_SEPARATOR)) {
            inputFileName = FILE_SEPARATOR + filename + FILE_EXTENSION_CSV;
        } else {
            inputFileName = filename;
        }
        return inputFileName;
    }

    public static String fileOutputVerification() {
        String saveToFileName = null;
        System.out.println("Enter name of file to save ");
        String filename = BufferedReaderClass.read();
        if (filename.isEmpty()) {
            saveToFileName = DEFAULT_FILE_NAME;
            System.out.println("You have not entered any name. Default name for file " + DEFAULT_FILE_NAME);
        } else if (!filename.contains(FILE_EXTENSION_TXT)) {
            saveToFileName = filename + FILE_EXTENSION_TXT;
        } else if (!filename.contains(FILE_SEPARATOR)) {
            saveToFileName = FILE_SEPARATOR + filename;
        } else if (!filename.contains(FILE_EXTENSION_TXT) & !filename.contains(FILE_SEPARATOR)) {
            saveToFileName = FILE_SEPARATOR + filename + FILE_EXTENSION_TXT;
        } else {
            saveToFileName = filename;
        }
        return saveToFileName;
    }

    public static String fileExistVerification() {
        boolean notEntered = true;
        String fileName = null;
        while (notEntered) {
            try {
                System.out.println(" Enter a name of .csv file ");
                String name = BufferedReaderClass.read();
                fileName = fileInputVerification(name);
                File file = new File(fileName);
                System.out.println("Reading file " + fileName);
                if (file.exists()) {
                    if (file.length() == 0) {
                        System.out.println("File is empty");
                        System.exit(0);
                    } else {
                        return fileName;
                    }
                } else {
                    throw new FileNotFoundException();
                }
                notEntered = false;
            } catch (FileNotFoundException e) {
                System.out.println("This is not a .csv file ");
                System.out.println("Try again. ");
            }
        }
        return fileName;
    }

    public static ColumnNames columnVerification() {

        while (true) {
            System.out.println("Enter the column name for sorting ");
            String columnName = BufferedReaderClass.read();
            for (ColumnNames name : ColumnNames.values()) {
                if (name.getAnalizer().analize(columnName)) {
                    return name;
                }
            }

            System.out.println("We have not this name among column names ");
            System.out.println("Try again. ");
        }
    }
}
