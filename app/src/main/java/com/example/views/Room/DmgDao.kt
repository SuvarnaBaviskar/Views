package com.example.views.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DmgDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveDmg(dmg:DmgInfo):Long

    @Query("select * from dmg_info")
    fun all():List<DmgInfo>

}
