package com.lap.alexanderprototype.event;

import android.hardware.SensorManager;

import com.lap.alexanderprototype.EventHandler;

/**
 * Created by Lauri on 8.4.2015.
 */
public abstract class Event {
    public abstract void register();
    public abstract void unRegister();

    protected void trigger() {
        EventHandler.getSingleton().triggerEvent(this);
    }
}
