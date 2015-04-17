package com.lap.alexanderprototype;

import android.util.Log;

import com.lap.alexanderprototype.action.Action;
import com.lap.alexanderprototype.event.Event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Lauri on 8.4.2015.
 */
public class EventHandler {
    // Using list instead of set since the Adapters work well with lists
    private List<EventActionPair> eventActionPairs;

    private static EventHandler singleton;

    static {
        singleton = new EventHandler();
    }

    private EventHandler() {
        this.eventActionPairs = Collections.synchronizedList(new ArrayList<EventActionPair>());
    }

    public static EventHandler getSingleton() {
        return singleton;
    }

    public void addEventActionPair(EventActionPair eventActionPair) {
        Log.d("EventHandler", "Adding event action pair " + eventActionPair);
        this.eventActionPairs.add(eventActionPair);
    }

    public List<EventActionPair> getEventActionPairs() {
        return this.eventActionPairs;
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
}
