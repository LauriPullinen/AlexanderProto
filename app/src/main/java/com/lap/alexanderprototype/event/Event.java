package com.lap.alexanderprototype.event;

import android.hardware.SensorManager;

import com.lap.alexanderprototype.EventHandler;
import com.lap.alexanderprototype.R;
import com.lap.alexanderprototype.UIListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lauri on 8.4.2015.
 */
public abstract class Event {
    public abstract void register();
    public abstract void unRegister();

    public abstract UIListItem getUIListItem();

    protected void trigger() {
        EventHandler.getSingleton().triggerEvent(this);
    }
}
