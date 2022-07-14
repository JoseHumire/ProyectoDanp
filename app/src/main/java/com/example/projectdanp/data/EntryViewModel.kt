package com.example.projectdanp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EntryViewModel(application: Application): AndroidViewModel(application) {

    private val entryRepository: EntryRepository = EntryRepository(application)

    val searchResults: MutableLiveData<List<Entry>> = entryRepository.searchResults

    fun fetchAllEntry(): LiveData<List<Entry>> {
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