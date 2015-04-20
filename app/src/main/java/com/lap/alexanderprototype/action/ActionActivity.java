package com.lap.alexanderprototype.action;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lap.alexanderprototype.AlexanderPrototype;
import com.lap.alexanderprototype.EventActionPair;
import com.lap.alexanderprototype.EventHandler;
import com.lap.alexanderprototype.MainActivity;
import com.lap.alexanderprototype.R;
import com.lap.alexanderprototype.UIListAdapter;
import com.lap.alexanderprototype.UIListItem;
import com.lap.alexanderprototype.UIListItemActivity;
import com.lap.alexanderprototype.event.Event;
import com.lap.alexanderprototype.event.Events;

import java.util.List;

public class ActionActivity extends UIListItemActivity {
    public ActionActivity() {
        super(Actions.getAll(), AlexanderPrototype.CHOSEN_ACTION);
    }

    @Override
    protected View getView() {
        return findViewById(R.id.action_list);
    }

    @Override
    protected int getContentViewID() {
        return R.layout.activity_actions;
    }

    @Override
    protected int getItemViewID() {
        return R.layout.action;
    }
}
