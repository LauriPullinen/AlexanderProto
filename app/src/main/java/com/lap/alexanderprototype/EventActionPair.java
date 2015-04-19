package com.lap.alexanderprototype;

import com.lap.alexanderprototype.action.Action;
import com.lap.alexanderprototype.event.Event;

/**
 * Created by lauripullinen on 15-4-13.
 */
public class EventActionPair {
    private Event event;
    private Action action;

    public EventActionPair() {
        this.event = null;
        this.action = null;
    }

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

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String toString() {
        return "EventActionPair: " + this.event.toString() + " " + this.action.toString();
    }
}
