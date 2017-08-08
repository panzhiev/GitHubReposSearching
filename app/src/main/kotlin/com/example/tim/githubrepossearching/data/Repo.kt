package id.kotlin.sample.room.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Repo constructor(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long,
                            @ColumnInfo(name = "repo_id") val repoId: Long,
                            @ColumnInfo(name = "user_name") val userName: String,
                            @ColumnInfo(name = "url") val url: String)