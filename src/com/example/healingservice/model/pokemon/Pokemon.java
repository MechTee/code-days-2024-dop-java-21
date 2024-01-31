package com.example.healingservice.model.pokemon;

import com.example.healingservice.model.dex.PokeDexEntry;

public sealed interface Pokemon {

  PokeDexEntry pokeDexEntry();
  String name();
  String ability();

  boolean isHealed();

  record SingleTypePokemon(PokeDexEntry pokeDexEntry, String name, String ability, String type, boolean isHealed)
      implements Pokemon {}
  record DoubleTypePokemon(PokeDexEntry pokeDexEntry, String name, String ability, String type,
                           boolean isHealed, String secondType) implements Pokemon {}
}
