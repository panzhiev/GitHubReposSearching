package com.example.tim.githubrepossearching.databases.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "repo")
data class Repo (
//        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long,
        @PrimaryKey var id: Int = 0,
        @ColumnInfo(name = "name") var name: String = "",
        @ColumnInfo(name = "htmlUrl") var htmlUrl: String = ""
)