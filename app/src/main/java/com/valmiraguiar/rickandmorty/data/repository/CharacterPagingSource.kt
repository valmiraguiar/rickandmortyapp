package com.valmiraguiar.rickandmorty.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.valmiraguiar.rickandmorty.data.mapper.CharacterMapper
import com.valmiraguiar.rickandmorty.data.remote.RickAndMortyApi
import com.valmiraguiar.rickandmorty.domain.entity.Character

class CharacterPagingSource(
    private val api: RickAndMortyApi,
    private val mapper: CharacterMapper,
) : PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchor ->
            state
                .closestPageToPosition(anchor)
                ?.prevKey
                ?.plus(ONE) ?: state
                    .closestPageToPosition(anchor)
                    ?.nextKey
                    ?.minus(ONE)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val page = params.key ?: ONE

        return try {
            val response = requireNotNull(api.getCharacters(page).body()?.results)
            val mappedResponse = mapper.convert(response)

            val nextKey = if (mappedResponse.isEmpty()) null else page + ONE
            LoadResult.Page(
                data = mappedResponse,
                prevKey = if (page == ONE) null else page - ONE,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private companion object {
        const val ONE = 1
    }
}