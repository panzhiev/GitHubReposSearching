package com.example.tim.githubrepossearching.databases.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Repo::class), version = 2, exportSchema = false)
abstract class RepoDatabase : RoomDatabase() {

    abstract fun repoDao(): RepoDao
}