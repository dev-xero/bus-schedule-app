package com.example.busschedule.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class BusScheduleDB : RoomDatabase() {
	abstract fun busScheduleDao(): BusScheduleDao

	companion object {
		@Volatile
		private var INSTANCE: BusScheduleDB? = null

		fun getDatabase(context: Context): BusScheduleDB {
			return INSTANCE ?: synchronized(this) {
				Room.databaseBuilder(
					context,
					BusScheduleDB::class.java,
					"app_database"
				)
					.createFromAsset("database/bus_schedule.db")
					.fallbackToDestructiveMigration()
					.build()
					.also {
						INSTANCE = it
					}
			}
		}
	}
}