package com.lap.alexanderprototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lauri on 19.4.2015.
 */
public class UIListAdapter extends ArrayAdapter<UIListItem> {
    private int itemViewID;

    public UIListAdapter(Context context, int resource, List<UIListItem> objects, int itemViewID) {
        super(context, resource, objects);
        this.itemViewID = itemViewID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
            view = layoutInflater.inflate(this.itemViewID, null);
        }

        UIListItem item = this.getItem(position);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView name = (TextView) view.findViewById(R.id.name);

        image.setImageResource(item.getImageResourceID());
        name.setText(item.getName());

        return view;
    }
}
