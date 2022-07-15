package com.example.projectdanp.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\bJ\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f0\u001fJ\u000e\u0010 \u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006!"}, d2 = {"Lcom/example/projectdanp/data/EntryViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "allEntry", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/example/projectdanp/data/Entry;", "getAllEntry", "()Lkotlinx/coroutines/flow/Flow;", "entryRepository", "Lcom/example/projectdanp/data/EntryRepository;", "searchResults", "Landroidx/lifecycle/MutableLiveData;", "", "getSearchResults", "()Landroidx/lifecycle/MutableLiveData;", "deleteAllEntry", "", "deleteEntryById", "id", "", "fetchAllEntry", "findEntry", "text", "", "findEntryById", "insertEntry", "entry", "readAllData", "Landroidx/lifecycle/LiveData;", "updateEntry", "app_debug"})
public final class EntryViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.example.projectdanp.data.EntryRepository entryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.projectdanp.data.Entry>> searchResults = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.projectdanp.data.Entry>> allEntry = null;
    
    public EntryViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.example.projectdanp.data.Entry>> getSearchResults() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.projectdanp.data.Entry>> getAllEntry() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.projectdanp.data.Entry>> fetchAllEntry() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.projectdanp.data.Entry>> readAllData() {
        return null;
    }
    
    public final void insertEntry(@org.jetbrains.annotations.NotNull()
    com.example.projectdanp.data.Entry entry) {
    }
    
    public final void findEntry(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void updateEntry(@org.jetbrains.annotations.NotNull()
    com.example.projectdanp.data.Entry entry) {
    }
    
    public final void findEntryById(int id) {
    }
    
    public final void deleteEntryById(int id) {
    }
    
    public final void deleteAllEntry() {
    }
}