package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventProcessors.Action;
import ru.sbt.mipt.oop.EventProcessors.Actionable;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public void setOpen(boolean open) {
        this.isOpen = open;
    }

    public String getId(){ return this.id; }

    public boolean getIsOpen(){ return this.isOpen; }

    @Override
    public void execute(Action action) {
        action.act(this);
    }
}
