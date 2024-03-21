package com.example.healingservice.model.pokemon;

import com.example.healingservice.model.dex.PokeDexEntry;

public sealed interface Pokemon permits SingleTypePokemon, DoubleTypePokemon {

  PokeDexEntry pokeDexEntry();
  String name();
  String ability();

  boolean isHealed();

}