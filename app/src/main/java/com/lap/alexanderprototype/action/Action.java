package com.lap.alexanderprototype.action;

import android.app.Activity;

import com.lap.alexanderprototype.UIListItem;

/**
 * Created by Lauri on 8.4.2015.
 */
public interface Action {
    public void commit();
    public abstract UIListItem getUIListItem();
}
