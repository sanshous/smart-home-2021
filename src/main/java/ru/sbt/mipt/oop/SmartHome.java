package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class SmartHome {
    Collection<Room> rooms;

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

    public enum changeThing{
        LIGHT {
            RoomAndThing changeThingSmartHome(String id, boolean b, SmartHome smartHome) {
                for (Room room : smartHome.getRooms()) {
                    for (Thing thing : room.getLights()) {
                        if (thing.getId().equals(id)) {
                            thing.setOn(b);
                            RoomAndThing r = new RoomAndThing(room, thing);
                            return r;
                        }
                    }
                }
                return null;
            }
        },
        DOOR {
            RoomAndThing changeThingSmartHome(String id, boolean b, SmartHome smartHome) {
                for (Room room : smartHome.getRooms()) {
                    for (Thing thing : room.getDoors()) {
                        if (thing.getId().equals(id)) {
                            thing.setOn(b);
                            RoomAndThing r = new RoomAndThing(room, thing);
                            return r;
                        }
                    }
                }
                return null;
            }
        };

        abstract RoomAndThing changeThingSmartHome(String id, boolean b, SmartHome smartHome);
    }
}
