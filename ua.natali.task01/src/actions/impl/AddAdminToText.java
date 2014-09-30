package actions.impl;

import actions.Action;


public class AddAdminToText implements Action {

    @Override
    public String performAction(String text) {
        if (text != null && !text.isEmpty()) {
            TransformToApperCase up = new TransformToApperCase();
            String upstring = up.performAction(text);
            return upstring + " -Admin";
        }
        return null;
    }
}
