import actions.Action;
import actions.impl.AddAdminToText;
import actions.impl.TransformToApperCase;
import analizers.Analizer;
import analizers.impl.AdminAnalizer;
import analizers.impl.UserAnalizer;

import java.util.*;

public enum Person {

    ADMIN(new AdminAnalizer(), new ArrayList<Action>(Arrays.asList(new AddAdminToText()))),
    USER(new UserAnalizer(), new ArrayList<Action>(Arrays.asList(new TransformToApperCase())));

    private Analizer analizer;
    private ArrayList<Action> actions;


    Person(Analizer analizer, ArrayList<Action> actions) {

        this.analizer = analizer;
        this.actions = actions;
    }

    public static void processString(String text) {
        for (Person dir : Person.values()) {
            if (dir.analizer.analize(text) == true) {

                for (Action act : dir.actions) {
                    System.out.println(act.performAction(text));
                }
            }
        }
    }
}






