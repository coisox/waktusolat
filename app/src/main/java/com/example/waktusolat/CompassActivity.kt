// src/com/example/waktusolat/CompassActivity.kt
package com.example.waktusolat

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_compass.*

class CompassActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private lateinit var compass: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compass)

        // Initialize sensors
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        compass = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION)!!
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, compass, SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            val degree = event.values[0]
            compassImage.rotation = -degree // Rotate compass image
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}