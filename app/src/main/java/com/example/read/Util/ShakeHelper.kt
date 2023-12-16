package com.example.read.Util

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager


class ShakeHelper(private val mContext: Context) : SensorEventListener {
    private var mSensorManager: SensorManager? = null
    private var mSensor: Sensor? = null
    private val mSpeed = 3000
    private val mInterval = 50
    private var LastTime: Long = 0
    private var LastX = 0f
    private var LastY = 0f
    private var LastZ = 0f
    fun Start() {
        mSensorManager = mContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        if (mSensorManager != null) {
            mSensor = mSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        }
        if (mSensor != null) {
            mSensorManager!!.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_GAME)
        }
    }
    fun Stop() {
        mSensorManager!!.unregisterListener(this)
    }
    override fun onAccuracyChanged(arg0: Sensor, arg1: Int) {}
    override fun onSensorChanged(Event: SensorEvent) {
        val NowTime = System.currentTimeMillis()
        if (NowTime - LastTime < mInterval) return
        LastTime = NowTime
        val NowX = Event.values[0]
        val NowY = Event.values[1]
        val NowZ = Event.values[2]
        val DeltaX = NowX - LastX
        val DeltaY = NowY - LastY
        val DeltaZ = NowZ - LastZ
        LastX = NowX
        LastY = NowY
        LastZ = NowZ
        val NowSpeed =
            Math.sqrt((DeltaX * DeltaX + DeltaY * DeltaY + DeltaZ * DeltaZ).toDouble()) / mInterval * 10000
        if (NowSpeed >= mSpeed) {
            val intent = Intent()
            val cn = ComponentName("tv.danmaku.bili", "tv.danmaku.bili.MainActivityV2")
            intent.setComponent(cn)
            mContext.startActivity(intent)
        }
    }
}