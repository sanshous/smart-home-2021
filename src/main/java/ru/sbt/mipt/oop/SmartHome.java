package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.AlarmEvent.Alarm;
import ru.sbt.mipt.oop.EventProcessors.Action;
import ru.sbt.mipt.oop.EventProcessors.Actionable;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    private Collection<Room> rooms;

    private Alarm alarm;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public Alarm getAlarm() { return alarm; }

    @Override
    public void execute(Action action) {
        action.act(this);
        for (Room room: rooms)
            room.execute(action);
    }
}
