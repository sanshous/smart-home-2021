package ru.sbt.mipt.oop;

import java.io.IOException;

public interface FileToSmartHome {
    public SmartHome getSmarthomeFromFile(String Filename) throws IOException;
}
