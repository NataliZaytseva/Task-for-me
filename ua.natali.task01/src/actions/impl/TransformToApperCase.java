package actions.impl;

import actions.Action;


public class TransformToApperCase implements Action {

    @Override
    public String performAction(String text) {
        if (text != null && !text.isEmpty()) {
            return text.toUpperCase();
        }
        return null;
    }
}
