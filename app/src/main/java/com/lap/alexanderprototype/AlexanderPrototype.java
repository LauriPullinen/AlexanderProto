package com.lap.alexanderprototype;

import android.app.Application;
import android.hardware.SensorManager;

/**
 * Created by Lauri on 17.4.2015.
 */
public class AlexanderPrototype extends Application {
    private SensorManager sensorManager;

    private static AlexanderPrototype singleton;

    public static AlexanderPrototype getSingleton() {
        return singleton;
    }

    public SensorManager getSensorManager() {
        return sensorManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        singleton = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        EventHandler.getSingleton().removeAllEventActionPairs();
    }
}
