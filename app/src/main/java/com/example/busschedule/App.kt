package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.BusScheduleDB

class App : Application() {
	val database: BusScheduleDB by lazy {
		BusScheduleDB.getDatabase(this)
	}
}