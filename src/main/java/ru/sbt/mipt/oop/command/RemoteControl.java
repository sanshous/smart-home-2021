package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.command.Command;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoteControl implements rc.RemoteControl {
    private HashMap<String, Command> controlToButton;

    public void createControl(HashMap<String, Command> controlToButton) {
        this.controlToButton = controlToButton;
    }

    @Override
    public void onButtonPressed(String buttonCod) {
        controlToButton.get(buttonCod).execute();
    }

    private void executeCommand(Command command) {
        command.execute();
    }
}
