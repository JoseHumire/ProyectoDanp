package com.example.projectdanp.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class EntryRepository(val totalCount: Int, val pageSize: Int, application: Application) {
    private var entryDao: EntryDao
    val searchResults = MutableLiveData<List<Entry>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    init {
        val database = MyDatabase.getDatabase(application)
        entryDao = database.entryDao()
    }

    val readAllData: LiveData<List<Entry>> = entryDao.readAllData()

    suspend fun getPaginatedData(page: Int): List<Entry> {

        val startIndex = (page - 1) * pageSize + 1
        var endIndex = startIndex + pageSize - 1
        if (endIndex > totalCount) {
            endIndex = totalCount
        }
        delay(3000)

        return (startIndex..endIndex).map { index -> readAllData.value!![index] }

    }

    suspend fun addEntry(entry: Entry) {
        entryDao.addEntry(entry)
    }
    suspend fun updateEntry(entry: Entry) {
        entryDao.updateEntry(entry)
    }
    suspend fun findEntryById(id: Int){
        entryDao.findOneEntry(id)
    }
    suspend fun deleteEntryById(id: Int){
        entryDao.deleteEntryById(id)
    }
    suspend fun deleteAllEntries(){
        entryDao.deleteAllEntries()
    }

    fun findEntry(text: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(text).await()
        }
    }

    private fun asyncFind(name: String): Deferred<List<Entry>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async entryDao.findEntry(name)
        }
}