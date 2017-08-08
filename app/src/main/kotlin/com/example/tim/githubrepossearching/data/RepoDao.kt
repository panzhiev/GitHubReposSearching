package id.kotlin.sample.room.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface RepoDao {

    @Query("SELECT * FROM Repo")
    fun findAll(): List<Repo>

    @Insert()
    fun insertRepos(userList: List<Repo>)


    @Delete
    fun deleteUser()
}