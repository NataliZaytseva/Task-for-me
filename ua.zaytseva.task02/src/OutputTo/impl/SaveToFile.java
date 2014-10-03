package OutputTo.impl;

import OutputTo.SaveTo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class SaveToFile implements SaveTo {
    @Override
    public void save(List<String> references, String fileName) throws IOException {
        if (fileName.isEmpty()) {
            fileName = "./references.txt";
            System.out.println("You have not entered any name. Default name for file - references");
        } else {
            fileName = "./" + fileName + ".txt";
        }
        File file = new File(fileName);
        FileWriter fw = null;
        if (!file.exists()) {
            file.createNewFile();
        }
        try {
            fw = new FileWriter(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String ref : references) {
            fw.write(ref);
        }
        System.out.println("Your file will be save at this direction " + file.getAbsoluteFile());
        fw.close();
    }
}
