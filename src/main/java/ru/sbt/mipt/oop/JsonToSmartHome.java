package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToSmartHome {
    public static SmartHome getSmarthomeFromJson(String Filename) throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(Filename)));
        SmartHome smartHome = gson.fromJson(json, SmartHome.class);
        return smartHome;
    }
}
