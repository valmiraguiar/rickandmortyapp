//TEMPLATE

//package com.valmiraguiar.rickandmorty.data.remote
//
//import androidx.paging.ExperimentalPagingApi
//import androidx.paging.LoadType
//import androidx.paging.PagingState
//import androidx.paging.RemoteMediator
//import com.valmiraguiar.rickandmorty.data.entities.CharacterResponse
//
//@OptIn(ExperimentalPagingApi::class)
//class CharacterRemoteMediator(
//    private val api: RickAndMortyApi
//) : RemoteMediator<Int, CharacterResponse>() {
//    override suspend fun load(
//        loadType: LoadType,
//        state: PagingState<Int, CharacterResponse>
//    ): MediatorResult {
//        val page = when (loadType) {
//            LoadType.REFRESH -> FIRST_PAGE
//            LoadType.PREPEND -> onPrepend()
//            LoadType.APPEND -> APPEND
//        }
//
//
//        val lastItem = state.lastItemOrNull()
//        val response = if (page == APPEND && lastItem?.info?.next != null) requireNotNull(
//            api.getCharactersFromPage(lastItem.info.next).body()?.results
//        ) else requireNotNull(api.getCharacters().body()?.results)
//
//        /* TODO - DO DATABASE OPTION
//
//        try {
//            val response = api.articles(page = page, pageSize = state.config.pageSize)
//            val entities = response.items.map { dto ->
//                ArticleEntity(id = dto.id, title = dto.title, body = dto.body, page = page)
//            }
//            db.withTransaction {
//                if (loadType == LoadType.REFRESH) {
//                    dao.clearAll()
//                }
//                dao.insertAll(entities)
//            }
//            return MediatorResult.Success(endOfPaginationReached = response.items.isEmpty())
//        } catch (e: IOException) {
//            return MediatorResult.Error(e)
//        } catch (e: HttpException) {
//            return MediatorResult.Error(e)
//        }
//         */
//        return MediatorResult.Success(endOfPaginationReached = response.isEmpty())
//    }
//
//
//    private fun onPrepend() = MediatorResult.Success(
//        endOfPaginationReached = true
//    )
//
//    private fun onAppend(state: PagingState<Int, CharacterResponse>) {
//        val lastItem = state.lastItemOrNull()
//        if (lastItem == null) {
//            1
//        } else {
//            state.pages
//        }
//    }
//
//    private companion object {
//        const val FIRST_PAGE = 1
//        const val APPEND = 2
//    }
//}