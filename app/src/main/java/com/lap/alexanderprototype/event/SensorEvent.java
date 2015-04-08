package com.lap.alexanderprototype.event;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by Lauri on 8.4.2015.
 */
public abstract class SensorEvent extends Event implements SensorEventListener {
    SensorManager manager;
    Sensor sensor;

    public SensorEvent(SensorManager manager, Sensor sensor) {
        this.manager = manager;
        this.sensor = sensor;
    }

    @Override
    public void register() {
        this.manager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void unRegister() {
        this.manager.unregisterListener(this);
    }

    @Override
    public abstract void onSensorChanged(android.hardware.SensorEvent event);

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}
