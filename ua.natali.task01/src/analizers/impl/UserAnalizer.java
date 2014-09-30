package analizers.impl;

import analizers.Analizer;


public class UserAnalizer implements Analizer {
    @Override
    public boolean analize(String text) {
        if (text.toUpperCase().contains("USER")){
            System.out.println("You are logged in as User");
            return true;
        }
        return false;
    }
}
