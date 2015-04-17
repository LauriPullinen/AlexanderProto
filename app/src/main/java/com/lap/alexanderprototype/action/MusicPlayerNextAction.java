package com.lap.alexanderprototype.action;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;

/**
 * Created by lauripullinen on 15-4-13.
 */
public class MusicPlayerNextAction extends Activity implements Action {
    public void commit() {
        Intent skipIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        synchronized (this) {
            skipIntent.putExtra(Intent.EXTRA_KEY_EVENT,
                    new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT));
            sendOrderedBroadcast(skipIntent, null);
            skipIntent.putExtra(Intent.EXTRA_KEY_EVENT,
                    new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_NEXT));
            sendOrderedBroadcast(skipIntent, null);
        }
    }

    @Override
    public String toString() {
        return "MusicPlayerNextAction";
    }
}
