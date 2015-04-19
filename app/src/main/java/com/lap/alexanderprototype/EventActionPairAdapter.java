package com.lap.alexanderprototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import java.util.List;

/**
 * Created by lauripullinen on 15-4-15.
 */
public class EventActionPairAdapter extends ArrayAdapter<EventActionPair> {
    private MainActivity mainActivity;

    public EventActionPairAdapter(MainActivity context, int resource, List<EventActionPair> list) {
        super(context, resource, list);
        this.mainActivity = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
            view = layoutInflater.inflate(R.layout.event_action_pair, null);
        }

        EventActionPair eventActionPair = this.getItem(position);

        ImageButton eventButton = (ImageButton) view.findViewById(R.id.event_button);
        ImageButton actionButton = (ImageButton) view.findViewById(R.id.action_button);

        int eventImageResourceID = R.drawable.placeholder;
        int actionImageResourceID = R.drawable.placeholder;
        if(eventActionPair.getAction() != null) {
            actionImageResourceID = eventActionPair.getAction().getUIListItem().getImageResourceID();
        }
        if(eventActionPair.getEvent() != null) {
            eventImageResourceID = eventActionPair.getEvent().getUIListItem().getImageResourceID();
        }
        actionButton.setImageResource(actionImageResourceID);
        eventButton.setImageResource(eventImageResourceID);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlexanderPrototype.getSingleton().setChosenAction(position);
                mainActivity.moveToActionList();
            }
        });
        eventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlexanderPrototype.getSingleton().setChosenEvent(position);
                mainActivity.moveToEventList();
            }
        });

        return view;
    }
}
