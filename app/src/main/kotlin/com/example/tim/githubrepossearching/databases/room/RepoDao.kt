package com.example.tim.githubrepossearching.databases.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface RepoDao {

    @Query("SELECT * FROM repo")
    fun getRepos(): List<Repo>

    @Insert()
    fun insert(repo: Repo)

    @Query("DELETE FROM repo")
    fun deleteAll()
}