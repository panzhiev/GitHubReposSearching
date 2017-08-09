package com.example.tim.githubrepossearching

import android.app.Application
import android.arch.persistence.room.Room
import com.example.tim.githubrepossearching.databases.room.RepoDatabase

/**
 * Created by TIM on 08.08.17.
 */
class App : Application() {

    companion object {
        var database: RepoDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(applicationContext, RepoDatabase::class.java, "repo-db").build()
    }
}
