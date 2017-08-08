package com.example.tim.githubrepossearching

import android.app.Application
import android.arch.persistence.room.Room
import id.kotlin.sample.room.data.RepoDatabase

/**
 * Created by lekar on 08.08.17.
 */
class App: Application() {

    companion object {
        var database: RepoDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        App.database =  Room.databaseBuilder(this, RepoDatabase::class.java, "we-need-db").build()
    }
}
