package ru.sbt.mipt.oop;

public class RoomAndThing<T> {
    private Room room;
    private Thing thing;

    public RoomAndThing(Room room, Thing thing) {
        this.room = room;
        this.thing = thing;
    }

    public Thing getThing() {
        return thing;
    }

    public Room getRoom(){
        return room;
    }
}
