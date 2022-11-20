package com.example.roomandflow.data.database

import android.app.Application

class ScheduleApplication : Application() {
    val database: ScheduleDatabase by lazy{
        ScheduleDatabase.getDatabase(this)
    }
}