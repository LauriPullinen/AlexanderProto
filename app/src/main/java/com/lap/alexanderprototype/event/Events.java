package com.lap.alexanderprototype.event;

import com.lap.alexanderprototype.R;
import com.lap.alexanderprototype.UIListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lauri on 19.4.2015.
 */
public class Events {
    public static final UIListItem SHAKE =
            new UIListItem(R.drawable.shake, "Shake phone", ShakeEvent.class);

    public static List<UIListItem> getAll() {
        List<UIListItem> events = new ArrayList<>();
        events.add(SHAKE);
        return events;
    }
}
