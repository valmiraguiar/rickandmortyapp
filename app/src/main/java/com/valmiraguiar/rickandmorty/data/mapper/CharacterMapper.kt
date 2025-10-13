package com.valmiraguiar.rickandmorty.data.mapper

import com.valmiraguiar.rickandmorty.data.entities.DataMapper
import com.valmiraguiar.rickandmorty.data.entities.ResultResponse
import com.valmiraguiar.rickandmorty.domain.entity.Character

interface CharacterMapper : DataMapper<List<ResultResponse>, List<Character>>