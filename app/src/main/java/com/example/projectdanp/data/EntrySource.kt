package com.example.projectdanp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState

class EntrySource (private val repository: EntryRepository) : PagingSource<Int, Entry>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Entry> {
        return try {
            val page = params.key ?: 1
            val paginatedData = repository.getPaginatedData(page)

            LoadResult.Page(
                data = paginatedData,
                prevKey = if (page == 1) null else page - 1,
                nextKey =  if (paginatedData.isEmpty()) null else page + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, Entry>): Int? {
        return state.anchorPosition
    }
}