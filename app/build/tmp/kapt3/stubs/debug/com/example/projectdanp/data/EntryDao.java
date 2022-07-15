package com.example.projectdanp.data;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\'J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\'J\u0019\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\u0014H\'J\u0019\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/example/projectdanp/data/EntryDao;", "", "addEntry", "", "entry", "Lcom/example/projectdanp/data/Entry;", "(Lcom/example/projectdanp/data/Entry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllEntries", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteEntryById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findEntry", "", "search", "", "findOneEntry", "insertEntry", "readAllData", "Landroidx/lifecycle/LiveData;", "updateEntry", "entity", "app_debug"})
public abstract interface EntryDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract java.lang.Object addEntry(@org.jetbrains.annotations.NotNull()
    com.example.projectdanp.data.Entry entry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * from entry_table ORDER BY id ASC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.projectdanp.data.Entry>> readAllData();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM entry_table WHERE amount LIKE :search or description LIKE :search or currency LIKE :search ")
    public abstract java.util.List<com.example.projectdanp.data.Entry> findEntry(@org.jetbrains.annotations.NotNull()
    java.lang.String search);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM entry_table WHERE id = :id")
    public abstract com.example.projectdanp.data.Entry findOneEntry(int id);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insertEntry(@org.jetbrains.annotations.NotNull()
    com.example.projectdanp.data.Entry entry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object updateEntry(@org.jetbrains.annotations.NotNull()
    com.example.projectdanp.data.Entry entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM entry_table where id = :id")
    public abstract java.lang.Object deleteEntryById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM entry_table")
    public abstract java.lang.Object deleteAllEntries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}