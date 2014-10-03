package OutputTo.impl;

import OutputTo.SaveFrom;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class SaveFromURL implements SaveFrom {

    @Override
    public void save(String siteName, String filename) throws IOException {
        URL url = new URL(siteName);
        File out = new File(filename);
        FileWriter fw = null;
        HttpURLConnection con = null;
        if (!out.exists()) {
            out.createNewFile();
        }
        try {
            fw = new FileWriter(out);
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String input;
        while ((input = br.readLine()) != null) {
            fw.write(input);
        }
        System.out.println("Your file will be save at this direction " + out.getAbsoluteFile());
        br.close();
        fw.close();
    }
}

