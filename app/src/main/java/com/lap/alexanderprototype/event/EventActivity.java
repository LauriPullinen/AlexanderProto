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
import com.lap.alexanderprototype.EventActionPair;
import com.lap.alexanderprototype.EventActionPairAdapter;
import com.lap.alexanderprototype.EventHandler;
import com.lap.alexanderprototype.MainActivity;
import com.lap.alexanderprototype.R;
import com.lap.alexanderprototype.UIListAdapter;
import com.lap.alexanderprototype.UIListItem;

public class EventActivity extends ActionBarActivity {
    private UIListAdapter adapter;

    public void moveToMain() {
        Intent moveIntent = new Intent(EventActivity.this, MainActivity.class);
        startActivity(moveIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        this.adapter = new UIListAdapter(this,
                android.R.layout.simple_list_item_1,
                Events.getAll(),
                R.layout.event);

        ListView listView = (ListView) findViewById(R.id.event_list);
        listView.setAdapter(this.adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UIListItem item = adapter.getItem(position);
                Log.d("EventActivity", item.toString());
                EventHandler.getSingleton().setEvent(AlexanderPrototype.getSingleton().getChosenEvent(),
                        (Event) item.getItem());
                moveToMain();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent action in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
