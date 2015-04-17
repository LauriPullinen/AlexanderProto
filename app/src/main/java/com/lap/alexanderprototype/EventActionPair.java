package com.lap.alexanderprototype;

import com.lap.alexanderprototype.action.Action;
import com.lap.alexanderprototype.event.Event;

/**
 * Created by lauripullinen on 15-4-13.
 */
public class EventActionPair {
    private Event event;
    private Action action;

    public EventActionPair(Event event, Action action) {
        this.event = event;
        this.action = action;
    }

    public Event getEvent() {
        return event;
    }

    public Action getAction() {
        return action;
    }

    public String toString() {
        return "EventActionPair: " + this.event.toString() + " " + this.action.toString();
    }
}
