package com.massDefect.parsers.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONParserImpl {

    private Gson gson;

    public JSONParserImpl() {
        this.setGson(new GsonBuilder().setPrettyPrinting().create());
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public <T> T[] readFromJSON(Class<T[]> classes, String file) {
        String fileData = null;
        T[] objects = null;

        try {
            fileData = new String(Files.readAllBytes(Paths.get(file)));

            objects = this.getGson().fromJson(fileData, classes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
