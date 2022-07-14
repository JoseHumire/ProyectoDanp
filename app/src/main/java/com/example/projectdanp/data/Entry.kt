package com.example.projectdanp.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "entry_table")
data class Entry(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val day: Int,
    val month: Int,
    val year: Int,
    val amount: Double,
    val isIncome: Boolean,
    val description: String,
    val currency: String,
)
