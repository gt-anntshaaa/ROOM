package com.example.roomandflow.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomandflow.data.local.Schedule
import com.example.roomandflow.data.local.ScheduleDao

@Database (entities = arrayOf(Schedule::class), version = 1)
abstract class ScheduleDatabase : RoomDatabase() {
    abstract fun scheduleDao() : ScheduleDao

    companion object{
        @Volatile
        private var INSTANCE: ScheduleDatabase? = null

        fun getDatabase(context: Context) : ScheduleDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    ScheduleDatabase::class.java,
                    "app_database"
                ).build()

                INSTANCE = instance
                instance
            }

        }
    }
}