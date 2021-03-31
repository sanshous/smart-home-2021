package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.EventProcessors.Action;

public interface Actionable {
    void execute( Action action );
}
