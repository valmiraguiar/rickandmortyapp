package com.valmiraguiar.rickandmorty.data.mapper

import com.valmiraguiar.rickandmorty.data.entities.CharacterResponse
import com.valmiraguiar.rickandmorty.data.entities.DataMapper
import com.valmiraguiar.rickandmorty.domain.entity.Character

interface CharacterListMapper : DataMapper<List<CharacterResponse>, List<Character>>