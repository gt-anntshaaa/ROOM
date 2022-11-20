package com.example.roomandflow.data.viewmodel

import androidx.lifecycle.ViewModel
import com.example.roomandflow.data.local.Schedule
import com.example.roomandflow.data.local.ScheduleDao

class BusScheduleViewModel(private val scheduleDao: ScheduleDao) : ViewModel() {
    fun fullSchedule(): List<Schedule> = scheduleDao.getAllSchedule()
}