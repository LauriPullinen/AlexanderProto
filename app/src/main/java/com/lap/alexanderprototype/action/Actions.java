package com.lap.alexanderprototype.action;

import com.lap.alexanderprototype.R;
import com.lap.alexanderprototype.UIListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lauri on 19.4.2015.
 */
public class Actions {
    public static final UIListItem MUSIC_PLAYER_NEXT =
            new UIListItem(R.drawable.music_player_next, "Skip to next song", MusicPlayerNextAction.class);

    public static List<UIListItem> getAll() {
        List<UIListItem> actions = new ArrayList<>();
        actions.add(MUSIC_PLAYER_NEXT);
        return actions;
    }
}
