package com.example.projectdanp.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface EntryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEntry(entry: Entry)

    @Query("SELECT * from entry_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Entry>>

    @Query(
        "SELECT * FROM entry_table WHERE amount LIKE :search " +
                "or description LIKE :search " +
                "or currency LIKE :search "
    )
    fun findEntry(search: String): List<Entry>


    @Query("SELECT * FROM entry_table WHERE id = :id")
    fun findOneEntry(id: Int): Entry

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntry(entry: Entry)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateEntry(entity: Entry)

    @Query("DELETE FROM entry_table where id = :id")
    suspend fun deleteEntryById(id: Int)

    @Query("DELETE FROM entry_table")
    suspend fun deleteAllEntries()
}