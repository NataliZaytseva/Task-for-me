package read;

import verificationField.Verification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Natali on 21.11.2014.
 */
public class ReadFromConsole {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Verification verification = new Verification();

    private String setterName;



    public String readClassNameFromConsole() {
        String className = null;
        try {
            System.out.println("Enter class name ");
            className = reader.readLine();
        } catch (IOException e) {
            System.out.println("Sorry, can't find the class");
        }
        return className;
    }

    public String readParameter(ArrayList<String> fieldList, Class classForName) {
        try {
            boolean notEnteredCorrectSetMethod = true;
            while (notEnteredCorrectSetMethod) {
                System.out.println("Enter please name of parameter to set (for instance age or name)");
                String parameterName = reader.readLine();
                boolean fieldFlag = verification.fieldVerification(parameterName, fieldList);
                if (!fieldFlag) {
                    setterName = verification.setterMethodNameForFiled(classForName, parameterName);
                }else{
                    System.out.println("Incorrect field name. Try again.");
                }
                notEnteredCorrectSetMethod = fieldFlag;
            }
        } catch (IOException e) {
            System.out.println("Input exception");
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry, can't find the class");
        }
        return setterName;
    }

    public String readValue(Class classForName) {
        String value = null;
        try {
            boolean notEnteredCorrectValue = true;
            while (notEnteredCorrectValue) {
                System.out.println("Enter please value for set method ");
                value = reader.readLine();
                boolean valueFlag = verification.valueVerification(classForName, value, setterName);
                if(valueFlag){
                    System.out.println("Types don't matches. Try again.");
                }
                notEnteredCorrectValue = valueFlag;
            }
        } catch (IOException e) {
            System.out.println("Input exception");
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry, can't find the class");
        }
        return value;
    }

    public boolean oneMore() {
        String yes = "yes";
        try {
            System.out.println("Do you like to set one more method? ");
            System.out.println("Enter Y/N ");
            String  oneMore = reader.readLine();
            if (yes.toUpperCase().contains(oneMore.toUpperCase())) {
                return true;
            } else {
                reader.close();
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
