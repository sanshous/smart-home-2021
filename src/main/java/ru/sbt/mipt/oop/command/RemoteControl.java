package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.command.Command;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoteControl implements rc.RemoteControl {
    private HashMap<String, Command> controlToButton;

    public void createControl(SmartHome smartHome, String[] buttons) {
        controlToButton.put(buttons[0], new AlarmActivating(smartHome));
        controlToButton.put(buttons[1], new AlarmAlerting(smartHome));
        controlToButton.put(buttons[2], new DoorClosedCommand(smartHome));
        controlToButton.put(buttons[3], new HallLightTurnedOn(smartHome));
        controlToButton.put(buttons[4], new LightTurnedOn(smartHome));
        controlToButton.put(buttons[5], new TurnOffLightCommand(smartHome));
    }

    @Override
    public void onButtonPressed(String buttonCod) {
        controlToButton.get(buttonCod).execute();
    }

    private void executeCommand(Command command) {
        command.execute();
    }
}
