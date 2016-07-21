package com.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Component {
    private String name;
    private String type;

    public Component(String name, String type) {
        this.setName(name);
        this.setType(type);
    }

    public String getName() {
        return name;
    }

    //TODO validate name
    protected void setName(String name) {
        if (name == null) {
            return;
        }
//        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
//        Matcher matcher = pattern.matcher(name);
//        if(!matcher.find()){
//            return;
//        }

        this.name = name;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }
}
