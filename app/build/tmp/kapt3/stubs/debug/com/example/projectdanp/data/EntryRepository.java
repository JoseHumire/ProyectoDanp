package com.example.projectdanp.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0011\u0010!\u001a\u00020\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010\'\u001a\u00020 J\u0019\u0010(\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010*\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J\u0019\u0010+\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lcom/example/projectdanp/data/EntryRepository;", "", "totalCount", "", "pageSize", "application", "Landroid/app/Application;", "(IILandroid/app/Application;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "entryDao", "Lcom/example/projectdanp/data/EntryDao;", "getPageSize", "()I", "readAllData", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/projectdanp/data/Entry;", "getReadAllData", "()Landroidx/lifecycle/LiveData;", "searchResults", "Landroidx/lifecycle/MutableLiveData;", "getSearchResults", "()Landroidx/lifecycle/MutableLiveData;", "getTotalCount", "addEntry", "", "entry", "(Lcom/example/projectdanp/data/Entry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asyncFind", "Lkotlinx/coroutines/Deferred;", "name", "", "deleteAllEntries", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteEntryById", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findEntry", "text", "findEntryById", "getPaginatedData", "page", "updateEntry", "app_debug"})
public final class EntryRepository {
    private final int totalCount = 0;
    private final int pageSize = 0;
    private com.example.projectdanp.data.EntryDao entryDao;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.projectdanp.data.Entry>> searchResults = null;
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.projectdanp.data.Entry>> readAllData = null;
    
    public EntryRepository(int totalCount, int pageSize, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
    
    public final int getTotalCount() {
        return 0;
    }
    
    public final int getPageSize() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.example.projectdanp.data.Entry>> getSearchResults() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.projectdanp.data.Entry>> getReadAllData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPaginatedData(int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.projectdanp.data.Entry>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addEntry(@org.jetbrains.annotations.NotNull()
    com.example.projectdanp.data.Entry entry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateEntry(@org.jetbrains.annotations.NotNull()
    com.example.projectdanp.data.Entry entry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object findEntryById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteEntryById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAllEntries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final void findEntry(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    private final kotlinx.coroutines.Deferred<java.util.List<com.example.projectdanp.data.Entry>> asyncFind(java.lang.String name) {
        return null;
    }
}