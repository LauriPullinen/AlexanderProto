package com.lap.alexanderprototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.lap.alexanderprototype.action.ActionActivity;
import com.lap.alexanderprototype.action.MusicPlayerNextAction;
import com.lap.alexanderprototype.event.EventActivity;
import com.lap.alexanderprototype.event.ShakeEvent;


public class MainActivity extends Activity {
    private EventActionPairAdapter eventActionListAdapter;

    public void moveToActionList() {
        Intent moveIntent = new Intent(MainActivity.this, ActionActivity.class);
        startActivity(moveIntent);
    }

    public void moveToEventList() {
        Intent moveIntent = new Intent(MainActivity.this, EventActivity.class);
        startActivity(moveIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        // as you specify a parent action in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initializeEventActionArrayView() {
        this.eventActionListAdapter = new EventActionPairAdapter(this,
                android.R.layout.simple_list_item_1,
                EventHandler.getSingleton().getEventActionPairs());

        ListView listView = (ListView) findViewById(R.id.eventActionListView);
        listView.setAdapter(this.eventActionListAdapter);
    }

    private class AddButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EventHandler.getSingleton().addEventActionPair(new EventActionPair());
            eventActionListAdapter.notifyDataSetChanged();
        }
    }
}
