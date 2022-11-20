package com.example.roomandflow.data.local

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ScheduleDao {
    @Query("SELECT * FROM BusSchedule")
    fun getAllSchedule(): List<Schedule>
}