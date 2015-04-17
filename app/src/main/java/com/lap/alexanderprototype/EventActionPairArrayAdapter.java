package com.lap.alexanderprototype;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by lauripullinen on 15-4-15.
 */
public class EventActionPairArrayAdapter extends ArrayAdapter<EventActionPair> {
    public EventActionPairArrayAdapter(Context context, int resource, List<EventActionPair> list) {
        super(context, resource, list);
    }
}
