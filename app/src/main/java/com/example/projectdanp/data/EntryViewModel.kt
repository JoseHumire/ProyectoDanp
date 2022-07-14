package com.example.projectdanp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class EntryViewModel(application: Application): AndroidViewModel(application) {

    private val entryRepository: EntryRepository = EntryRepository(
        totalCount = 67, pageSize = 12, application
    )

    val searchResults: MutableLiveData<List<Entry>> = entryRepository.searchResults

    val allEntry = fetchAllEntry()
    fun fetchAllEntry(): Flow<PagingData<Entry>> {
        return Pager(PagingConfig(pageSize = entryRepository.pageSize)) {
            EntrySource(entryRepository)
        }.flow
    }


    fun readAllData(): LiveData<List<Entry>> {
        return entryRepository.readAllData
    }

    fun insertEntry(entry: Entry) {
        viewModelScope.launch {
            entryRepository.addEntry(entry = entry)
        }

    }

    fun findEntry(text: String) {
        viewModelScope.launch {
            entryRepository.findEntry(text)
        }

    }

    fun updateEntry(entry: Entry) {
        viewModelScope.launch {
            entryRepository.updateEntry(entry = entry)
        }

    }

    fun findEntryById(id: Int) {
        viewModelScope.launch {
            entryRepository.findEntryById(id)
        }
    }

    fun deleteEntryById(id: Int) {
        viewModelScope.launch {
            entryRepository.deleteEntryById(id)
        }
    }

    fun deleteAllEntry() {
        viewModelScope.launch {
            entryRepository.deleteAllEntries()
        }
    }

}