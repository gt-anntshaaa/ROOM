package com.example.roomandflow.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BusSchedule")
data class Schedule(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "Stop_Name") val stopName: String,
    @ColumnInfo(name = "Arrival_Time") val arrivalTime: String
)
