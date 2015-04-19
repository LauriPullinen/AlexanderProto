package com.lap.alexanderprototype.action;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.view.KeyEvent;

import com.lap.alexanderprototype.AlexanderPrototype;
import com.lap.alexanderprototype.R;
import com.lap.alexanderprototype.UIListItem;

/**
 * Created by lauripullinen on 15-4-13.
 */
public class MusicPlayerNextAction implements Action {
    public void commit() {
        Intent skipIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        synchronized (this) {
            Context context = AlexanderPrototype.getSingleton();
            skipIntent.putExtra(Intent.EXTRA_KEY_EVENT,
                    new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT));
            context.sendOrderedBroadcast(skipIntent, null);
            skipIntent.putExtra(Intent.EXTRA_KEY_EVENT,
                    new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_NEXT));
            context.sendOrderedBroadcast(skipIntent, null);
        }
    }

    @Override
    public UIListItem getUIListItem() {
        return Actions.MUSIC_PLAYER_NEXT;
    }

    @Override
    public String toString() {
        return "MusicPlayerNextAction";
    }
}
