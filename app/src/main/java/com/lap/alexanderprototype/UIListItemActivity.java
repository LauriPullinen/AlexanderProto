package com.lap.alexanderprototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lap.alexanderprototype.event.Event;
import com.lap.alexanderprototype.event.Events;

import java.util.List;

/**
 * Created by Lauri on 20.4.2015.
 */
public abstract class UIListItemActivity extends Activity {
    private UIListAdapter adapter;
    private List<UIListItem> data;
    private String itemID;
    private int itemPosition;

    public UIListItemActivity(List<UIListItem> data, String itemID) {
        this.data = data;
        this.itemID = itemID;
    }

    protected abstract View getView();
    protected abstract int getContentViewID();
    protected abstract int getItemViewID();

    public void moveToMain() {
        Intent moveIntent = new Intent(this, MainActivity.class);
        startActivity(moveIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            this.itemPosition = extras.getInt(this.itemID);
        }
        setContentView(getContentViewID());

        this.adapter = new UIListAdapter(this,
                android.R.layout.simple_list_item_1,
                this.data,
                this.getItemViewID());

        ListView listView = (ListView) getView();
        listView.setAdapter(this.adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UIListItem item = adapter.getItem(position);
                Log.d("UIListItemActivity", item.toString());
                EventHandler.getSingleton().setItem(itemPosition, item.getItem());
                moveToMain();
            }
        });
    }
}
