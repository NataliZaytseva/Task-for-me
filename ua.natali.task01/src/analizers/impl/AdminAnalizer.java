package analizers.impl;

import analizers.Analizer;


public class AdminAnalizer implements Analizer {
    @Override
    public boolean analize(String text) {
        if (text.toUpperCase().contains("ADMIN")) {
            System.out.println("You are logged in as Admin");
            return true;
        }
        return false;
    }
}
