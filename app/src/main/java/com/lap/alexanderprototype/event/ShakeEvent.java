package com.lap.alexanderprototype.event;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Log;

import com.lap.alexanderprototype.AlexanderPrototype;
import com.lap.alexanderprototype.R;
import com.lap.alexanderprototype.UIListItem;

/**
 * Created by Lauri on 8.4.2015.
 */
public class ShakeEvent extends SensorEvent {
    private float lastX;
    private float lastY;
    private float lastZ;
    private long lastShake;
    private long lastUpdate;

    private static final int MIN_SHAKE_DELAY = 500;
    private static final double SHAKE_THRESHOLD = 0.5;

    public ShakeEvent() {
        this(AlexanderPrototype.getSingleton().getSensorManager());
    }

    public ShakeEvent(SensorManager manager) {
        super(manager, manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));

        this.lastX = this.lastY = this.lastZ = 0.0f;
        this.lastShake = 0;
        this.lastUpdate = 0;
    }

    @Override
    public UIListItem getUIListItem() {
        return Events.SHAKE;
    }

    @Override
    public void onSensorChanged(android.hardware.SensorEvent event) {
        Sensor sensor = event.sensor;
        long currentTime = System.currentTimeMillis();
        if(sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            long sinceLastShake = currentTime - this.lastShake;
            long sinceLastUpdate = currentTime - this.lastUpdate;
            if(sinceLastShake > MIN_SHAKE_DELAY && sinceLastUpdate > 0) {
                double shakeSpeed = Math.sqrt(square(x - this.lastX) +
                        square(y - this.lastY) +
                        square(z - this.lastZ)) / sinceLastUpdate;
                if(shakeSpeed > SHAKE_THRESHOLD) {
                    Log.d("ShakeEvent", String.format("Shake speed: %.2f threshold: %.2f",
                            shakeSpeed, SHAKE_THRESHOLD));
                    this.trigger();
                    this.lastShake = currentTime;
                }
            }
            this.lastX = x;
            this.lastY = y;
            this.lastZ = z;
        } else {
            Log.e("ShakeEvent", "Wrong type of sensor: " + sensor.getType());
        }
        this.lastUpdate = currentTime;
    }

    @Override
    public String toString() {
        return String.format("ShakeEvent %.2f,%.2f,%.2f", this.lastX, this.lastY, this.lastZ);
    }

    private float square(float number) {
        return number * number;
    }
}
