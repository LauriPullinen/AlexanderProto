package com.lap.alexanderprototype.event;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lap.alexanderprototype.AlexanderPrototype;
import com.lap.alexanderprototype.EventHandler;
import com.lap.alexanderprototype.MainActivity;
import com.lap.alexanderprototype.R;
import com.lap.alexanderprototype.UIListAdapter;
import com.lap.alexanderprototype.UIListItem;
import com.lap.alexanderprototype.UIListItemActivity;

import java.util.List;

public class EventActivity extends UIListItemActivity {
    public EventActivity() {
        super(Events.getAll(), AlexanderPrototype.CHOSEN_EVENT);
    }

    @Override
    protected View getView() {
        return findViewById(R.id.event_list);
    }

    @Override
    protected int getContentViewID() {
        return R.layout.activity_events;
    }

    @Override
    protected int getItemViewID() {
        return R.layout.event;
    }
}
