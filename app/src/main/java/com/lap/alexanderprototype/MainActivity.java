package com.lap.alexanderprototype;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.lap.alexanderprototype.action.MusicPlayerNextAction;
import com.lap.alexanderprototype.event.ShakeEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class MainActivity extends Activity {
    private SensorManager sensorManager;
    private EventActionPairArrayAdapter eventActionListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Running onCreate");

        this.sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        initializeEventActionArrayView();

        Button addButton = (Button) findViewById(R.id.addEventActionPair);
        addButton.setOnClickListener(new AddButtonListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initializeEventActionArrayView() {
        this.eventActionListAdapter = new EventActionPairArrayAdapter(this,
                android.R.layout.simple_list_item_1, EventHandler.getSingleton().getEventActionPairs());

        ListView listView = (ListView) findViewById(R.id.eventActionListView);
        listView.setAdapter(this.eventActionListAdapter);
    }

    private class AddButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EventHandler.getSingleton().addEventActionPair(
                    new EventActionPair(new ShakeEvent(sensorManager), new MusicPlayerNextAction())
            );
            eventActionListAdapter.notifyDataSetChanged();
        }
    }
}
