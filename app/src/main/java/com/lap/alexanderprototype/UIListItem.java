package com.lap.alexanderprototype;

import android.util.Log;

/**
 * Created by Lauri on 19.4.2015.
 */
public class UIListItem {
    private int imageResourceID;
    private String name;
    private Class<?> itemClass;

    public UIListItem(int imageResourceID, String name, Class<?> itemClass) {
        this.imageResourceID = imageResourceID;
        this.name = name;
        this.itemClass = itemClass;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public String getName() {
        return name;
    }

    public Object getItem() {
        try {
            return this.itemClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            Log.e("UIListItem", "Error instantiating class");
            e.printStackTrace();
        }
        return null;
    }

    public String toString() {
        return "UIListItem img: " + imageResourceID + " name: " + name + " class: " + itemClass;
    }
}
