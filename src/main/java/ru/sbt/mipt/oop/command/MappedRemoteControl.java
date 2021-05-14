package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.command.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MappedRemoteControl implements rc.RemoteControl {
    private Map<String, Command> controlToButton;

    public MappedRemoteControl(Map<String, Command> controlToButton) {
        this.controlToButton = controlToButton;
    }

    @Override
    public void onButtonPressed(String buttonCod) {
        if (buttonCod == null) {
            throw new NullPointerException( "Button can't be null!");
        }
        else {
            controlToButton.get(buttonCod).execute();
        }
    }

    private void executeCommand(Command command) {
        command.execute();
    }
}
