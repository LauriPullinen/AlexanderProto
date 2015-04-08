package com.lap.alexanderprototype;

import com.lap.alexanderprototype.action.Action;
import com.lap.alexanderprototype.event.Event;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Lauri on 8.4.2015.
 */
public class EventHandler {
    private Set<EventActionPair> eventActionPairs;

    private static EventHandler singleton;

    static {
        singleton = new EventHandler();
    }

    private EventHandler() {
        this.eventActionPairs = Collections.synchronizedSet(new TreeSet<EventActionPair>());
    }

    public static EventHandler getSingleton() {
        return singleton;
    }

    public void addEventActionPair(Event event, Action action) {
        this.eventActionPairs.add(new EventActionPair(event, action));
    }

    public void removeEventActionPair(Event event, Action action) {
        this.eventActionPairs.remove(new EventActionPair(event, action));
    }

    public void triggerEvent(Event event) {
        synchronized (this.eventActionPairs) {
            for (EventActionPair eventActionPair : this.eventActionPairs) {
                if (event.equals(eventActionPair.getEvent())) {
                    eventActionPair.getAction().commit();
                }
            }
        }
    }

    private static class EventActionPair {
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
    }
}
